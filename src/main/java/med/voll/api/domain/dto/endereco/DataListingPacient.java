package med.voll.api.domain.dto.endereco;

import med.voll.api.domain.entity.pacient.Pacient;

public record DataListingPacient(

        String nome,
        String email,
        String cpf
) {
    public DataListingPacient(Pacient pacient){
        this(
                pacient.getNome(),
                pacient.getEmail(),
                pacient.getCpf()
        );
    }
}
