import edu.duke.*;
/**
 * Write a description of WordCounts here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordCounts {
    public void countShakespeare(){
        String [] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
        "likeit.txt", "macbeth.txt", "romeo.txt"};
        String[] common = getCommon(); // this loads the 20 most common English words from a file
        int[] counts = new int[common.length];
        // for the plays above, loop through and get common word counts for each
        for (int i =0; i<plays.length; i++){
            FileResource fr = new FileResource("CommonWordsData/" + plays[i]);
            countWords(fr, common, counts);
        }
        
        for (int i = 0; i < common.length; i++){
            System.out.println(common[i] + ": " + counts[i]);
        }
    }
    
    public String[] getCommon(){
        FileResource fr = new FileResource("CommonWordsData/common.txt");
        String[] common = new String[20];
        int index = 0;
        for (String word : fr.words()){
            common[index] = word;
            index += 1;
        }
        return common;
    }
    
    public int indexOf(String word, String[] common){
        // finds the first instance of word in the array common and returns that as the index
        for (int i = 0; i < common.length; i++){
            if (common[i].equals(word)) return i;
        }    
        return -1;
    }
    
    public void countWords(FileResource resource, String[] common, int[] counts){
        // for each word in the FileResource, determine the indexOf the word in common.
        // if the word is in the common list, increment the count at counts[idx]
        
        for (String word: resource.words()){
            word = word.toLowerCase();
            int idx = indexOf(word, common);
            if (idx != -1){
                counts[idx]++;
            }
        }
    }

    public void resetCounts(int[] counts){
        for (int i=0; i<counts.length; i++){
            counts[i] = 0;
        }
    }
    
    public void testCountWords(){
        System.out.println("\nStart of testCountWords");
        FileResource fr = new FileResource("CommonWordsData/common.txt");
        String[] common = getCommon();
        int[] counts = new int[common.length];
        // Case: countWords should find 1 for each word in common.txt
        countWords(fr, common, counts);
        if (counts[3] != 1) {
            System.out.println("Error counting in common.txt");
            for (int i = 0; i < common.length; i++){
                System.out.println(common[i] + ": " + counts[i]);
            }
        }
        
        FileResource fr1 = new FileResource("CommonWordsData/small.txt");
        resetCounts(counts);
        countWords(fr1, common, counts);
        if (counts[0] != 3) {        
            System.out.println("Error counting in small.txt");
            for (int i = 0; i < common.length; i++){
                System.out.println(common[i] + ": " + counts[i]);
            }   
        }
        System.out.println("testCountWords complete");
    }
}
