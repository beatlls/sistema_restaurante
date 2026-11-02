package org.example.app;

import org.example.cardapio.*;
import org.example.pedido.GerenciadorPedidos;
import org.example.pedido.Pedido;

import java.util.HashMap;

public class RestauranteFacade {
    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }

    public HashMap<Integer, Pedido> getPedidos() {
        return gerenciador.getPedidos();
    }

    public Lanche pedirLanche(int opcaoCardapio) {
        switch (opcaoCardapio) {
            case 1:
                return LancheFactory.xBurger();
            case 2:
                return LancheFactory.xSalada();
            case 3:
                return LancheFactory.xBacon();
            default:
                return null;
        }
    }

    public ItemCardapio adicionarExtra(ItemCardapio itemAtual, int opcaoAdicional) {
        switch (opcaoAdicional) {
            case 1:
                return new ComCheddar(itemAtual);
            case 2:
                return new ComBaconExtra(itemAtual);
            default:
                return itemAtual;
        }
    }
}
