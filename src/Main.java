import model.Estoque;
import model.Produto;

import java.util.ArrayList;
import java.util.Scanner;

// Classe principal do sistema
public class Main {

    // Método principal executado quando o programa inicia
    public static void main(String[] args) {

        // Cria o estoque do sistema
        Estoque estoque = new Estoque();

        // Scanner responsável por ler os dados digitados pelo usuário
        Scanner scanner = new Scanner(System.in);

        // Mantém o sistema rodando até o usuário escolher sair
        while (true) {

            System.out.println();
            System.out.println("========================");
            System.out.println("CONTROLE DE ESTOQUE");
            System.out.println("========================");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Listagem");
            System.out.println("3 - Buscar ID");
            System.out.println("4 - Buscar nome");
            System.out.println("5 - Resumo");
            System.out.println("6 - Entrada de estoque");
            System.out.println("7 - Saída de estoque");
            System.out.println("8 - Remover produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            // Lê a opção digitada pelo usuário
            int opcao = scanner.nextInt();

            // Verifica se o usuário escolheu sair
            if (opcao == 0) {
                System.out.println("Sistema encerrado.");
                break;
            }

            switch(opcao) {
                case 1: {
                    System.out.println("===================");
                    System.out.println("Cadastro de produto");
                    System.out.println("===================");

                    scanner.nextLine();

                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite a quantidade do produto: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();

                    System.out.print("Digite o estoque mínimo do produto: ");
                    int estoqueMinimo = scanner.nextInt();

                    Produto produto = new Produto(
                            nome,
                            quantidade,
                            preco,
                            estoqueMinimo
                    );

                    estoque.adicionarProduto(produto);

                    break;
                }

                case 2: {
                    estoque.listarProdutos();
                    break;
                }

                case 3: {
                    System.out.println("Digite o ID: ");

                    int buscarId = scanner.nextInt();

                    Produto produtoEncontrado = estoque.buscarProdutoPorId(buscarId);

                    if (produtoEncontrado != null) {

                        System.out.println(produtoEncontrado);

                    } else {
                        System.out.println("Não existe nenhum produto com esse ID!");
                    }

                    break;
                }

                case 4: {
                    scanner.nextLine();

                    System.out.print("Digite o nome do produto: ");
                    String nomePesquisa = scanner.nextLine();

                    ArrayList<Produto> nomeEncontrado = estoque.buscarProdutosPorNome(nomePesquisa);

                    if (nomeEncontrado.isEmpty()) {

                        System.out.println("Não existe nenhum produto com esse nome!");

                    } else {
                        for (Produto produto : nomeEncontrado) {
                            System.out.println(produto);
                        }
                    }

                    break;
                }

                case 5: {
                    estoque.exibirResumoEstoque();
                    break;
                }

                case 6: {
                    scanner.nextLine();

                    System.out.print("Digite o nome do produto: ");
                    String nomeEntrada = scanner.nextLine();

                    ArrayList<Produto> produtosEncontrados =
                            estoque.buscarProdutosPorNome(nomeEntrada);

                    if (produtosEncontrados.isEmpty()) {

                        System.out.println("Nenhum produto encontrado com esse nome.");

                    } else if (produtosEncontrados.size() > 1) {

                        System.out.println("Mais de um produto encontrado. Seja mais específico.");

                        for (Produto produtoEncontrado : produtosEncontrados) {
                            System.out.println(produtoEncontrado);
                        }

                    } else {

                        Produto produtoEncontrado = produtosEncontrados.get(0);

                        System.out.println("Produto encontrado:");
                        System.out.println(produtoEncontrado);

                        System.out.print("Digite a quantidade para adicionar: ");
                        int quantidadeEntrada = scanner.nextInt();

                        produtoEncontrado.adicionarEstoque(quantidadeEntrada);

                        System.out.println("Estoque atualizado com sucesso!");
                    }

                    break;
                }

                case 7: {
                    scanner.nextLine();

                    System.out.print("Digite o nome do produto: ");
                    String nomeEntrada = scanner.nextLine();

                    ArrayList<Produto> produtosEncontrados =
                            estoque.buscarProdutosPorNome(nomeEntrada);

                    if (produtosEncontrados.isEmpty()) {

                        System.out.println("Nenhum produto encontrado com esse nome.");

                    } else if (produtosEncontrados.size() > 1) {

                        System.out.println("Mais de um produto encontrado. Seja mais específico.");

                        for (Produto produtoEncontrado : produtosEncontrados) {
                            System.out.println(produtoEncontrado);
                        }

                    } else {

                        Produto produtoEncontrado = produtosEncontrados.get(0);

                        System.out.println("Produto encontrado:");
                        System.out.println(produtoEncontrado);

                        System.out.print("Digite a quantidade para retirar: ");
                        int quantidadeSaida = scanner.nextInt();

                        boolean removido = produtoEncontrado.removerEstoque(quantidadeSaida);

                        if (removido) {
                            System.out.println("Estoque atualizado com sucesso!");
                        } else {
                            System.out.println("Quantidade inválida ou estoque insuficiente!");
                        }
                    }

                    break;
                }

                case 8: {
                    scanner.nextLine();

                    System.out.print("Digite o nome do produto: ");
                    String nomeRemover = scanner.nextLine();

                    ArrayList<Produto> produtosEncontrados =
                            estoque.buscarProdutosPorNome(nomeRemover);

                    if (produtosEncontrados.isEmpty()) {

                        System.out.println("Nenhum produto encontrado.");

                    } else if (produtosEncontrados.size() == 1) {

                        Produto produtoEscolhido = produtosEncontrados.get(0);

                        System.out.println("Produto encontrado:");
                        System.out.println(produtoEscolhido);

                        System.out.print("Deseja remover este produto? (S/N): ");
                        String confirmacao = scanner.nextLine();

                        if (confirmacao.equalsIgnoreCase("S")) {

                            boolean removido =
                                    estoque.removerProdutoPorId(produtoEscolhido.getId());

                            if (removido) {
                                System.out.println("Produto removido com sucesso!");
                            }

                        } else {
                            System.out.println("Remoção cancelada.");
                        }

                    } else {

                        System.out.println("Mais de um produto encontrado:");

                        for (int i = 0; i < produtosEncontrados.size(); i++) {
                            System.out.println((i + 1) + " - " + produtosEncontrados.get(i).getNome());
                        }

                        System.out.print("Escolha o número do produto: ");
                        int escolha = scanner.nextInt();

                        scanner.nextLine();

                        Produto produtoEscolhido = produtosEncontrados.get(escolha - 1);

                        System.out.println("Produto escolhido:");
                        System.out.println(produtoEscolhido);

                        System.out.print("Deseja remover este produto? (S/N): ");
                        String confirmacao = scanner.nextLine();

                        if (confirmacao.equalsIgnoreCase("S")) {

                            boolean removido =
                                    estoque.removerProdutoPorId(produtoEscolhido.getId());

                            if (removido) {
                                System.out.println("Produto removido com sucesso!");
                            }

                        } else {
                            System.out.println("Remoção cancelada.");
                        }
                    }

                    break;
                }

                default:
                    System.out.println("Opção inválida");

            }

        }

        // Fecha o scanner
        scanner.close();
    }
}