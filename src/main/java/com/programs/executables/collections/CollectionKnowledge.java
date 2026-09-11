package com.programs.executables.collections;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionKnowledge {
    static void main() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        reverseList(numbers);
        convertToSetAndFilterEven(numbers);
        String text = "java streams java spring boot";
        wordFrequencyCounter(text);
        charFrequencyCounter(text);
        List<String> list = Arrays.asList("task1", "task2", "task3");
        geInSortedManner(list);
        Queue<String> tasks = new ArrayDeque<>(List.of("task1", "task2", "task3"));
        splitIntoEvenAndOdd();
        groupEmployeesByDeptThenRole();
    }

    private static void groupEmployeesByDeptThenRole() {

    }

    public static class Employee{
        private String dept;
        private String role;
    }

    private static void splitIntoEvenAndOdd() {
        List<Integer> intList = IntStream.range(1,10).boxed().toList();
        Map<Boolean, List<Integer>> groups = intList.parallelStream().collect(Collectors.partitioningBy(n -> n%2 == 0));
        System.out.println(groups);
    }

    private static void geInSortedManner(List<String> priorityQueue) {
        PriorityQueue<String> pqueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.stream().forEach(e -> pqueue.add(e));
    }

    private static void charFrequencyCounter(String text) {
        Map<Character, Long> charCountMap = text.chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy( e -> e, Collectors.counting()));
    }

    private static void wordFrequencyCounter(String text) {
        Map<String, Long> countMap = Arrays.stream(text.split(" ")).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
//        Arrays.stream(text.split(" ")).sorted(Comparator.naturalOrder());
//        Arrays.stream(text.split(" ")).sorted(Comparator.comparing(e -> e));
    }

    private static void convertToSetAndFilterEven(List<Integer> numbers) {
        Set<Integer> setNum = new HashSet<>(numbers);
        setNum.stream().filter(e -> e%2 == 0).toList();
    }

    private static void reverseList(List<Integer> numbers) {
        Collections.reverse(numbers);
    }
}
