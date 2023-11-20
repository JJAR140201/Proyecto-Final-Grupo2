package com.example.demo.Service;

import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Participacion;
import com.example.demo.Entity.Premio;
import com.example.demo.Entity.ResultadoSorteo;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IRepository.IResultadoSorteoRepository;
import com.example.demo.IService.IParticipacionService;
import com.example.demo.IService.IResultadoSorteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoSorteoService extends BaseService<ResultadoSorteo> implements IResultadoSorteoService {
    @Autowired
    private IResultadoSorteoRepository repository;

    @Override
    public List<ResultadoSorteo> findByGanador(Cliente ganador) {
        return repository.findByGanador(ganador);
    }

    @Override
    public List<ResultadoSorteo> findByPremio(Premio premio) {
        return repository.findByPremio(premio);
    }

    @Override
    public ResultadoSorteo findByNumeroParticipacionGanadora(String numeroParticipacionGanadora) {
        return repository.findByNumeroParticipacionGanadora(numeroParticipacionGanadora);
    }

    @Override
    protected IBaseRepository<ResultadoSorteo, Long> getRepository() {
        return repository;
    }
}
