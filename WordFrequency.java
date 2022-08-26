import java.util.*;

/**
 * This java program calculates the word frequency 
 * of a given input text and prints the number of times
 * each word occurred in the input text. It prints the output
 * in the descending order of frequencies.
 * @author Subashini Shanmugadas
 */
public class WordFrequency {
    private Map<String, Integer> wordFrequencyMap;

    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter text: ");
        String inputText = scannerObj.nextLine();
        if((inputText == null) || (inputText.length() == 0) ||
                ((inputText.trim()).length() == 0)) {
            System.out.println("Input text cannot be empty exiting... : ");
            System.exit(-1);
        }
        WordFrequency wordFrequencyObj = new WordFrequency();
        String[] words = wordFrequencyObj.getWords(inputText);
        Map<String, Integer> wordFrequencyMap = wordFrequencyObj.getWordFrequency(words);
        Map<String, Integer> wordFrequencySortedMap = wordFrequencyObj.sortByWordFrequency(wordFrequencyMap);
        wordFrequencyObj.printWordFrequency(wordFrequencySortedMap);
    }

    /**
     * Given an input text this method returns an array of words in the text
     * @param inputText
     * @return String array of words
     */
    private String[] getWords(String inputText) {
        if((inputText == null) || (inputText.length() == 0))
            return null;
        String[] wordsArray = inputText.split("\\s+");
        return wordsArray;
    }

    /**
     * Given an array of words, this method returns the frequency count of
     * each word in the array as a map.
     * @param words - array of String
     * @return Map of frequency count of the words in the array
     */
    private Map<String, Integer> getWordFrequency(String[] words) {
        wordFrequencyMap = new HashMap<>();
        if((words == null) || (words.length == 0))
            return null;
        for(String word : words) {
            int count = 1;
            if(wordFrequencyMap.containsKey(word)) {
                count = wordFrequencyMap.get(word);
                count += 1;
            }
            wordFrequencyMap.put(word, count);
        }
        return wordFrequencyMap;
    }

    /**
     * This is a helper function to print the entries in the given Map
     * to the console.
     * @param wordFrequencySortedMap
     */
    private void printWordFrequency(Map<String, Integer> wordFrequencySortedMap) {
        if(wordFrequencyMap != null){
            for(Map.Entry<String, Integer> entry : wordFrequencySortedMap.entrySet()) {
                System.out.println(entry.getValue() + " " + entry.getKey());
            }
        }
    }

    /**
     * Given an unsorted map of words with their respective frequencies, this
     * function returns a sorted map of the words in the descending order of frequencies
     *
     * @param wordFrequencyMap
     * @return
     */
    private Map<String, Integer> sortByWordFrequency(Map<String, Integer> wordFrequencyMap) {
        Map<String, Integer> wordFrequencySortedMap = new LinkedHashMap<>();
        wordFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> wordFrequencySortedMap.put(x.getKey(), x.getValue()));
        return wordFrequencySortedMap;
    }
}