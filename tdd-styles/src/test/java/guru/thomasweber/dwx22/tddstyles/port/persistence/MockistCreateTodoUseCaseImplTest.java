package guru.thomasweber.dwx22.tddstyles.port.persistence;

import guru.thomasweber.dwx22.tddstyles.domain.CreateTodoCommand;
import guru.thomasweber.dwx22.tddstyles.domain.State;
import guru.thomasweber.dwx22.tddstyles.domain.Todo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class MockistCreateTodoUseCaseImplTest {

    @Mock
    CreateTodoCommand command;

    @Mock
    TodoEntityRepository repository;

    @InjectMocks
    CreateTodoUseCaseImpl createTodoUseCase;

    @Test
    void createSavesAndReturnsInitializedTodo() {
        // given
        given(command.getName()).willReturn("Aufgaben-Name");
        given(command.getDueDate()).willReturn(LocalDate.now().plusDays(2));
        given(repository.save(any())).willAnswer(answer -> answer.getArgument(0));
        // when
        Todo todo = createTodoUseCase.create(command);
        // then
        then(repository).should(times(1)).save(any(TodoEntity.class));
        assertEquals(command.getName(), todo.getName());
        assertEquals(command.getDueDate(), todo.getDueDate());
        assertEquals(State.OPEN, todo.getState());
        assertNotNull(todo.getId());
    }

}
