package med.voll.api.medicos;

import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;

public record DadosAtualizarMedicos(Long id, String nome, String telefone, Endereco endereco) {
}
