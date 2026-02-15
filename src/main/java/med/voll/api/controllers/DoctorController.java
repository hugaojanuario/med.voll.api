package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import med.voll.api.domain.dto.doctor.DataCreatedDoctor;
import med.voll.api.domain.entity.doctor.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void cadastrarDoctor(@RequestBody DataCreatedDoctor dataCreatedDoctor){
        doctorRepository.save(new Doctor(dataCreatedDoctor));
    }
}
