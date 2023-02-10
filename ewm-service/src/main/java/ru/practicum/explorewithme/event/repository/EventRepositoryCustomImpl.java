package ru.practicum.explorewithme.event.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.practicum.explorewithme.event.dto.OutputEventDto;
import ru.practicum.explorewithme.event.model.EventEntity;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EventRepositoryCustomImpl implements EventRepositoryCustom {

  private final EntityManager em;

  @Override
  public List<OutputEventDto> searchEvents(List<Long> users, List<String> states, List<Integer> categories,
      String rangeStart, String rangeEnd, int from, int size) {
    var cb = em.getCriteriaBuilder();
    CriteriaQuery<OutputEventDto> cq = cb.createQuery(OutputEventDto.class);

    Root<EventEntity> statsEntityRoot = cq.from(EventEntity.class);
    List<Predicate> predicates = new ArrayList<>();

    predicates.add(
        cb.between(statsEntityRoot.get("timestamp"), Timestamp.valueOf(rangeStart), Timestamp.valueOf(rangeEnd)));

    if (users != null && !users.isEmpty()) {
      predicates.add(cb.isTrue(statsEntityRoot.get("initiator_id").in(users)));
    }

    if (states != null && !states.isEmpty()) {
      predicates.add(cb.isTrue(statsEntityRoot.get("state").in(states)));
    }

    if (categories != null && !categories.isEmpty()) {
      predicates.add(cb.isTrue(statsEntityRoot.get("category_id").in(categories)));
    }

    cq.orderBy(cb.desc(cb.literal(1)));
    cq.where(predicates.toArray(new Predicate[0]));

    return em.createQuery(cq).setFirstResult(from).setMaxResults(size).getResultList();
  }
}
