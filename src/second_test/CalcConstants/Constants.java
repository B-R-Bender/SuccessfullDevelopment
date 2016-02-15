package second_test.CalcConstants;

import java.awt.*;

/**
 * Created by bender on 30.01.16.
 */
public class Constants {
    public static final Font DISPLAY_FONT;
    public static final String CONVERT_LABEL_TEXT;
    public static final Dimension CONVERTING_BUTTONS_SIZE;
    public static final Dimension MAIN_BUTTONS_SIZE;
    public static final Color BUTTON_PRESSED;
    public static final Color BUTTON_RELEASED;
    public static final String ERROR_MESSAGE;
    public static final String DIV_BY_ZERO_MSG;

    static {
        DISPLAY_FONT = new Font("Courier New", Font.BOLD, 15);
        CONVERT_LABEL_TEXT = "Converting tool";
        CONVERTING_BUTTONS_SIZE = new Dimension(50, 20);
        MAIN_BUTTONS_SIZE = new Dimension(65, 25);
        BUTTON_PRESSED = Color.GREEN;
        BUTTON_RELEASED = Color.getColor("E0FFFF");
        ERROR_MESSAGE = "A problem occurred. Check input.";
        DIV_BY_ZERO_MSG = "Division by zero, achievement unlock!!! Congrats!";
    }
}
