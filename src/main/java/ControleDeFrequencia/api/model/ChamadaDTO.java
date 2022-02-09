package ControleDeFrequencia.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ChamadaDTO {

    private String nomeAluno;

    private Date data;

    private Boolean presenca;
}
