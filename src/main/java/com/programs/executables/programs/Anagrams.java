package com.programs.executables.programs;

import java.util.Map;

public class Anagrams {
    static void main(String[] args) {
        String str1 = "cat";
        String str2 = "tac";
        System.out.println(getIfAnagrams(str1, str2));
    }

    private static boolean getIfAnagrams(String str1, String str2) {
        int asciiA = 'A';
        if(str1.length() != str2.length()){
            return false;
        }
        int[] stringBinary1 = new int[26];
        int[] stringBinary2 = new int[26];
        for(int i = 0; i < str1.length(); i++){
            char input1 = str1.charAt(i);
            char input2 = str2.charAt(i);
            stringBinary1[input1-asciiA] += 1;
            stringBinary2[input2-asciiA] += 1;
        }

        for(int i = 0; i < 26; i++){
            if(stringBinary1[i] != stringBinary2[i]){
                return false;
            }
        }
        return true;
    }
}
