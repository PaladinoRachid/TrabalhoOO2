package ufjf_dcc025.modelo.disciplinas;

// Representa uma disciplina obrigatória do currículo.
public class DisciplinaObrigatoria extends Disciplina {

    public DisciplinaObrigatoria(String codigo, String nome, int cargaHorariaSemanal) {
        super(codigo, nome, cargaHorariaSemanal);
    }

    // Obrigatórias têm prioridade máxima (nível 1) sobre Eletivas e Optativas
    @Override
    public int getPrecedencia() {
        return 1;
    }
}