
package com.soporte.tickets.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
    @NotBlank(message = "El nombre del ticket es obligatorio")
    private String nombre;
    
    @Column
     @NotBlank(message = "La descripcion no puede estar vacia")
    private String descripcion;
    
    @Column
    @NotBlank(message = "El tipo de problema del ticket es obligatorio")
    private String tipoProblema;
    
    @Column
    @NotBlank(message = "El estado del ticket es obligatorio")
    private String estadoTicket;
    
    @Column
    @NotBlank(message = "Asignar un tecnico a los ticket es obligatorio")
    private String tecnicoAsignado;

    @NotNull(message = "id de curso es obligatorio")
    private int curso_adjunto;
    
}
