package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ResultadoSorteo")
public class ResultadoSorteo extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ganador_id", nullable = false)
    private Cliente ganador;

    @ManyToOne
    @JoinColumn(name = "premio_id", nullable = false)
    private Premio premio;

    @Column(name = "numeroParticipacionGanadora")
    private String numeroParticipacionGanadora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getGanador() {
        return ganador;
    }

    public void setGanador(Cliente ganador) {
        this.ganador = ganador;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }

    public String getNumeroParticipacionGanadora() {
        return numeroParticipacionGanadora;
    }

    public void setNumeroParticipacionGanadora(String numeroParticipacionGanadora) {
        this.numeroParticipacionGanadora = numeroParticipacionGanadora;
    }

    public ResultadoSorteo(Long id, Cliente ganador, Premio premio, String numeroParticipacionGanadora) {
        this.id = id;
        this.ganador = ganador;
        this.premio = premio;
        this.numeroParticipacionGanadora = numeroParticipacionGanadora;
    }

    public ResultadoSorteo() {
    }

    @ManyToOne
    @JoinColumn(name = "sorteo_id")
    private Sorteo sorteo;

}
