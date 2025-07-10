package ufjf_dcc025.validador;

import ufjf_dcc025.modelo.Aluno;
import ufjf_dcc025.modelo.disciplinas.Disciplina;
import java.util.List;

// Valida se um conjunto de pré-requisitos foi atendido (lógica E).
public class ValidadorLogicoAND implements ValidadorPreRequisito {

    private final List<ValidadorPreRequisito> validadores;

    public ValidadorLogicoAND(List<ValidadorPreRequisito> validadores) {
        this.validadores = validadores;
    }

    @Override
    public boolean validar(Aluno aluno, Disciplina disciplina) {
        // Itera sobre cada validador da lista
        for (ValidadorPreRequisito validador : this.validadores) {
            // Se qualquer um deles falhar (retornar false), a condição AND falha.
            if (!validador.validar(aluno, disciplina)) {
                return false;
            }
        }
        // Se o loop terminar, significa que todos os validadores retornaram true.
        return true;
    }
}