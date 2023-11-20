package com.example.demo.Service;

import com.example.demo.Entity.Compra;
import com.example.demo.Entity.Participacion;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IRepository.IParticipacionRepository;
import com.example.demo.IService.ICompraService;
import com.example.demo.IService.IParticipacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipacionService extends BaseService<Participacion> implements IParticipacionService {
    @Autowired
    private IParticipacionRepository repository;

    @Override
    public Participacion findByNumeroParticipacion(String numeroParticipacion) {
        return repository.findByNumeroParticipacion(numeroParticipacion);
    }

    @Override
    protected IBaseRepository<Participacion, Long> getRepository() {
        return repository;
    }
}
