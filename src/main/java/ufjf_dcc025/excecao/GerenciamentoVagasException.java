package ufjf_dcc025.excecao;

// Classe base para exceções relacionadas ao gerenciamento de vagas em turmas.
public class GerenciamentoVagasException extends MatriculaException {

    public GerenciamentoVagasException(String message) {
        super(message);
    }
}