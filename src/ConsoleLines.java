import java.util.Calendar;
import java.util.List;

public final class ConsoleLines {

    public static boolean indo = true;
    public static StringBuilder line;

    public static StringBuilder MountLine(int length) {
        return MountLine(length, '-');
    }
    public static StringBuilder MountLine(int length, char letter) {
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < length; i++) {
            line.append(letter);
        }

        return line;
    }

    public static String GenerateSuperLine(int number) {
        return GenerateSuperLine(number, 10);
    }
    public static String GenerateSuperLine(int number, int length) {
        return GenerateSuperLine(number, length, '-');
    }
    public static String GenerateSuperLine(int number, int length, char letter) {
        return GenerateSuperLine(number, length, letter, '*');
    }
    public static String GenerateSuperLine(int number, int length, char letter, char asterisco) {

        int location = number % length;
        boolean hasAsterisco = false;
        StringBuilder line = MountLine(length, letter);

        if (indo) {
            if (location == length - 1) {
                indo = false;
            } else {
                line.setCharAt(location, asterisco);
                hasAsterisco = true;
            }
        } else {
            if (location == length - 1) {
                indo = true;
            } else {
                line.setCharAt((length - 1) - location, asterisco);
                hasAsterisco = true;
            }
        }

        if (hasAsterisco) {
            return line.toString();
        } else {
            return null;
        }
    }

    public static void GenerateLines(int length) {
        GenerateLines(length, 10);
    }
    public static void GenerateLines(int length, int lineLength) {
        GenerateLines(length, lineLength, '-');
    }
    public static void GenerateLines(int length, int lineLength, char letter) {
        GenerateLines(length, lineLength, letter, '*');
    }
    public static void GenerateLines (int length, int lineLength, char letter, char asterisco) {

        for (int i = 0; i < length; i++) {
            String lineDone = GenerateSuperLine(i, lineLength, letter, asterisco);

            if (lineDone != null) {
                System.out.println(lineDone);
            }
        }
    }
}
