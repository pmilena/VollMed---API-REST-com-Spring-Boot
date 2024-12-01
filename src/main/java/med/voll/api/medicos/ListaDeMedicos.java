package med.voll.api.medicos;


public record ListaDeMedicos(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public ListaDeMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
