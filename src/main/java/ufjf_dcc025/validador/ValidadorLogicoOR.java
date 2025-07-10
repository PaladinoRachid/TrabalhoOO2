package ufjf_dcc025.validador;

import ufjf_dcc025.modelo.Aluno;
import ufjf_dcc025.modelo.disciplinas.Disciplina;
import java.util.List;

// Valida se pelo menos um de um conjunto de pré-requisitos foi atendido (lógica OU).
public class ValidadorLogicoOR implements ValidadorPreRequisito {

    private final List<ValidadorPreRequisito> validadores;

    public ValidadorLogicoOR(List<ValidadorPreRequisito> validadores) {
        this.validadores = validadores;
    }

    @Override
    public boolean validar(Aluno aluno, Disciplina disciplina) {
        // Itera sobre cada validador da lista
        for (ValidadorPreRequisito validador : this.validadores) {
            // Se qualquer um deles passar (retornar true), a condição OR é satisfeita.
            if (validador.validar(aluno, disciplina)) {
                return true;
            }
        }
        // Se o loop terminar, significa que nenhum validador retornou true.
        return false;
    }
}