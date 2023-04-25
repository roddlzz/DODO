package doit.dodo.service;

import doit.dodo.model.TodoDTO;
import doit.dodo.repository.TodoEntity;
import doit.dodo.repository.TodoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class TodoService {
  private TodoRepository todoRepository;

  public List<TodoDTO> getAllTodoList() {
    return todoRepository.findAll().stream().map(o ->
            convert(o))
        .collect(Collectors.toList());
  }

  public TodoDTO getTodo(Long id) {
    Optional<TodoEntity> optionalTodo = todoRepository.findById(id);
    Optional<TodoDTO> todoDTO = optionalTodo.map(o -> {
      return convert(o);
    });

    return todoDTO.orElseThrow();
  }

  public TodoDTO convert(TodoEntity o) {
    return new TodoDTO(o.getId(), o.getContent(), o.getCreatedDate(), o.getUpdatedDate(), o.getMemo());
  }

  @Transactional
  public TodoDTO createTodo(TodoDTO dto) {
    TodoEntity todoEntity = new TodoEntity();
    todoEntity.setContent(dto.getContent());
    todoEntity.setMemo(dto.getMemo());
    todoEntity.setCreatedDate(LocalDateTime.now());
    todoEntity.setUpdatedDate(LocalDateTime.now());
    todoEntity = todoRepository.save(todoEntity);
    TodoDTO convert = convert(todoEntity);
    return convert;
  }

  @Transactional
  public TodoDTO updateTodo(Long id, TodoDTO todoDTO) {
    Optional<TodoEntity> optionalTodo = todoRepository.findById(id);
    TodoEntity todoEntity = optionalTodo.orElseThrow();
    todoEntity.setContent(todoDTO.getContent());
    todoEntity.setMemo(todoDTO.getMemo());
    todoEntity.setUpdatedDate(LocalDateTime.now());
    todoRepository.save(todoEntity);
    TodoDTO convert = convert(todoEntity);
    return convert;
  }

  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }
}


