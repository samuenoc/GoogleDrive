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
@Table(name = "tbl_tipos_lugares")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoLugar {
    @Id
    @Column(name = "id_tipo_lugar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoLugar;

    @Column(name = "nombre_tipo")
    private String nombreTipo;

    @OneToMany(mappedBy = "tipoArchivoEntity")
    private List<Lugar> lugares;
}
