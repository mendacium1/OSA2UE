# FractionsOfTime.java

Mathematische Operationen werden in Java grundsätzlich im Integer-Zahlenraum ausgeführt, außer einer der Operanden ist
vom
Typ `long`. In diesem Fall wird die Operation im Long-Zahlenraum ausgeführt. Dabei ist der Datentyp der Variable, die
das
Berechnungsergebnis speichert, unerheblich.

Da bei primitiven Datentypen Über- und Unterläufe keine Fehlermeldungen produzieren, können diese leicht übersehen
werden.

Ist absehbar, dass eine Berechnung nicht mit dem Integer-Zahlenraum auskommt, muss daher zumindest ein Operand vom Typ
`long` bei der Berechnung eingebaut werden.

# FuzzyArithmetics.java

Java implementiert bei Berechnungen mit Gleitkommazahlen den IEEE Standard for Floating-Point Arithmetic (IEEE 754).
Dabei
kann es bei Zahlen, die sich nicht auf endliche Binärzahlen abbilden lassen, zu Rundungsfehlern kommen.

Es gibt unterschiedliche Ansätze, diese Rundungsfehler zu vermeiden:

* Das Berechnungsergebnis auch runden.
* Die Berechnung derart anpassen, dass keine Gleitkommazahlen verwendet werden müssen.
* Auf andere Datentypen ausweichen, die eine exakte Berechnung bei Gleitkommazahlen unterstützen (`BigDecimal`).

https://en.wikipedia.org/wiki/IEEE_754

# Abc.java

Character-Arrays werden nicht automatisch in Strings umgewandelt.

# HaHa.java

Der `+` Operator verkettet Zeichen nur, wenn zumindest ein Operand vom Typ String ist.

Werden zwei Operanden vom Typ `char` mit `+` verknüpft, so werden diese auf `int` gecastet und addiert.

# MindTheCharacter.java

Zur Kennzeichnung von Ganzzahlen als `long`-Werte muss der Postfix `L` verwendet werden. Dabei ist es syntaktisch egal, ob ein großes oder ein kleines L verwendet wird.

Verwendet man jedoch das kleine l, kann dieses aufgrund seiner Darstellung leicht mit der Ziffer 1 verwechselt werden, was zu Fehlinterpretationen des Codes führen kann. Daher ist es empfehlenswert, immer ein großes L zu verwenden.

# Wrappers.java

Für alle primitiven Datentypen in Java existieren entsprechende Wrapper-Klassen, mit denen sich die Werte auch als Objekte abbilden lassen.

# BoxingDay.java

Autoboxing versucht Werte wiederzuverwenden ("Pooling"). Aus diesem Grund funktioniert der Vergleich mit `==` in diesen Fällen.

Wird kein Autoboxing verwendet (durch das explizite Verwenden der Konstruktoren) werden unterschiedliche Instanzen erzeugt, die beim Vergleich mit `==` nicht gleich sind. In diesem Fall muss auf die Vergleichsmethode `equals()` zurückgegriffen werden.

# Multicast.java

Grundsätzlich würde man erwarten, dass die Folge von Typecasts wieder `-1` ergibt. Allerdings muss man bedenken, dass sich `char` wie ein Unsigned Integer verhält, das bedeutet es gibt keine negativen Werte.

Das `int` zur Darstellung negativer Werte das Zweierkomplement verwendet lautet die Binärrepräsentation für den Byte-Wert -1 `11111111`. Wird dieser Wert auf `char` gecastet, wird er zuerst in einen Integer-Wert umgewandelt (widening conversion) und erst dann auf `char`gecasted (narrowing conversion). Da `char` 16 bit verwendet, aber keine Vorzeichen kennzeichnen muss, entspricht dieser Wert 2^16 - 1 = 65535.

# PlusMinus.java

Der übertriebene Einsatz von Inkrement- und Dekrement-Operatoren (sowohl in der Variante Pre- als auch Postfix) kann die Lesbarkeit des Codes beeinträchtigen.

# Shift

Signed Left Shift: Die Bits des Operanden werden unter Berücksichtigung des Vorzeichens n-mal nach links geschoben (Erhöhung der 2er-Potenz). Der rechts frei werdende Bit-Platz wird immer mit 0 aufgefüllt.

Signed Right Shift: Beim Verschieben nach rechts wird, je nachdem, ob das Vorzeichen-Bit gesetzt ist oder nicht, eine 1 oder eine 0 von links eingeschoben; das linke Vorzeichen-Bit bleibt unberührt (Verminderung der 2er-Potenz).

Unsigned Right Shift: Der Operator >>> berücksichtigt das Vorzeichen der Variablen nicht, sodass eine vorzeichenlose Rechtsverschiebung ausgeführt wird.

# Ugly.java
```
\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0020\u0020\u0020
\u0063\u006c\u0061\u0073\u0073\u0020\u0055\u0067\u006c\u0079
\u007b\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0020\u0020
\u0020\u0020\u0020\u0020\u0073\u0074\u0061\u0074\u0069\u0063
\u0076\u006f\u0069\u0064\u0020\u006d\u0061\u0069\u006e\u0028
\u0053\u0074\u0072\u0069\u006e\u0067\u005b\u005d\u0020\u0020
\u0020\u0020\u0020\u0020\u0061\u0072\u0067\u0073\u0029\u007b
\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u006f\u0075\u0074
\u002e\u0070\u0072\u0069\u006e\u0074\u006c\u006e\u0028\u0020
\u0022\u0048\u0065\u006c\u006c\u006f\u0020\u0077\u0022\u002b
\u0022\u006f\u0072\u006c\u0064\u0022\u0029\u003b\u007d\u007d
```

Java-Quellcode verwendet Unicode. Das bedeutet, dass auch über den ASCII-Zeichensatz hinaus alle Unicode-Characters verwendet werden können.

Aus praktischen Gründen sollte man darauf jedoch verzichten. Man kann nicht davon ausgehen, dass jeder Entwickler einen geeigneten Font installiert hat, um alle verwendeten Unicode-Zeichen richtig anzuzeigen.

Alternativ kann man die Zeichen auch durch Unicode-Escape-Sequenzen ersetzen, dadurch wird der Code aber unleserlich.

PS: Die Klasse kann kompiliert und ausgeführt werden...