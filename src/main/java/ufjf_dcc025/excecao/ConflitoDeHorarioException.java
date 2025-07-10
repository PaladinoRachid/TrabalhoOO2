package ufjf_dcc025.excecao;

// Lançada quando há um conflito de horário que não pode ser resolvido pela regra de precedência.
public class ConflitoDeHorarioException extends ValidacaoMatriculaException {

    public ConflitoDeHorarioException(String message) {
        super(message);
    }
}