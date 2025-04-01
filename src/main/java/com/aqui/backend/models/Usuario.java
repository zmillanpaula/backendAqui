package com.aqui.backend.models;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String nombre;
    private String apellido;

    @Column(unique = true)
    private String email;

    private String contraseña;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro = new Date();

    //RELACIONES
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Comprador comprador;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Vendedor vendedor;


    




    
}
