package com.example.demo.IService;


import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Premio;
import com.example.demo.Entity.ResultadoSorteo;

import java.util.List;

public interface IResultadoSorteoService extends IBaseService<ResultadoSorteo>{
    List<ResultadoSorteo> findByGanador(Cliente ganador);

    List<ResultadoSorteo> findByPremio(Premio premio);

    ResultadoSorteo findByNumeroParticipacionGanadora(String numeroParticipacionGanadora);
}
