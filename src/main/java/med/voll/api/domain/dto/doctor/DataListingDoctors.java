package med.voll.api.domain.dto.doctor;

import med.voll.api.domain.entity.doctor.Doctor;
import med.voll.api.domain.entity.doctor.Especialidade;

public record DataListingDoctors(

        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public DataListingDoctors(Doctor doctor){
        this(
                doctor.getNome(),
                doctor.getEmail(),
                doctor.getCrm(),
                doctor.getEspecialidade()
        );
    }
}
