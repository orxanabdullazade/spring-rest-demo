package az.spring.rest.demo.springrestdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Department department;

    private String name;
    private String surname;
    private int age;
    private double salary;
}
