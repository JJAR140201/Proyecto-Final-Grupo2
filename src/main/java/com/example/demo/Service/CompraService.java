package com.example.demo.Service;

import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Compra;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IRepository.ICompraRepository;
import com.example.demo.IService.IClienteService;
import com.example.demo.IService.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CompraService extends BaseService<Compra> implements ICompraService {
    @Autowired
    private ICompraRepository repository;

    @Override
    public Compra findByNumeroFactura(String numeroFactura) {
        return repository.findByNumeroFactura(numeroFactura);
    }

    @Override
    public List<Compra> findByFechaCompra(Date fechaCompra) {
        return repository.findByFechaCompra(fechaCompra);
    }

    @Override
    public List<Compra> findByMontoTotal(BigDecimal montoTotal) {
        return repository.findByMontoTotal(montoTotal);
    }

    @Override
    public List<Compra> findByProductosContaining(String productos) {
        return repository.findByProductosContaining(productos);
    }

    @Override
    protected IBaseRepository<Compra, Long> getRepository() {
        return repository;
    }
}
