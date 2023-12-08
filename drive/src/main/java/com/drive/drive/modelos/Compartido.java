package com.drive.drive.modelos;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tbl_compartidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compartido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Compartidos")
    private int idCompartidos;
 
    @ManyToOne
    @JoinColumn(name = "id_archivo_compartido", referencedColumnName = "id_archivo", insertable = false, updatable = false)
    private Archivo archivoEntity;

    @ManyToOne
    @JoinColumn(name = "id_permiso", referencedColumnName = "id_permiso", insertable = false, updatable = false)
    private Permiso permisoEntity;

    @ManyToOne
    @JoinColumn(name = "id_propietario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Usuario propietarioEntity;

    @ManyToOne
    @JoinColumn(name = "id_usuario_receptor", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Usuario usuarioReceptorEntity;
    
}
