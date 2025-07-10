package ufjf_dcc025.validador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ufjf_dcc025.modelo.Aluno;
import ufjf_dcc025.modelo.disciplinas.*;

class ValidadorSimplesTest {

    private Aluno aluno;
    private Disciplina dcc013; // Algoritmos (pré-requisito)
    private Disciplina dcc025; // POO (disciplina a ser cursada)

    @BeforeEach
    void setUp() {
        aluno = new Aluno("Fulano", "202501001", 24);
        dcc013 = new DisciplinaObrigatoria("DCC013", "Algoritmos", 4);
        dcc025 = new DisciplinaObrigatoria("DCC025", "POO", 4);
    }

    @Test
    void deveValidarQuandoPreRequisitoFoiCursadoComNotaBoa() {
        aluno.getDisciplinasCursadas().put(dcc013, 70); // Nota >= 60

        ValidadorPreRequisito validador = new ValidadorSimples(dcc013);
        assertTrue(validador.validar(aluno, dcc025));
    }

    @Test
    void naoDeveValidarQuandoPreRequisitoFoiCursadoComNotaRuim() {
        aluno.getDisciplinasCursadas().put(dcc013, 59); // Nota < 60

        ValidadorPreRequisito validador = new ValidadorSimples(dcc013);
        assertFalse(validador.validar(aluno, dcc025));
    }

    @Test
    void naoDeveValidarQuandoPreRequisitoNaoFoiCursado() {
        // Histórico do aluno está vazio
        ValidadorPreRequisito validador = new ValidadorSimples(dcc013);
        assertFalse(validador.validar(aluno, dcc025));
    }
}