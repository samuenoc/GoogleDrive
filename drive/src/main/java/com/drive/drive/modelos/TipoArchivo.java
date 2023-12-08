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
@Table(name = "tbl_tipos_archivos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoArchivo {
    @Id
    @Column(name = "id_tipo_archivo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoArchivo;

    @Column(name = "tipo_archivo")
    private String tipoArchivo;

    @OneToMany(mappedBy = "tipoArchivoEntity")
    private List<Archivo> archivos;
}
