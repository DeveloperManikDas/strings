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
            if (!b)
                return false;
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

    public static boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }

            // Mark their latest mapping position (i+1 to avoid default 0 confusion)
            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }

        return true;
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        String combined = s1 + s1;
        return combined.contains(s2); // You could roll your own .contains with char arrays if needed
    }

    public static boolean isOneEditAway(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (Math.abs(len1 - len2) > 1) return false;

        String shorter = len1 < len2 ? s : t;
        String longer = len1 < len2 ? t : s;

        int i = 0, j = 0;
        boolean foundDifference = false;

        while (i < shorter.length() && j < longer.length()) {
            if (shorter.charAt(i) != longer.charAt(j)) {
                if (foundDifference) return false;
                foundDifference = true;

                if (len1 == len2) i++; // Replace
            } else {
                i++; // Same char, move both
            }
            j++; // Always move pointer for longer string
        }

        return true;
    }

    public static boolean detectCapitalUse(String word) {
        int capitals = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                capitals++;
            }
        }

        if (capitals == word.length()) return true; // All capitals
        if (capitals == 0) return true;             // All lowercase
        if (capitals == 1 && Character.isUpperCase(word.charAt(0))) return true; // Only first is capital

        return false;
    }

  public static String toLowerCase(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char)(chars[i] + 32);
            }
        }

        return new String(chars);
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !isVowel(chars[left])) left++;
            while (left < right && !isVowel(chars[right])) right--;

            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) return i;
        }

        return -1;
    }

      public static int findMaxLength(int[] nums) {
        int n = nums.length;
        
        // Replace 0 with -1 to find longest subarray with sum=0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        
        int maxLen = 0;
        int prefixSum = 0;
        
        // prefixSum can be in range [-n, n], so size = 2*n + 1
        int size = 2 * n + 1;
        int[] firstOccurrence = new int[size];
        
        // Initialize with -2 meaning not occurred
        for (int i = 0; i < size; i++) {
            firstOccurrence[i] = -2;
        }
        
        // prefixSum 0 occurs at index -1 (before array start)
        firstOccurrence[n] = -1;  // offset by n
        
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            
            int idx = prefixSum + n;  // offset index
            
            if (firstOccurrence[idx] != -2) {
                // Calculate subarray length
                int len = i - firstOccurrence[idx];
                if (len > maxLen) maxLen = len;
            } else {
                // Store first occurrence of this prefix sum
                firstOccurrence[idx] = i;
            }
        }
        
        return maxLen;
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
        // System.out.print(canConstruct("manik", "maniktiya"));
        // System.out.print(isIsomorphic("manik", "maniktiya"));
        // System.out.print(isRotation("man", "nam"));
        // System.out.print(isOneEditAway("man", "nam"));
        // System.out.print(detectCapitalUse("man"));
        // System.out.print(toLowerCase("man"));
        System.out.print(strStr("maanik", "nik"));


    }
}

