package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Participacion")
public class Participacion extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeroParticipacion")
    private String numeroParticipacion;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "sorteo_id", nullable = false)
    private Sorteo sorteo;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroParticipacion() {
        return numeroParticipacion;
    }

    public void setNumeroParticipacion(String numeroParticipacion) {
        this.numeroParticipacion = numeroParticipacion;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Sorteo getSorteo() {
        return sorteo;
    }

    public void setSorteo(Sorteo sorteo) {
        this.sorteo = sorteo;
    }

    public Participacion(Long id, String numeroParticipacion, Compra compra, Sorteo sorteo) {
        this.id = id;
        this.numeroParticipacion = numeroParticipacion;
        this.compra = compra;
        this.sorteo = sorteo;
    }

    public Participacion() {
    }
}

