package algos;

public class ContainerMaxArea {
    public static void main(String args[]){
        System.out.println(maxArea(new int[]{3,6,1}));
    }
    public static int maxArea(int[] height) {
        int columns = height.length;
        int[] leftMax = new int[columns];
        int[] rightMax = new int[columns];
        int bestLeft = height[0];
        int bestRight = height[columns-1];
        int maxCapacity = 0;
        for(int i = 0; i < columns; i++){
            bestLeft = height[i] > bestLeft ? height[i] : bestLeft;
            bestRight = height[columns-1-i] > bestRight ? height[columns-1-i] : bestRight;
            leftMax[i] = bestLeft;
            rightMax[columns-1-i] = bestRight;
            int minHeight = Math.min(bestLeft, bestRight);
            int capacity = minHeight*(columns-i-1);
            maxCapacity = capacity > maxCapacity ? capacity : maxCapacity;
        }


        return maxCapacity;
    }
}
