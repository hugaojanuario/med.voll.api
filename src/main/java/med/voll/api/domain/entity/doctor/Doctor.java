package med.voll.api.domain.entity.doctor;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import med.voll.api.domain.dto.doctor.DataCreatedDoctor;
import med.voll.api.domain.dto.doctor.DataPutDoctors;
import med.voll.api.domain.entity.endereco.Endereco;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "doctors")
@EqualsAndHashCode(of = "id")
public class Doctor {
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
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Doctor(DataCreatedDoctor dataDoctor) {
        this.ativo = true;
        this.nome = dataDoctor.nome();
        this.email = dataDoctor.email();
        this.telefone = dataDoctor.telefone();
        this.crm = dataDoctor.crm();
        this.especialidade = dataDoctor.especialidade();
        this.endereco = new Endereco(dataDoctor.endereco());
    }

    public void updateDoctor(@Valid DataPutDoctors dataPutDoctors) {
        if (dataPutDoctors.nome() != null){
            this.nome = dataPutDoctors.nome();
        }

        if (dataPutDoctors.telefone() != null){
            this.telefone = dataPutDoctors.telefone();
        }

        if (dataPutDoctors.enderecoCadastroDTO() != null){
            this.endereco.updateInformations(dataPutDoctors.enderecoCadastroDTO());
        }
    }

    public void delete() {
            ativo = false;
        }
    }

