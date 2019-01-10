package util;

public class Validator {
    private final static String TEXT = "^[a-z][a-zA-Z,-:. ]*$";
    public  static  boolean isCorrectString(String str) {
        return str.matches(TEXT);
    }
    //for password
    // String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
}
