// Importa a classe ArrayList da biblioteca padrão do Java
import java.util.ArrayList;

// Classe pública EstudanteADS que estende (herda de) Participante
public class EstudanteADS extends Participante {

    // Lista de horários associados ao estudante (ex: horários de atividades)
    private ArrayList<Integer> horarios = new ArrayList<>();

    // Construtor da classe, recebe nome e matrícula
    public EstudanteADS(String nome, String matricula) {
        super(nome, matricula);           // Chama o construtor da superclasse Participante
        Participante.qtdInscritos++;      // Incrementa o contador de inscritos (embora não seja usado no controle de inscrições)
    }

    // Retorna a lista de horários do estudante
    public ArrayList<Integer> getHorarios() {
        return horarios;
    }

    // Adiciona um horário à lista, se não houver conflito detectado
    public void addHorario(Integer horario) {
        if (this.checarConflito()) {      // Verifica conflitos antes de adicionar
            this.horarios.add(horario);   // Adiciona o horário à lista
        }
    }

    // Verifica se há conflitos de horário
    // Um conflito é considerado quando dois horários consecutivos são iguais
    public boolean checarConflito() throws ConflitoHorarios {
        int ultimo = 0;

        // Percorre todos os horários da lista
        for (int horario : this.horarios) {
            // Se encontrar dois horários iguais consecutivos, lança exceção
            if (horario == ultimo) {
                throw new ConflitoHorarios("Tá dando conflito de horaraio pae"); // Mensagem personalizada
            }
            ultimo = horario;
        }

        // Se não houver conflitos, retorna true
        return true;
    }
}
