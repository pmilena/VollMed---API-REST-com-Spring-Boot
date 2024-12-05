package med.voll.api.domain.medicos;

import med.voll.api.domain.endereco.Endereco;

public record DadosAtualizarMedicos(Long id, String nome, String telefone, Endereco endereco) {
}
