package br.com.fiap.mp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.mp.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
