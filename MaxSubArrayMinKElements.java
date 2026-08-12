package programs;

public class MaxSubArrayMinKElements {
    public static void main(String args[]){
        int[] arr = new int[]{1,-2,2,-3};
        int k = 3;
        int max = 0;
        int res = 0;
        int refVal = 0;
        for(int i = 0; i < k; i++){
            max += arr[i];
            res += arr[i];
            refVal += arr[i];
        }

        for(int i = k; i < arr.length; i++){
            refVal = refVal + arr[i] - arr[i-k];
            max = Math.max(max+arr[i], refVal);
            res = Math.max(res, max);
        }
        System.out.println(res);
    }
}
