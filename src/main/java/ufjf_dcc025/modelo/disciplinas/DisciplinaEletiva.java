package ufjf_dcc025.modelo.disciplinas;

// Descreve uma disciplina eletiva.
public class DisciplinaEletiva extends Disciplina {

    public DisciplinaEletiva(String codigo, String nome, int cargaHorariaSemanal) {
        super(codigo, nome, cargaHorariaSemanal);
    }

    // Eletivas têm prioridade intermediária (nível 2)
    @Override
    public int getPrecedencia() {
        return 2;
    }
}