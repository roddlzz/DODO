package doit.dodo;

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
}
