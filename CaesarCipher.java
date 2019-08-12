
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt(String input, int key){
        if (key < 0) key = 26  + key;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        StringBuilder sbIn = new StringBuilder(input);
        StringBuilder sbOut = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++){
            char ch = sbIn.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(ch));
            if (idx != -1){
                if (Character.isLowerCase(ch)){
                    sbOut.append(Character.toLowerCase(shiftedAlphabet.charAt(idx)));
                } else {
                    sbOut.append(shiftedAlphabet.charAt(idx));
                }
            } else {
                sbOut.append(ch);                
            }
        }
        return sbOut.toString();
    }
    
    public void testEncrypt(){
        System.out.println("\nStart testEncrypt");
        // Case: empty string returns empty string
        if (!encrypt("", 0).equals("")) System.out.println("Error processing empty string");
        // Case: key = 0 returns original string
        
        if (!encrypt("String Goes Here", 0).equals("String Goes Here")) 
        System.out.println("Error with key == 0" + " " + encrypt("String Goes Here", 0));
        
        // Case: encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23) == “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
        if (!encrypt("FIRST LEGION ATTACK EAST FLANK!", 23).equals("CFOPQ IBDFLK XQQXZH BXPQ CIXKH!")) {
            System.out.print("Error in key == 23: ");
            System.out.println("characters are ALL CAPS");
            System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        }
        
        if (!encrypt("First Legion", 23).equals("Cfopq Ibdflk")) {
            System.out.print("Error in key == 23: ");
            System.out.println("characters are Mixed Case");        
            System.out.println(encrypt("First Legion", 23));
        }

        
        if (!encrypt("First Legion", 17).equals("Wzijk Cvxzfe")) {
            System.out.print("Error in key == 17: ");
            System.out.println("characters are Mixed Case");        
        }
        
        if (!encrypt("The quick Brown Fox jumped over the Lazy Dog!", 7)
            .equals("Aol xbpjr Iyvdu Mve qbtwlk vcly aol Shgf Kvn!")) {
                System.out.println("Error in Mixed Case pangram: key == 7");
        }
        
        if (!encrypt("String Goes Here", -1).equals("Rsqhmf Fndr Gdqd")) {
            System.out.println("Error with negative key == -1 should wrap to 25");
        }
        
        if (!encrypt("String Goes Here", 26).equals("String Goes Here")){
            System.out.println("Error with wrap... key == 26 should wrap to 0.");
        }
        System.out.println("testEncrypt... all tests run");
    }
    
    public String encryptTwoKeys(String phrase, int key0, int key1){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet0 = alphabet.substring(key0) + alphabet.substring(0, key0);
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);        
        StringBuilder sbIn = new StringBuilder(phrase);
        StringBuilder sbOut = new StringBuilder();
        
        for (int i = 0; i < phrase.length(); i++){
            char ch = sbIn.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(ch));
            if (idx != -1){
                if (i%2 == 0) {
                    if (Character.isLowerCase(ch)){
                        sbOut.append(Character.toLowerCase(shiftedAlphabet0.charAt(idx)));
                    } else {
                        sbOut.append(shiftedAlphabet0.charAt(idx));
                    }                
                } else {
                    if (Character.isLowerCase(ch)){
                        sbOut.append(Character.toLowerCase(shiftedAlphabet1.charAt(idx)));
                    } else {
                        sbOut.append(shiftedAlphabet1.charAt(idx));
                    }
                }
            } else {
                sbOut.append(ch);                
            }
        }
        return sbOut.toString();
    }
    
    public void testEncryptTwoKeys(){
        System.out.println("\nStart testEncrypt");
        // Case: empty string returns empty string
        if (!encryptTwoKeys("", 0, 0).equals("")) System.out.println("Error processing empty string");
        // Case: key = 0 returns original string
        
        if (!encryptTwoKeys("String Goes Here", 0, 0).equals("String Goes Here")) 
        System.out.println("Error with key == 0" + " " + encrypt("String Goes Here", 0));
        
        // CASE ALL CAPS two keys
        if (!encryptTwoKeys("FIRST LEGION", 23, 17).equals("CZOJQ IVDZLE")) {
            System.out.print("Error in key == 23, 17: ");
            System.out.println("characters are ALL CAPS");        
            System.out.println(encryptTwoKeys("FIRST LEGION", 23, 17));
        }

        // CASE Mixed Case two keys
        if (!encryptTwoKeys("First Legion", 23, 17).equals("Czojq Ivdzle")) {
            System.out.print("Error in key == 23, 17: ");
            System.out.println("characters are Mixed Case");        
            System.out.println(encryptTwoKeys("First Legion", 23, 17));
        }
        
        
        if (!encrypt("The quick Brown Fox jumped over the Lazy Dog!", 7)
            .equals("Aol xbpjr Iyvdu Mve qbtwlk vcly aol Shgf Kvn!"))
            // Aol xbpjr Iyvdu Mve qbtwlk vcly aol Shgf Kvn!
            // Ftq cguow Ndaiz Raj vgybqp ahqd ftq Xmlk Pas!
            {
                System.out.println("Error in Mixed Case pangram: key == 7");
                System.out.println(encrypt("The quick Brown Fox jumped over the Lazy Dog!", 12));
        }

        System.out.println("testEncryptTwoKeys... all tests run");
    }
    
    public void quizQuestions(){
        System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", 15));
        System.out.println(encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21, 8));
        
    }
}
