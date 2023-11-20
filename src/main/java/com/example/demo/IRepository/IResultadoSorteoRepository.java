package com.example.demo.IRepository;

import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Participacion;
import com.example.demo.Entity.Premio;
import com.example.demo.Entity.ResultadoSorteo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IResultadoSorteoRepository extends IBaseRepository<ResultadoSorteo, Long>{
    // Consulta personalizada para buscar por ganador
    @Query("SELECT r FROM ResultadoSorteo r WHERE r.ganador = :ganador")
    List<ResultadoSorteo> findByGanador(@Param("ganador") Cliente ganador);

    // Consulta personalizada para buscar por premio
    @Query("SELECT r FROM ResultadoSorteo r WHERE r.premio = :premio")
    List<ResultadoSorteo> findByPremio(@Param("premio") Premio premio);

    // Consulta personalizada para buscar por numeroParticipacionGanadora
    @Query("SELECT r FROM ResultadoSorteo r WHERE r.numeroParticipacionGanadora = :numeroParticipacionGanadora")
    ResultadoSorteo findByNumeroParticipacionGanadora(@Param("numeroParticipacionGanadora") String numeroParticipacionGanadora);

}
