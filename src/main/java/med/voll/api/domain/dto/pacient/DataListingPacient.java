package med.voll.api.domain.dto.pacient;

import med.voll.api.domain.entity.pacient.Pacient;

public record DataListingPacient(

        Long id,
        String nome,
        String email,
        String cpf
) {
    public DataListingPacient(Pacient pacient){
        this(
                pacient.getId(),
                pacient.getNome(),
                pacient.getEmail(),
                pacient.getCpf()
        );
    }
}
