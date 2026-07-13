package algos;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class ReverseString {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "HELLO ALL TODAY";
        StringBuffer reversedStr = new StringBuffer();
        int j = str.length()-1;
        while(j >= 0){
            reversedStr.append(str.substring(j, j+1));
            j--;
        }

        String reverseOfStr = reversedStr.toString();
        StringBuffer requiredString = new StringBuffer();
        int i = 0;
        int startOfWord = 0;
        while(i < str.length()){
            if(reverseOfStr.substring(i, i+1).equalsIgnoreCase(" ")){
                StringBuffer reverseWord = new StringBuffer();
                for(int k = i; k > startOfWord ; k--){
                    reverseWord.append(reverseOfStr.substring(k-1, k));
                }
                reverseWord.append(" ");
                requiredString.append(reverseWord.toString());
                startOfWord = i + 1;
            } else if(Objects.equals(i, str.length()-1)){
                StringBuffer reverseWord = new StringBuffer();
                for(int k = i+1; k > startOfWord ; k--){
                    reverseWord.append(reverseOfStr.substring(k-1, k));
                }
                requiredString.append(reverseWord.toString());
                startOfWord = i + 1;
            }
            i++;
        }
        System.out.println(requiredString);

    }

}
