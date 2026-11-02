package org.example.app;

public class Main {
    public static void main(String[] args) {
        MenuConsole console = new MenuConsole();
        RestauranteFacade sistema = new RestauranteFacade();
        GerenciadorFluxo fluxo = new GerenciadorFluxo(console, sistema);

        int opcao = -1;

        System.out.println("Bem-vindo ao Sistema do Restaurante!");

        while (opcao != 0) {
            console.exibirMenu();
            opcao = console.lerInteiro("Escolha uma opção do menu principal: ");

            switch (opcao) {
                case 1:
                    fluxo.realizarNovoPedido();
                    break;
                case 2:
                    fluxo.listarPedidos();
                    break;
                case 3:
                    fluxo.fecharDia();
                    break;
                case 4:
                    fluxo.modificarPedido();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}