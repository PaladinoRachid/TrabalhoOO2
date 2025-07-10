package ufjf_dcc025.excecao;

// Lançada quando um pré-requisito não é atendido, incluindo a regra de nota mínima.
public class PreRequisitoNaoCumpridoException extends ValidacaoMatriculaException {

    public PreRequisitoNaoCumpridoException(String message) {
        super(message);
    }
}