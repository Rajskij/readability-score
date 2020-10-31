package readability;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CountWords {

    private double countWords;
    private double countSentence;
    private double countCharacters;

    private double score;
    private String years;

    public void calcNumOfWords(String str) {

        countWords = str.split(" |\\n|\\t").length;
        countSentence = str.split("[!?.]").length;
        countCharacters = str.replace(" ", "").trim().length();

        score = 4.71 * (countCharacters / countWords) + 0.5 * (countWords / countSentence) - 21.43;



        switch ((int) Math.ceil(score)) {
            case 1:
                years = "5-6";
                break;
            case 2:
                years = "6-7";
                break;
            case 3:
                years = "7-9";
                break;
            case 4:
                years = "9-10";
                break;
            case 5:
                years = "10-11";
                break;
            case 6:
                years = "11-12";
                break;
            case 7:
                years = "12-13";
                break;
            case 8:
                years = "13-14";
                break;
            case 9:
                years = "14-15";
                break;
            case 10:
                years = "15-16";
                break;
            case 11:
                years = "16-17";
                break;
            case 12:
                years = "17-18";
                break;
            case 13:
                years = "18-24";
                break;
            case 14:
                years = "24+";
                break;
        }

        System.out.println("Words: " + String.format("%.0f", countWords));
        System.out.println("Sentences: " + String.format("%.0f", countSentence));
        System.out.println("Characters: " + String.format("%.0f", countCharacters));
        System.out.println("Th score is: " + new BigDecimal(score).setScale(2, RoundingMode.DOWN));
        System.out.println("This text should be understood by " + years + " year olds");
    }
}

