// Importa a classe ArrayList da biblioteca padrão do Java
import java.util.ArrayList;

// Classe abstrata Participante, que implementa a interface Certificavel
abstract class Participante implements Certificavel {

    // Contador estático de quantos participantes foram criados
    protected static int qtdInscritos = 0;

    // Contador estático de quantas inscrições totais foram feitas (entre todos os participantes)
    protected static int inscricoes;

    // Constante que define o limite máximo de inscrições por participante
    protected static final int limite = 4;

    // Nome do participante (atributo de instância)
    protected String nome;

    // Matrícula do participante (atributo de instância)
    protected String matricula;

    // Lista de atividades nas quais o participante está inscrito
    protected ArrayList<TipoAtividade> atividades = new ArrayList<>();

    // Construtor: inicializa nome e matrícula do participante
    public Participante(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    // Método estático que verifica se ainda é possível fazer uma inscrição
    public static boolean checarInscricoes(){
        return inscricoes < limite;
    }

    // Incrementa o número total de inscrições
    public static void addInscricao(){
        inscricoes++;
    }

    // Decrementa o número total de inscrições
    public static void removeInscricao(){
        inscricoes--;
    }

    // Getter para o número total de inscrições
    public static int getInscricoes() {
        return inscricoes;
    }

    // Setter para o número total de inscrições
    public static void setInscricoes(int inscricoes) {
        Participante.inscricoes = inscricoes;
    }

    // Getter para o nome do participante
    public String getNome() {
        return nome;
    }

    // Setter para o nome do participante
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para a matrícula do participante
    public String getMatricula() {
        return matricula;
    }

    // Setter para a matrícula do participante
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Retorna a lista de atividades nas quais o participante está inscrito
    public ArrayList<TipoAtividade> getAtividades() {
        return atividades;
    }

    // Adiciona uma atividade, se ainda estiver dentro do limite
    public String addAtividades(TipoAtividade atividade) {
        if (checarInscricoes()) {
            addInscricao();                    // Atualiza o contador global de inscrições
            this.atividades.add(atividade);    // Adiciona atividade à lista do participante
            return "Inscrição realizada com sucesso!";
        } else {
            return "Você atingiu seu limite de " + limite + " inscrições";
        }
    }

    // Remove uma atividade da lista e atualiza o contador global
    public void removeAtividade(TipoAtividade atividade) {
        removeInscricao();
        this.atividades.remove(atividade);
    }

    // Implementação do método da interface Certificavel
    // Gera o certificado se o participante tiver pelo menos uma atividade
    @Override
    public void gerarCertificado() {
        if (this.validarParticipacao()) {
            System.out.println("Toma o certificado");

            int creditoTotal = 0;

            // Soma os créditos de todas as atividades
            for (TipoAtividade atividade : atividades) {
                creditoTotal += atividade.getCredits();
            }

            System.out.println("Seus creditos totais: " + creditoTotal);
        } else {
            System.out.println("Calado Jr"); // Mensagem cômica para ausência de participação
        }
    }

    // Verifica se o participante tem pelo menos uma atividade
    @Override
    public boolean validarParticipacao() {
        return !this.atividades.isEmpty();
    }

    // Getter para a quantidade total de participantes criados
    public static int getQtdInscritos() {
        return qtdInscritos;
    }
}
