# Beispiel: Property-based Testing

* Fehler in `Factorizer`:  
  Übrigbleibende Primzahl muss hinzugefügt werden (Zeile 38):
  ```java
  if (number != 1) {
    factors.add(number);
  }
  ```
* Problem im Property-based-Test:  
  Spezialfall Integer.MIN_VALUE muss behandelt werden, da es hier keine entsprechendes
  positives Integer gibt und durch den Overflow `Integer.MIN_VALUE * (-1) == Integer.MIN_VALUE` ergibt.


