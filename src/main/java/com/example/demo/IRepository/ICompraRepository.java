package com.example.demo.IRepository;

import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Compra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICompraRepository extends IBaseRepository<Compra, Long> {
    // Consulta personalizada para buscar por numeroFactura
    @Query("SELECT c FROM Compra c WHERE c.numeroFactura = :numeroFactura")
    Compra findByNumeroFactura(@Param("numeroFactura") String numeroFactura);

    // Consulta personalizada para buscar por fechaCompra
    @Query("SELECT c FROM Compra c WHERE c.fechaCompra = :fechaCompra")
    List<Compra> findByFechaCompra(@Param("fechaCompra") Date fechaCompra);

    // Consulta personalizada para buscar por montoTotal
    @Query("SELECT c FROM Compra c WHERE c.montoTotal = :montoTotal")
    List<Compra> findByMontoTotal(@Param("montoTotal") BigDecimal montoTotal);

    // Consulta personalizada para buscar por productos
    @Query("SELECT c FROM Compra c WHERE c.productos LIKE %:productos%")
    List<Compra> findByProductosContaining(@Param("productos") String productos);
}
