package med.voll.api.domain.pacientes;

import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroPacientes(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {
}