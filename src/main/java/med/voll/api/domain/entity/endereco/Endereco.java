package med.voll.api.domain.entity.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.dto.endereco.EnderecoCadastroDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String cep;
    private String bairro;
    private String numero;
    private String complemento;

    public Endereco(EnderecoCadastroDTO dataEndereco) {
        this.logradouro = dataEndereco.logradouro();
        this.cep = dataEndereco.cep();
        this.bairro = dataEndereco.bairro();
        this.numero = dataEndereco.numero();
        this.complemento = dataEndereco.complemento();
    }
}
