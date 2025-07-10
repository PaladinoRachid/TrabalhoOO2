package ufjf_dcc025.validador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ufjf_dcc025.modelo.Aluno;
import ufjf_dcc025.modelo.disciplinas.*;

class ValidadorCreditosMinimosTest {

    private Aluno aluno;
    private Disciplina dcc013, dcc001;

    @BeforeEach
    void setUp() {
        aluno = new Aluno("Fulano", "202501001", 24);
        dcc013 = new DisciplinaObrigatoria("DCC013", "Algoritmos", 4);
        dcc001 = new DisciplinaObrigatoria("DCC001", "Cálculo I", 6);
    }

    @Test
    void deveValidarQuandoAlunoTemCreditosSuficientes() {
        aluno.getDisciplinasCursadas().put(dcc013, 80); // 4 créditos
        aluno.getDisciplinasCursadas().put(dcc001, 75); // 6 créditos
        // Total: 10 créditos

        ValidadorPreRequisito validador = new ValidadorCreditosMinimos(10);
        assertTrue(validador.validar(aluno, null)); // Disciplina é irrelevante aqui
    }

    @Test
    void naoDeveValidarQuandoAlunoNaoTemCreditosSuficientes() {
        aluno.getDisciplinasCursadas().put(dcc013, 80); // 4 créditos
        // Total: 4 créditos

        ValidadorPreRequisito validador = new ValidadorCreditosMinimos(10);
        assertFalse(validador.validar(aluno, null));
    }

    @Test
    void deveIgnorarCreditosDeMateriasComNotaRuim() {
        aluno.getDisciplinasCursadas().put(dcc013, 80);  // 4 créditos válidos
        aluno.getDisciplinasCursadas().put(dcc001, 50);  // 6 créditos inválidos
        // Total válido: 4 créditos

        ValidadorPreRequisito validador = new ValidadorCreditosMinimos(10);
        assertFalse(validador.validar(aluno, null));
    }
}