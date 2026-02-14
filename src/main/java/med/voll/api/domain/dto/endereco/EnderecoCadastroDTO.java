package med.voll.api.domain.dto.endereco;

public record EnderecoCadastroDTO(
        String logradouro,
        String cep,
        String bairro,
        String numero,
        String complemento
) {
}
