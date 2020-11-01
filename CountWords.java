package readability;

class CountWords {

    private double words;
    private double sentence;
    private double characters;
    private double syllables;
    private double polysyllables;

    public CountWords(String str) {
        this.words = str.split(" |\\n|\\t").length;
        this.characters = str.replace(" ", "").trim().length();
        this.sentence = str.split("[!?.]").length;

        String numOfVowel = str.replaceAll("e\\b", "")
                .replaceAll("you", "a")
                .replaceAll("[aeiouy]{2}", "a")
                .replaceAll(" th "," a ")
                .replaceAll(",","")
                .replaceAll(" w "," a ")
                .replaceAll("[0-9]+", "a")
                .replaceAll("[^aeiouyAEIOUY |\\n|\\t]", "");

        this.syllables = numOfVowel
                .replaceAll(" ","")
                .length();
        this.polysyllables = numOfVowel
                .replaceAll("[aeiouyAEIOUY]{3,}", "X")
                .replaceAll("[^X]","")
                .length();
    }

    public double ari() {
        return 4.71 * (characters / words) + 0.5 * (words / sentence) - 21.43;
    }

    public double fk() {
        return 0.39 * (words / sentence) + 11.8 * (syllables / words) - 15.59;
    }

    public double smog() {
        return 1.043 * Math.sqrt(polysyllables * (30 / sentence)) + 3.1291;
    }

    public double cl() {
        return 0.0588 * (characters / words * 100)
                - 0.296 * (sentence / words * 100) - 15.8;
    }

    public void calcNumOfWords() {
        System.out.println("Words: " + String.format("%.0f", words));
        System.out.println("Sentences: " + String.format("%.0f", sentence));
        System.out.println("Characters: " + String.format("%.0f", characters));
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
    }
}
