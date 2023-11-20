package com.example.demo.Controller;

import com.example.demo.Entity.Cliente;
import com.example.demo.IService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController extends BaseController<Cliente, IClienteService>{
    @Autowired
    private IClienteService service;
    protected ClienteController(IClienteService service) {
        super(service, "Cliente");
        this.service = service;
    }

    // Endpoint para obtener todos los clientes
    @GetMapping("/getAllClientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = service.all();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para obtener un cliente por ID
    @GetMapping("/getClienteById/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) throws Exception {
        Cliente cliente = service.findById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    // Endpoint para crear un nuevo cliente
    @PostMapping("/createCliente")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) throws Exception {
        Cliente createdCliente = service.save(cliente);
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un cliente existente
    @PutMapping("/updateCliente/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) throws Exception {
        service.update(id, cliente); // Llama al método de servicio que actualiza el cliente
        Cliente updatedCliente = service.findById(id); // Recupera el cliente actualizado
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }

    // Endpoint para eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
