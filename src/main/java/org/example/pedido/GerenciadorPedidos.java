package org.example.pedido;

import java.util.HashMap;

public class GerenciadorPedidos {
    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private  int contadorPedidos = 1;

    public Pedido criarPedido(String nomeCliente) {
        Pedido novoPedido = new Pedido(contadorPedidos, nomeCliente);
        pedidos.put(novoPedido.getNumIdent(), novoPedido);
        contadorPedidos++;
        return novoPedido;
    }

    public Pedido buscarPedido(int numero) {
        return pedidos.get(numero);
    }

    public HashMap<Integer, Pedido> getPedidos() {
        return pedidos;
    }

    public double calcularTotalDoDia() {
        double total = 0.0;
        for (Pedido pedidoAtual : pedidos.values()) {
            total = total + pedidoAtual.calcularTotal();
        }
        return total;
    }
}
