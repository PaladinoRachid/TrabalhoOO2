package ufjf_dcc025.modelo.disciplinas;

import ufjf_dcc025.validador.ValidadorPreRequisito;
import java.util.ArrayList;
import java.util.List;

public abstract class Disciplina {

    private String codigo;
    private String nome;
    private int cargaHorariaSemanal;
    private List<Disciplina> coRequisitos;
    private List<ValidadorPreRequisito> validadoresPreRequisito;

    public Disciplina(String codigo, String nome, int cargaHorariaSemanal) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.coRequisitos = new ArrayList<>();
        this.validadoresPreRequisito = new ArrayList<>(); // Inicializa a lista de validadores
    }

    public abstract int getPrecedencia();

    // Adiciona um novo validador à lista de pré-requisitos da disciplina.
    public void adicionarValidador(ValidadorPreRequisito validador) {
        this.validadoresPreRequisito.add(validador);
    }

    // --- Getters e Setters ---

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public List<Disciplina> getCoRequisitos() {
        return coRequisitos;
    }

    public void setCoRequisitos(List<Disciplina> coRequisitos) {
        this.coRequisitos = coRequisitos;
    }

    public List<ValidadorPreRequisito> getValidadoresPreRequisito() {
        return validadoresPreRequisito;
    }

    public void setValidadoresPreRequisito(List<ValidadorPreRequisito> validadoresPreRequisito) {
        this.validadoresPreRequisito = validadoresPreRequisito;
    }
}