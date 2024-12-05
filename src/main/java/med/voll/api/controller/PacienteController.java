package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.pacientes.DadosAtualizarPacientes;
import med.voll.api.domain.pacientes.DadosCadastroPacientes;
import med.voll.api.domain.pacientes.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPacientes dados){
        repository.save(new Paciente(dados));
    }

   @GetMapping
    public Page<Paciente> listar(@PageableDefault(size=5) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarPacientes dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarDados(dados);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }




}
