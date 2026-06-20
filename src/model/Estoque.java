package model;

import java.util.ArrayList;

// Classe responsável por armazenar todos os produtos
public class Estoque {

    private int proximoId = 1;

    // Lista que armazenará os produtos cadastrados
    private ArrayList<Produto> produtos;

    // Construtor da classe Estoque
    public Estoque() {

        // Inicializa a lista vazia
        produtos = new ArrayList<>();

    }

    // Adiciona um produto à lista
    public void adicionarProduto(Produto produto) {

        // Define automaticamente o ID do produto
        produto.setId(proximoId);

        // Aumenta o próximo ID para o próximo produto cadastrado
        proximoId++;

        // Adiciona o produto na lista
        produtos.add(produto);

    }
    // Exibe todos os produtos cadastrados no estoque
    public void listarProdutos() {

        // Percorre todos os produtos da lista
        for (Produto produto : produtos) {

            System.out.println(produto);

            if (produto.estaComEstoqueCritico()) {

                System.out.println("🔴 ESTOQUE CRÍTICO");

            } else if (produto.estaComEstoqueBaixo()) {

                System.out.println("🟡 ESTOQUE BAIXO");

            }

        }

    }

    // Procura um produto pelo ID
    public Produto buscarProdutoPorId(int id) {

        // Percorre todos os produtos da lista
        for (Produto produto : produtos) {

            // Verifica se o ID do produto é igual ao ID procurado
            if (produto.getId() == id) {

                // Retorna o produto encontrado
                return produto;

            }

            System.out.println(produto);
        }

        // Retorna null caso não encontre nenhum produto
        return null;


    }

    // Remove um produto pelo ID
    public boolean removerProdutoPorId(int id) {

        // Procura o produto na lista
        for (Produto produto : produtos) {

            // Verifica se encontrou o produto
            if (produto.getId() == id) {

                // Remove o produto da lista
                produtos.remove(produto);

                // Retorna sucesso
                return true;

            }

        }

        // Retorna falha
        return false;

    }

    // Procura produtos que contenham o texto informado
    public ArrayList<Produto> buscarProdutosPorNome(String nome) {

        // Lista de resultados
        ArrayList<Produto> resultados = new ArrayList<>();

        // Percorre todos os produtos
        for (Produto produto : produtos) {

            // Verifica se o nome contém o texto pesquisado
            if (produto.getNome()
                    .toLowerCase()
                    .contains(nome.toLowerCase())) {

                resultados.add(produto);

            }

        }

        return resultados;

    }

    // Exibe um resumo geral do estoque
    public void exibirResumoEstoque() {

        // Armazena a quantidade total de itens
        int quantidadeTotal = 0;

        int produtosCriticos = 0;

        int produtosAlerta = 0;

        // Armazena o valor total do estoque
        double valorTotal = 0;

        // Percorre todos os produtos
        for (Produto produto : produtos) {

            // Soma todas as quantidades
            quantidadeTotal += produto.getQuantidade();

            // Soma o valor total do estoque
            valorTotal += produto.getQuantidade() * produto.getPreco();

            if (produto.estaComEstoqueCritico()) {
                produtosCriticos++;
            }

            if (produto.estaComEstoqueBaixo()) {
                produtosAlerta++;
            }

        }

        System.out.println("==========================");

        System.out.println("      RESUMO GERAL");

        System.out.println("==========================");

        System.out.printf("Produtos cadastrados : %d%n", produtos.size());

        System.out.printf("Quantidade total     : %d%n", quantidadeTotal);

        System.out.printf("Valor total          : R$ %.2f%n", valorTotal);

        System.out.printf("Produtos críticos    : %d%n", produtosCriticos);

        System.out.printf("Produtos em alerta   : %d%n", produtosAlerta);

    }

}