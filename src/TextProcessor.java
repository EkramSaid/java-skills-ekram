public class TextProcessor {

    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return 0;
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    public static String replaceWord(String text, String oldWord, String newWord) {
        return text.replaceAll(oldWord, newWord);
    }

    public static void main(String[] args) {
        String sentence = "Java is fun and Java is powerful";

        int wordCount = countWords(sentence);
        String replaced = replaceWord(sentence, "Java", "Programming");

        System.out.println("Original sentence: " + sentence);
        System.out.println("Word count: " + wordCount);
        System.out.println("After replacement: " + replaced);
    }
}
