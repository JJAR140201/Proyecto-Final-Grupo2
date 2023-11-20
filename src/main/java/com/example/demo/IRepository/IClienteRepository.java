package com.example.demo.IRepository;

import com.example.demo.Entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClienteRepository extends IBaseRepository<Cliente, Long>{
    // Ejemplo de consulta personalizada usando @Query
    @Query("SELECT c FROM Cliente c WHERE c.numParticipacionAcumulado > :minParticipacion")
    List<Cliente> findByNumParticipacionAcumuladoGreaterThan(@Param("minParticipacion") int minParticipacion);

    // Consulta personalizada para buscar por nombreCompleto
    @Query("SELECT c FROM Cliente c WHERE c.nombreCompleto = : nombreCompleto")
    List<Cliente> findByNombreCompletoContaining(@Param("nombreCompleto") String nombreCompleto);

    // Consulta personalizada para buscar por identificacion
    @Query("SELECT c FROM Cliente c WHERE c.identificacion = :identificacion")
    Cliente findByIdentificacion(@Param("identificacion") String identificacion);
}
