package com.example.demo.IService;

import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Compra;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ICompraService extends IBaseService<Compra>{
    Compra findByNumeroFactura(String numeroFactura);

    List<Compra> findByFechaCompra(Date fechaCompra);

    List<Compra> findByMontoTotal(BigDecimal montoTotal);

    List<Compra> findByProductosContaining(String productos);
}
