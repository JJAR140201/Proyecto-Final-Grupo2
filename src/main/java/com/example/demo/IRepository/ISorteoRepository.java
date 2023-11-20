package com.example.demo.IRepository;

import com.example.demo.Entity.Premio;
import com.example.demo.Entity.ResultadoSorteo;
import com.example.demo.Entity.Sorteo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ISorteoRepository extends IBaseRepository<Sorteo, Long> {
    // Consulta personalizada para buscar por fechaInicio
    @Query("SELECT s FROM Sorteo s WHERE s.fechaInicio = :fechaInicio")
    List<Sorteo> findByFechaInicio(@Param("fechaInicio") Date fechaInicio);

    // Consulta personalizada para buscar por fechaFin
    @Query("SELECT s FROM Sorteo s WHERE s.fechaFin = :fechaFin")
    List<Sorteo> findByFechaFin(@Param("fechaFin") Date fechaFin);

    // Consulta personalizada para buscar por premio en premiosDisponibles
    @Query("SELECT s FROM Sorteo s JOIN s.premiosDisponibles p WHERE p = :premio")
    List<Sorteo> findByPremioEnPremiosDisponibles(@Param("premio") Premio premio);

    // Consulta personalizada para buscar por resultado en resultados
    @Query("SELECT s FROM Sorteo s JOIN s.resultados r WHERE r = :resultado")
    List<Sorteo> findByResultadoEnResultados(@Param("resultado") ResultadoSorteo resultado);
}
