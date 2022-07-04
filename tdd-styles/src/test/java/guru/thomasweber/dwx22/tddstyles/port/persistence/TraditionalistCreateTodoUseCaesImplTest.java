package guru.thomasweber.dwx22.tddstyles.port.persistence;

import guru.thomasweber.dwx22.tddstyles.domain.CreateTodoCommand;
import guru.thomasweber.dwx22.tddstyles.domain.CreateTodoUseCase;
import guru.thomasweber.dwx22.tddstyles.domain.Todo;
import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TraditionalistCreateTodoUseCaesImplTest {
    @Autowired
    CreateTodoUseCase createTodoUseCase;
    @Autowired
    TodoEntityRepository todoEntityRepository;

    @Test
    void createSavesAndReturnsInitializedTodo() {
        // given
        CreateTodoCommand command = CreateTodoCommandStub.builder()
                .name("Aufgaben-Name")
                .dueDate(LocalDate.now().plusDays(2))
                .build();
        // when
        Todo todo = createTodoUseCase.create(command);
        // then
        assertThat(todo).isEqualTo(todoEntityRepository.findById(todo.getId().toString()).get());
    }

    @Builder
    @Getter
    private static class CreateTodoCommandStub implements CreateTodoCommand {
        private String name;
        private LocalDate dueDate;
    }
}
