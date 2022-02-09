package ControleDeFrequencia.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chamadas")
public class Chamada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_chamada")
    Long idChamada;

    @JoinColumn(name = "nome_aluno")
    String nomeAluno;

    Date data;

    Boolean presenca;
}
