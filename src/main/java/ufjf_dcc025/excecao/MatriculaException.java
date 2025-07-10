package ufjf_dcc025.excecao;

// Exceção abstrata base para erros de matrícula — facilita tratamento genérico
public abstract class MatriculaException extends Exception {

    public MatriculaException(String message) {
        super(message);
    }
}