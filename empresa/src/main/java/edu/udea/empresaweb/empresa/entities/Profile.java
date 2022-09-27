package edu.udea.empresaweb.empresa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Profile")
public class Profile {
    //Atributos
    @Id
    private long id;
    
    @Column(name = "image")
    private String image;
    
    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;


    @Column(name = "updatedAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Employee employee;

    
   
}
