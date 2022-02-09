package ControleDeFrequencia.domain.Service;

import ControleDeFrequencia.api.assembler.ChamadaAssembler;
import ControleDeFrequencia.api.model.AlunoDTO;
import ControleDeFrequencia.api.model.ChamadaDTO;
import ControleDeFrequencia.domain.Repository.ChamadaRepository;
import ControleDeFrequencia.domain.model.Aluno;
import ControleDeFrequencia.domain.model.Chamada;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ChamadaService {

    ChamadaRepository chamadaRepository;
    ChamadaAssembler chamadaAssembler;

    @Transactional
    public Chamada Cadastrar(Chamada chamada) {


        return chamadaRepository.save(chamada);
    }
    public ResponseEntity<Chamada> editarChamada(long idChamada, Chamada preseca) {
        Chamada chamada = chamadaRepository.getById(idChamada);
        chamada.setPresenca(preseca.getPresenca());

        chamada = chamadaRepository.save(chamada);

        return ResponseEntity.ok(chamada);
    }
    @Transactional
    public List<ChamadaDTO> listar() {
        return chamadaAssembler.toCollectionModel(chamadaRepository.findAll());
    }
}
