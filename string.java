public class string {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }

        return true; // It's a palindrome
    }

    public static String capitalizeEachWord(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split("\\s+"); // split by spaces
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return result.toString().trim(); // remove trailing space
    }

    public  boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] count = new int[26]; // only lowercase English letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // increment for s
            count[t.charAt(i) - 'a']--; // decrement for t
        }

        for (int val : count) {
            if (val != 0)
                return false;
        }

        return true;
    }

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            // swap characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
        return new String(chars);
    }
    

    public static void main(String[] args) {
        // System.out.println(isPalindrome("mom"));
        // System.out.println(capitalizeEachWord("mom is good"));

        // string obj = new string();
        // System.out.println(obj.isAnagram("anagram", "nagaram")); // true

        System.out.print(reverseString("Manik"));

    }
}
