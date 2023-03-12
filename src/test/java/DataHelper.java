import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

public class DataHelper {

    private DataHelper() {
    }
    private static Faker faker = new Faker(new Locale("en"));
    @Value
    public static class AuthInfo {
        String month ;
        int year ;
        String code;
        String name;
    }

    @Value
    public static class CardInfo {
        private String cardNumber;
    }

    public static CardInfo getFirstCardNumber() {
        return new CardInfo("1111 2222 3333 4444");
    }

    public static CardInfo getSecondCardNumber() {
        return new CardInfo("5555 6666 7777 8888");
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("01", 24, "111" ,"Vera");
    }
    public static AuthInfo getInvalidInfo() {
        return new AuthInfo("15",20,"998","111");
    }

    public static String generateRandomName() {
        return faker.name().fullName();
    }

    public static String generateValidMonth() {
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        Random index = new Random();
        int indexInt = index.nextInt(months.length);
        String randomMonth = months[indexInt];
        return randomMonth;
    }
    public static String generateInvalidMonth() {
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Random index = new Random();
        int indexInt = index.nextInt(months.length);
        String randomMonth = months[indexInt];
        return randomMonth;
    }
    public static String generateNotExistMonth() {
        String[] months = {"15", "25", "35", "45"};
        Random index = new Random();
        int indexInt = index.nextInt(months.length);
        String randomMonth = months[indexInt];
        return randomMonth;
    }
    public static int generateRandomYear() {
        return faker.number().numberBetween(24,29);
    }
    public static int generateInvalidRandomYear() {
        return faker.number().numberBetween(19,22);
    }
    public static String generateValidCode() {
        String[] codes = {"111", "222", "333", "444", "555", "666", "777", "888", "999", "100", "110", "120"};
        Random index = new Random();
        int indexInt = index.nextInt(codes.length);
        String randomCode = codes[indexInt];
        return randomCode;
    }
    public static String generateInvalidCode() {
        String[] codes = {"1", "2", "3"};
        Random index = new Random();
        int indexInt = index.nextInt(codes.length);
        String randomCode = codes[indexInt];
        return randomCode;
    }
    public static AuthInfo generateRandomInfo() {
        return new AuthInfo(generateValidMonth(), generateRandomYear(), generateValidCode(), generateRandomName());
    }
}


