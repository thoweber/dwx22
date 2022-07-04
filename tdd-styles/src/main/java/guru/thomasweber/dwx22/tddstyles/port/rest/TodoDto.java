package guru.thomasweber.dwx22.tddstyles.port.rest;

import guru.thomasweber.dwx22.tddstyles.domain.State;
import guru.thomasweber.dwx22.tddstyles.domain.Todo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
public class TodoDto implements Todo {
    private UUID id;
    private String name;
    private LocalDate dueDate;
    private State state;
}
