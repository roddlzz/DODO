package doit.dodo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequest {
  private String content;
  private String memo;
}
