package med.voll.api.domain.dto.pacient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import med.voll.api.domain.dto.endereco.EnderecoCadastroDTO;

public record DataCreatedPacient(

        @NotBlank
        @Size(min = 3)
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @Valid
        EnderecoCadastroDTO endereco
) {
}
