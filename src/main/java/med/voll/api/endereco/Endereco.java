package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.medicos.DadosAtualizarMedicos;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
    }

    public void atualizarDados(@Valid DadosEndereco dados) {
        if(dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
        if(dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if(dados.cep() != null){
            this.cep = dados.cep();
        }
        if(dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if(dados.uf() != null){
            this.uf = dados.uf();
        }
        if(dados.numero() != null){
            this.numero = dados.numero();
        }
        if(dados.complemento() != null){
            this.complemento = dados.complemento();
        }
    }
}
