package ru.practicum.explorewithme.event.dto.comment;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.practicum.explorewithme.event.model.CommentEntity;
import ru.practicum.explorewithme.user.model.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentMapper {

  public static CommentEntity toComment(CommentDto commentDto, long userId, long eventId) {
    return CommentEntity.builder()
        .id(commentDto.getId())
        .text(commentDto.getText())
        .author(new User(userId))
        .eventId(eventId)
        .createDateTime(LocalDateTime.now())
        .isModified(commentDto.getIsModified())
        .build();
  }

  public static CommentDto toCommentDto(CommentEntity comment) {
    return CommentDto.builder()
        .id(comment.getId())
        .text(comment.getText())
        .authorName(comment.getAuthor().getName())
        .created(comment.getCreateDateTime())
        .isModified(comment.getIsModified())
        .build();
  }

  public static CommentEntity toUpdatedComment(CommentDto commentDto, CommentEntity commentEntity) {
    return CommentEntity.builder()
        .id(commentEntity.getId())
        .text(commentDto.getText() != null ? commentDto.getText() : commentEntity.getText())
        .author(commentEntity.getAuthor())
        .eventId(commentEntity.getEventId())
        .createDateTime(commentEntity.getCreateDateTime())
        .build();
  }
}
