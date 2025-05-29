package com.soporte.tickets.controller;
import com.soporte.tickets.model.Ticket;
import com.soporte.tickets.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/tickets")//Este endpoint sirve para los POST y para realizar las peticiones
public class TicketController {

    private final TicketService ticketService;
    
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    // Obtener todos los tickets
    @GetMapping
    public List<Ticket> listarTickets() {
        return ticketService.listarTickets();
    }
    // Cambiar estado de un ticket
    @PutMapping("/estado")//Este endpoint sirve para cambiar estado del ticket
    public Ticket cambiarEstado(
            @RequestParam String nombre,
            @RequestParam String nuevoEstado) {
        return ticketService.cambiarEstado(nombre, nuevoEstado);
    }
    // Asignar técnico a un ticket
    @PutMapping("/asignar")//Este endpoint sirve para asignar un tecnico al ticket
    public Ticket asignarTecnico(
            @RequestParam String nombre,
            @RequestParam String tecnico) {
        return ticketService.asignarTecnico(nombre, tecnico);
    }
    // Obtener tickets de tipo SIMPLE
    @GetMapping("/simples")//Este endpoint sirve para llamar solo a los ticket tipo simples
    public List<Ticket> obtenerProblemasSimples() {
        return ticketService.obtenerProblemasSimples();
    }
    // Crear un nuevo ticket
    @PostMapping
    public Ticket crearTicket(@Valid @RequestBody Ticket ticket) {
        return ticketService.guardarTicket(ticket);
    }
    @DeleteMapping("/{id}")
    public void eliminarTicket(@PathVariable Long id) {
        ticketService.eliminarTicket(id);
    }
}
