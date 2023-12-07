package com.drive.drive.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "tbl_archivos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Archivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_archivo")
    private int idArchivo;
    @Column(name = "tamano")
    private int tamano;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_propietario")
    private int idPropietario;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_abierto")
    private Date fechaAbierto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "ubicacion")
    private int ubicacion;

    @Column(name = "tipo_archivo")
    private int tipoArchivo;

    @Column(name = "estado")
    private int estado;

}
