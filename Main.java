import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Criando a lista de produtos
        List<Produto> listaProdutos = new ArrayList<>();

        // Adicionando alguns produtos à lista
        listaProdutos.add(new Produto("Sapato"));
        listaProdutos.add(new Produto("Camiseta"));
        listaProdutos.add(new Produto("Calça"));
        listaProdutos.add(new Produto("Boné"));

        // Criando o predicado para verificar se um produto está na lista
        Predicate<Produto> produtoPertenceLista = produto ->
                listaProdutos.stream().anyMatch(p -> p.getNome().equalsIgnoreCase(produto.getNome()));

        // Testando com alguns produtos
        Produto produto1 = new Produto("Camiseta");
        Produto produto2 = new Produto("Meia"); // Não está na lista

        // Verificando se os produtos pertencem à lista
        boolean resultado1 = produtoPertenceLista.test(produto1);
        boolean resultado2 = produtoPertenceLista.test(produto2);

        // Exibindo os resultados
        System.out.println(produto1.getNome() + " pertence à lista? " + resultado1);
        System.out.println(produto2.getNome() + " pertence à lista? " + resultado2);
    }
}

