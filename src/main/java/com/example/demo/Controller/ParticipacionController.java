package com.example.demo.Controller;

import com.example.demo.Entity.Participacion;
import com.example.demo.IService.IParticipacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participaciones")
@CrossOrigin("*")
public class ParticipacionController extends BaseController<Participacion, IParticipacionService> {
    @Autowired
    private IParticipacionService service;

    protected ParticipacionController(IParticipacionService service) {
        super(service, "Participacion");
        this.service = service;
    }

    // Endpoint para obtener todas las participaciones
    @GetMapping("/getAllParticipaciones")
    public ResponseEntity<Iterable<Participacion>> getAllParticipaciones() {
        Iterable<Participacion> participaciones = service.all();
        return new ResponseEntity<>(participaciones, HttpStatus.OK);
    }

    // Endpoint para obtener una participación por ID
    @GetMapping("/getParticipacionById/{id}")
    public ResponseEntity<Participacion> getParticipacionById(@PathVariable Long id) throws Exception {
        Participacion participacion = service.findById(id);
        return new ResponseEntity<>(participacion, HttpStatus.OK);
    }

    // Endpoint para crear una nueva participación
    @PostMapping("/createParticipacion")
    public ResponseEntity<Participacion> createParticipacion(@RequestBody Participacion participacion) throws Exception {
        Participacion createdParticipacion = service.save(participacion);
        return new ResponseEntity<>(createdParticipacion, HttpStatus.CREATED);
    }

    // Endpoint para actualizar una participación existente
    @PutMapping("/updateParticipacion/{id}")
    public ResponseEntity<Participacion> updateParticipacion(@PathVariable Long id, @RequestBody Participacion participacion) throws Exception {
        service.update(id, participacion); // Llama al método de servicio que actualiza la participación
        Participacion updatedParticipacion = service.findById(id); // Recupera la participación actualizada
        return new ResponseEntity<>(updatedParticipacion, HttpStatus.OK);
    }
}
