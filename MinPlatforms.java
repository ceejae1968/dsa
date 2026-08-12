package programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class MinPlatforms {
    static void main() {
//        int[] arr = new int[]{900, 940, 950, 1100, 1500, 1800};
//        int[] dep = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        int[] arr = new int[]{646, 1812, 1953, 1859, 46, 1935, 1624, 617, 1645, 628};
        int[] dep = new int[]{805, 2200, 2106, 2333, 1554, 2047, 2020, 1900, 2048, 2351};
        System.out.println(minPlatformOptimised(arr, dep));
    }

    private static int minPlatformOptimised(int[] arr, int[] dep) {
        int minDifference = dep[0] - arr[0];
        int minTime = arr[0];
        int maxTime = dep[0];
        for(int i = 0; i < arr.length; i++){
            int arrival = arr[i];
            int departure = dep[i];
            minDifference = Math.min(departure - arrival, minDifference);
            minTime = Math.min(arr[i], minTime);
            maxTime = Math.max(dep[i], maxTime);
        }

        int range = (maxTime - minTime) % minDifference > 0 ? ((maxTime - minTime) / minDifference) +1 : (maxTime - minTime) / minDifference;
        int[] timelineArray = new int[range];
        for(int i = 0; i < range; i+minDifference)

    }

    public static int minPlatform(int arr[], int dep[]) {
        //  code here
        if(arr.length < 2){
            return arr.length;
        }
        Integer[] indices = IntStream.range(0, arr.length).boxed().toArray(Integer[]::new);
        Arrays.sort(indices, Comparator.comparingInt(a -> arr[a]));
        int[] arr2 = Arrays.stream(indices).mapToInt(i -> arr[i]).toArray();
        int[] dep2 = Arrays.stream(indices).mapToInt(i -> dep[i]).toArray();
        int max = 1;
        int platforms = 0;
        int arrival = arr2[0];
        int departure = dep2[0];
        for(int i=1; i < arr2.length; i++){
            if(arr2[i] > departure){
                departure = dep2[i];
                arrival = arr2[i];
                max = 1;
            } else if(arr2[i] <= departure){
                if(arr2[i] <= arrival){
                    max++;
                }
                departure = Math.max(dep2[i], departure);
                arrival = arr2[i];
            }
            platforms = Math.max(max, platforms);

        }
        return platforms;
    }
}
