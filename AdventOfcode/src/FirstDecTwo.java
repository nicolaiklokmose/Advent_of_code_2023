import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstDecTwo {
    public static void main(String[] args) throws Exception {
        int count = 0;

        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        try {
            // Replace "example.txt" with the path to your text file
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            // Read the file line by line
            while (scanner.hasNextLine()) {
                char[] lineArray = scanner.nextLine().toCharArray();

                for (int i = 0; i < lineArray.length; i++) {
                    if (Character.isDigit(lineArray[i])) {
                        count += (Character.getNumericValue(lineArray[i]) *  10);
                        break;
                    }
                    String substring = new String(lineArray, i, 4);
                    if (map.containsKey(substring)) {
                        count += map.get(substring);
                        break;
                    }
                }

                for (int i = lineArray.length-1; i >= 0; i--) {
                    if (Character.isDigit(lineArray[i])) {
                        count += Character.getNumericValue(lineArray[i]);
                        break;
                    }
                    String substring = new String(lineArray, i-4, 4);
                    if (map.containsKey(substring)) {
                        count += map.get(substring);
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
