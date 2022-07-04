package guru.thomasweber.dwx22.tddstyles.port.rest;

import guru.thomasweber.dwx22.tddstyles.domain.CreateTodoCommand;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Builder
@Jacksonized
@Getter
public class CreateTodoCommandImpl implements CreateTodoCommand {
    private String name;
    private LocalDate dueDate;
}
