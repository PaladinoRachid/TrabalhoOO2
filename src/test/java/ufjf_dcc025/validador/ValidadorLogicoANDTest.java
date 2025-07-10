package ufjf_dcc025.validador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ufjf_dcc025.modelo.Aluno;
import ufjf_dcc025.modelo.disciplinas.*;
import java.util.List;
import java.util.ArrayList;

class ValidadorLogicoANDTest {

    private Aluno aluno;
    private Disciplina dcc013, dcc001;

    @BeforeEach
    void setUp() {
        aluno = new Aluno("Fulano", "202501001", 24);
        dcc013 = new DisciplinaObrigatoria("DCC013", "Algoritmos", 4);
        dcc001 = new DisciplinaObrigatoria("DCC001", "Cálculo I", 6);
    }

    @Test
    void deveValidarQuandoTodosOsValidadoresPassam() {
        aluno.getDisciplinasCursadas().put(dcc013, 60);
        aluno.getDisciplinasCursadas().put(dcc001, 60);

        List<ValidadorPreRequisito> validadores = List.of(
                new ValidadorSimples(dcc013),
                new ValidadorSimples(dcc001)
        );

        ValidadorPreRequisito validadorAND = new ValidadorLogicoAND(validadores);
        assertTrue(validadorAND.validar(aluno, null));
    }

    @Test
    void naoDeveValidarQuandoUmDosValidadoresFalha() {
        aluno.getDisciplinasCursadas().put(dcc013, 60); // Apenas um pré-requisito satisfeito

        List<ValidadorPreRequisito> validadores = List.of(
                new ValidadorSimples(dcc013),
                new ValidadorSimples(dcc001)
        );

        ValidadorPreRequisito validadorAND = new ValidadorLogicoAND(validadores);
        assertFalse(validadorAND.validar(aluno, null));
    }
}