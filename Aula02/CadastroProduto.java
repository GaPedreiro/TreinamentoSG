import Produto.Produto;

import java.util.ArrayList;
import java.util.Scanner;
public class CadastroProduto {
    /*
    - Visualizar produtos;
    - Cadastrar produtos;
    - Ativa/Desativar produtos;
    - Adicionar estoque;
    - Retirar estoque;
    - Tudo deve funcionar dentro de um menu, sem encerrar o programa.
     */

    public static void main(String[] args) {
        // CRIAR LISTA DO TIPO PRODUTO
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        Scanner read = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("---------------------------");
            System.out.println("01 - Visualizar produtos.");
            System.out.println("02 - Cadastrar produto.");
            System.out.println("03 - Ativar / Inativar produto.");
            System.out.println("04 - Estoque.");
            System.out.println("05 - Sair.");
            System.out.println(("-> Selecione uma opção: "));
            choice = read.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < listaDeProdutos.size(); i++) {
                        System.out.println("---------------------------");
                        System.out.println("Nome: " + listaDeProdutos.get(i).getNomeProduto());
                        System.out.println("Status: " + listaDeProdutos.get(i).getStatusProduto());
                        System.out.println("Estoque: " + listaDeProdutos.get(i).getEstoqueAtualProduto());
                    }
                    break;

                case 2:
                    System.out.println("Informe o nome do produto: ");
                    String nome = read.next();
                    System.out.println("Informe o estoque: ");
                    int estoque = read.nextInt();
                    listaDeProdutos.add(new Produto(nome, estoque));
                    //System.out.print(String.format("\033[H\033[2J"));
                    break;

                case 3:
                    System.out.println("De qual produto você deseja alterar o status? ");
                    String nomeAlteraStatus = read.next();
                    for (int i = 0; i < listaDeProdutos.size(); i++) {
                        if (listaDeProdutos.get(i).getNomeProduto().equals(nomeAlteraStatus)) {
                            System.out.println("Insira o novo status do produto " + nomeAlteraStatus + ": ATIVO | INATIVO.");
                            String status = read.next();
                            if (status.equals("ativo")){
                                listaDeProdutos.get(i).setStatusProduto(true);
                            } else {
                                listaDeProdutos.get(i).setStatusProduto(false);
                            }
                        }
                    }
                    break;
                case 4:

                    break;
                case 5:
                    break;
            }

        }

        System.out.println("Fim do programa.");

    }
}
