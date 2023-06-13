package localizations;


import java.util.ListResourceBundle;

public class GUILabels_en extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    {"dataFormat", "dd/MM/yyyy"},
                    {"failed to login", "Failed to login"},
                    {"failed to register", "Failed to register"},
                    {"welcome to music band", "Welcome to music band"},
                    {"Log to account", "Log in to your account"},
                    {"Register", "Register"},
                    {"name", "Username"},
                    {"password", "Password"},
                    {"loginButton", "Login"},
                    {"registerButton", "Register"},
                    {"language:", "Language:"},
                    {"have account", "Already have an account?"},
                    {"not have account", "Don't have an account?"},
                    {"toLoginButton", "Login"},
                    {"toRegisterButton", "Create"},
                    {"alb", "Albanian"},
                    {"en", "English"},
                    {"ru", "Russian"},
                    {"ge", "German"},
                    {"info about help", "About commands"},
                    {"help command", "info: display information about the collection\n" +
                            "show: display the elements of the collection\n" +
                            "add: add an element to the collection\n" +
                            "update: update a music band by id based on the given music band\n" +
                            "remove_by_id: remove a music band from the collection by id\n" +
                            "clear: clear the collection\n" +
                            "head: display the first element of the collection\n" +
                            "remove_greater: remove music bands that are greater than the given one\n" +
                            "history: display the last 11 commands\n" +
                            "filter_by_number_of_participants: display music bands with the specified number of participants\n" +
                            "print_descending: display the elements of the collection in descending order\n" +
                            "print_field_descending_genre: display the genre field values of all elements in descending order\n" +
                            "auth: log in as a user\n" +
                            "register: register a new user\n" +
                            "logout: log out of the account\n" +
                            "user_info: display information about the current user\n" +
                            "help: display detailed information about the commands\n" +
                            "exit: exit the program\n" +
                            "execute_script: execute commands from a file\n"},
                    {"info about commands", "About collection"},
                    {"info", "Data Type: java.util.LinkedList\n" +
                            "Initialization Date: "},
                    {"count elements", "Number of elements: "},
                    {"ok", "OK"},
                    {"choose script", "Choose a script"},
                    {"not empty", "Fields cannot be empty"},
                    {"not numbers", "All fields, except for name and genre, should be integers"},
                    {"not update", "Cannot update this object"},
                    {"not this user", "You cannot update values of objects that you did not create"},
                    {"invalid enter coordinates", "Invalid coordinates entered"},
                    {"write coordinates", "Write coordinates separated by semicolon (;)"},
                    {"field need number", "This field must be a number"},
                    {"null", "Null"},
                    {"not null", "This field cannot be empty"},
                    {"exit", "Exit"},
                    {"map", "Map"},
                    {"help", "Help"},
                    {"information", "Information"},
                    {"add", "Add"},
                    {"script", "Execute script"},
                    {"remove greater", "Remove greater"},
                    {"clear", "Clear"},
                    {"searchLabel", "Search:"},
                    {"searchField", "enter text"},
                    {"name", "Name"},
                    {"creation date", "Creation Date"},
                    {"count fans", "Number of Fans"},
                    {"single count", "Number of Singles"},
                    {"genre", "Genre"},
                    {"labels", "Label (Sales)"},
                    {"table", "Table"},
                    {"delete", "Delete"},
                    {"add", "Add"},
                    {"coord x", "Coordinate x"},
                    {"coord y", "Coordinate y"},
                    {"input text", "Enter text"}
            };
    public Object[][] getContents() {
        return contents;
    }
}
