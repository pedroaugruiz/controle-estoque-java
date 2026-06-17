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

    // Quantidade mínima aceitável antes do estoque ser considerado crítico
    private int estoqueMinimo;

    // Quantidade para aviso de estoque baixo
    private int estoqueAlerta;

    // Construtor responsável por criar um produto
    public Produto(
            int id,
            String nome,
            int quantidade,
            double preco,
            int estoqueMinimo,
            int estoqueAlerta
    ) {

        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueAlerta = estoqueAlerta;

    }

    // Retorna o id do produto
    public int getId() {
        return id;
    }

    // Retorna o nome do produto
    public String getNome() {
        return nome;
    }

    // Retorna a quantidade do produto
    public int getQuantidade() {
        return quantidade;
    }

    // Retorna o preço do produto
    public double getPreco() {
        return preco;
    }

    // Retorna o estoque mínimo do produto
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    // Retorna o estoque de alerta
    public int getEstoqueAlerta() {
        return estoqueAlerta;
    }

    // Verifica se o estoque está crítico
    public boolean estaComEstoqueCritico() {

        return quantidade <= estoqueMinimo;

    }

    // Verifica se o estoque está baixo
    public boolean estaComEstoqueBaixo() {

        return quantidade > estoqueMinimo
                && quantidade <= estoqueAlerta;

    }

    // Altera o id do produto
    public void setId(int id) {
        this.id = id;
    }

    // Altera o nome do produto
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Altera a quantidade do produto
    public void setQuantidade(int quantidade) {

        // Não permite quantidade negativa
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        }

    }

    // Altera o preço do produto
    public void setPreco(double preco) {

        // Não permite preço negativo
        if (preco >= 0) {
            this.preco = preco;
        }

    }

    // Altera o estoque mínimo do produto
    public void setEstoqueMinimo(int estoqueMinimo) {

        // Não permite estoque mínimo negativo
        if (estoqueMinimo >= 0) {
            this.estoqueMinimo = estoqueMinimo;
        }

    }

    // Adiciona uma quantidade ao estoque do produto
    public void adicionarEstoque(int quantidadeAdicionada) {

        // Verifica se a quantidade adicionada é maior que zero
        if (quantidadeAdicionada > 0) {

            // Soma a quantidade atual com a nova quantidade
            this.quantidade += quantidadeAdicionada;

        }

    }

    // Remove uma quantidade do estoque do produto
    public void removerEstoque(int quantidadeRemovida) {

        // Verifica se a quantidade removida é maior que zero
        // e se existe estoque suficiente para remover
        if (quantidadeRemovida > 0 && quantidadeRemovida <= this.quantidade) {

            // Subtrai a quantidade removida da quantidade atual
            this.quantidade -= quantidadeRemovida;

        }

    }

}