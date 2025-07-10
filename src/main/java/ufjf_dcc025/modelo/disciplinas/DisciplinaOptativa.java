package ufjf_dcc025.modelo.disciplinas;

// Representa uma disciplina optativa.
public class DisciplinaOptativa extends Disciplina {

    public DisciplinaOptativa(String codigo, String nome, int cargaHorariaSemanal) {
        super(codigo, nome, cargaHorariaSemanal);
    }

    // Optativas têm prioridade mais baixa (nível 3)
    @Override
    public int getPrecedencia() {
        return 3;
    }
}