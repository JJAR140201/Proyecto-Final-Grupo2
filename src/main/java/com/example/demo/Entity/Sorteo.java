package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Sorteo")
public class Sorteo extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "sorteo", cascade = CascadeType.ALL)
    private List<Premio> premiosDisponibles;

    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Column(name = "fechaFin")
    private Date fechaFin;

    @OneToMany(mappedBy = "sorteo", cascade = CascadeType.ALL)
    private List<ResultadoSorteo> resultados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Premio> getPremiosDisponibles() {
        return premiosDisponibles;
    }

    public void setPremiosDisponibles(List<Premio> premiosDisponibles) {
        this.premiosDisponibles = premiosDisponibles;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<ResultadoSorteo> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoSorteo> resultados) {
        this.resultados = resultados;
    }

    public Sorteo(Long id, List<Premio> premiosDisponibles, Date fechaInicio, Date fechaFin, List<ResultadoSorteo> resultados) {
        this.id = id;
        this.premiosDisponibles = premiosDisponibles;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.resultados = resultados;
    }

    public Sorteo() {
    }
}
