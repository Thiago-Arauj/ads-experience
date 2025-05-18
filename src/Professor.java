// Classe Professor que herda da classe abstrata Participante
public class Professor extends Participante {

    // Atributo que representa o horário em que o professor dará aula (pode ser um identificador de horário)
    private int horario;

    // Atributo que representa o conteúdo (atividade) que o professor irá ministrar
    private TipoAtividade conteudo;

    // Construtor da classe Professor
    public Professor(String nome, String matricula, int horario) {
        super(nome, matricula);         // Chama o construtor da superclasse Participante
        this.horario = horario;         // Define o horário do professor
        Participante.qtdInscritos++;    // Incrementa o contador global de participantes
    }

    // Getter para o horário do professor
    public int getHorario() {
        return horario;
    }

    // Setter para o horário do professor
    public void setHorario(int horario) {
        this.horario = horario;
    }

    // Getter para o conteúdo (atividade) que o professor irá ministrar
    public TipoAtividade getConteudo() {
        return conteudo;
    }

    // Setter para o conteúdo (atividade)
    public void setConteudo(TipoAtividade conteudo) {
        this.conteudo = conteudo;
    }
}
