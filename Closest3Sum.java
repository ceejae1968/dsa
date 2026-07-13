package algos;

public class Closest3Sum {
    public static void main(String args[]){
        threeSumClosest(new int[]{-1,2,1,-4}, 1);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int a=0, b=0, c=0;
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j=i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    int distance = sum > target ? sum-target : target-sum;
                    if(distance < closest){
                        closest = distance;
                        a=i;
                        b=j;
                        c=k;
                    }
                }
            }
        }
            return nums[a] + nums[b] + nums[c];
    }
}
