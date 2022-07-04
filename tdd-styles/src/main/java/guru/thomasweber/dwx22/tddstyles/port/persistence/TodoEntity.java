package guru.thomasweber.dwx22.tddstyles.port.persistence;

import guru.thomasweber.dwx22.tddstyles.domain.State;
import guru.thomasweber.dwx22.tddstyles.domain.Todo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "todo")
@NoArgsConstructor
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
@ToString
public class TodoEntity implements Todo {
    @Id
    private String id;
    @Basic
    private LocalDate dueDate;
    @Basic
    private String name;
    @Enumerated(EnumType.STRING)
    private State state;

    public UUID getId() {
        return UUID.fromString(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TodoEntity that = (TodoEntity) o;
        if (this.id == null && that.id == null) {
            return super.equals(o);
        }
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // overwrite part of the generated builder
    public static class TodoEntityBuilder {
        public TodoEntityBuilder id(UUID id) {
            this.id = id.toString();
            return this;
        }
    }
}
