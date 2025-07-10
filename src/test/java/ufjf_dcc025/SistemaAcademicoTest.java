package ufjf_dcc025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ufjf_dcc025.modelo.Aluno;
import ufjf_dcc025.modelo.Turma;
import ufjf_dcc025.modelo.disciplinas.*;
import ufjf_dcc025.excecao.*;

import java.util.Map;

class SistemaAcademicoTest {

    private SistemaAcademico sistema;
    private Disciplina dcc025, dcc013;
    private Aluno aluno;

    // O método com @BeforeEach roda antes de CADA teste
    @BeforeEach
    void setUp() {
        sistema = new SistemaAcademico();
        dcc025 = new DisciplinaObrigatoria("DCC025", "POO", 4);
        dcc013 = new DisciplinaObrigatoria("DCC013", "Algoritmos", 4);
        aluno = new Aluno("Fulano", "202501001", 24);

        sistema.cadastrarDisciplina(dcc025);
        sistema.cadastrarDisciplina(dcc013);
        sistema.cadastrarAluno(aluno);
    }

    // Testa o cenário de sucesso de uma matrícula simples
    @Test
    void testMatriculaBemSucedida() {
        // Cenário
        Turma turmaPoo = new Turma("T1", dcc025, "Seg 14-16", 30);
        sistema.cadastrarTurma(turmaPoo);
        aluno.getPlanejamentoFuturo().add(turmaPoo);

        // Ação
        Map<Turma, String> relatorio = sistema.processarPlanejamentoMatricula(aluno);

        // Verificação
        assertEquals(1, relatorio.size());
        assertEquals("ACEITA", relatorio.get(turmaPoo));
    }

    // Testa o lançamento da exceção TurmaCheiaException
    @Test
    void testLancaTurmaCheiaException() {
        // Cenário
        Turma turmaAlg = new Turma("T2", dcc013, "Ter 16-18", 1);
        Aluno outroAluno = new Aluno("Ciclano", "202501002", 24);
        turmaAlg.getAlunosMatriculados().add(outroAluno); // A turma já está cheia
        sistema.cadastrarTurma(turmaAlg);

        aluno.getPlanejamentoFuturo().add(turmaAlg);

        // Ação e Verificação
        Map<Turma, String> relatorio = sistema.processarPlanejamentoMatricula(aluno);
        assertTrue(relatorio.get(turmaAlg).contains("REJEITADA"));
        assertTrue(relatorio.get(turmaAlg).contains("está cheia"));
    }
}