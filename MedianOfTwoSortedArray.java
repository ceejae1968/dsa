package algos;

public class MedianOfTwoSortedArray {
    public static void main(String[] args){
        fetchMedian(new int[]{}, new int[]{2,3});
    }

    private static double fetchMedian(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int sum = n + m;
        int median1 = sum > 2 ? (sum%2 == 0 ? (sum/2) - 1 : (sum-1)/2) : 0;
        int median2 = sum > 2 ? (sum%2 == 0 ? (sum/2) : (sum-1)/2) : (sum == 2 ? 1 : 0);
        int ni = 0;
        int mi = 0;
        int i = 0;
        int[] mergedArray = new int[sum];
        while(i < sum && m > mi && n > ni){
            if (nums1[ni] <= nums2[mi]) {
                mergedArray[i] = nums1[ni];
                ni++;
            } else {
                mergedArray[i] = nums2[mi];
                mi++;
            }
            i++;
        }
        while(ni < n){
            mergedArray[i] = nums1[ni];
            ni++;
            i++;
        }

        while(mi < m){
            mergedArray[i] = nums2[mi];
            mi++;
            i++;
        }
        return (Double.valueOf(mergedArray[median1]) + Double.valueOf(mergedArray[median2]))/2.0;
    }
}
