package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.dto.doctor.DataCreatedDoctor;
import med.voll.api.domain.dto.doctor.DataListingDoctors;
import med.voll.api.domain.dto.doctor.DataPutDoctors;
import med.voll.api.domain.entity.doctor.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarDoctor(@RequestBody @Valid DataCreatedDoctor dataCreatedDoctor, UriComponentsBuilder uriBuilder){
        var doctor = new Doctor(dataCreatedDoctor);
        doctorRepository.save(doctor);

        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataListingDoctors(doctor));
    }

    @GetMapping
    public ResponseEntity <Page<DataListingDoctors>> listAll(@PageableDefault(size = 2)Pageable pageable){
        var find = doctorRepository.findAllByAtivoTrue(pageable).map(DataListingDoctors::new);

        return ResponseEntity.ok(find);
    }

    @GetMapping("/{id}")
    public ResponseEntity listById(@PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataListingDoctors(doctor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity putDoctor (@RequestBody @Valid DataPutDoctors dataPutDoctors){
        var doctor = doctorRepository.getReferenceById(dataPutDoctors.id());
        doctor.updateDoctor(dataPutDoctors);
        return ResponseEntity.ok(new DataListingDoctors(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteDoctor(@PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();
        return ResponseEntity.noContent().build();
    }

}
