import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String PHONE_NUMBER_REGEX = "^0[35789][0-9]{8}$";
    public static final String DATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
    public static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    public static final String FULL_NAME = "^\\S[(.*?)\\D\\s]+\\S$";

    public static boolean validateString(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }


}
