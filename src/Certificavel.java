// Interface que define um contrato para objetos que podem gerar certificados
public interface Certificavel {

    // Método que deve ser implementado para gerar um certificado para o participante
    void gerarCertificado();

    // Método que deve ser implementado para validar se o participante tem direito ao certificado
    boolean validarParticipacao();
}
