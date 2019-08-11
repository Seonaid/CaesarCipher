import edu.duke.*;
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch){
        String vowels = "AEIOUaeiou";
        int idx = vowels.indexOf(ch);
        if (idx != -1) return true;
        return false;
    }
    
    public void testIsVowel(){
        System.out.println("\nStart of testIsVowel");
        // Case: lower case vowel == true
        if (isVowel('a') != true) System.out.println("Error with lowercase vowel");
        // Case: upper case vowel == true
        if (isVowel('E') != true) System.out.println("Error with uppercase vowel");
        // Case: lower case consonant == false
        if (isVowel('n') != false) System.out.println("Error with lowercase consonant");        
        // Case: upper case consonant == false
        if (isVowel('G') != false) System.out.println("Error with uppercase consonant");        
        // Case: number == false
        if (isVowel('1') != false) System.out.println("Error with number");        
        // Case: punctuation == false
        if (isVowel('#') != false) System.out.println("Error with punctuation");                
        
        System.out.println("testIsVowel... all tests run");
    }
    
    public String replaceVowels(String phrase){
        StringBuilder oldString = new StringBuilder(phrase);
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < phrase.length(); i+= 1){
            if (isVowel(oldString.charAt(i))) {
                newString.append('*');
            } else {
                newString.append(oldString.charAt(i));
            }
        }
        return newString.toString();
    }
    
    public void testReplaceVowels(){
        System.out.println("\nStart of testReplaceVowels");
        // Case: empty string
        if (!replaceVowels("").equals("")) System.out.println("Error with empty string");
        // Case: no vowels
        if (!replaceVowels("tfgvb").equals("tfgvb")) System.out.println("Error with no vowels");
        
        // Case: single capital vowel
        if (!replaceVowels("A").equals("*")) System.out.println("Error with single uppercase vowel");
        
        // Case: single lowercaes vowel
        if (!replaceVowels("e").equals("*")) System.out.println("Error with single lowercase vowel");        

        // Case "Hello World" returns H*ll* W*rld
        if (!replaceVowels("Hello World").equals("H*ll* W*rld")) System.out.println("Error with base case");
        System.out.println("testReplaceVowels... all tests run");
    }
    
    public String emphasize(String phrase, char ch){
        StringBuilder oldString = new StringBuilder(phrase);
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < phrase.length(); i+= 1){
            if (Character.toUpperCase(oldString.charAt(i)) == Character.toUpperCase(ch)) {
                if (i % 2 == 0) {
                    newString.append('*');
                } else {
                    newString.append('+');
                }
            } else {
                newString.append(oldString.charAt(i));
            }
        }
        return newString.toString();        
    }

    public void testEmphasize(){
        System.out.println("\nStart of testEmphasize");
        // Case: empty string
        if (!emphasize("", 'a').equals("")) System.out.println("Error with empty string");
        // Case: no vowels
        if (!emphasize("tfgvb", 'g').equals("tf*vb")) System.out.println("Error with no vowels");
        
        // Case: single capital vowel
        if (!emphasize("A", 'A').equals("*")) System.out.println("Error with single uppercase vowel");
        
        // Case: single lowercaes vowel
        if (!emphasize("e", 'e').equals("*")) System.out.println("Error with single lowercase vowel");        

        // Case: single lowercaes vowel
        if (!emphasize("eee", 'e').equals("*+*")) System.out.println("Error with single lowercase vowel");
        
        // Case "Hello World" returns H*ll* W*rld
        if (!emphasize("dna ctgaaactga", 'a').equals("dn* ctg+*+ctg+")) System.out.println("Error with sample case");
        
        // Case "emphasize(“Mary Bella Abracadabra”, ‘a’)" return
        if (!emphasize("Mary Bella Abracadabra", 'a').equals("M+ry Bell+ +br*c*d*br+")) System.out.println("Error with second sample case");
        System.out.println("testEmphasize... all tests run");
    }    
}
