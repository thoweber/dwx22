# Beispiel: Mutation-Testing

* Coverage-Report erstellen: `mvn clean test jacoco:report`  
  Der Report befindet sich dann in [`target/site/jacoco/index.html`](target/site/jacoco/index.html)
* Mutation-Coverage-Report erstellen: `mvn clean test pitest:mutationCoverage`  
  Der Report befindet sich dann in [`target/pit-reports/index.html`](target/site/jacoco/index.html)
