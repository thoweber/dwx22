package guru.thomasweber.dwx22.tddstyles.port.rest;

import guru.thomasweber.dwx22.tddstyles.domain.CreateTodoCommand;
import guru.thomasweber.dwx22.tddstyles.domain.CreateTodoUseCase;
import guru.thomasweber.dwx22.tddstyles.domain.Todo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MockistCreateTodoControllerTest {

    @Mock
    CreateTodoUseCase createTodoUseCase;

    @Mock
    Todo todo;

    @InjectMocks
    CreateTodoController controller;

    @Captor
    ArgumentCaptor<CreateTodoCommand> createTodoCommandArgumentCaptor;

    @Test
    void createReturnsTodoInResponseEntityOf201Created() {
        // given
        CreateTodoCommandImpl command = CreateTodoCommandImpl.builder()
                .name("Meine wichtige Aufgabe")
                .dueDate(LocalDate.now().plusDays(2))
                .build();
        given(createTodoUseCase.create(command)).willReturn(todo);
        // when
        ResponseEntity<Todo> responseEntity = controller.create(command);
        // then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertSame(todo, responseEntity.getBody());
    }

    @Test
    void createCallsCreateTodoUseCaseWithReceivedCommand() {
        // given
        CreateTodoCommandImpl command = CreateTodoCommandImpl.builder()
                .name("Meine wichtige Aufgabe")
                .dueDate(LocalDate.now().plusDays(2))
                .build();
        given(createTodoUseCase.create(createTodoCommandArgumentCaptor.capture())).willReturn(todo);
        // when
        controller.create(command);
        // then
        assertThat(createTodoCommandArgumentCaptor.getValue()).isEqualTo(command);
    }
}
