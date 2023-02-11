package ru.practicum.explorewithme.event.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.practicum.explorewithme.event.dto.EventStatus;
import ru.practicum.explorewithme.event.model.EventEntity;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EventRepositoryCustomImpl implements EventRepositoryCustom {

  private final EntityManager em;

  @Override
  public List<EventEntity> searchEvents(List<Long> users, List<String> states, List<Integer> categories,
      String rangeStart, String rangeEnd, int from, int size) {
    var cb = em.getCriteriaBuilder();
    CriteriaQuery<EventEntity> cq = cb.createQuery(EventEntity.class);

    Root<EventEntity> statsEntityRoot = cq.from(EventEntity.class);
    List<Predicate> predicates = new ArrayList<>();

    var format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    predicates.add(cb.between(statsEntityRoot.get("eventDate"),
        LocalDateTime.parse(rangeStart, format),
        LocalDateTime.parse(rangeEnd, format)));

    if (users != null && !users.isEmpty()) {
      predicates.add(cb.isTrue(statsEntityRoot.get("initiator").get("id").in(users)));
    }

    if (states != null && !states.isEmpty()) {
      var eStates = states.stream().map(EventStatus::valueOf).collect(Collectors.toList());
      predicates.add(cb.isTrue(statsEntityRoot.get("state").in(eStates)));
    }

    if (categories != null && !categories.isEmpty()) {
      predicates.add(cb.isTrue(statsEntityRoot.get("category").get("id").in(categories)));
    }

    cq.select(statsEntityRoot);
    cq.orderBy(cb.desc(cb.literal(1)));
    cq.where(predicates.toArray(new Predicate[0]));

    return em.createQuery(cq).setFirstResult(from).setMaxResults(size).getResultList();
  }
}
