package doit.dodo;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/todos")
public class TodoController {
  private final TodoService todoService;
  private final TodoResponse todoResponse;
  @GetMapping
  public Response<List<TodoResponse>> retrieve() {
    List<TodoDTO> alltodolist = todoService.getAllTodoList();
    List<TodoResponse> todoResponse = alltodolist.stream().map(all ->
            new TodoResponse(all.getId(), all.getContent(), all.getMemo(),
                all.getCreatedDate()))
        .collect(Collectors.toList());
    return new TodoResponse(alltodolist);
  }

  @PostMapping
  public Response<TodoResponse> createTodo(@RequestBody TodoRequest todoRequest){
    TodoDTO todoDTO = new TodoDTO();
    todoDTO.setContent(todoRequest.getContent());
    todoDTO.setMemo(todoRequest.getMemo());
    return Response(TodoDTO);
  }

  @DeleteMapping("/{id}")
public Response<Boolean> deleteTodo(@PathVariable Long id){
    todoService.deleteTodo(id);
    return Response.ok(true);
    }
    }