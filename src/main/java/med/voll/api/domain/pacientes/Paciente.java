package med.voll.api.domain.pacientes;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.endereco.Endereco;

@Entity
@Table(name="pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private Boolean ativo = true;

    public Paciente(DadosCadastroPacientes dados) {
        this.nome= dados.nome();
        this.telefone = dados.telefone();
        this.cpf= dados.cpf();
        this.email= dados.email();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarDados(DadosAtualizarPacientes dados) {

        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }

        if (dados.endereco() != null) {
            if (this.endereco == null) {
                this.endereco = new Endereco();
            }

            if (dados.endereco().logradouro() != null) {
                this.endereco.setLogradouro(dados.endereco().logradouro());
            }
            if (dados.endereco().bairro() != null) {
                this.endereco.setBairro(dados.endereco().bairro());
            }
            if (dados.endereco().cep() != null) {
                this.endereco.setCep(dados.endereco().cep());
            }
            if (dados.endereco().cidade() != null) {
                this.endereco.setCidade(dados.endereco().cidade());
            }
            if (dados.endereco().uf() != null) {
                this.endereco.setUf(dados.endereco().uf());
            }
            if (dados.endereco().numero() != null) {
                this.endereco.setNumero(dados.endereco().numero());
            }
            if (dados.endereco().complemento() != null) {
                this.endereco.setComplemento(dados.endereco().complemento());
            }
        }

    }

    public void excluir() {
        this.ativo=false;
    }
}
