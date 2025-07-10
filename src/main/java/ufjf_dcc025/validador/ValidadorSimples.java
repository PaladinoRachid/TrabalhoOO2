package ufjf_dcc025.validador;

import ufjf_dcc025.modelo.Aluno;
import ufjf_dcc025.modelo.disciplinas.Disciplina;
import java.util.Map;

// Valida se uma única disciplina pré-requisito foi concluída com nota >= 60.
public class ValidadorSimples implements ValidadorPreRequisito {

    private final Disciplina preRequisito;

    public ValidadorSimples(Disciplina preRequisito) {
        this.preRequisito = preRequisito;
    }

    @Override
    public boolean validar(Aluno aluno, Disciplina disciplina) {
        // Pega o mapa de disciplinas cursadas pelo aluno
        Map<Disciplina, Integer> disciplinasCursadas = aluno.getDisciplinasCursadas();

        // Verifica se o pré-requisito está no histórico e se a nota é suficiente
        if (disciplinasCursadas.containsKey(this.preRequisito)) {
            int nota = disciplinasCursadas.get(this.preRequisito);
            // A disciplina é considerada concluída somente se a nota for >= 60
            return nota >= 60;
        }

        // Se o aluno nunca cursou a disciplina, o pré-requisito não foi atendido.
        return false;
    }
}