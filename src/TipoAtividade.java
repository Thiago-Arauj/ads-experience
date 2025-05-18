// Enumeração que representa os tipos de atividades disponíveis
public enum TipoAtividade {

    // Cada constante enum representa um tipo de atividade com sua respectiva carga horária (créditos)
    PALESTRA(2),
    WORKSHOP(4),
    HACKATHON(8),
    NETWORKING(1);

    // Atributo privado que armazena os créditos da atividade
    private final int credits;

    // Construtor do enum, chamado implicitamente ao declarar as constantes acima
    TipoAtividade(int credits) {
        this.credits = credits;
    }

    // Getter que retorna o número de créditos de uma atividade
    public int getCredits() {
        return credits;
    }

    // Sobrescreve o método toString() para retornar uma representação textual personalizada da constante
    @Override
    public String toString() {
        return "TipoAtividade{" +
                "credits=" + credits +
                '}';
    }
}
