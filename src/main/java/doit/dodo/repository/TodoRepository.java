package doit.dodo.repository;

import doit.dodo.repository.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
