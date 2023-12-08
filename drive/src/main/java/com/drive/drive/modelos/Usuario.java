package com.drive.drive.modelos;

import java.util.List;

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

@Entity
@Table(name = "tbl_usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "numero_telefonico")
    private int numeroTelefonico;

    @Column(name = "pais")
    private String pais;

    @ManyToOne
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero", insertable = false, updatable = false)
    private Genero generoEntity;

    @OneToMany(mappedBy = "propietarioEntity")
    private List<Archivo> archivosPropios;

    @OneToMany(mappedBy = "usuarioReceptorEntity")
    private List<Compartido> archivosCompartidos;

    @OneToMany(mappedBy = "usuarioModificadorEntity")
    private List<ModificacionArchivo> modificaciones;

    @OneToMany(mappedBy = "usuarioDuenoEntity")
    private List<Tarjeta> tarjetas;

    @OneToMany(mappedBy = "usuarioEntity")
    private List<FacturacionPlanes> facturaciones;
}
