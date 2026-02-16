package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.dto.pacient.DataListingPacient;
import med.voll.api.domain.dto.pacient.DataCreatedPacient;
import med.voll.api.domain.dto.pacient.DataUpdatePacient;
import med.voll.api.domain.entity.pacient.Pacient;
import med.voll.api.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacient")
public class PacientController {

    @Autowired
    private PacientRepository pacientRepository;

    @PostMapping
    @Transactional
    public void createdPacient(@RequestBody @Valid DataCreatedPacient data){
        pacientRepository.save(new Pacient(data));
    }

    @GetMapping
    public Page<DataListingPacient> listAll(@PageableDefault(size = 2)Pageable pageable){
        return pacientRepository.findAllByAtivoTrue(pageable)
                .map(DataListingPacient::new);
    }

    @PutMapping
    @Transactional
    public void updatedPacient(@RequestBody @Valid DataUpdatePacient dataUP){
        var pacient = pacientRepository.getReferenceById(dataUP.id());
        pacient.updatePacient(dataUP);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteByid(@PathVariable Long id){
        var pacient = pacientRepository.getReferenceById(id);
        pacient.delete();
    }

}
