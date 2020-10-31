package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        String str = "";

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                str = sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + file.getPath());
        }

        new CountWords().calcNumOfWords(str);
    }
}
