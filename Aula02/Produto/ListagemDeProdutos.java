package Produto;

import java.util.ArrayList;
import  java.util.Scanner;

public class ListagemDeProdutos extends Produto {
    ArrayList<Produto> listaProdutos = new ArrayList<>();
    public void imprimirComEstoque() {
        // Utilizar filter
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getEstoqueProduto() > 0) {
                System.out.println("O produtos que possuem estoque são: " + listaProdutos.get(i).getNomeProduto());

            }
        }
    }

    public static String imprimirMenuDeListagens() {
        Scanner read = new Scanner(System.in);
        int choice = 1;

        System.out.println(
                "\n Escolha uma opção de impressão: " +
                        "\n 1 - Ordem crescente de código. " +
                        "\n 2 - Ordem alfabética. " +
                        "\n 3 - Ordem de quantidade de estoque maior. " +
                        "\n 4 - Ordem de quantidade de estoque menor. " +
                        "\n 5 - Somente produtos ativos. " +
                        "\n 6 - Somente produtos inativos. " +
                        "\n 7 - Somente produtos com estoque. " +
                        "\n 8 - Somente produtos sem estoque. " +
                        "\n 9 - Pesquisar por nome." +
                        "\n 0 - Sair."
        );
        choice = read.nextInt();

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 0:
                System.out.println("Retornando ao menu anterior.");
                break;
        }


        return null;
    }
}
