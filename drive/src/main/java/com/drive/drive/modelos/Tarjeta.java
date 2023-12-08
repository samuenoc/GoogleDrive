package com.drive.drive.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_tarjetas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarjeta {
    @Id
    @Column(name = "id_tarjeta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarjeta;

    @Column(name = "numero_tarjeta")
    private int numeroTarjeta;

    @Column(name = "mes_fecha_vencimiento")
    private int mesFechaVencimiento;

    @Column(name = "anio_fecha_vencimiento")
    private int anioFechaVencimiento;

    @Column(name = "codigo_postal")
    private int codigoPostal;

    @ManyToOne
    @JoinColumn(name = "id_usuario_dueno", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Usuario usuarioDuenoEntity;

    @ManyToOne
    @JoinColumn(name = "id_lugar", referencedColumnName = "id_lugar", insertable = false, updatable = false)
    private Lugar lugarEntity;

}
