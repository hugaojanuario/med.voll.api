package med.voll.api.repository;

import med.voll.api.domain.entity.pacient.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepository extends JpaRepository<Pacient, Long> {
}
