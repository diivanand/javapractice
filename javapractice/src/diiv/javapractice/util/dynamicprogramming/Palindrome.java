package diiv.javapractice.util.dynamicprogramming;

/**
 * Created by Diiva on 3/28/2016.
 */
public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null | s.length() == 0) {
           throw new IllegalArgumentException("s must be a nonempty string");
        }
        else if (s.length() == 1) {
            return true;
        }
        else if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        }
        else {
            return (s.charAt(0) == s.charAt(s.length()-1)) && isPalindrome(s.substring(1,s.length()-1));
        }
    }

    public static void main(String[] args)
    {
        String[] words = new String[] {"a", "ab", "aa", "bat", "tat", "kettle", "baaaab"};
        for (String word : words)
        {
            System.out.printf("Is %s a palindrome?  %s %n", word, isPalindrome(word));
        }
    }
}
