package az.spring.rest.demo.springrestdemo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dep_id")
    private Department department;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;

    private String name;
    private String surname;
    private int age;
    private double salary;
}
