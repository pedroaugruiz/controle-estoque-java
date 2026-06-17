import model.Produto;
import model.Estoque;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Cria o estoque
        Estoque estoque = new Estoque();

        // Cria alguns produtos
        Produto arroz = new Produto(1, "Arroz", 50, 29.90, 10, 20);

        Produto feijao = new Produto(2, "Feijão", 12, 8.50, 10, 15);

        Produto macarrao = new Produto(3, "Macarrão", 8, 6.90, 10, 12);

        // Adiciona os produtos ao estoque
        estoque.adicionarProduto(arroz);

        estoque.adicionarProduto(feijao);

        estoque.adicionarProduto(macarrao);

        // Exibe todos os produtos cadastrados
        estoque.listarProdutos();

        // Remove o produto de ID 2
        boolean removido = estoque.removerProdutoPorId(2);

        // Verifica o resultado da remoção
        if (removido) {

            System.out.println("Produto removido com sucesso.");

        } else {

            System.out.println("Produto não encontrado.");

        }

        // Lista novamente os produtos
        estoque.listarProdutos();

        ArrayList<Produto> resultados =
                estoque.buscarProdutosPorNome("arroz");

        for (Produto produto : resultados) {

            System.out.println(produto.getNome());

        }

    }



}