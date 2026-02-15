package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.domain.dto.doctor.DataListingDoctors;
import med.voll.api.domain.dto.endereco.DataListingPacient;
import med.voll.api.domain.dto.pacient.DataCreatedPacient;
import med.voll.api.domain.entity.pacient.Pacient;
import med.voll.api.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/pacient")
public class PacientController {

    @Autowired
    private PacientRepository pacientRepository;

    @PostMapping
    public void createdPacient(@RequestBody @Valid DataCreatedPacient data){
        pacientRepository.save(new Pacient(data));
    }

    @GetMapping
    public Page<DataListingPacient> listAll(@PageableDefault(size = 2)Pageable pageable){
        return pacientRepository.findAll(pageable)
                .map(DataListingPacient::new);
    }
}
