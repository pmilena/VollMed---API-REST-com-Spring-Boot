package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medicos.DadosAtualizarMedicos;
import med.voll.api.medicos.DadosCadastroMedicos;
import med.voll.api.medicos.ListaDeMedicos;
import med.voll.api.medicos.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<ListaDeMedicos> listar(@PageableDefault(size=5) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(ListaDeMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedicos dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarDados(dados);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }




}
