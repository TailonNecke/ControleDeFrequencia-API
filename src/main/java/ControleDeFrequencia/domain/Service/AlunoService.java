package ControleDeFrequencia.domain.Service;

import ControleDeFrequencia.api.assembler.AlunoAssembler;
import ControleDeFrequencia.api.model.AlunoDTO;
import ControleDeFrequencia.api.model.Input.AlunoInputDTO;
import ControleDeFrequencia.domain.Repository.AlunoRepository;
import ControleDeFrequencia.domain.model.Aluno;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository alunoRepository;
    private AlunoAssembler alunoAssembler;

    @Transactional
    public Aluno Cadastrar(Aluno aluno) {
        Aluno newAluno = aluno;

        return alunoRepository.save(newAluno);
    }
    @Transactional
    public void excluir(Long idAluno){
        alunoRepository.deleteById(idAluno);
    }
    @Transactional
    public ResponseEntity<Aluno> editarAluno(long idAluno, Aluno aluno) {

        aluno.setIdAluno(idAluno);

        aluno = alunoRepository.save(aluno);

        return ResponseEntity.ok(aluno);
    }
    @Transactional
    public List<AlunoDTO> listar() {
        return alunoAssembler.toCollectionModel(alunoRepository.findAll());
    }
}

