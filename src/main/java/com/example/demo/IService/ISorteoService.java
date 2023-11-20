package com.example.demo.IService;

import com.example.demo.Entity.Premio;
import com.example.demo.Entity.ResultadoSorteo;
import com.example.demo.Entity.Sorteo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface ISorteoService extends IBaseService<Sorteo>{
    List<Sorteo> findByFechaInicio(Date fechaInicio);

    List<Sorteo> findByFechaFin(Date fechaFin);

    List<Sorteo> findByPremioEnPremiosDisponibles(Premio premio);

    List<Sorteo> findByResultadoEnResultados(ResultadoSorteo resultado);
}
