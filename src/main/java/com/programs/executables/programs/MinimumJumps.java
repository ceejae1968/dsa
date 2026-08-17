package com.programs.executables.programs;

public class MinimumJumps {
    public static void main(String args[]){
//        int[] arr = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
//        int[] arr = new int[]{5, 5, 10, 7, 6, 9, 8, 5, 10, 6, 7, 7, 9, 8, 5};
//        int[] arr = new int[]{1,4, 3, 2, 6, 7};
        int[] arr = new int[]{9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1};

        System.out.println("Hops : " + extracted(arr));
    }

    private static int extracted(int[] arr) {
        int length = arr.length;
        int i = 0;
        int hops = 0;
        while(i < length){
            if(i == length-1){
                break;
            }
            int jumpSize = arr[i];
            if(jumpSize == 0) return -1;

            hops++;

            if(i+arr[i] > length-1){
                break;
            }

            int biggest = i + arr[i +1];
            int till = i + jumpSize ;
            if(till >= length-1){
                break;
            }

            for(int k = i +1; k <= till; k++){
                if(k + arr[k] >= biggest){
                    i = k;
                    biggest = arr[k] + k;
                }
            }
        }

        return hops;
    }
}
