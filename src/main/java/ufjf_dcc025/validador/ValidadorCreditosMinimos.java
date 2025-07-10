package ufjf_dcc025.validador;

import ufjf_dcc025.modelo.Aluno;
import ufjf_dcc025.modelo.disciplinas.Disciplina;
import java.util.Map;

// Valida se o aluno atingiu uma quantidade mínima de créditos.
public class ValidadorCreditosMinimos implements ValidadorPreRequisito {

    private final int creditosMinimos;

    public ValidadorCreditosMinimos(int creditosMinimos) {
        this.creditosMinimos = creditosMinimos;
    }

    @Override
    public boolean validar(Aluno aluno, Disciplina disciplina) {
        int creditosAcumulados = 0;

        // Itera sobre o histórico do aluno
        for (Map.Entry<Disciplina, Integer> historico : aluno.getDisciplinasCursadas().entrySet()) {
            int nota = historico.getValue();
            // Somente disciplinas com nota >= 60 contam para os créditos
            if (nota >= 60) {
                // A carga horária semanal é usada como "crédito"
                creditosAcumulados += historico.getKey().getCargaHorariaSemanal();
            }
        }
        return creditosAcumulados >= this.creditosMinimos;
    }
}