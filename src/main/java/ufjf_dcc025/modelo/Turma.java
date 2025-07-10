package ufjf_dcc025.modelo;

import ufjf_dcc025.modelo.disciplinas.Disciplina;
import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String id;
    private Disciplina disciplina;
    private String horario;
    private int capacidadeMaxima;
    private List<Aluno> alunosMatriculados;

    public Turma(String id, Disciplina disciplina, String horario, int capacidadeMaxima) {
        this.id = id;
        this.disciplina = disciplina;
        this.horario = horario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.alunosMatriculados = new ArrayList<>(); // Inicializa a lista de alunos
    }

    //Retorna o número de alunos atualmente matriculados na turma.O total de alunos na lista.
    public int getNumeroAtualMatriculados() {
        return this.alunosMatriculados.size();
    }

    //Verifica se ainda há vagas disponíveis na turma.
    public boolean temVagas() {
        return getNumeroAtualMatriculados() < this.capacidadeMaxima;
    }

    // --- Getters e Setters ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }
}