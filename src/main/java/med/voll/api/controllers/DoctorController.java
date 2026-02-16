package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.dto.doctor.DataCreatedDoctor;
import med.voll.api.domain.dto.doctor.DataListingDoctors;
import med.voll.api.domain.dto.doctor.DataPutDoctors;
import med.voll.api.domain.entity.doctor.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


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
    public Page<DataListingDoctors> listAll(@PageableDefault(size = 2)Pageable pageable){
        return doctorRepository.findAllByAtivoTrue(pageable).map(DataListingDoctors::new);
    }

    @PutMapping
    @Transactional
    public void putDoctor (@RequestBody @Valid DataPutDoctors dataPutDoctors){
        var doctor = doctorRepository.getReferenceById(dataPutDoctors.id());
        doctor.updateDoctor(dataPutDoctors);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();

    }

}
