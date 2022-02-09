package ControleDeFrequencia.api.controller;

import ControleDeFrequencia.api.assembler.ChamadaAssembler;
import ControleDeFrequencia.api.model.AlunoDTO;
import ControleDeFrequencia.api.model.ChamadaDTO;
import ControleDeFrequencia.api.model.Input.AlunoInputDTO;
import ControleDeFrequencia.api.model.Input.ChamadaInputDTO;
import ControleDeFrequencia.domain.Repository.AlunoRepository;
import ControleDeFrequencia.domain.Service.ChamadaService;
import ControleDeFrequencia.domain.model.Aluno;
import ControleDeFrequencia.domain.model.Chamada;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/chamada")
public class chamadaController {

    ChamadaAssembler chamadaAssembler;
    ChamadaService chamadaService;
    AlunoRepository alunoRepository;

    @PostMapping("{idAluno}")
    @ResponseStatus(HttpStatus.CREATED)
    public ChamadaDTO cadastrar(@PathVariable long idAluno, @Valid @RequestBody ChamadaInputDTO chamadaInputDTO){
        Chamada newChamada = chamadaAssembler.toEntity(chamadaInputDTO);
        Aluno aluno = alunoRepository.getById(idAluno);
        newChamada.setNomeAluno(aluno.getNome());
        LocalDateTime teste = LocalDateTime.now();
        Date date1 = Date.from(teste.atZone(ZoneId.systemDefault()).toInstant());
        newChamada.setData(date1);
        newChamada.setPresenca(chamadaInputDTO.getPresenca());
        Chamada chamada = chamadaService.Cadastrar(newChamada);

        return chamadaAssembler.toModel(chamada);
    }
    @PutMapping("idChamada/{idChamada}")
    @ResponseStatus(HttpStatus.CREATED)
    public ChamadaDTO editarChamada(@PathVariable long idChamada, @Valid @RequestBody ChamadaInputDTO chamadaInputDTO){
        Chamada presenca = chamadaAssembler.toEntity(chamadaInputDTO);

        ResponseEntity<Chamada> chamadaResponseEntity = chamadaService.editarChamada(idChamada, presenca);
        return chamadaAssembler.toModel(chamadaResponseEntity.getBody());
    }
    @GetMapping
    public List<ChamadaDTO> listar(){ return chamadaService.listar(); }
}
