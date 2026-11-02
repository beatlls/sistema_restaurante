package org.example.pedido;

import org.example.cardapio.ItemCardapio;

import java.util.ArrayList;

public class Pedido {

    private int numIdent;
    private String nomeCliente;
    private ArrayList<ItemCardapio> itens;

    public int getNumIdent() {
        return numIdent;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Digite um nome.");
        }
        System.out.println("Nome do cliente: " + nomeCliente);
        this.nomeCliente = nomeCliente;
    }

    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemCardapio itemAtual : this.itens) {
            total = total + itemAtual.getPreco();
        }
        return total;
    }

    public void adicionarItem(ItemCardapio itemCardapio) {
        this.itens.add(itemCardapio);
    }

    public Pedido(int numIdent, String nomeCliente) {
        this.numIdent = numIdent;
        setNomeCliente(nomeCliente);
        this.itens = new ArrayList<>();
    }
}
