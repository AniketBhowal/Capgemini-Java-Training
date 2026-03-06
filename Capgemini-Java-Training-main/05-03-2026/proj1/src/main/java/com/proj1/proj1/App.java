package com.proj1.proj1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        // Setup
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GenericDBAdapter");
        EntityManager manager = emf.createEntityManager();
        EntityTransaction trans = manager.getTransaction();
        
        // CREATE - Add students
        trans.begin();
        Student s1 = new Student("FirstStudent", "test@email.com", "123456");
        Student s2 = new Student("SecondStudent", "second@email.com", "23456");
        manager.persist(s1);
        manager.persist(s2);
        trans.commit();
        System.out.println("Created: " + s1.getId() + ", " + s2.getId());
        
        // READ - Find student
        Student found = manager.find(Student.class, 1);
        System.out.println("Found: " + found);
        
        // UPDATE - Modify student
        trans.begin();
        found.setName("UpdatedName");
        found.setEmail("updated@email.com");
        trans.commit();
        System.out.println("Updated: " + manager.find(Student.class, 1));
        
        // DELETE - Remove student
        trans.begin();
        Student toDelete = manager.find(Student.class, 2);
        manager.remove(toDelete);
        trans.commit();
        System.out.println("Deleted student with ID 2");
        
        // Cleanup
        manager.close();  
        emf.close();
    }
}