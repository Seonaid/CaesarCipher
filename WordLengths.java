import edu.duke.*;
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {
    public void countWordLengths(FileResource fr, int[] counts){
        for (String word: fr.words()){
            int idx = word.length();
            if (!Character.isLetter(word.charAt(idx-1))) idx = idx - 1;
            if (!Character.isLetter(word.charAt(0))) idx = idx - 1;
            //System.out.println(word + " length = " + idx );
            if (idx < 30){
                counts[idx]++;
            } else {
                counts[30]++;
            }
        }        
    }
    
    public void resetCounts(int[] counts){
        for (int i=0; i<counts.length; i++){
            counts[i] = 0;
        }
    }
    
    public int indexOfMax(int[] values){
        int maxValue = 0;
        int idx = 0;
        for (int i=0; i<values.length; i++){
            if (values[i] > maxValue) {
                maxValue = values[i];
                idx = i;
            }
        }
        return idx;
    }
    
    public void testCountWordLengths(){
        System.out.println("\nStart of testCountWordLengths");
        // Case And,.length() == 3
        // Case "blue-jeans".length() == 10
        // Case "Hello," .length() == 6 (goddamit.)
        int[] counts = new int[30];
        // Case: common.txt has... 6 three letter words AND 3 four letter words
        FileResource fr = new FileResource("CommonWordsData/common.txt");
        countWordLengths(fr, counts);
        System.out.println("There are " + counts[4] + " four letter words.");
        System.out.println("There are " + counts[3] + " three letter words.");
        
        resetCounts(counts);
        FileResource small = new FileResource("CommonWordsData/small.txt");
        countWordLengths(small, counts);
        System.out.println("File contains odd words... " );
        if(counts[3] != 7) {
            System.out.println("There are " + counts[3] + " three letter words.");
            System.out.println("There are " + counts[10] + " ten letter words.");
        }
        
        resetCounts(counts);
        FileResource smallHamlet = new FileResource("CommonWordsData/smallHamlet.txt");
        countWordLengths(smallHamlet, counts);
        System.out.println("Small hamlet: " );
        for (int i=0; i<counts.length; i++){
            System.out.println(i + " : " + counts[i]);
        }
        System.out.println("Most common word length is: " + indexOfMax(counts));
        
        resetCounts(counts);
        FileResource romeo = new FileResource("CommonWordsData/lotsOfWords.txt");
        countWordLengths(romeo, counts);
        System.out.println("Lots of Words: " );

        System.out.println("Most common word length is: " + indexOfMax(counts));        
        
        System.out.println("End testCountWordLengths. All tests run.");
    }
}
