package ControleDeFrequencia.api.assembler;

import ControleDeFrequencia.api.model.AlunoDTO;
import ControleDeFrequencia.api.model.ChamadaDTO;
import ControleDeFrequencia.api.model.Input.AlunoInputDTO;
import ControleDeFrequencia.api.model.Input.ChamadaInputDTO;
import ControleDeFrequencia.domain.model.Aluno;
import ControleDeFrequencia.domain.model.Chamada;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ChamadaAssembler {
    ModelMapper modelMapper;

    public ChamadaDTO toModel(Chamada chamada) {
        return modelMapper.map(chamada, ChamadaDTO.class);
    }

    public Chamada toEntity(ChamadaInputDTO chamadaInputDTO) {
        return modelMapper.map(chamadaInputDTO, Chamada.class);
    }

    public List<ChamadaDTO> toCollectionModel(List<Chamada> chamadas) {
        return chamadas.stream().map(this::toModel)
                .collect(Collectors.toList());
    }
}
