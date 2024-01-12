import Produto.Produto;
import Produto.ListagemDeProdutos;
import Produto.ImprimirProduto;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static Produto.ListagemDeProdutos.listaProdutos;
import static Produto.ListagemDeProdutos.listaProvisoria;

public class CadastroProduto {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int escolha = 0;
        int contador = 0;

        while (escolha != 6) {
            System.out.println("---------------------------");
            System.out.println("01 - Visualizar produtos.");
            System.out.println("02 - Cadastrar produto.");
            System.out.println("03 - Ativar / Inativar produto.");
            System.out.println("04 - Estoque.");
            System.out.println("05 - Listagem de produtos.");
            System.out.println("06 - Sair.");
            System.out.println(("-> Selecione uma opção: "));
            escolha = read.nextInt();

            switch (escolha) {
                case 1:
                    for (int i = 0; i < listaProdutos.size(); i++) {
                        ImprimirProduto.imprimirProduto(listaProdutos.get(i));
                    }
                    break;

                case 2:
                    System.out.println("- Digite o nome do produto a ser cadastrado: ");
                    String nome = read.next();
                    System.out.println("- Digite a quantidade em estoque do produto " + nome + ":");
                    int estoque = read.nextInt();
                    contador ++;
                    listaProdutos.add(new Produto(nome, estoque, contador));
                    listaProvisoria.add(new Produto(nome, estoque, contador));
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
                    int escolhaSubmenu = read.nextInt();

                    switch (escolhaSubmenu) {
                        case 1:
                            ListagemDeProdutos.ordenarPorCodigo();
                            break;
                        case 2:
                            ListagemDeProdutos.ordenarPorNome();
                            break;
                        case 3:
                            ListagemDeProdutos.ordenarPorEstoqueMaior();
                            break;
                        case 4:
                            ListagemDeProdutos.ordenarPorEstoqueMenor();
                            break;
                        case 5:
                            ListagemDeProdutos.mostrarAtivos();
                            break;
                        case 6:
                            ListagemDeProdutos.mostrarInativos();
                            break;
                        case 7:
                            ListagemDeProdutos.mostrarProdutosComEstoque();
                            break;
                        case 8:
                            ListagemDeProdutos.mostrarProdutosSemEstoque();
                            break;
                        case 9:
                            System.out.println("- Digite o nome do produto que deseja pesquisar: ");
                            String nomePesquisa = read.next();
                            ListagemDeProdutos.pesquisarPorNome(nomePesquisa);
                            break;
                        case 0:
                            System.out.println("Retornando ao menu anterior.");
                            break;
                    }
                    break;

                case 6:
                    System.out.println("Fim do programa :)");
                    break;
            }
        }

    }
}