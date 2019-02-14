package io.zipcoder;

import java.lang.StringBuilder;
import java.util.Objects;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        int count = 0;
        String[] words = input.split("\\s+");
        for (String word : words) {
            if (word.charAt(word.length() - 1) == 'y' || word.charAt(word.length() - 1) == 'z') {
                count++;
            }
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        return base.replace(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        String noSpaceInput = input.replaceAll("\\s", "");
        char firstChar = noSpaceInput.charAt(0);
        int isCount = 0;
        int notCount = 0;
        for (int i = 1; i < noSpaceInput.length(); i++) {
            if ((firstChar == 'i' && noSpaceInput.charAt(i) == 's')) {
                // Character charString += (new char[]{firstChar, noSpaceInput.charAt(i)});
                isCount++;
                firstChar = noSpaceInput.charAt(i);
            }
            if (firstChar == 'n' && noSpaceInput.charAt(i) == 'o' && noSpaceInput.charAt(i + 1) == 't') {
                notCount++;
                firstChar = noSpaceInput.charAt(i);
            } else {
                firstChar = noSpaceInput.charAt(i);
            }
        }
        return isCount == notCount;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        char firstLetter = input.charAt(0);
        int lastIndex = input.length() - 1;
        boolean happy = true;
        int i = 1;
        while (i != lastIndex)
            if (firstLetter == 'g' && input.charAt(i) == 'g') {
                firstLetter = input.charAt(i);
                happy = true;
                i++;
            } else if (firstLetter != 'g' && input.charAt(i) == 'g') {
                firstLetter = input.charAt(i);
                happy = false;
                i++;
            } else {
                firstLetter = input.charAt(i);
                i++;
            }
        return happy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     * countTriple("xxxabyyyycd") // Should return 3
     * countTriple("a") // Should return 0
     */

    public Integer countTriple(String input) {
        int count = 0;
        int i = 1;
        char previousChar = input.charAt(0);
        int lastIndex = input.length() - 1;
        while (i != lastIndex)
            if (input.charAt(i) == previousChar && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                previousChar = input.charAt(i);
                i++;
            } else {
                previousChar = input.charAt(i);
                i++;
            }
        return count;
    }
}