package com.programs.executables.programs;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RemoveZerosAndAppendInEnd {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String a = "30460070";
        doItViaCollections(a);
        doItWithoutCollections(a);
    }

    private static void doItWithoutCollections(String a) {
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

    private static void doItViaCollections(String a) {
        AtomicInteger zeroCount = new AtomicInteger(0);
        a.chars().mapToObj(e -> e).filter(e -> {

            if(e == 0){
                zeroCount.incrementAndGet();
                return false;
            }
            return true;
        }).collect(Collectors.toList());
    }
}
