package com.proj1.proj1;
import jakarta.persistence.*;

@Entity // Marks this class as a JPA entity (maps to a database table)
@Table(name = "students") // Specifies the table name in the database
public class Student {
    
    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment the ID
    private Long id;
    
    @Column(name = "name", nullable = false) // Maps to 'name' column, cannot be null
    private String name;
    
    @Column(name = "email", unique = true) // Maps to 'email' column, must be unique
    private String email;
    
    @Column(name = "phone") // Maps to 'phone' column
    private String phone;
    
    // Default constructor (required by JPA)
    public Student() {}
    
    // Constructor with parameters
    public Student(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    // Getters and Setters (required for JPA)
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "', phone='" + phone + "'}";
    }
}
