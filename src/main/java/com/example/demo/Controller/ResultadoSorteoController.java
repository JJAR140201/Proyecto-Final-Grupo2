package com.example.demo.Controller;

import com.example.demo.Entity.ResultadoSorteo;
import com.example.demo.IService.IResultadoSorteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultados-sorteo")
@CrossOrigin("*")
public class ResultadoSorteoController extends BaseController<ResultadoSorteo, IResultadoSorteoService> {
    @Autowired
    private IResultadoSorteoService service;

    protected ResultadoSorteoController(IResultadoSorteoService service) {
        super(service, "ResultadoSorteo");
        this.service = service;
    }

    // Endpoint para obtener todos los resultados de sorteos
    @GetMapping("/getAllResultadosSorteo")
    public ResponseEntity<List<ResultadoSorteo>> getAllResultadosSorteo() {
        List<ResultadoSorteo> resultadosSorteo = service.all();
        return new ResponseEntity<>(resultadosSorteo, HttpStatus.OK);
    }

    // Endpoint para obtener un resultado de sorteo por ID
    @GetMapping("/getResultadoSorteoById/{id}")
    public ResponseEntity<ResultadoSorteo> getResultadoSorteoById(@PathVariable Long id) throws Exception {
        ResultadoSorteo resultadoSorteo = service.findById(id);
        return new ResponseEntity<>(resultadoSorteo, HttpStatus.OK);
    }

    // Endpoint para crear un nuevo resultado de sorteo
    @PostMapping("/createResultadoSorteo")
    public ResponseEntity<ResultadoSorteo> createResultadoSorteo(@RequestBody ResultadoSorteo resultadoSorteo) throws Exception {
        ResultadoSorteo createdResultadoSorteo = service.save(resultadoSorteo);
        return new ResponseEntity<>(createdResultadoSorteo, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un resultado de sorteo existente
    @PutMapping("/updateResultadoSorteo/{id}")
    public ResponseEntity<ResultadoSorteo> updateResultadoSorteo(@PathVariable Long id, @RequestBody ResultadoSorteo resultadoSorteo) throws Exception {
        service.update(id, resultadoSorteo); // Llama al método de servicio que actualiza el resultado de sorteo
        ResultadoSorteo updatedResultadoSorteo = service.findById(id); // Recupera el resultado de sorteo actualizado
        return new ResponseEntity<>(updatedResultadoSorteo, HttpStatus.OK);
    }
}
