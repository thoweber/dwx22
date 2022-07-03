package guru.thomasweber.dwx22.tddstyles.domain;

import java.time.LocalDate;

public interface CreateTodoCommand {
    String getName();
    LocalDate getDueDate();
}
