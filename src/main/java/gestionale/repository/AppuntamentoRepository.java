package gestionale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionale.model.Appuntamento;
@Repository
public interface AppuntamentoRepository extends JpaRepository<Appuntamento, Long> {

}
