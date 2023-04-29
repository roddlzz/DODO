package doit.dodo.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import doit.dodo.model.TodoDTO;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class TodoServiceTest {

  @Autowired
  TodoService todoService;

  /**
   * 0. todo 목록을 조회한다 (결과 0개)
   * 1. todo를 하나 작성한다.
   * 2. todo 목록을 조회한다 (결과 1개)
   * 3. ID로 한개를 조회
   * 4. todo 내용을 수정한다
   * 5. todo를 하나 더 만든다
   * 6. todo 목록을 조회한다 (결과가 2개)
   * 7. todo를 삭제한다.
   * 8. todo 목록을 조회한다 (결과 1개)
   * 9. todo를 삭제한다.
   * 10. todo 목록을 조회한다 (결과 0개)
   */

  @Test
  @DisplayName("todo 작성하고 삭제 테스트")
  void todoTest(){
    //0. todo 목록을 조회한다 (결과 0개)
    List<TodoDTO> todoDTOList = todoService.getAllTodoList();
    assertThat(todoDTOList.size()).isEqualTo(0);

    //1. todo를 하나 작성한다.
    TodoDTO todo1 = new TodoDTO();
    todo1.setContent("수제사탕사기");
    todo1.setMemo("홍대가서 살지 or 망원동가서 살지 고민중");
    TodoDTO createTodoTest = todoService.createTodo(todo1);

    //2. todo 목록을 조회한다 (결과 1개)
    todoDTOList = todoService.getAllTodoList();
    assertThat(todoDTOList.size()).isEqualTo(1);

    //3. ID로 한개를 조회
    TodoDTO getTodo = todoService.getTodo(createTodoTest.getId());
    assertThat(getTodo).isEqualTo(createTodoTest);

    //4. todo 내용을 수정한다
    createTodoTest.setContent("망원동가기");
    createTodoTest.setMemo("망원동가서 수제캔디 사오기");
    TodoDTO updateTodoTest = todoService.updateTodo(createTodoTest.getId(), createTodoTest);
    assertThat(updateTodoTest).isEqualTo(createTodoTest);

    //5. todo를 하나 더 만든다
    TodoDTO todo2 = new TodoDTO();
    todo2.setContent("저녁에 산책 약속");
    todo2.setMemo("9시에 희주랑 어린이대공원 산책");
    TodoDTO createTodoTest2 = todoService.createTodo(todo2);

    //6. todo 목록을 조회한다 (결과 2개)
    todoDTOList = todoService.getAllTodoList();
    assertThat(todoDTOList.size()).isEqualTo(2);

    //7. todo를 삭제한다.
    todoService.deleteTodo(createTodoTest.getId());

    //8. todo 목록을 조회한다 (결과 1개)
    todoDTOList = todoService.getAllTodoList();
    assertThat(todoDTOList.size()).isEqualTo(1);

    //9. todo를 삭제한다.
    todoService.deleteTodo(createTodoTest2.getId());

    //10. todo 목록을 조회한다 (결과 0개)
    todoDTOList = todoService.getAllTodoList();
    assertThat(todoDTOList.size()).isEqualTo(0);

  }

}