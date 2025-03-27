package Homework;

import java.util.List;
import java.util.Objects;

public class Employee {
    private String name;
    private int age;
    private List<Project> projectList;
    private int salary;


    public Employee(String name, int age, List<Project> projectList, int salary) {
        this.name = name;
        this.age = age;
        this.projectList = projectList;
        this.salary = salary;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && salary == employee.salary && Objects.equals(name, employee.name)
                && Objects.equals(projectList, employee.projectList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, projectList, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", projectList=" + projectList +
                '}';
    }
}
