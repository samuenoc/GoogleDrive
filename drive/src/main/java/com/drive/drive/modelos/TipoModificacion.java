package com.drive.drive.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_tipos_modificaciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoModificacion {
    @Id
    @Column(name = "id_modificacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModificacion;

    @Column(name = "nombre_modificacion")
    private String nombreModificacion;

    @OneToMany(mappedBy = "tipoModificacionEntity")
    private List<ModificacionArchivo> modificaciones;

}
