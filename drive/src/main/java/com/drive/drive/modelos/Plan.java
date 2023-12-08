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
@Table(name = "tbl_planes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
    @Id
    @Column(name = "id_plan")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlan;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "espacio_almacenamiento")
    private int espacioAlmacenamiento;

    @Column(name = "precio")
    private int precio;

    @Column(name = "duracion_plan")
    private int duracionPlan;


    @ManyToOne
    @JoinColumn(name = "id_oferta", referencedColumnName = "id_oferta", insertable = false, updatable = false)
    private Oferta ofertaEntity;

    @OneToMany(mappedBy = "planEntity")
    private List<FacturacionPlanes> facturaciones;
}
