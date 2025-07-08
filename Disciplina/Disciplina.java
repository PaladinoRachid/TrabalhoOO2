package Disciplina;
import Turma.Turma;

public abstract class Disciplina 
{
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private Disciplina [] prerrequisitos;
    private Disciplina [] correquisitos;
    private Turma [] turmas;
}
