import Produto.Produto;
import Produto.ListagemDeProdutos;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class CadastroProduto {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        int choice = 0;
        int contador = 0;

        while (choice != 6) {
            System.out.println("---------------------------");
            System.out.println("01 - Visualizar produtos.");
            System.out.println("02 - Cadastrar produto.");
            System.out.println("03 - Ativar / Inativar produto.");
            System.out.println("04 - Estoque.");
            System.out.println("05 - Listagem de produtos.");
            System.out.println("06 - Sair.");
            System.out.println(("-> Selecione uma opção: "));
            choice = read.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < listaProdutos.size(); i++) {
                        System.out.println("---------------------------");
                        System.out.println("ID: " + listaProdutos.get(i).getIdProduto());
                        System.out.println("Nome: " + listaProdutos.get(i).getNomeProduto());
                        System.out.println("Estoque: " + listaProdutos.get(i).getEstoqueProduto());
                        System.out.println("Status: " + listaProdutos.get(i).getStatusProduto());
                    }
                    break;

                case 2:
                    System.out.println("- Digite o nome do produto a ser cadastrado: ");
                    String nome = read.next();
                    System.out.println("- Digite a quantidade em estoque do produto " + nome + ":");
                    int estoque = read.nextInt();
                    contador ++;
                    listaProdutos.add(new Produto(nome, estoque, contador));
                    break;

                case 3:
                    System.out.println("- Informe o ID do produto: ");
                    int idStatus = read.nextInt();
                    for (int i = 0; i < listaProdutos.size(); i++) {
                        if (listaProdutos.get(i).getIdProduto() == idStatus) {
                            System.out.println("- Informe o novo status: ATIVO | INATIVO");
                            //TESTAR ISSO AQUI
                            String novoStatusProduto = read.next().toLowerCase(Locale.ROOT);
                            if (novoStatusProduto.equals("ativo")) {
                                listaProdutos.get(i).setStatusProduto(true);
                                System.out.println("Status alterado com sucesso!");
                            } else if (novoStatusProduto.equals("inativo")) {
                                listaProdutos.get(i).setStatusProduto(false);
                                System.out.println("Status alterado com sucesso!");
                            } else {
                                System.out.println("O status informado é inválido!");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("- Informe o ID do produto: ");
                    int idEstoque = read.nextInt();
                    for (int i = 0; i < listaProdutos.size(); i++) {
                        if (listaProdutos.get(i).getIdProduto() == idEstoque) {
                            System.out.println("- Informe a operação: ADICIONAR | RETIRAR");
                            String operacao = read.next().toLowerCase();
                            if (operacao.equals("adicionar")) {
                                int novoEstoqueMaior = 0;
                                while (novoEstoqueMaior <= 0) {
                                    System.out.println("- Digite a quantidade a ser adicionada: ");
                                    novoEstoqueMaior = read.nextInt();
                                    if (novoEstoqueMaior > 0) {
                                        novoEstoqueMaior += listaProdutos.get(i).getEstoqueProduto();
                                        listaProdutos.get(i).setEstoqueProduto(novoEstoqueMaior);
                                        System.out.println("Estoque alterado com sucesso!");
                                    } else {
                                        System.out.println("O valor informado deve ser maior que 0!");
                                    }
                                }
                            } else if (operacao.equals("retirar")) {
                                int valorTransitorioEstoqueMenor = 0;
                                while (valorTransitorioEstoqueMenor <= 0) {
                                    System.out.println("- Digite a quantidade a ser retirada: ");
                                    valorTransitorioEstoqueMenor = read.nextInt();
                                    if (valorTransitorioEstoqueMenor > 0) {
                                        int novoEstoqueMenor = listaProdutos.get(i).getEstoqueProduto();
                                        novoEstoqueMenor -= valorTransitorioEstoqueMenor;
                                        listaProdutos.get(i).setEstoqueProduto(novoEstoqueMenor);
                                        System.out.println("Estoque alterado com sucesso!");
                                    } else {
                                        System.out.println("O valor informado deve ser maior que 0!");
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println(ListagemDeProdutos.imprimirMenuDeListagens());
                    break;

                case 6:
                    System.out.println("Fim do programa :)");
                    break;
            }
        }

    }
}