package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nombreCompleto")
    private String nombreCompleto;
    @Column(name = "identificacion")
    private String identificacion;
    @Column(name = "numParticipacionAcumulado")
    private int numParticipacionAcumulado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Compra> historialCompras;

    @OneToMany(mappedBy = "ganador", cascade = CascadeType.ALL)
    private List<ResultadoSorteo> resultadosGanados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getNumParticipacionAcumulado() {
        return numParticipacionAcumulado;
    }

    public void setNumParticipacionAcumulado(int numParticipacionAcumulado) {
        this.numParticipacionAcumulado = numParticipacionAcumulado;
    }

    public List<Compra> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(List<Compra> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public List<ResultadoSorteo> getResultadosGanados() {
        return resultadosGanados;
    }

    public void setResultadosGanados(List<ResultadoSorteo> resultadosGanados) {
        this.resultadosGanados = resultadosGanados;
    }

    public Cliente(Long id, String nombreCompleto, String identificacion, int numParticipacionAcumulado, List<Compra> historialCompras, List<ResultadoSorteo> resultadosGanados) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.numParticipacionAcumulado = numParticipacionAcumulado;
        this.historialCompras = historialCompras;
        this.resultadosGanados = resultadosGanados;
    }

    public Cliente() {

    }
}
