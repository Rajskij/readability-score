package readability;

import java.math.BigDecimal;
import java.math.RoundingMode;

class PrintScore {

    private String years;

    public void printScore(String name ,double score) {
        switch ((int) Math.round(score)) {
            case 1:
                years = "6";
                break;
            case 2:
                years = "7";
                break;
            case 3:
                years = "7-9";
                break;
            case 4:
                years = "10";
                break;
            case 5:
                years = "11";
                break;
            case 6:
                years = "12";
                break;
            case 7:
                years = "13";
                break;
            case 8:
                years = "14";
                break;
            case 9:
                years = "15";
                break;
            case 10:
                years = "16";
                break;
            case 11:
                years = "17";
                break;
            case 12:
                years = "18";
                break;
            case 13:
                years = "18-24";
                break;
            case 14:
                years = "24+";
                break;
            default:
                years = "there is no score";
                break;
        }
        System.out.println(name + ": "
                + new BigDecimal(score).setScale(2, RoundingMode.DOWN)
                + " (about " + years + " year olds)");
    }
}