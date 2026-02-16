package med.voll.api.repository;

import med.voll.api.domain.entity.pacient.Pacient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepository extends JpaRepository<Pacient, Long> {
    Page<Pacient> findAllByAtivoTrue(Pageable pageable);
}
