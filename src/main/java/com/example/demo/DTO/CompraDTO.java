package com.example.demo.DTO;

import java.math.BigDecimal;
import java.util.Date;

public interface CompraDTO {
    Long getId();
    String getNumeroFactura();
    String getProducto();
    Date getFechaCompra();
    BigDecimal getMontoTotal();
}
