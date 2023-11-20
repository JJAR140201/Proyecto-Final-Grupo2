package com.example.demo.IRepository;

import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Compra;
import com.example.demo.Entity.Participacion;
import com.example.demo.Entity.Sorteo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IParticipacionRepository extends IBaseRepository<Participacion, Long> {
    // Consulta personalizada para buscar por numeroParticipacion
    @Query("SELECT p FROM Participacion p WHERE p.numeroParticipacion = :numeroParticipacion")
    Participacion findByNumeroParticipacion(@Param("numeroParticipacion") String numeroParticipacion);
}
