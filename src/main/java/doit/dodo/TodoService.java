package doit.dodo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class TodoService {
  private TodoRepository todoRepository;

  public List<TodoDTO> getAllTodoList() {
  return todoRepository.findAll().stream().map(all ->
          new TodoResponse(all.getId(), all.getContent(), all.getMemo(),
              all.getCreatedDate()))
      .collect(Collectors.toList());
  }
  public TodoDTO getTodo(Long id) {
    return todoRepository.findone()
  }

  @Transactional
  public TodoDTO createTodo(TodoDTO todoDTO) {
    TodoEntity todoEntity = new TodoEntity();
    todoEntity.setContent(TodoRequest.getcontent());
    todoEntity.setMemo(TodoRequest.getMemo());
    todoEntity.setCreatedDate(LocalDateTime.now());
    todoEntity = todoRepository.save(todoEntity);
    TodoResponse todoResponse = new TodoResponse(todoEntity.getId(), todoEntity.getContent(), todoEntity.getMemo(),
        todoEntity.getCreatedDate());
    return TodoResponse;
  }

  @Transactional
  public TodoDTO updateTodo(Long id, TodoDTO todoDTO) {
    TodoEntity todoEntity = todoRepository.findById(id);
    todoEntity.setContent(todoDTO.getContent());
    todoEntity.setMemo(todoDTO.getMemo());
    return todoDTO. (todoRepository.save(todoEntity));
  }

  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }
}


