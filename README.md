# Sistema de Gerenciamento de Estacionamento

## Sobre o Projeto
Este é um sistema de gerenciamento de entrada e saída de veículos em Java Spring Boot que permite controlar entradas, saídas e vagas de estacionamentos.

## Funcionalidades
- Cadastro e gerenciamento de estabelecimentos (estacionamentos)
- Registro de entrada e saída de veículos
- Controle de vagas disponíveis
- Cadastro de veículos e motoristas
- Cálculo automático de valores baseado no tempo de permanência

## Demonstração
Veja abaixo uma demonstração do sistema embarcado em um hardware:

![Demonstração do Sistema](./src/main/resources/assets/simulacao-estacionamento.gif)

## Requisitos
- Java 17 ou superior
- Maven
- Postgres
- Docker

## Configuração do Ambiente

## Como Executar

1. Clone o repositório (usando HTTPS):
```bash
git clone https://github.com/Joao-Victor-Medeiros/estacionamento.git
cd estacionamento
```

2. Configure o banco de dados no arquivo `src/main/resources/application.properties`

3. Execute o projeto usando Maven:
```bash
./mvnw spring-boot:run
```
Ou no Windows:
```bash
mvnw.cmd spring-boot:run
```

Ou no Intellij:
```bash
shift + F10
```
4. A aplicação estará disponível em `http://localhost:8080`