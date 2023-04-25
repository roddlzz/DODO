package doit.dodo.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TodoDTO {
  private Long id;
  private String content;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private String memo;



  public TodoDTO(Long id, String content, LocalDateTime createdDate, LocalDateTime updatedDate, String memo) {
    this.id = id;
    this.content = content;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
    this.memo = memo;
  }
}
