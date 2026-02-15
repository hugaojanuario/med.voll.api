package med.voll.api.domain.dto.pacient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.dto.endereco.EnderecoCadastroDTO;

public record DataUpdatePacient(

        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoCadastroDTO enderecoCadastroDTO) {
}
