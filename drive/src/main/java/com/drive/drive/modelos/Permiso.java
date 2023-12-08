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
@Table(name = "tbl_permisos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Permiso {
    @Id
    @Column(name = "id_permiso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPermiso;

    @Column(name = "nombre_de_permiso")
    private String nombreDePermiso;

    @OneToMany(mappedBy = "permisoEntity")
    private List<Compartido> compartidos;
}
