package model;

// Classe responsável por representar um produto do estoque
public class Produto {

    // Identificador único do produto
    private int id;

    // Nome do produto
    private String nome;

    // Quantidade disponível em estoque
    private int quantidade;

    // Preço unitário do produto
    private double preco;

    // Construtor responsável por criar um produto
    public Produto(int id, String nome, int quantidade, double preco) {

        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;

    }

}