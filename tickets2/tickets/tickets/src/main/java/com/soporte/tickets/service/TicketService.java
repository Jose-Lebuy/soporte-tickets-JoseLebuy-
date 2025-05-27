package com.soporte.tickets.service;
import com.soporte.tickets.model.Ticket;
import com.soporte.tickets.repository.TicketRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    // Listar todos los tickets
    public List<Ticket> listarTickets() {
        return ticketRepository.findAll();
    }
    // Cambiar el estado de un ticket por nombre
    public Ticket cambiarEstado(String nombre, String nuevoEstado) {
        Ticket ticket = ticketRepository.findByNombre(nombre).orElseThrow(() -> new RuntimeException("Ticket no encontrado con nombre: " + nombre));
        ticket.setEstadoTicket(nuevoEstado.toUpperCase());
        return ticketRepository.save(ticket);
    }
    // Asignar técnico a un ticket
    public Ticket asignarTecnico(String nombre, String nombreTecnico) {
        Ticket ticket = ticketRepository.findByNombre(nombre).orElseThrow(() -> new RuntimeException("Ticket no encontrado con nombre: " + nombre));
        ticket.setTecnicoAsignado(nombreTecnico);
        return ticketRepository.save(ticket);
    }
    // Obtener todos los tickets de tipo SIMPLE
    public List<Ticket> obtenerProblemasSimples() {
        return ticketRepository.findByTipoProblemaIgnoreCase("SIMPLE");
    }
    //crear y  guardar un nuevo ticket
    public Ticket guardarTicket(Ticket ticket) {
    return ticketRepository.save(ticket);
    }
}

