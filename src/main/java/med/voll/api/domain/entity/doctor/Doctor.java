package med.voll.api.domain.entity.doctor;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.dto.doctor.DataCreatedDoctor;
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
    Especialidade especialidade;

    @Embedded
    Endereco endereco;

    public Doctor(DataCreatedDoctor dataDoctor) {
        this.nome = dataDoctor.nome();
        this.email = dataDoctor.email();
        this.telefone = dataDoctor.telefone();
        this.crm = dataDoctor.crm();
        this.especialidade = dataDoctor.especialidade();
        this.endereco = new Endereco(dataDoctor.endereco());
    }
}
