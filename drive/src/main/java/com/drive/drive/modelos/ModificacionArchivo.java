package com.drive.drive.modelos;

import java.util.Date;

import jakarta.persistence.Id;
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
@Table(name = "tbl_modificacion_archivos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModificacionArchivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_modificacion_archivos")
    private int tblModificacionArchivos;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_modificacion", referencedColumnName = "id_modificacion")
    private TipoModificacion tipoModificacionEntity;

    @ManyToOne
    @JoinColumn(name = "id_usuario_modificador", referencedColumnName = "id_usuario")
    private Usuario usuarioModificadorEntity;

    @ManyToOne
    @JoinColumn(name = "id_archivo", referencedColumnName = "id_archivo")
    private Archivo archivoEntity;

}
