package med.voll.api.domain.dto.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import med.voll.api.domain.dto.endereco.EnderecoCadastroDTO;
import med.voll.api.domain.entity.doctor.Especialidade;

public record DataCreatedDoctor(
        @NotBlank
        @Size(min = 3)
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String crm,

        @NotBlank
        Especialidade especialidade,

        @NotBlank
        EnderecoCadastroDTO endereco
) {
}
