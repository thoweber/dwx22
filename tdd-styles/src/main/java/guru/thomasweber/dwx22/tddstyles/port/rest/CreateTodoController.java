package guru.thomasweber.dwx22.tddstyles.port.rest;

import guru.thomasweber.dwx22.tddstyles.domain.CreateTodoCommand;
import guru.thomasweber.dwx22.tddstyles.domain.CreateTodoUseCase;
import guru.thomasweber.dwx22.tddstyles.domain.Todo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CreateTodoController {

    private final CreateTodoUseCase createTodoUseCase;

    @PostMapping("/todo")
    public ResponseEntity<Todo> create(@RequestBody CreateTodoCommandImpl command) {
        log.info("create command: {}", command);
        return new ResponseEntity<>(createTodoUseCase.create(command), HttpStatus.CREATED);
    }
}
