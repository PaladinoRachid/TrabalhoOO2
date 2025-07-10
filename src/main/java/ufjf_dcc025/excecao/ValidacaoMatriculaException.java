package ufjf_dcc025.excecao;

// Classe base para todas as exceções relacionadas a falhas de validação de regras de negócio.
public class ValidacaoMatriculaException extends MatriculaException {

    public ValidacaoMatriculaException(String message) {
        super(message);
    }
}