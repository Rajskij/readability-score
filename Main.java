package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String str = "";
        File file = new File(args[0]);

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                str = sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + file.getPath());
        }
        CountWords count = new CountWords(str);
        count.calcNumOfWords();
        PrintScore print = new PrintScore();

        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): \n");

        String score = new Scanner(System.in).next();

        switch (score) {
            case "ARI":
                print.printScore("Automated Readability Index", count.ari());
                break;
            case "FK":
                print.printScore("Flesch–Kincaid readability tests", count.fk());
                break;
            case "SMOG":
                print.printScore("Simple Measure of Gobbledygook", count.smog());
                break;
            case "CL":
                print.printScore("Coleman–Liau index", count.cl());
                break;
            case "all":
                print.printScore("Automated Readability Index", count.ari());
                print.printScore("Flesch–Kincaid readability tests", count.fk());
                print.printScore("Simple Measure of Gobbledygook", count.smog());
                print.printScore("Coleman–Liau index", count.cl());
                break;
        }
    }
}