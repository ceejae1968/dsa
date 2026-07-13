package algos;

import java.security.NoSuchAlgorithmException;

public class RemoveZerosAndAppendInEnd {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String a = "30460070";
        StringBuffer str = new StringBuffer();
        int countZero = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.substring(i,i+1).equalsIgnoreCase("0")){
                countZero++;
            } else {
                str.append(a.substring(i, i+1));
            }
        }
        for(int k = 0; k < countZero; k++){
            str.append("0");
        }
        System.out.println(str.toString());
    }
}
