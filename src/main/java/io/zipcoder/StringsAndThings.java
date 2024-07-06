package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {
    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        //https://www.geeksforgeeks.org/split-string-java-examples/
        //https://www.w3schools.com/java/ref_string_split.asp
        String x = input;//Copies the input string into a new variable x.
        int counter = 0;//Initializes a counter variable to count words ending with 'y' or 'z'.
        String[] strings = x.split(" ");//Splits the string x into an array of strings (strings), where each element in the array corresponds to a word separated by spaces in the original string.
        for (int i = 0; i < strings.length; i++) {//Iterates through each element (word) in the strings array.
            if (strings[i].endsWith("y") || (strings[i].endsWith("z"))) {//Checks if the current word (strings[i]) ends with either 'y' or 'z'.
                counter++;//If true, increments the counter variable.
            }
        }
        System.out.println(x);
        return counter;//Returns the final count of words ending with 'y' or 'z' from the input string.
    }
    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        //given 2 strings, return the new string with all the removed based.
        //(.replace) function - takes two value, what you're replacing and what you're replacing it with
        //https://www.baeldung.com/java-remove-replace-string-part
        String s = base.replace(remove, "");
        System.out.println(s);
        return s; //The return is made easier if we just 'return base.replace(remove, "");' will be quicker than designating a new variable
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        //check if the input contains equal number of "is" and "not"
        //if #not = #is = true; if #not < #is return false
        //https://www.baeldung.com/java-remove-replace-string-part
        int orgLength = input.length(); //store original string input
        int isLength = removeString(input, "is").length(); // invoke removeString to remove all "is"
        int countIs = (orgLength - isLength) / 2; // Calculates how many "is" by subtracting the new length from the original length and dividing by 2 (since "is" has 2 characters).
        int notLength1 = removeString(input, "not").length(); // Removes all occurrences of "not" from the input string and calculates the new length after removal.
        int countNot =(orgLength - notLength1) / 3; // Calculates the number of occurrences of "not" by subtracting the new length from the original length and dividing by 3 (since "not" has 3 characters).
        System.out.println(countIs == countNot);
        return countIs == countNot; //Compares the counts of "is" and "not". If they are equal, returns true; otherwise, returns false.
    }
    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        //https://www.w3schools.com/java/ref_string_charat.asp
        boolean gHappy = false;//initialize to keep track of happy g's
        for(int i = 0; i < input.length(); i++) { //iterate through each character in the input string
            if (i > 0) { //don't check 1st character
                if (input.charAt(i) == 'g' && input.charAt(i + 1) == 'g') { //check if current char is "g" and the next char. is also "g"
                    gHappy = true; // = gHappy true condition
                    break; // loop break
                }
            }
        }
        System.out.println(gHappy);
        return gHappy;
    }
    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int counter = 0; //initialize counter
        for(int i = 0; i < input.length(); i++) { // Iterates through each character in the input string.
            while (i + 2 < input.length() && input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(i+2)) { //Checks if the current char (input.charAt(i)) is equal to the next two char (input.charAt(i + 1) and input.charAt(i + 2)).
                i++;//moves index foward by one to skip over identified triple                                          //i + 2 < input.length(): Ensures that there are at least three characters remaining in the string to check.
                counter++;//increment counter on discovery of a triple                                                 //input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(i + 2): Ensures that all three characters are identical.
            }
            System.out.print(counter);
        }   return counter;
    }
}
