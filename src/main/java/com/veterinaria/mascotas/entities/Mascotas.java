package com.veterinaria.mascotas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mascotas_adopcion")
@Data
public class Mascotas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "adoptado", nullable = false)
    private Boolean adoptado;
    @Column(name = "adoptado_date", nullable = true)
    private Date adoptadoDate;
    @Column(name = "persona_nombre", nullable = false)
    private String personaNombre;
    @Column(name = "nombre_foto", nullable = false)
    private String nombreFoto;
    @Column(name = "tipo_foto", nullable = false)
    private String mimeTypeFoto;
    @Column(name = "foto", nullable = false)
    @Lob
    private String fotoBase64;
}