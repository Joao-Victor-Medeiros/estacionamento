package com.bacondeveight.estacionamento.domain.terminal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;

public interface RegistryTerminalLogRepository extends JpaRepository<RegistryTerminalLog, Long> {
    Optional<RegistryTerminalLog> findTopByMotoristaIdAndPlacaAndHorarioSaidaIsNullOrderByHorarioEntradaDesc(Long motoristaId, String placa);

    Optional<RegistryTerminalLog> findTopByMotoristaIdAndPlacaAndHorarioEntradaBetweenOrderByHorarioEntradaDesc(Long motoristaId, String placa, Instant start, Instant end);
}
