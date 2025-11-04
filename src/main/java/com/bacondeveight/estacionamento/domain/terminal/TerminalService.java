package com.bacondeveight.estacionamento.domain.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {
    @Autowired
    private RegistryTerminalLogRepository terminalRepository;

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
