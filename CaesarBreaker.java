import edu.duke.*;
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarBreaker {   
    public void eyeballDecrypt(){
        CaesarCipher cc = new CaesarCipher();
        String encrypted = "CFOPQ IBDFLK XQQXZH BXPQ CIXKH!";
        for (int i=1; i<26; i++){
            System.out.println(cc.encrypt(encrypted, i));
        }        
    }
    
    public int[] countLetters(String message){
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k< message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int idx = alphabet.indexOf(ch);
            if (idx !=-1){
                counts[idx]++;
            }
        } 
        
        return counts;
    }
    
    public void testCountLetters(){
        System.out.println("\nStart testCountLetters");
        
        //Case: empty string
        if (countLetters("")[4] != 0) System.out.println("Error with empty string.");
        
        // Case: "eeeee"
        if (countLetters("eeeee")[4] != 5) System.out.println("Error with all e's.");
        
        // Mixed case
        if (countLetters("Pizza pie")[15] != 2) System.out.println("Error with mixed cases");
        System.out.println("End testCountLetters. All tests run.");
        //
    }
    
    public String decrypt(String message){
        CaesarCipher cc = new CaesarCipher();
        int maxDex = getKey(message);
        int dkey = maxDex - 4;
        if (maxDex < 4) dkey = 26 - (4 - maxDex);
        return cc.encrypt(message, 26-dkey);
    }
    
    public int getKey(String message){
        int dkey = 0;
        WordLengths wl = new WordLengths();
        int[] freqs = countLetters(message);
        int maxDex = wl.indexOfMax(freqs);
        if (maxDex < 4) { 
            dkey = 26 - (4 - maxDex);
        } else { 
            dkey = maxDex - 4; 
        }
        return dkey;
    }
    
    public String halfOfString(String message, int start){
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < message.length(); i+=2){
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }
    
    public String decryptTwoKeys(String message){
        CaesarCipher cc = new CaesarCipher();
        String firstHalf = halfOfString(message, 0);
        String secondHalf = halfOfString(message, 1);
        
        int key1 = getKey(firstHalf);
        System.out.println("Key is:  " + key1);
        int key2 = getKey(secondHalf);
        System.out.println("Key is:  " + key2);
        
        return cc.encryptTwoKeys(message, 26-key1, 26-key2);
    }
    
    public void testDecrypt(){
        CaesarCipher cc = new CaesarCipher();
        // this is a very hard problem... and there aren't enough es, 7
        // aopz pz h clyf ohyk wyvislt... huk aolyl hylu'a luvbno lz
        
        System.out.println(cc.encrypt("aopz pz h clyf ohyk wyvislt... huk aolyl hylu'a luvbno lz", 19));

        // Case: encryption key > 4 (7)
        System.out.println(decrypt("aopz pz h clyf ohyk wyvislt... huk aolyl hylu'a luvbno lz"));
        
        // Case: encryption key < 4 (3)
        System.out.println("Key is 3: " + decrypt("wklv lv d yhub kdug sureohp... dqg wkhuh duhq'w hqrxjk hv"));
        
        
        System.out.println(halfOfString("Top ncmy qkff vi vguv vbg ycpx", 0));
        System.out.println("Top ncmy qkff vi vguv vbg ycpx");
        System.out.println(decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko"));
        System.out.println(decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));
        
    }
    
    public void decryptFile(){
        FileResource fr = new FileResource();
        String wholeFile = fr.asString();
        
        System.out.println(decryptTwoKeys(wholeFile));
    }
}
