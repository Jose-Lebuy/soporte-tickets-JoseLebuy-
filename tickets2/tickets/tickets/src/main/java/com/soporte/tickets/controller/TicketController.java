package com.soporte.tickets.controller;

import com.soporte.tickets.model.Ticket;
import com.soporte.tickets.service.TicketService;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
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
    @PutMapping("/estado")
    public Ticket cambiarEstado(
            @RequestParam String nombre,
            @RequestParam String nuevoEstado) {
        return ticketService.cambiarEstado(nombre, nuevoEstado);
    }

    // Asignar técnico a un ticket
    @PutMapping("/asignar")
    public Ticket asignarTecnico(
            @RequestParam String nombre,
            @RequestParam String tecnico) {
        return ticketService.asignarTecnico(nombre, tecnico);
    }

    // Obtener tickets de tipo SIMPLE
    @GetMapping("/simples")
    public List<Ticket> obtenerProblemasSimples() {
        return ticketService.obtenerProblemasSimples();
    }

    // Crear un nuevo ticket
    @PostMapping
    public Ticket crearTicket(@RequestBody Ticket ticket) {
        return ticketService.guardarTicket(ticket);
    }
}
