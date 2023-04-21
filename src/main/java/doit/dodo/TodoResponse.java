package doit.dodo;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoResponse {
  private Long id;
  private String content;
  private String memo;
  private LocalDateTime createDate;
}
