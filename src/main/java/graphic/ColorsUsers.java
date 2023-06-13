package graphic;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class ColorsUsers {
    private static Map<Integer, Color> colorsUsers = new HashMap<>();

    public static Map<Integer, Color> getColorsUsers() {
        return colorsUsers;
    }

    public static void setColorsUsers(Map<Integer, Color> colorsUsers) {
        ColorsUsers.colorsUsers = colorsUsers;
    }
}
