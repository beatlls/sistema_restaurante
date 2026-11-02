package org.example.app;

import org.example.cardapio.ItemCardapio;
import org.example.cardapio.Lanche;
import org.example.pedido.Pedido;
import java.util.HashSet;

public class GerenciadorFluxo {
    private MenuConsole console;
    private RestauranteFacade sistema;

    public GerenciadorFluxo(MenuConsole console, RestauranteFacade sistema) {
        this.console = console;
        this.sistema = sistema;
    }

    public void realizarNovoPedido() {
        String nomeCliente = console.lerTexto("Digite o nome do cliente: ");
        Pedido novoPedido = sistema.criarPedido(nomeCliente);
        int opcaoLanche = -1;

        while (opcaoLanche != 0) {
            System.out.println("\n--- CARDÁPIO DE LANCHES ---");
            System.out.println("1 - X-Burger | 2 - X-Salada | 3 - X-Bacon | 0 - Concluir pedido");
            opcaoLanche = console.lerInteiro("Escolha o lanche: ");

            if (opcaoLanche != 0) {
                ItemCardapio itemEscolhido = montarItem(opcaoLanche);
                if (itemEscolhido != null) {
                    novoPedido.adicionarItem(itemEscolhido);
                    System.out.println(itemEscolhido.getDescricao() + " adicionado ao carrinho!");
                } else {
                    System.out.println("Lanche não encontrado.");
                }
            }
        }
        System.out.println("Pedido finalizado com sucesso!");
        console.exibirPedido(novoPedido);
    }

    public void listarPedidos() {
        if (sistema.getPedidos().isEmpty()) {
            System.out.println("Nenhum pedido registrado ainda.");
        } else {
            for (Pedido pedidoAtual : sistema.getPedidos().values()) {
                console.exibirPedido(pedidoAtual);
            }
        }
    }

    public void modificarPedido() {
        int idBusca = console.lerInteiro("\nDigite o número do pedido que deseja modificar: ");
        Pedido modificarPedido = sistema.getPedidos().get(idBusca);

        if (modificarPedido != null) {
            int opcaoModificar = -1;
            while (opcaoModificar != 0) {
                System.out.println("\n--- MODIFICAR PEDIDO #" + idBusca + " ---");
                System.out.println("1 - Acrescentar item | 2 - Remover item | 3 - Cancelar pedido | 0 - Voltar");
                opcaoModificar = console.lerInteiro("Escolha uma opção: ");

                switch (opcaoModificar) {
                    case 1:
                        System.out.println("\n--- ADICIONAR NOVO ITEM ---");
                        int opcaoNovoLanche = console.lerInteiro("Escolha o lanche (1-X-Burger | 2-X-Salada | 3-X-Bacon): ");
                        ItemCardapio novoItem = montarItem(opcaoNovoLanche);
                        if (novoItem != null) {
                            modificarPedido.adicionarItem(novoItem);
                            System.out.println(novoItem.getDescricao() + " adicionado ao pedido!");
                        }
                        break;
                    case 2:
                        removerItemDoPedido(modificarPedido);
                        break;
                    case 3:
                        sistema.getPedidos().remove(idBusca);
                        System.out.println("Pedido cancelado com sucesso!");
                        opcaoModificar = 0;
                        break;
                    case 0:
                        System.out.println("Voltando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    public void fecharDia() {
        double total = sistema.calcularTotalDoDia();
        console.exibirFechamentoDoDia(total);
        HashSet<String> combinacoesUnicas = new HashSet<>();

        for (Pedido pedidoAtual : sistema.getPedidos().values()) {
            for (ItemCardapio item : pedidoAtual.getItens()) {
                combinacoesUnicas.add(item.getDescricao());
            }
        }

        System.out.println("\n--- ESTATÍSTICAS DE PRODUTO ---");
        System.out.println("Combinações diferentes vendidas hoje: " + combinacoesUnicas.size());
        for (String combinacao : combinacoesUnicas) {
            System.out.println("- " + combinacao);
        }
    }

    private void removerItemDoPedido(Pedido modificarPedido) {
        var itensDoPedido = modificarPedido.getItens();
        if (itensDoPedido.isEmpty()) {
            System.out.println("Este pedido não tem mais itens.");
            return;
        }

        System.out.println("\n--- ITENS DO PEDIDO ---");
        for (int i = 0; i < itensDoPedido.size(); i++) {
            System.out.println((i + 1) + " - " + itensDoPedido.get(i).getDescricao());
        }

        int numeroItem = console.lerInteiro("Digite o número do item para remover (ou 0 para cancelar): ");
        if (numeroItem > 0 && numeroItem <= itensDoPedido.size()) {
            ItemCardapio itemRemovido = itensDoPedido.remove(numeroItem - 1);
            System.out.println(itemRemovido.getDescricao() + " removido do pedido!");
        } else if (numeroItem != 0) {
            System.out.println("Número de item inválido.");
        }
    }

    private ItemCardapio montarItem(int opcaoLanche) {
        Lanche lancheBase = sistema.pedirLanche(opcaoLanche);
        if (lancheBase == null) return null;

        System.out.println("\n--- PERSONALIZAÇÃO ---");
        if (console.lerInteiro("Retirar Queijo? (1 - Sim | 2 - Não): ") == 1) lancheBase.setQueijo(false);
        if (console.lerInteiro("Retirar Alface? (1 - Sim | 2 - Não): ") == 1) lancheBase.setAlface(false);
        if (console.lerInteiro("Retirar Tomate? (1 - Sim | 2 - Não): ") == 1) lancheBase.setTomate(false);
        if (console.lerInteiro("Retirar Cebola? (1 - Sim | 2 - Não): ") == 1) lancheBase.setCebola(false);

        ItemCardapio itemEscolhido = lancheBase;
        int opcaoExtra = -1;

        while (opcaoExtra != 0) {
            System.out.println("\nAdicional? 1 - Cheddar | 2 - Bacon Extra | 0 - Terminar montagem");
            opcaoExtra = console.lerInteiro("Escolha: ");
            if (opcaoExtra != 0) {
                itemEscolhido = sistema.adicionarExtra(itemEscolhido, opcaoExtra);
                System.out.println("Adicional inserido! Atual: " + itemEscolhido.getDescricao());
            }
        }
        return itemEscolhido;
    }
}
