package med.voll.api.domain.entity.pacient;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.domain.dto.pacient.DataCreatedPacient;
import med.voll.api.domain.dto.pacient.DataUpdatePacient;
import med.voll.api.domain.entity.endereco.Endereco;

@Entity
@Table(name = "pacients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telefone;

    @Column(unique = true)
    private String cpf;

    @Embedded
    private Endereco endereco;

    @Column
    private Boolean ativo;

    public Pacient (DataCreatedPacient dataCreatedPacient){
        this.ativo = true;
        this.nome = dataCreatedPacient.nome();
        this.email = dataCreatedPacient.email();
        this.telefone = dataCreatedPacient.telefone();
        this.cpf = dataCreatedPacient.cpf();
        this.endereco = new Endereco(dataCreatedPacient.endereco());
    }

    public void updatePacient(@Valid DataUpdatePacient dataUp){
        if (dataUp.nome() != null){
            this.nome = dataUp.nome();
        }

        if(dataUp.telefone() != null){
            this.telefone = dataUp.telefone();
        }

        if(dataUp.enderecoCadastroDTO() != null){
            this.endereco.updateInformations(dataUp.enderecoCadastroDTO());
        }
    }

    public void delete(){
        this.ativo = false;
    }
}
