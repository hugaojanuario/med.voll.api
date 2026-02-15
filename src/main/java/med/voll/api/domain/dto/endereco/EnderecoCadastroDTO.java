package med.voll.api.domain.dto.endereco;

import jakarta.validation.constraints.NotBlank;

public record EnderecoCadastroDTO(

        @NotBlank
        String logradouro,

        @NotBlank
        String cep,

        @NotBlank
        String bairro,

        @NotBlank
        String numero,

        //pode ser nulo.
        String complemento
) {
}
