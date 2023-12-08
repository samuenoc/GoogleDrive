package com.drive.drive.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
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

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_abierto")
    private Date fechaAbierto;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "tipo_archivo", referencedColumnName = "id_tipo_archivo")
    private TipoArchivo tipoArchivo;

    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "id_estado")
    private EstadoArchivo estadoArchivo;

    @ManyToOne
    @JoinColumn(name = "ubicacion", referencedColumnName = "id_ubicacion")
    private UbicacionArchivo ubicacionArchivo;

    @ManyToOne
    @JoinColumn(name = "id_propietario", referencedColumnName = "id_usuario")
    private Usuario propietario;

    @OneToMany(mappedBy = "id_archivo")
    private List<Compartido> compartidos;

    @OneToMany(mappedBy = "id_archivo")
    private List<ModificacionArchivo> modificaciones;
}
