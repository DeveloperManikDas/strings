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

    public boolean isAnagram(String s, String t) {
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

    public static int countVowels(String s) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] index = new int[128]; // ASCII size
        for (int i = 0; i < 128; i++)
            index[i] = -1;

        int maxLen = 0, start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (index[c] >= start) {
                start = index[c] + 1; // Move start past the last duplicate
            }

            index[c] = end;
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int oddCount = 0;
        for (int freq : count) {
            if (freq % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }

    public static int firstUniqChar(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static boolean checkIfPangram(String s) {
        boolean[] seen = new boolean[26];

        for (char c : s.toCharArray()) {
            seen[c - 'a'] = true;
        }

        for (boolean b : seen) {
            if (!b) return false;
        }

        return true;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // System.out.println(isPalindrome("mom"));
        // System.out.println(capitalizeEachWord("mom is good"));

        // string obj = new string();
        // System.out.println(obj.isAnagram("anagram", "nagaram")); // true

        // System.out.println(reverseString("panic"));
        // System.out.print(countVowels("Manoeik"));
        // System.out.print(lengthOfLongestSubstring("qwe"));
        // System.out.print(canPermutePalindrome("qwe"));
        // System.out.print(firstUniqChar("qqwe"));
        // System.out.print(checkIfPangram("qqwe"));
        System.out.print(canConstruct("manik", "maniktiya"));


    }
}
