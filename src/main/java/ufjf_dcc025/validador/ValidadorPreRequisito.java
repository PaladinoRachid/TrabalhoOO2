package ufjf_dcc025.validador;

import ufjf_dcc025.modelo.Aluno;
import ufjf_dcc025.modelo.disciplinas.Disciplina;


//Esta interface define o contrato para qualquer regra de validação de pré-requisito.
//Ela permite que diferentes lógicas de validação sejam tratadas de forma polimórfica.
public interface ValidadorPreRequisito {

    // O metodo principal que toda classe validadora deve implementar.
    // Ele verifica se um aluno atende a um critério específico para cursar uma disciplina.
    boolean validar(Aluno aluno, Disciplina disciplina);
}