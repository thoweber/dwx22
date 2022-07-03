package guru.thomasweber.dwx22.tddstyles.domain;

import java.time.LocalDate;
import java.util.UUID;

public interface Todo {
    UUID getId();
    String getName();
    LocalDate getDueDate();
    State getState();
}
