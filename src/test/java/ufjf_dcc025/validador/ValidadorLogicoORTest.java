package ufjf_dcc025.validador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ufjf_dcc025.modelo.Aluno;
import ufjf_dcc025.modelo.disciplinas.*;
import java.util.List;

class ValidadorLogicoORTest {

    private Aluno aluno;
    private Disciplina dcc013, dcc001;

    @BeforeEach
    void setUp() {
        aluno = new Aluno("Fulano", "202501001", 24);
        dcc013 = new DisciplinaObrigatoria("DCC013", "Algoritmos", 4);
        dcc001 = new DisciplinaObrigatoria("DCC001", "Cálculo I", 6);
    }

    @Test
    void deveValidarQuandoPeloMenosUmValidadorPassa() {
        aluno.getDisciplinasCursadas().put(dcc013, 60); // Apenas um pré-requisito satisfeito

        List<ValidadorPreRequisito> validadores = List.of(
                new ValidadorSimples(dcc013),
                new ValidadorSimples(dcc001)
        );

        ValidadorPreRequisito validadorOR = new ValidadorLogicoOR(validadores);
        assertTrue(validadorOR.validar(aluno, null));
    }

    @Test
    void naoDeveValidarQuandoNenhumValidadorPassa() {
        // Histórico vazio

        List<ValidadorPreRequisito> validadores = List.of(
                new ValidadorSimples(dcc013),
                new ValidadorSimples(dcc001)
        );

        ValidadorPreRequisito validadorOR = new ValidadorLogicoOR(validadores);
        assertFalse(validadorOR.validar(aluno, null));
    }
}