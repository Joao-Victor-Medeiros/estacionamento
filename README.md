# Sistema de Gerenciamento de Estacionamento

## Sobre o Projeto
Este é um sistema de gerenciamento de estacionamento desenvolvido em Java Spring Boot que permite controlar entradas, saídas e vagas de estacionamentos.

## Funcionalidades
- Cadastro e gerenciamento de estabelecimentos (estacionamentos)
- Registro de entrada e saída de veículos
- Controle de vagas disponíveis
- Cadastro de veículos e motoristas
- Cálculo automático de valores baseado no tempo de permanência

## Requisitos
- Java 17 ou superior
- Maven
- MySQL/MariaDB
- Git

## Configuração do Ambiente

### Configurando o Git
1. Instale o Git em sua máquina se ainda não tiver instalado
2. Configure seu usuário e email no Git:
```bash
git config --global user.name "Seu Nome"
git config --global user.email "seu.email@exemplo.com"
```

## Como Executar

1. Clone o repositório (usando HTTPS):
```bash
git clone https://github.com/SEU_USUARIO/estacionamento.git
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

4. A aplicação estará disponível em `http://localhost:8080`

## Demonstração
Veja abaixo uma demonstração do sistema em funcionamento:

https://github.com/user/estacionamento/raw/main/src/main/resources/assets/simulacao-estacionamento.mp4

Ou visualize o vídeo diretamente:

<video width="640" height="480" controls>
  <source src="src/main/resources/assets/simulacao-estacionamento.mp4" type="video/mp4">
  Seu navegador não suporta a tag de vídeo.
</video>