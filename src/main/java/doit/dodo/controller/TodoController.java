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

    @GetMapping
    public List<TodoResponse> retrieve() {
        List<TodoDTO> allTodoList = todoService.getAllTodoList();
        return allTodoList.stream().map(TodoController::convert).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public TodoResponse getTodo(@PathVariable Long id) {
        TodoDTO todo = todoService.getTodo(id);
        return convert(todo);
    }

    @PostMapping
    public TodoResponse createTodo(@RequestBody TodoRequest todoRequest) {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setContent(todoRequest.getContent());
        todoDTO.setMemo(todoRequest.getMemo());
        return convert(todoService.createTodo(todoDTO));
    }

    @PutMapping("/{id}")
    public TodoResponse modifyTodo(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
        TodoDTO todo = todoService.getTodo(id);
        todo.setContent(todoRequest.getContent());
        todo.setMemo(todoRequest.getMemo());
        return convert(todoService.updateTodo(id, todo));
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    private static TodoResponse convert(TodoDTO dto) {
        return new TodoResponse(dto.getId(), dto.getContent(), dto.getMemo(),
                dto.getCreatedDate(), dto.getUpdatedDate());
    }
}