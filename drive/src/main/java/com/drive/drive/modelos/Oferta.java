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
@Table(name = "tbl_ofertas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Oferta {
    @Id
    @Column(name = "id_oferta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOferta;

    @Column(name = "descuento")
    private int descuento;

    @Column(name = "duracion_oferta")
    private int duracionOferta;

    @OneToMany(mappedBy = "ofertaEntity")
    private List<Plan> planes;

}
