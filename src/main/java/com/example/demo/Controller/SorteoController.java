package com.example.demo.Controller;

import com.example.demo.Entity.Sorteo;
import com.example.demo.IService.ISorteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sorteos")
@CrossOrigin("*")
public class SorteoController extends BaseController<Sorteo, ISorteoService> {
    @Autowired
    private ISorteoService service;

    protected SorteoController(ISorteoService service) {
        super(service, "Sorteo");
        this.service = service;
    }

    // Endpoint para obtener todos los sorteos
    @GetMapping("/getAllSorteos")
    public ResponseEntity<List<Sorteo>> getAllSorteos() {
        List<Sorteo> sorteos = service.all();
        return new ResponseEntity<>(sorteos, HttpStatus.OK);
    }

    // Endpoint para obtener un sorteo por ID
    @GetMapping("/getSorteoById/{id}")
    public ResponseEntity<Sorteo> getSorteoById(@PathVariable Long id) throws Exception {
        Sorteo sorteo = service.findById(id);
        return new ResponseEntity<>(sorteo, HttpStatus.OK);
    }

    // Endpoint para crear un nuevo sorteo
    @PostMapping("/createSorteo")
    public ResponseEntity<Sorteo> createSorteo(@RequestBody Sorteo sorteo) throws Exception {
        Sorteo createdSorteo = service.save(sorteo);
        return new ResponseEntity<>(createdSorteo, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un sorteo existente
    @PutMapping("/updateSorteo/{id}")
    public ResponseEntity<Sorteo> updateSorteo(@PathVariable Long id, @RequestBody Sorteo sorteo) throws Exception {
        service.update(id, sorteo); // Llama al método de servicio que actualiza el sorteo
        Sorteo updatedSorteo = service.findById(id); // Recupera el sorteo actualizado
        return new ResponseEntity<>(updatedSorteo, HttpStatus.OK);
    }
}
