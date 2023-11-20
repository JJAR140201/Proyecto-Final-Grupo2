package com.example.demo.DTO;

import java.math.BigDecimal;

public interface PremioDTO {
    Long getId();
    String getTipo();
    BigDecimal getValor();
    String getDescripcion();
}
