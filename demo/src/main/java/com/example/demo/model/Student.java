package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Data provides all the properties thats why to maintain simplicity we use required properties
@Entity
@Table(name = "studentdetails")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    // Change this line - either rename the field or escape the column name
    @Column(name = "`add`") // Using backticks to escape the reserved keyword
    private String add; // You can keep the field name as "add" if you want

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getAdd() {
        return this.add;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}