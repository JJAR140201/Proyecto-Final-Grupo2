package com.example.demo.Service;

import com.example.demo.Entity.Premio;
import com.example.demo.Entity.ResultadoSorteo;
import com.example.demo.Entity.Sorteo;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IRepository.ISorteoRepository;
import com.example.demo.IService.IResultadoSorteoService;
import com.example.demo.IService.ISorteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SorteoService extends BaseService<Sorteo> implements ISorteoService {
    @Autowired
    private ISorteoRepository repository;

    @Override
    public List<Sorteo> findByFechaInicio(Date fechaInicio) {
        return repository.findByFechaInicio(fechaInicio);
    }

    @Override
    public List<Sorteo> findByFechaFin(Date fechaFin) {
        return repository.findByFechaFin(fechaFin);
    }

    @Override
    public List<Sorteo> findByPremioEnPremiosDisponibles(Premio premio) {
        return repository.findByPremioEnPremiosDisponibles(premio);
    }

    @Override
    public List<Sorteo> findByResultadoEnResultados(ResultadoSorteo resultado) {
        return null;
    }

    @Override
    protected IBaseRepository<Sorteo, Long> getRepository() {
        return repository;
    }
}
