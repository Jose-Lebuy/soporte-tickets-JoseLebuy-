
package com.soporte.tickets.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {


    //Asigna id como pk y le asigna un valor autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String tipoProblema;
    @Column
    private String estadoTicket;
    @Column
    private String tecnicoAsignado;
}
