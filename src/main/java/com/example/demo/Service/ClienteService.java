package com.example.demo.Service;

import com.example.demo.Entity.Cliente;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IRepository.IClienteRepository;
import com.example.demo.IService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService extends BaseService<Cliente> implements IClienteService {
    @Autowired
    private IClienteRepository repository;
    @Override
    public List<Cliente> findByNumParticipacionAcumuladoGreaterThan(int minParticipacion) {
        return repository.findByNumParticipacionAcumuladoGreaterThan(minParticipacion);
    }

    @Override
    public List<Cliente> findByNombreCompletoContaining(String nombreCompleto) {
        return repository.findByNombreCompletoContaining(nombreCompleto);
    }

    @Override
    public Cliente findByIdentificacion(String identificacion) {
        return repository.findByIdentificacion(identificacion);
    }

    @Override
    protected IBaseRepository<Cliente, Long> getRepository() {
        return repository;
    }
}
