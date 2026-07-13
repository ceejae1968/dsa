package algos;

public class LongestPalindromeSubstring {
    public static void main(String args[]){
        System.out.println(getLengthOfLongestPalindromeSubstring("tattarrattat"));
    }

    private static String getLengthOfLongestPalindromeSubstring(String s) {
        int left = 0;
        int right = 0;
        int best = 0;
        String returnString = s;
        for(int i = 1; i < s.length(); i++){
            int length = 1;
            left = i-1;
            right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                length = length + 2;
                left--;
                right++;
            }
            if(length > best){
                best = length;
                returnString = s.substring(left+1,left+1+length);
            }
        }
        for(int i = 1; i < s.length(); i++) {
            int length = 1;
            left = i-1;
            right = i;
            while(right < s.length() && s.charAt(right-1) == s.charAt(right)){
                length++;
                right++;
                i = right;
            }

            if(length > best){
                best = length;
                returnString = s.substring(left,left + length);
            }
        }
        for(int i = 1; i < s.length(); i++) {
            int length = 0;
            left = i-1;
            right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                length = length + 2;
                left--;
                right++;
            }
            if(length > best){
                best = length;
                returnString = s.substring(left+1,left+1+length);
            }
        }

        return returnString;
    }
}
