package localizations;


import java.util.ListResourceBundle;

public class GUILabels_ge extends ListResourceBundle {
    private static final Object[][] contents =
            {
                   {"dataFormat", "dd.MM.yyyy"},
                    {"failed to login", "Anmeldung fehlgeschlagen"},
                    {"failed to register", "Registrierung fehlgeschlagen"},
                    {"welcome to music band", "Willkommen in der Musikband"},
                    {"Log to account", "Melde dich an"},
                    {"Register", "Registrieren"},
                    {"name", "Benutzername"},
                    {"password", "Passwort"},
                    {"loginButton", "Anmelden"},
                    {"registerButton", "Registrieren"},
                    {"language:", "Sprache:"},
                    {"have account", "Bereits einen Account haben?"},
                    {"not have account", "Keinen Account haben?"},
                    {"toLoginButton", "Anmelden"},
                    {"toRegisterButton", "Registrieren"},
                    {"alb", "Albanisch"},
                    {"en", "Englisch"},
                    {"ru", "Russisch"},
                    {"ge", "Deutsch"},
                    {"info about help", "Informationen über Befehle"},
                    {"help command", "info: gibt Informationen über die Sammlung aus\n" +
                            "show: zeigt die Elemente der Sammlung an\n" +
                            "add: fügt ein Element zur Sammlung hinzu\n" +
                            "update: aktualisiert eine Musikband anhand der angegebenen ID\n" +
                            "remove_by_id: entfernt eine Musikband anhand der ID aus der Sammlung\n" +
                            "clear: leert die Sammlung\n" +
                            "head: gibt das erste Element der Sammlung aus\n" +
                            "remove_greater: entfernt Musikbands, die größer als die angegebene sind\n" +
                            "history: gibt die letzten 11 Befehle aus\n" +
                            "filter_by_number_of_participants: gibt Musikbands mit der angegebenen Anzahl an Auftritten aus\n" +
                            "print_descending: gibt die Elemente der Sammlung in absteigender Reihenfolge aus\n" +
                            "print_field_descending_genre: gibt die Werte des Feldes \"Genre\" aller Elemente in absteigender Reihenfolge aus\n" +
                            "auth: ermöglicht einem Benutzer, sich anzumelden\n" +
                            "register: ermöglicht einem Benutzer, sich zu registrieren\n" +
                            "logout: meldet den Benutzer ab\n" +
                            "user_info: gibt Informationen zum aktuellen Benutzer aus\n" +
                            "help: gibt vollständige Informationen zu den Befehlen aus\n" +
                            "exit: beendet das Programm\n" +
                            "execute_script: führt Befehle aus einer Datei aus\n"},
                    {"info about commands", "Informationen über die Sammlung"},
                    {"info", "Datentyp: java.util.LinkedList\n" +
                            "Initialisierungsdatum: "},
                    {"count elements", "Anzahl der Elemente: "},
                    {"ok", "OK"},
                    {"choose script", "Skript auswählen"},
                    {"not empty", "Felder dürfen nicht leer sein"},
                    {"not numbers", "Alle Felder außer Name und Genre müssen Ganzzahlen sein"},
                    {"not update", "Dieses Objekt kann nicht aktualisiert werden"},
                    {"not this user", "Sie können keine Werte von Objekten aktualisieren, die Sie nicht erstellt haben"},
                    {"invalid enter coordinates", "Ungültige Koordinateneingabe"},
                    {"write coordinates", "Geben Sie die Koordinaten durch ein Semikolon (;) getrennt ein"},
                    {"field need number", "Dieses Feld muss eine Ganzzahl sein"},


                    {"null", "Leerer Wert"},
                    {"not null", "Dieses Feld darf nicht leer sein"},
                    {"exit", "Beenden"},
                    {"map", "Karte"},
                    {"help", "Hilfe"},
                    {"information", "Information"},
                    {"add", "Hinzufügen"},
                    {"script", "Skript ausführen"},
                    {"remove greater", "Größere entfernen"},
                    {"clear", "Leeren"},
                    {"searchLabel", "Suche:"},
                    {"searchField", "Text eingeben"},
                    {"name", "Name"},
                    {"creation date", "Erstellungsdatum"},
                    {"count fans", "Anzahl der Fans"},
                    {"single count", "Anzahl der Singles"},
                    {"genre", "Genre"},
                    {"labels", "Label (Verkäufe)"},
                    {"table", "Tabelle"},
                    {"delete", "Löschen"},
                    {"add", "Hinzufügen"},
                    {"coord x", "Koordinate x"},
                    {"coord y", "Koordinate y"},
                    {"input text", "Text eingeben"}

            };
    public Object[][] getContents() {
        return contents;
    }
}
