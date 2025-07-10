package ufjf_dcc025.excecao;

// Lançada quando um co-requisito não é selecionado junto com a disciplina principal.
public class CoRequisitoNaoAtendidoException extends ValidacaoMatriculaException {

    public CoRequisitoNaoAtendidoException(String message) {
        super(message);
    }
}