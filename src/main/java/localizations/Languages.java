package localizations;

import java.util.Locale;
import java.util.ResourceBundle;

public class Languages {

    public static final ResourceBundle ru = ResourceBundle.getBundle("localizations.GUILabels", new Locale("ru", "RU"));

    public static final ResourceBundle en = ResourceBundle.getBundle("localizations.GUILabels", Locale.ENGLISH);

    public static final ResourceBundle ge = ResourceBundle.getBundle("localizations.GUILabels", new Locale("ge", "GE"));

    public static final ResourceBundle alb = ResourceBundle.getBundle("localizations.GUILabels", new Locale("alb", "ALB"));
}
