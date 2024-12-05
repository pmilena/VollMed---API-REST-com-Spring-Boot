package med.voll.api.domain.medicos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import med.voll.api.domain.endereco.Endereco;

@Entity
@Table(name="medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedicos dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email= dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade= dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarDados(@Valid DadosAtualizarMedicos dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco = dados.endereco();
        }
    }

    public void excluir() {
        this.ativo=false;
    }
}
