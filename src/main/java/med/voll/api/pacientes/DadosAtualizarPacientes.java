package med.voll.api.pacientes;

import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;

public record DadosAtualizarPacientes(Long id, String nome, String email, String telefone, String cpf, DadosEndereco endereco) {

}
