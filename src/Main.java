import model.Produto;

// Classe principal do sistema
public class Main {

    // Método principal executado quando o programa inicia
    public static void main(String[] args) {

        // Cria um produto
        Produto arroz = new Produto(
                1,
                "Arroz",
                50,
                29.90
        );

        System.out.println("Produto criado com sucesso!");

    }
}