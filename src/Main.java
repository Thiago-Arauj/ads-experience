// Classe principal com o método main, ponto de entrada da aplicação
public class Main {
    public static void main(String[] args) {

        // Criação de um estudante do curso de ADS
        EstudanteADS e1 = new EstudanteADS("Jade Diniz", "12345");

        // Criação de 5 professores com diferentes horários (mas mesmos dados pessoais)
        Professor p1 = new Professor("Pablo Roberto", "67890", 7);
        Professor p2 = new Professor("Pablo Roberto", "67890", 3);
        Professor p3 = new Professor("Pablo Roberto", "67890", 8); // mesmo horário de p2 (possível conflito)
        Professor p4 = new Professor("Pablo Roberto", "67890", 1);
        Professor p5 = new Professor("Pablo Roberto", "67890", 9);

        // Definindo o conteúdo (atividade) que cada professor irá ministrar
        p1.setConteudo(TipoAtividade.HACKATHON);
        p2.setConteudo(TipoAtividade.NETWORKING);
        p3.setConteudo(TipoAtividade.HACKATHON);
        p4.setConteudo(TipoAtividade.PALESTRA);
        p5.setConteudo(TipoAtividade.WORKSHOP);

        // Adicionando os horários dos professores à agenda do estudante
        // Isso pode lançar uma exceção se houver conflito de horário
        e1.addHorario(p1.getHorario());  // 7
        e1.addHorario(p2.getHorario());  // 3
        e1.addHorario(p3.getHorario());  // 3 novamente → conflito esperado!
        e1.addHorario(p4.getHorario());  // 1
        e1.addHorario(p5.getHorario());  // 9

        // Tentativas de inscrição do estudante em cada uma das atividades dos professores
        // O método verifica o limite de inscrições antes de aceitar
        System.out.println(e1.addAtividades(p1.getConteudo())); // Sucesso
        System.out.println(e1.addAtividades(p2.getConteudo())); // Sucesso
        System.out.println(e1.addAtividades(p3.getConteudo())); // Sucesso
        System.out.println(e1.addAtividades(p4.getConteudo())); // Sucesso
        System.out.println(e1.addAtividades(p5.getConteudo())); // Limite atingido → erro

        // Mostra o número total de participantes cadastrados (estudantes + professores)
        System.out.println(Participante.getQtdInscritos()); // Deve imprimir 6
    }
}
