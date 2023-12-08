package com.drive.drive.modelos;

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
@Table(name = "tbl_estados_archivo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoArchivo {
    @Id
    @Column(name = "id_estado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstado;

    @Column(name = "tipo_estado")
    private int tipoEstado;
    
    @ManyToOne
    @JoinColumn(name = "plan", referencedColumnName = "id_plan")
    private Plan planEntity;

}
