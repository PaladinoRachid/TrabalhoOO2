package ufjf_dcc025.excecao;

// Lançada quando a carga horária máxima do aluno para o semestre é excedida.
public class CargaHorariaExcedidaException extends ValidacaoMatriculaException {

    public CargaHorariaExcedidaException(String message) {
        super(message);
    }
}