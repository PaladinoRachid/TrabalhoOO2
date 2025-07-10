package ufjf_dcc025.excecao;

// Lançada ao tentar matricular um aluno em uma turma que não possui mais vagas disponíveis.
public class TurmaCheiaException extends GerenciamentoVagasException {

    public TurmaCheiaException(String message) {
        super(message);
    }
}