package med.voll.api.domain.dto.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @Valid
        EnderecoCadastroDTO endereco
) {
}
