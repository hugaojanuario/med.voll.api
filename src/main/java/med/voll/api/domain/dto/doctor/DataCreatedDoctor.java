package med.voll.api.domain.dto.doctor;

import med.voll.api.domain.dto.endereco.EnderecoCadastroDTO;
import med.voll.api.domain.entity.doctor.Especialidade;

public record DataCreatedDoctor(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        EnderecoCadastroDTO endereco
) {
}
