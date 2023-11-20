package com.example.demo.Controller;

import com.example.demo.Entity.Compra;
import com.example.demo.IService.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
@CrossOrigin("*")
public class CompraController extends BaseController<Compra, ICompraService>{
    @Autowired
    private ICompraService service;

    protected CompraController(ICompraService service) {
        super(service, "Compra");
        this.service = service;
    }

    // Endpoint para obtener todas las compras
    @GetMapping("/getAllCompras")
    public ResponseEntity<List<Compra>> getAllCompras() {
        List<Compra> compras = service.all();
        return new ResponseEntity<>(compras, HttpStatus.OK);
    }

    // Endpoint para obtener una compra por ID
    @GetMapping("/getCompraById/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable Long id) throws Exception {
        Compra compra = service.findById(id);
        return new ResponseEntity<>(compra, HttpStatus.OK);
    }

    // Endpoint para crear una nueva compra
    @PostMapping("/createCompra")
    public ResponseEntity<Compra> createCompra(@RequestBody Compra compra) throws Exception {
        Compra createdCompra = service.save(compra);
        return new ResponseEntity<>(createdCompra, HttpStatus.CREATED);
    }

    // Endpoint para actualizar una compra existente
    @PutMapping("/updateCompra/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable Long id, @RequestBody Compra compra) throws Exception {
        service.update(id, compra); // Llama al método de servicio que actualiza la compra
        Compra updatedCompra = service.findById(id); // Recupera la compra actualizada
        return new ResponseEntity<>(updatedCompra, HttpStatus.OK);
    }
}
