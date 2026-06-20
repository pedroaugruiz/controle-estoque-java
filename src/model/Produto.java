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

    // Construtor responsável por criar um produto
    public Produto(
            String nome,
            int quantidade,
            double preco,
            int estoqueMinimo
    ) {

        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.estoqueMinimo = estoqueMinimo;

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

    // Verifica se o estoque está crítico
    public boolean estaComEstoqueCritico() {

        return quantidade <= estoqueMinimo;

    }

    // Verifica se o estoque está baixo
    public boolean estaComEstoqueBaixo() {

        // Calcula automaticamente o limite de alerta
        int limiteAlerta = Math.max(
                estoqueMinimo + 5,
                (int) (estoqueMinimo * 1.5)
        );

        return quantidade > estoqueMinimo
                && quantidade <= limiteAlerta;
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
    public boolean removerEstoque(int quantidadeRemovida) {

        // Verifica se a quantidade removida é maior que zero
        // e se existe estoque suficiente para remover
        if (quantidadeRemovida > 0 && quantidadeRemovida <= this.quantidade) {

            // Subtrai a quantidade removida da quantidade atual
            this.quantidade -= quantidadeRemovida;

            // Retorna verdadeiro porque conseguiu remover
            return true;

        }

        // Retorna falso porque não conseguiu remover
        return false;
    }

    // Define como o produto será exibido no console
    @Override
    public String toString() {

        return """
            ------------------
            ID: %d
            Nome: %s
            Quantidade: %d
            Preço: R$ %.2f
            Estoque mínimo: %d
            """.formatted(
                id,
                nome,
                quantidade,
                preco,
                estoqueMinimo
        );

    }

}