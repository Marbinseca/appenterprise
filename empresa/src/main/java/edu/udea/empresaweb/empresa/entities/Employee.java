package edu.udea.empresaweb.empresa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
//import java.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "Employee")
public class Employee {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    //@NotNull(message = "Debe ingresar un email")
    @Column(name = "email", length = 50, nullable = false)
    private String email;


    @OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "Idprofile")
    private Profile profile;
    
    //@NotNull(message = "El rol del empleado puede ser Admin u operario")
    @Column(name = "role")
    private Enum_RoleName role;

    @Column(name = "createdAt", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;


    @Column(name = "updatedAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "id_enterprise")
    private Enterprise enterprise;

    /*@OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Transaction> transactions;

     */

   

    
}
