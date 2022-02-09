package ControleDeFrequencia.api.assembler;

import ControleDeFrequencia.api.model.AlunoDTO;
import ControleDeFrequencia.api.model.Input.AlunoInputDTO;
import ControleDeFrequencia.domain.model.Aluno;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class AlunoAssembler {
    ModelMapper modelMapper;

    public AlunoDTO toModel(Aluno aluno){
        return modelMapper.map(aluno, AlunoDTO.class);
    }

    public Aluno toEntity(AlunoInputDTO alunoInputDTO){
        return modelMapper.map(alunoInputDTO, Aluno.class);
    }

    public List<AlunoDTO> toCollectionModel(List<Aluno> alunos){
        return alunos.stream().map(this::toModel)
                .collect(Collectors.toList());
    }
}
