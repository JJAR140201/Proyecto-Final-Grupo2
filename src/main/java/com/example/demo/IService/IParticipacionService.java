package com.example.demo.IService;

import com.example.demo.Entity.Compra;
import com.example.demo.Entity.Participacion;

public interface IParticipacionService extends IBaseService<Participacion>{
    Participacion findByNumeroParticipacion(String numeroParticipacion);
}
