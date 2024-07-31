package gerenciaestoque;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GerenciaEstoque {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            boolean valido = false;
            int codigo = 0;
            while (!valido) {
                try {
                    System.out.println("Cadastro do Produto");
                    System.out.print("Informe o código do produto: ");
                    codigo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    valido = true;
                } catch (InputMismatchException e) {
                    System.out.println("ERRO: O campo código deve ser preenchido por números. Digite o código corretamente.");
                    scanner.nextLine(); // Limpar o buffer
                }
            }

            System.out.print("Informe a descrição do produto: ");
            String descricao = scanner.nextLine();

            Produto produto = new Produto(codigo, descricao);
            produtos.add(produto);

            System.out.print("Deseja adicionar outro produto? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Exibir Estoque");
            System.out.println("2. Entrada de Produtos");
            System.out.println("3. Saída de Produtos");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    for (Produto p : produtos) {
                        p.exibirEstoque();
                    }
                    break;
                case 2:
                    System.out.print("Informe o código do produto para entrada de unidades: ");
                    int codigoEntrada = scanner.nextInt();
                    Produto produtoEntrada = encontrarProdutoPorCodigo(produtos, codigoEntrada);
                    if (produtoEntrada != null) {
                        System.out.print("Informe a quantidade de unidades a serem adicionadas ao estoque: ");
                        int quantidadeEntrada = scanner.nextInt();
                        produtoEntrada.entradaProduto(quantidadeEntrada);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Informe o código do produto para saída de unidades: ");
                    int codigoSaida = scanner.nextInt();
                    Produto produtoSaida = encontrarProdutoPorCodigo(produtos, codigoSaida);
                    if (produtoSaida != null) {
                        System.out.print("Informe a quantidade de unidades a serem retiradas do estoque: ");
                        int quantidadeSaida = scanner.nextInt();
                        produtoSaida.saidaProduto(quantidadeSaida);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    public static Produto encontrarProdutoPorCodigo(ArrayList<Produto> produtos, int codigo) {
        for (Produto p : produtos) {
            if (p.getCodProduto() == codigo) {
                return p;
            }
        }
        return null;
    }
}
