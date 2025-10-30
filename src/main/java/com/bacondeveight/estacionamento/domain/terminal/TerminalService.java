package com.bacondeveight.estacionamento.domain.terminal;

public class TerminalService {
    //responsável por fazer o acesso ao estabeleciemnto funcionar

    public void lerCartaoMotorista() {
        //verifica se é ou não assinante, se não for assinante vai pagar por hora
    }

    public void registrarEntrada(Terminal terminal) {
        //aqui necessita pegar tipo de veiculo que esta entrando para controle de vagas
        this.lerCartaoMotorista();
    }

    public void registrarSaida(Terminal terminal) {
        terminal.sair();
    }
}
