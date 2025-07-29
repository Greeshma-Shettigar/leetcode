/*Given a string s, return the longest palindromic substring in s.
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb" */
public class longestpalindrome {
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // Odd-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);   // Even-length palindrome
            int len = Math.max(len1, len2);               // Longer of the two
            if (len > end - start) {         // If this  current palindrome length(len) is longer than the previous longest palindrome (end - start)
                start = i - ((len - 1) / 2);              // Update start
                end = i + (len / 2);                      // Update end
            }
        }

        return s.substring(start, end + 1); // Return the longest palindrome
    }

    private int expandAroundCenter(String s, int left, int right) {
        // Expand as long as chars on both ends match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }

    public static void main(String[] args) {
        longestpalindrome lp = new longestpalindrome();
        String input = "babad";
        String result = lp.longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + result); // Expected output: "bab" or "aba"
    }
    
}
