package doit.dodo.controller;

import doit.dodo.model.TodoDTO;
import doit.dodo.model.TodoRequest;
import doit.dodo.model.TodoResponse;
import doit.dodo.service.TodoService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public List<TodoResponse> retrieve() {
    List<TodoDTO> alltodolist = todoService.getAllTodoList();
    List<TodoResponse> todoResponse = alltodolist.stream().map(all ->
        new TodoResponse(all.getId(), all.getContent(), all.getMemo(),
            all.getCreatedDate(), all.getUpdatedDate())).collect(Collectors.toList());
    return todoResponse;
  }

  @GetMapping("/{id}")
  public TodoResponse getTodo(@PathVariable Long id) {
    TodoDTO todo = todoService.getTodo(id);
    return todoResponse;
  }

  @PostMapping
  public TodoResponse createTodo(@RequestBody TodoRequest todoRequest) {
    TodoDTO todoDTO = new TodoDTO();
    todoDTO.setContent(todoRequest.getContent());
    todoDTO.setMemo(todoRequest.getMemo());
    return todoResponse(todoService.createTodo(todoDTO));
  }

  private TodoResponse todoResponse(TodoDTO todo) {
    return todoResponse(todo);
  }

  @PutMapping("/{id}")
  public TodoResponse modifyTodo(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
    TodoDTO todo = todoService.getTodo(id);
    todo.setContent(todoRequest.getContent());
    todo.setMemo(todoRequest.getMemo());
    return todoResponse(todoService.updateTodo(id,todo));
  }

  @DeleteMapping("/{id}")
  public void deleteTodo(@PathVariable Long id) {
    todoService.deleteTodo(id);
  }
}