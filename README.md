# hrm-systems-fullstack-backend-challenge

## Aufgabe REST Webservice Backend
Erstellen Sie einen REST Webservice für die von uns zur Verfügung gestellte Postman Collection. Die Implementation soll über folgende Features verfügen:
* Validation des Payloads
* Rückgabe des Stacktrace und sinnvoller HTTP Codes im Fehlerfall
* Minimale Verarbeitung des Payloads
* Rückgabe der Statistik über die verarbeiteten Daten

###  Voraussetzung / Vorgaben
* Backend Implementation mit mind. JEE8
* XSD (XML Schema) des Payloads: fullstack-backend-challenge.xsd
* XML-Dateien, welche als Payload Beispiele verwendet werden können:
  * fullstack-backend-challenge-1.xml
  * fullstack-backend-challenge-2.xml
  * fullstack-backend-challenge-3.xml
  * fullstack-backend-challenge-4.xml
* Postman Projekt, welches die geforderten REST-Services aufruft. Die 'free' Postman
Variante reicht. Host/Port der Target-URL könne frei gesetzt werden.
  * fullstack-backend-challenge.postman_collection.json
* Folgende Webservices sind im Postman Projekt definiert und müssen implementiert
werden:
  * Person hinzufügen
  * Personen abholen
  * Statistik abholen 
* Die Statistik soll bis zu einem Neustart des Backends folgende Daten (kumuliert) enthalten:
  * Anzahl der Add-Requests
  * Anzahl der nicht validen Add-Requests sowie deren Fehlermeldungen (sum-
  und gruppiert)
  * Anzahl der validen Requests
  * Anzahl der insgesamt hinzugefügten Personen via Webservice
* Folgender Webservice ist im Postman Projekt nicht enthalten und soll zusätzliche implementiert werden:
  * Person ändern


## Anmerkungen
* Coding Challenge wurde time boxed durchgeführt, ca. 10h
* Ein Update auf eine Person kann nur schwer vollzogen werden wenn kein eindeutiges Attribut (bspw. ID besteht) => Regeln zum Update unklar.
* Das XSD Schema hat einen Syntax Fehler auf Zeile 28 
* Ungünstige Vorgabe von Endpoint POST "person/add":
  * Resourcen sollten stets in Mehrzahl sein
  * Es sollten keine Verben in Pfaden sein
  * Vorschlag: POST "persons/"

## Ausstehend
* Automatisierte Tests
* Refactoring Statistics um die Anzahl der erstellten Personen zu erreichen.
* Personen welche doppelt hinzugefügt werden, werden ignoriert aber nicht in der Statistik geloggt.
* Aktualisierung von Personen (unique identifier?)


## Quellen
* JEE Setup: https://www.jetbrains.com/help/idea/creating-and-running-your-first-restful-web-service.html
* Glassfish configuration: https://stackoverflow.com/questions/41585188/setting-context-root-with-glassfish-application-server#49703004
* Unmarshalling: https://codenotfound.com/jaxb-unmarshal-xml-string-into-java-object.html  
* Schema validation: https://www.journaldev.com/895/how-to-validate-xml-against-xsd-in-java
* EJB Setup:
  * https://www.baeldung.com/java-ee-singleton-session-bean
  * https://www.ibm.com/support/knowledgecenter/SSEQTP_8.5.5/com.ibm.websphere.base.doc/ae/tejb_ssb.html
