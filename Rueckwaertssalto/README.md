<h1>Aufgabenstellung</h1>
Erstelle ein Java-Programm, dass Connection-Parameter und einen Datenbanknamen auf der Kommandozeile entgegennimmt und die Struktur der Datenbank als EER-Diagramm und Relationenmodell ausgibt (in Dateien geeigneten Formats, also z.B. PNG fuer das EER und TXT fuer das RM).
Verwende dazu u.A. das ResultSetMetaData-Interface, das Methoden zur Bestimmung von Metadaten zur Verfuegung stellt.
Zum Zeichnen des EER-Diagramms kann eine beliebige Technik eingesetzt werden fuer die Java-Bibliotheken zur Verfuegung stehen: Swing, HTML5, eine WebAPI, ... . Externe Programme duerfen nur soweit verwendet werden, als sich diese plattformunabhaengig auf gleiche Weise ohne Aufwand (sowohl technisch als auch lizenzrechtlich!) einfach nutzen lassen. (also z.B. ein Visio-File generieren ist nicht ok, SVG ist ok, da fuer alle Plattformen geeignete Werkzeuge zur Verfuegung stehen). Recherchiere dafuer im Internet nach geeigneten Werkzeugen.

Die Extraktion der Metadaten aus der DB muss mit Java und JDBC erfolgen.

<b>Im EER muessen zumindest vorhanden sein:</b>

- korrekte Syntax nach Chen, MinMax oder IDEFIX
- alle Tabellen der Datenbank als Entitaeten
- alle Datenfelder der Tabellen als Attribute
- Primaerschluessel der Datenbanken entsprechend gekennzeichnet
- Beziehungen zwischen den Tabellen inklusive Kardinalitaeten soweit durch Fremdschluessel nachvollziehbar. Sind mehrere Interpretationen moeglich, so ist nur ein (beliebiger) Fall umzusetzen: 1:n, 1:n schwach, 1:1
- Kardinalitaeten 

<b>Fortgeschritten (auch einzelne Punkte davon fuer Bonuspunkte umsetzbar):</b>

- Zusatzattribute wie UNIQUE oder NOT NULL werden beim Attributnamen dazugeschrieben, sofern diese nicht schon durch eine andere Darstellung ableitbar sind (1:1 resultiert ja in einem UNIQUE)
- optimierte Beziehungen z.B. zwei schwache Beziehungen zu einer m:n zusammenfassen (ev. mit Attributen)
- Erkennung von Sub/Supertyp-Beziehungen


<h1>Verwendung: Notwendige Schritte</h1>
Um dieses Programm verwenden zu koennen, muss lediglich die main-Methode in der Main-Klasse mit Java ausgefuehrt werden.

Folgende CLI-Parameter sind dabei verwendbar:
- <b>-h</b>   Hostname des DBMS. Standard: localhost
- <b>-u</b>   Benutzername. Standard: Benutzername des im Betriebssystem angemeldeten Benutzers
- <b>-p</b>   Passwort. Ohne nachfolgende Eingabe. Nach Programmstart wird ein Passwortprompt angezeigt.
- <b>-d</b>   Name der Datenbank.
- <b>-r</b>   Der Filename des Outputfiles des Relationenmodells. Falls nicht angegeben, wird kein RM erstellt.
- <b>-e</b>   Der Filename des Outputfiles des EER-Diagramms. Falls nicht angegeben, wird kein EER erstellt.

Sollte ein EER mit diesem Programm erstellt werden, so muss zunaechst das Programm Graphviz (http://www.graphviz.org/Download..php) heruntergeladen und installiert werden.
Bei einem Windows-Betriebssystem muss zusaetzlich noch der bin-Ordner von Graphviz in die Path-Variable eingetragen werden.
Anschliessend kann das Programm auch ein EER-Diagramm erstellen.
