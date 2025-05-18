# Sistema de Atividades Acadêmicas em Java

Este é um projeto simples feito em Java que simula um sistema de inscrição em atividades acadêmicas como palestras, workshops e hackathons. Ele foi criado para praticar conceitos de Programação Orientada a Objetos (POO).

## Funcionalidades

- Cadastro de estudantes e professores
- Limite de inscrições por participante
- Verificação de conflitos de horário (para estudantes)
- Geração de certificados
- Cálculo de créditos por atividade

## Estrutura do Projeto

### Participante (classe abstrata)
Classe base que guarda nome, matrícula e atividades inscritas. Também controla o número total de inscrições.

### EstudanteADS
Classe filha de Participante. Adiciona uma lista de horários e verifica se há conflito de horário.

### Professor
Classe filha de Participante. Possui um horário fixo e o conteúdo (atividade) que irá ministrar.

### TipoAtividade (enum)
Define os tipos de atividade:
- PALESTRA (2 créditos)
- WORKSHOP (4 créditos)
- HACKATHON (8 créditos)
- NETWORKING (1 crédito)

### Certificavel (interface)
Obrigatório para quem pode gerar certificado. Tem dois métodos:
- `gerarCertificado()`
- `validarParticipacao()`

### ConflitoHorarios (exceção)
Exceção usada quando o estudante tenta se inscrever em dois eventos no mesmo horário.

### Main
Simula o uso do sistema:
- Cria participantes
- Define horários e atividades
- Testa inscrições
- Mostra mensagens e contagem de inscritos
