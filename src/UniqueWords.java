import java.util.HashMap;
import java.util.Map;

public class UniqueWords {
    public static void main(String[] args) {
        String[] words = {
                "яблоко", "банан", "вишня", "яблоко",
                "груша", "банан", "вишня", "апельсин",
                "груша", "мандарин", "лимон", "яблоко",
                "апельсин", "мандарин", "груша", "абрикос",
                "вишня", "яблоко", "банан", "апельсин"
        };

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова и их количество:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}