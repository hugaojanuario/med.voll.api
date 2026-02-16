package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.dto.pacient.DataListingPacient;
import med.voll.api.domain.dto.pacient.DataCreatedPacient;
import med.voll.api.domain.dto.pacient.DataUpdatePacient;
import med.voll.api.domain.entity.pacient.Pacient;
import med.voll.api.repository.PacientRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacient")
public class PacientController {

    @Autowired
    private PacientRepository pacientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity createdPacient(@RequestBody @Valid DataCreatedPacient data, UriComponentsBuilder uriBuilder){
        var pacient = new Pacient(data);
        pacientRepository.save(pacient);
        var uri = uriBuilder.path("/pacient/{id}").buildAndExpand(pacient.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataListingPacient(pacient));
    }

    @GetMapping
    public ResponseEntity <Page<DataListingPacient>> listAll(@PageableDefault(size = 2)Pageable pageable){
        var pacient = pacientRepository.findAllByAtivoTrue(pageable).map(DataListingPacient::new);
        return ResponseEntity.ok().body(pacient);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatedPacient(@RequestBody @Valid DataUpdatePacient dataUP){
        var pacient = pacientRepository.getReferenceById(dataUP.id());
        pacient.updatePacient(dataUP);
        return ResponseEntity.ok().body(pacient);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteByid(@PathVariable Long id){
        var pacient = pacientRepository.getReferenceById(id);
        pacient.delete();
        return ResponseEntity.noContent().build();
    }

}
