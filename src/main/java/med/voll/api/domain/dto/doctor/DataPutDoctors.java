package med.voll.api.domain.dto.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.dto.endereco.EnderecoCadastroDTO;

public record DataPutDoctors(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoCadastroDTO enderecoCadastroDTO) {
}
