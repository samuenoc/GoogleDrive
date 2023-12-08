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
@Table(name = "tbl_genero")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Genero {
    @Id
    @Column(name = "id_genero")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idGenero;

    @Column(name = "tipo_genero")
    private String tipoGenero;

    @OneToMany(mappedBy = "generoEntity")
    private List<Usuario> usuarios;

}
