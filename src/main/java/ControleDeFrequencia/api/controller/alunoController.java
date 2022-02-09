package ControleDeFrequencia.api.controller;


import ControleDeFrequencia.api.assembler.AlunoAssembler;
import ControleDeFrequencia.api.model.AlunoDTO;
import ControleDeFrequencia.api.model.Input.AlunoInputDTO;
import ControleDeFrequencia.domain.Repository.AlunoRepository;
import ControleDeFrequencia.domain.Service.AlunoService;
import ControleDeFrequencia.domain.model.Aluno;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/alunos")
public class alunoController {

    private AlunoService alunoService;
    private AlunoAssembler alunoAssembler;
    private AlunoRepository alunoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO cadastrar(@Valid @RequestBody AlunoInputDTO alunoInputDTO){
        Aluno newAluno = alunoAssembler.toEntity(alunoInputDTO);
        Aluno aluno = alunoService.Cadastrar(newAluno);

        return alunoAssembler.toModel(aluno);
    }
    @DeleteMapping("{idAluno}")
    public ResponseEntity<Void> remover(@PathVariable Long idAluno){
        if(!alunoRepository.existsById(idAluno)){
            return ResponseEntity.notFound().build();
        }

        alunoService.excluir(idAluno);

        return ResponseEntity.noContent().build();
    }
    @PutMapping("{idAluno}")
    public AlunoDTO editarAluno(@PathVariable long idAluno, @Valid @RequestBody AlunoInputDTO alunoInputDTO){
        Aluno aluno = alunoAssembler.toEntity(alunoInputDTO);

        ResponseEntity<Aluno> alunoResponseEntity = alunoService.editarAluno(idAluno, aluno);
        return alunoAssembler.toModel(alunoResponseEntity.getBody());
    }
    @GetMapping
    public List<AlunoDTO> listar(){ return alunoService.listar(); }
}
