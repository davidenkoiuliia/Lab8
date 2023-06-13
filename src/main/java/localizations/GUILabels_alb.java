package localizations;


import java.util.ListResourceBundle;

public class GUILabels_alb extends ListResourceBundle {
    private static final Object[][] contents =
            {

                    {"dataFormat", "dd-MM-yyyy"},
                    {"failed to login", "Nuk u arrit të identifikohet"},
                    {"failed to register", "Nuk u arrit të regjistrohet"},
                    {"welcome to music band", "Mirë se vini në grupin muzikor"},
                    {"Log to account", "Identifikohu në llogarinë tënde"},
                    {"Register", "Regjistrohu"},
                    {"name", "emri"},
                    {"password", "fjalëkalimi"},
                    {"loginButton", "Identifikohu"},
                    {"registerButton", "Regjistrohu"},
                    {"language:", "Gjuha:"},
                    {"have account", "Keni një llogari?"},
                    {"not have account", "Nuk keni një llogari?"},
                    {"toLoginButton", "Identifikohu"},
                    {"toRegisterButton", "Regjistrohu"},
                    {"alb", "Shqiptar"},
                    {"en", "Anglisht"},
                    {"ru", "Rusisht"},
                    {"ge", "Gjermanisht"},
                    {"info about help", "Rreth komandave"},
                    {"help command", "info: tregon informacionin për koleksionin\n" +
                            "show: tregon elementet e koleksionit\n" +
                            "add: shton një element në koleksion\n" +
                            "update: përditëson grupin muzikor sipas ID-së duke përdorur një grup muzikor të dhënë\n" +
                            "remove_by_id: fshin grupin muzikor sipas ID-së nga koleksioni\n" +
                            "clear: zbrazë koleksionin\n" +
                            "head: tregon elementin e parë të koleksionit\n" +
                            "remove_greater: fshin grupet muzikore që janë më të mëdha se ato të dhënat\n" +
                            "history: tregon 11 komandat e fundit\n" +
                            "filter_by_number_of_participants: tregon grupin muzikor me numër të caktuar të pjesëmarrësve\n" +
                            "print_descending: tregon elementet e koleksionit në rend zbrites\n" +
                            "print_field_descending_genre: tregon vlerat e fushës 'genre' të të gjithë elementeve në rend zbrites\n" +
                            "auth: kryen hyrjen e përdoruesit\n" +
                            "register: kryen regjistrimin e përdoruesit\n" +
                            "logout: del nga llogaria\n" +
                            "user_info: tregon informacionin për përdoruesin aktual\n" +
                            "help: tregon informacionin e plotë për komandat\n" +
                            "exit: mbyll programin\n" +
                            "execute_script: ekzekuton komandat nga skedari\n"},
                    {"info about commands", "Rreth koleksionit"},
                    {"info", "Lloji i të dhënave: java.util.LinkedList\n" +
                            "Data e inicializimit: "},
                    {"count elements", "Numri i elementeve: "},
                    {"ok", "OK"},
                    {"choose script", "Zgjidhni skedarin"},
                    {"not empty", "Fushat nuk mund të jenë bosh"},
                    {"not numbers", "Të gjitha fushat përveç emrit dhe zhanrit, duhet të jenë numra të plotë"},
                            {"not update", "Nuk mund të përditësohet ky objekt"},
                            {"not this user", "Ju nuk mund të përditësoni vlerat e objekteve që nuk i keni krijuar ju"},
                            {"invalid enter coordinates", "Koordinatat e futura janë të pavlefshme"},
                            {"write coordinates", "Shkruani koordinatat përmes pikës me pikëpisje (;)"},
                            {"field need number", "Kjo fushë duhet të jetë një numër i plotë"},
                            {"null", "Vlera e zbrazët"},
                            {"not null", "Kjo fushë nuk mund të jetë e zbrazët"},
                            {"exit", "Dalje"},
                            {"map", "Harta"},
                            {"help", "Ndihmë"},
                            {"information", "Informacion"},
                            {"add", "Shto"},
                            {"script", "Ekzekuto skedarin"},
                            {"remove greater", "Fshi më të madhin"},
                            {"clear", "Pastro"},
                            {"searchLabel", "Kërko:"},
                            {"searchField", "shkruani tekstin"},
                            {"name", "Emri"},
                            {"creation date", "Data e krijimit"},
                            {"count fans", "Numri i fansave"},
                            {"single count", "Numri i këngëve të vetme"},
                            {"genre", "Zhanri"},
                            {"labels", "Labela (shitjet)"},
                            {"table", "Tabelë"},
                            {"delete", "Fshi"},
                            {"add", "Shto"},
                            {"coord x", "Koordinata x"},
                            {"coord y", "Koordinata y"},
                            {"input text", "Shkruani tekstin"}
            };
    public Object[][] getContents() {
        return contents;
    }
}
