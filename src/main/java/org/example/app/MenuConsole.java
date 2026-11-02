package org.example.app;

import org.example.cardapio.ItemCardapio;
import org.example.cardapio.Lanche;
import org.example.pedido.Pedido;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {
    Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("--- SISTEMA DO RESTAURANTE ---");
        System.out.println("1 - Registrar novo pedido ");
        System.out.println("2 - Listar pedidos do dia ");
        System.out.println("3 - Fechar restaurante");
        System.out.println("4 - Modificar pedido");
        System.out.println("0 - Sair");
    }

    public int lerOpcao() {
        return lerInteiro("Escolha uma opção: ");
    }

    public String lerTexto(String mensagem) {
        System.out.println(mensagem);
        return sc.nextLine();
    }

    public int lerOpcaoLanche() {
        return lerInteiro("Escolha o lanche: ");
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("\n--- COMANDA " + pedido.getNumIdent() + "---");
        System.out.println("Cliente: " + pedido.getNomeCliente());
        System.out.println("Itens: ");

        for (ItemCardapio lanche : pedido.getItens()) {
            System.out.println("- " + lanche.getDescricao()
                    + " (R$ " + lanche.getPreco() + ")");
        }
        System.out.println("Total: R$ " + pedido.calcularTotal());
    }

    public void exibirFechamentoDoDia(double total) {
        System.out.println("--- FECHANDO O CAIXA ---");
        System.out.println("Total arrecadado no dia: R$ " + total);
    }

    public int lerInteiro(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite apenas números: ");
                sc.nextLine();
            }
        }
    }
}
