package doit.dodo.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TodoResponse {
  private Long id;
  private String content;
  private String memo;
  private LocalDateTime createDate;


}
