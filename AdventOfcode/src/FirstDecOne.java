import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FirstDecOne {
    public static void main(String[] args) throws Exception {
        int count = 0;
        try {
            // Replace "example.txt" with the path to your text file
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            // Read the file line by line
            while (scanner.hasNextLine()) {
                int a, b;
                char[] lineArray = scanner.nextLine().toCharArray();

                for (int i = 0; i < lineArray.length; i++) {
                    if (Character.isDigit(lineArray[i])) {
                        count += (Character.getNumericValue(lineArray[i]) *  10);
                        break;
                    }
                }

                for (int i = lineArray.length-1; i >= 0; i--) {
                    if (Character.isDigit(lineArray[i])) {
                        count += Character.getNumericValue(lineArray[i]);
                        break;
                    }
                }
            }
            scanner.close();
            System.out.println(count);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
