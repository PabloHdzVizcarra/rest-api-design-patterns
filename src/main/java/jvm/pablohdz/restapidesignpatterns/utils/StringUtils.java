package jvm.pablohdz.restapidesignpatterns.utils;

public class StringUtils {
    
    public static String generateRandomIdWithLength(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(generateRandomChar());
        }
        return sb.toString();
    }
    
    public static String generateRandomChar() {
        return String.valueOf((char) (Math.random() * 26 + 'a'));
    }
}
