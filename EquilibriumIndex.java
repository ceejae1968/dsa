package algos;

import java.util.ArrayList;
import java.util.List;


public class EquilibriumIndex {
    public static void main(String[] args) {
        fetchEquilibriumIndex();
    }

    public static int fetchEquilibriumIndex(){
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(7);
        A.add(2);
        A.add(1);
        A.add(3);
        List<Integer> leftPrefixSum = new ArrayList<>();
        List<Integer> rightPrefixSum = new ArrayList<>();
        int sumFromLeft = 0;
        int sumFromRight = 0;
        int arrLength = A.size()-1;
        for(int i = 0; i < A.size(); i++){
            sumFromLeft += A.get(i);
            leftPrefixSum.add(sumFromLeft);
        }
        for(int i = arrLength; i >= 0; i--){
            sumFromRight += A.get(i);
            rightPrefixSum.add(sumFromRight);
        }
        for(int i = 0; i < arrLength; i++){
            int ls = leftPrefixSum.get(i)-A.get(i);
            int rs = leftPrefixSum.get(arrLength) - leftPrefixSum.get(i);
            if(ls == rs){
                return i;
            }
        }
        return -1;
    }
}
