package Homework;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Иван", 35, Arrays.asList(new Project("Project A", 8),
                        new Project("Project B", 5)), 70000),
                new Employee("Мария", 42, Arrays.asList(new Project("Project A", 12),
                        new Project("Project C", 7)), 80000),
                new Employee("Петр", 25, Arrays.asList(new Project("Project B", 3),
                        new Project("Project D", 2)), 40000),
                new Employee("Елена", 55, Arrays.asList(new Project("Project C", 9),
                        new Project("Project A", 10)), 90000),
                new Employee("Алексей", 38, Arrays.asList(new Project("Project B", 7),
                        new Project("Project C", 11)), 65000));

        Map<String, Double> projectAverageDuration = employees.stream()
                .filter(e -> e.getAge() >= 30 && e.getAge() <= 50 && e.getSalary() > 60000)
                .flatMap(e -> e.getProjectList().stream())
                .filter(p -> p.getDuration() > 6)
                .collect(Collectors.groupingBy(p -> p.getName().toUpperCase(),
                        Collectors.averagingInt(p -> p.getDuration())))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        k -> k.getKey(),
                        v -> v.getValue(),
                        (e1, e2) -> e1, () -> new LinkedHashMap<>()
                ));
        System.out.println(projectAverageDuration);
    }

}
