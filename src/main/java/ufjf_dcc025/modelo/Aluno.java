package ufjf_dcc025.modelo;

import ufjf_dcc025.modelo.disciplinas.Disciplina;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aluno {

    private String nome;
    private String matricula;
    private Map<Disciplina, Integer> disciplinasCursadas;
    private List<Turma> planejamentoFuturo;
    private int cargaHorariaMaxima;

    public Aluno(String nome, String matricula, int cargaHorariaMaxima) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargaHorariaMaxima = cargaHorariaMaxima;
        this.disciplinasCursadas = new HashMap<>(); // Inicializa o histórico
        this.planejamentoFuturo = new ArrayList<>(); // Inicializa o planejamento
    }

    // --- Getters e Setters ---

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Map<Disciplina, Integer> getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public void setDisciplinasCursadas(Map<Disciplina, Integer> disciplinasCursadas) {
        this.disciplinasCursadas = disciplinasCursadas;
    }

    public List<Turma> getPlanejamentoFuturo() {
        return planejamentoFuturo;
    }

    public void setPlanejamentoFuturo(List<Turma> planejamentoFuturo) {
        this.planejamentoFuturo = planejamentoFuturo;
    }

    public int getCargaHorariaMaxima() {
        return cargaHorariaMaxima;
    }

    public void setCargaHorariaMaxima(int cargaHorariaMaxima) {
        this.cargaHorariaMaxima = cargaHorariaMaxima;
    }
}