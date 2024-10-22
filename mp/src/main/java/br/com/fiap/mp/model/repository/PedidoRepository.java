package br.com.fiap.mp.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.mp.model.entity.Pedido;
import br.com.fiap.mp.model.entity.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedido status);
}
