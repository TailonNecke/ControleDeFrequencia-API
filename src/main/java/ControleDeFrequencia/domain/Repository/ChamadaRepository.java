package ControleDeFrequencia.domain.Repository;

import ControleDeFrequencia.domain.model.Chamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long> {
}
