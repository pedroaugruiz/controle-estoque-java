package model;

import java.util.ArrayList;

// Classe responsável por armazenar todos os produtos
public class Estoque {

    // Lista que armazenará os produtos cadastrados
    private ArrayList<Produto> produtos;

    // Construtor da classe Estoque
    public Estoque() {

        // Inicializa a lista vazia
        produtos = new ArrayList<>();

    }

    // Adiciona um produto à lista
    public void adicionarProduto(Produto produto) {

        produtos.add(produto);

    }
    // Exibe todos os produtos cadastrados no estoque
    public void listarProdutos() {

        // Percorre todos os produtos da lista
        for (Produto produto : produtos) {

            System.out.println("------------------");

            System.out.println("ID: " + produto.getId());

            System.out.println("Nome: " + produto.getNome());

            System.out.println("Quantidade: " + produto.getQuantidade());

            System.out.printf("Preço: R$ %.2f%n", produto.getPreco());

            System.out.println("Estoque mínimo: " + produto.getEstoqueMinimo());

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

}