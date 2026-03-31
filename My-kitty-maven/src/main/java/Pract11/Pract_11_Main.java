package Pract11;

import java.util.*;
import java.util.stream.Collectors;

public class Pract_11_Main {
    public static void main(String[] args) {

        //Task 1
        System.out.println("Task 1");
        List<Book> books = List.of(
                new Book("Clean Code", "Robert Martin", 2008, List.of("clean", "practice", "java")),
                new Book("Effective Java", "Joshua Bloch", 2018, List.of("java", "best", "api")),
                new Book("Modern Java", "Nicolai Parlog", 2020, List.of("java", "streams", "records")),
                new Book("Java Concurrency", "Brian Goetz", 2006, List.of("concurrency", "java"))
        );
        List<String> after2015 = books.stream()
                .filter(b -> b.year() > 2015)
                .map(b -> b.title().toUpperCase())
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(after2015);
        System.out.println();
        //Task2
        System.out.println("Task 2");

        List<String> result = books.stream()
                .flatMap(b -> b.tags().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        Map<String, Long> tagFrequency = books.stream()
                .flatMap(b -> b.tags().stream())
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));
        int n = 4;
        List<String> topTag = tagFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Tags: " + result);
        System.out.println("Tag frequency:" + tagFrequency);
        System.out.println("Top-"+n+" tag: " + topTag);
        System.out.println();
        System.out.println("Task 3");


        //Task 3

        List<Sale> sales = List.of(
                new Sale("a@ex.com", "Tea", 120),
                new Sale("b@ex.com", "Cake", 200),
                new Sale("a@ex.com", "Tea", 120),
                new Sale("c@ex.com", "Coffee", 150),
                new Sale("b@ex.com", "Cake", 200)
        );
        Map<String, Integer> sum = sales.stream()
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum
                ));
        System.out.println("Sum :" + sum);
        Map<String, Long> transactions = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::customerEmail,
                        Collectors.counting()
                ));
        System.out.println("Transactions:" + transactions);
        System.out.println();
        System.out.println("Task 4");


        //Task 4
        List<Result> results = List.of(
                new Failure("Oopsie"),
                new Success("Hurray!!!!"),
                new Failure("Ummmm......"),
                new Success("PEREMOGA!!!!"),
                new Failure("Error")
        );
       long countEr = results.stream()
               .filter(Failure.class::isInstance)
               .count();
       long countSuc = results.stream()
               .filter(Success.class::isInstance)
               .count();
       System.out.println("Amount of Error: " +countEr);
       System.out.println("Amount of Success: "+countSuc);
        List<String> errorMessages = results.stream()
                .filter(r -> r instanceof Failure)
                .map(r -> (Failure) r)
                .map(Failure::error)
                .toList();
        System.out.println("error: " + errorMessages);


        Map<Boolean, List<Book>> recentVsOld = books.stream()
                .collect(Collectors.partitioningBy(b -> b.year() > 2015));
        System.out.println();
        System.out.println("New after 2015-true: " + recentVsOld.get(true));
        System.out.println("Old before 2015-false: " + recentVsOld.get(false));
        System.out.println();

        Map<String, Integer> sortedRevenue = sales.stream()
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum,
                        TreeMap::new
                ));
        System.out.println(sortedRevenue);
    }
}

