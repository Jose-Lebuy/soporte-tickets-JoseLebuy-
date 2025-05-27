package com.soporte.tickets.repository;

import com.soporte.tickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {


    //Buscar por un ticket por su nombre
    Optional<Ticket> findByNombre(String nombre);

    //Busca por tipo de problema
    List<Ticket> findByTipoProblemaIgnoreCase(String tipoProblema);
}

