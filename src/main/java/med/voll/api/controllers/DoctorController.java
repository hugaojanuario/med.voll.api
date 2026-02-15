package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.dto.doctor.DataCreatedDoctor;
import med.voll.api.domain.dto.doctor.DataListingDoctors;
import med.voll.api.domain.entity.doctor.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void cadastrarDoctor(@RequestBody @Valid DataCreatedDoctor dataCreatedDoctor){
        doctorRepository.save(new Doctor(dataCreatedDoctor));
    }

    @GetMapping
    public List<DataListingDoctors> listAll(){
        return doctorRepository.findAll().stream().map(DataListingDoctors::new).toList();
    }

}
