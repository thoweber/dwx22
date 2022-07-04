package guru.thomasweber.dwx22.tddstyles.port.rest;

import guru.thomasweber.dwx22.tddstyles.domain.CreateTodoUseCase;
import guru.thomasweber.dwx22.tddstyles.domain.State;
import guru.thomasweber.dwx22.tddstyles.domain.Todo;
import guru.thomasweber.dwx22.tddstyles.port.persistence.CreateTodoUseCaseImpl;
import guru.thomasweber.dwx22.tddstyles.port.persistence.TodoEntity;
import guru.thomasweber.dwx22.tddstyles.port.persistence.TodoEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TraditionalistCreateTodoControllerTest {

    TodoEntityRepository repositoryStub = new StubTodoEntityRepository();
    CreateTodoUseCase createTodoUseCase = new CreateTodoUseCaseImpl(repositoryStub);
    CreateTodoController createTodoController = new CreateTodoController(createTodoUseCase);

    @Test
    void testCreateWillCreateTodo() {
        // given
        CreateTodoCommandImpl command = CreateTodoCommandImpl.builder()
                .name("Meine wichtige Aufgabe")
                .dueDate(LocalDate.now().plusDays(2))
                .build();

        // when
        ResponseEntity<Todo> responseEntity = createTodoController.create(command);
        // then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        Todo todo = responseEntity.getBody();
        assertEquals(command.getName(), todo.getName());
        assertEquals(command.getDueDate(), todo.getDueDate());
        assertEquals(State.OPEN, todo.getState());
        assertNotNull(todo.getId());
    }

    private static class StubTodoEntityRepository implements TodoEntityRepository {

        @Override
        public <S extends TodoEntity> S save(S entity) {
            return entity;
        }

        @Override
        public <S extends TodoEntity> Iterable<S> saveAll(Iterable<S> entities) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Optional<TodoEntity> findById(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean existsById(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterable<TodoEntity> findAll() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterable<TodoEntity> findAllById(Iterable<String> strings) {
            throw new UnsupportedOperationException();
        }

        @Override
        public long count() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void deleteById(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void delete(TodoEntity entity) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void deleteAllById(Iterable<? extends String> strings) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void deleteAll(Iterable<? extends TodoEntity> entities) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void deleteAll() {
            throw new UnsupportedOperationException();
        }
    }
}
