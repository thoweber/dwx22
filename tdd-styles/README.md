# Was werden wir erstellen?

* `CreateTodoController` mit einer `POST`-Methode zum Anlegen eines ToDo.
  * der Controller akzeptiert einen `CreateTodoCommand`
  * und gibt das angelegte `TodoDto` zurück

* `CreateTodoUseCase` der das Anlegen des `Todo` steuert

* ein Spring Data Repository für H2 mit zugehöriger Entity zum Speichern des `Todo`

# Wie werden wir es erstellen?

* mit **TDD** einmal traditionell und einmal im Mockist-Stil 