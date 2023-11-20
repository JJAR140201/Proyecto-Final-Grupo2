package com.example.demo.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Compra")
public class Compra extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeroFactura")
    private String numeroFactura;

    @Column(name = "productos")
    private String productos; // Puedes ajustar este atributo según la estructura real de tu aplicación

    @Column(name = "fechaCompra")
    private Date fechaCompra;

    @Column(name = "montoTotal")
    private BigDecimal montoTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<Participacion> participaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }

    public Compra(Long id, String numeroFactura, String productos, Date fechaCompra, BigDecimal montoTotal, Cliente cliente, List<Participacion> participaciones) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.productos = productos;
        this.fechaCompra = fechaCompra;
        this.montoTotal = montoTotal;
        this.cliente = cliente;
        this.participaciones = participaciones;
    }

    public Compra() {
    }

}
