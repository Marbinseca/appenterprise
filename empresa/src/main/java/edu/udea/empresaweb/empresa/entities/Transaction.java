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


@Data
@Entity
@Table(name = "Transaction")
public class Transaction {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "concept")
    private String concept;
    
    @Column(name = "account")
    private long account;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name="id_employee")
    private Employee employee;
    //@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    //private List<Employee> user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "id_enterprise")
    private Enterprise enterprise;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;


    @Column(name = "updatedAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;

}
