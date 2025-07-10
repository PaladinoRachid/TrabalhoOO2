package ufjf_dcc025;

import ufjf_dcc025.excecao.*;
import ufjf_dcc025.modelo.Aluno;
import ufjf_dcc025.modelo.Turma;
import ufjf_dcc025.modelo.disciplinas.Disciplina;
import ufjf_dcc025.validador.ValidadorPreRequisito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Núcleo da simulação: cuida de dados, regras e relatórios da matrícula
public class SistemaAcademico {

    private final List<Aluno> alunos;
    private final List<Disciplina> disciplinas;
    private final List<Turma> turmas;

    public SistemaAcademico() {
        // Simula o carregamento de dados inicializando as listas
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    // --- Métodos para simular o carregamento de dados ---
    public void cadastrarAluno(Aluno aluno) { this.alunos.add(aluno); }
    public void cadastrarDisciplina(Disciplina disciplina) { this.disciplinas.add(disciplina); }
    public void cadastrarTurma(Turma turma) { this.turmas.add(turma); }

    // Processa o plano de matrícula do aluno, validando turmas e gerando relatório
    public Map<Turma, String> processarPlanejamentoMatricula(Aluno aluno) {
        Map<Turma, String> relatorio = new HashMap<>();
        List<Turma> turmasDesejadas = aluno.getPlanejamentoFuturo();
        List<Turma> turmasAceitas = new ArrayList<>();
        int cargaHorariaSemestre = 0;

        for (Turma turmaDesejada : turmasDesejadas) {
            try {
                // ETAPA 1: Valida Vagas
                if (!turmaDesejada.temVagas()) {
                    throw new TurmaCheiaException("A turma " + turmaDesejada.getId() + " está cheia.");
                }

                // ETAPA 2: Valida Carga Horária Máxima
                int cargaHorariaFutura = cargaHorariaSemestre + turmaDesejada.getDisciplina().getCargaHorariaSemanal();
                if (cargaHorariaFutura > aluno.getCargaHorariaMaxima()) {
                    throw new CargaHorariaExcedidaException("A matrícula nesta turma excede a carga horária máxima.");
                }

                // ETAPA 3: Valida Pré-requisitos
                for (ValidadorPreRequisito validador : turmaDesejada.getDisciplina().getValidadoresPreRequisito()) {
                    if (!validador.validar(aluno, turmaDesejada.getDisciplina())) {
                        throw new PreRequisitoNaoCumpridoException("Pré-requisito não cumprido para " + turmaDesejada.getDisciplina().getNome());
                    }
                }

                // ETAPA 4: Valida Co-requisitos
                for (Disciplina coReq : turmaDesejada.getDisciplina().getCoRequisitos()) {
                    boolean coRequisitoEncontrado = false;
                    for(Turma outraTurmaDesejada : turmasDesejadas) {
                        if(outraTurmaDesejada.getDisciplina().equals(coReq)) {
                            coRequisitoEncontrado = true;
                            break;
                        }
                    }
                    if(!coRequisitoEncontrado) {
                        throw new CoRequisitoNaoAtendidoException("Co-requisito " + coReq.getNome() + " não selecionado.");
                    }
                }

                // ETAPA 5: Valida Conflito de Horário (versão simplificada)
                for (Turma turmaJaAceita : turmasAceitas) {
                    if (turmaJaAceita.getHorario().equals(turmaDesejada.getHorario())) {
                        // Lógica de precedência seria aplicada aqui.
                        // Por simplicidade, vamos apenas registrar o conflito.
                        throw new ConflitoDeHorarioException("Conflito de horário com a turma " + turmaJaAceita.getId());
                    }
                }

                // SUCESSO: Se todas as validações passaram
                turmasAceitas.add(turmaDesejada);
                cargaHorariaSemestre = cargaHorariaFutura;
                relatorio.put(turmaDesejada, "ACEITA");

            } catch (MatriculaException e) {
                // Captura qualquer uma das nossas exceções personalizadas e registra no relatório.
                relatorio.put(turmaDesejada, "REJEITADA: " + e.getMessage());
            }
        }

        // Ao final, o histórico do aluno seria atualizado.
        // E o relatório completo é retornado.
        return relatorio;
    }
}