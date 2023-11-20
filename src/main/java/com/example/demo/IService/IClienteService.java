package com.example.demo.IService;

import com.example.demo.Entity.Cliente;

import java.util.List;

public interface IClienteService extends IBaseService<Cliente>{
    List<Cliente> findByNumParticipacionAcumuladoGreaterThan(int minParticipacion);

    List<Cliente> findByNombreCompletoContaining(String nombreCompleto);

    Cliente findByIdentificacion(String identificacion);
}
