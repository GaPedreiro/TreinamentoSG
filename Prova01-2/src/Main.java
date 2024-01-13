import Livro.CadastroDeLivro;
import Livro.ImprimirLivro;
import Livro.ImprimirMenu;
import Livro.ListagemDeLivro;

import java.util.Date;
import java.util.Scanner;
import static Livro.ListagemDeLivro.listaLivros;
import static Livro.ListagemDeLivro.listaProvisoria;
import static Livro.AluguelDeLivro.listaLivrosAlugados;
public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int escolhaMenu = 0;
        int contador = 0;

        while (escolhaMenu != 7) {
            ImprimirMenu.imprimeMenu();
            escolhaMenu = read.nextInt();

            switch (escolhaMenu) {
                case 1:
                    System.out.println("- Digite o nome do livro a ser cadastrado: ");
                    String nomeLivro = read.next();
                    System.out.println("- Informe a quantidade total de cópias de " + nomeLivro + ": ");
                    int quantidadeCopias = read.nextInt();
                    int quantidadeDisponivel = quantidadeCopias;
                    contador++;
                    Date data = new Date();
                    listaLivros.add(new CadastroDeLivro(contador, nomeLivro, data, quantidadeCopias, quantidadeDisponivel));
                    listaProvisoria = listaLivros;
                    break;
                case 2:
                    int escolhaSubMenu = 0;
                    while (escolhaSubMenu != 5) {
                        System.out.println("-------------------------" +
                                "\n - Opções de visualização: " +
                                "\n 1 - Todos os livros cadastrados." +
                                "\n 2 - Por ordem alfabética." +
                                "\n 3 - Pesquisar pelo nome." +
                                "\n 4 - Livros alugados." +
                                "\n 5 - Retornar ao menu anterior." +
                                "\nInforme a opção desejada: ");
                        escolhaSubMenu = read.nextInt();
                        switch (escolhaSubMenu) {
                            case 1:
                                if (listaLivros.size() <= 0) {
                                    System.out.println("Sinto muito, mas ainda não há nada visualizar aqui. Cadastre algum livro primeiro.");
                                } else {
                                    for (int i = 0; i < listaLivros.size(); i++) {
                                        ImprimirLivro.imprimirLivro(listaLivros.get(i));
                                    }
                                    break;
                                }
                            case 2:
                                if (listaLivros.size() <= 0) {
                                    System.out.println("Sinto muito, mas ainda não há nada visualizar aqui. Cadastre algum livro primeiro.");
                                } else {
                                    ListagemDeLivro.ordenarPorNome();
                                }
                                break;
                            case 3:
                                if (listaLivros.size() <= 0) {
                                    System.out.println("Sinto muito, mas ainda não há nada visualizar aqui. Cadastre algum livro primeiro.");
                                } else {
                                    System.out.println("- Digite o nome do livro ou parte dele: ");
                                    String pesquisaNome = read.next();
                                    ListagemDeLivro.pesquisaPorNome(pesquisaNome);
                                }
                                break;
                            case 4:
                                if (listaLivrosAlugados.size() <= 0) {
                                    System.out.println("Sinto muito, mas ainda não há nada visualizar aqui. Alugue algum livro primeiro.");
                                } else {
                                    for (int i = 0; i < listaLivrosAlugados.size(); i++) {
                                        ImprimirLivro.imprimirLivro(listaLivrosAlugados.get(i));
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("Retornando ao menu anterior.");
                                break;
                        }
                    }

                    break;
                case 3:
                    System.out.println("- Informe o ID do livro que deseja aluguar: ");
                    int idAlugarLivro = read.nextInt();
                    for (int i = 0; i < listaLivros.size(); i++) {
                        if (listaLivros.get(i).getIdLivro() == idAlugarLivro) {
                            if (listaLivros.get(i).getStatusLivro() == true) {
                                int qtdDisponivel = listaLivros.get(i).getQuantidadeDisponivel();
                                qtdDisponivel -= 1;
                                int qtdAlugada = listaLivros.get(i).getQuantidadeAlugada();
                                qtdAlugada += 1;
                                listaLivros.get(i).setQuantidadeDisponivel(qtdDisponivel);
                                listaLivros.get(i).setQuantidadeAlugada(qtdAlugada);

                                int idProvisorio = listaLivros.get(i).getIdLivro();
                                String nomeProvisorio = listaLivros.get(i).getNomeLivro();
                                Date dataProvisoria = listaProvisoria.get(i).getData();
                                int qtdProvisoria = listaLivros.get(i).getQuantidadeLivro();
                                int qtdDisponivelProvisoria = listaLivros.get(i).getQuantidadeDisponivel();

                                listaLivrosAlugados.add(new CadastroDeLivro(idProvisorio, nomeProvisorio, dataProvisoria, qtdProvisoria,qtdDisponivelProvisoria));

                            } else {
                                System.out.println("- Sinto muito, o livro " +
                                        listaLivros.get(i).getNomeLivro() +
                                        " não está disponível no momento.");
                            }
                        } else {
                            System.out.println("Sinto muito, o ID informado não corresponde a nenhum dos livros em nosso acervo.");
                        }

                    }
                    break;
                case 4: // Devolver
                    System.out.println("- Informe o ID do livro que deseja devolver: ");
                    int idDevolverLivro = read.nextInt();
                    for (int i = 0; i < listaLivrosAlugados.size(); i++) {
                        if (listaLivrosAlugados.get(i).getIdLivro() == idDevolverLivro) {
                            int qtdDisponivel = listaLivros.get(i).getQuantidadeDisponivel();
                            qtdDisponivel += 1;
                            int qtdAlugada = listaLivros.get(i).getQuantidadeAlugada();
                            qtdAlugada -= 1;
                            listaLivros.get(i).setQuantidadeDisponivel(qtdDisponivel);
                            listaLivros.get(i).setQuantidadeAlugada(qtdAlugada);

                            listaLivrosAlugados.remove(i);
                            System.out.println("- O livro " + listaLivros.get(i).getNomeLivro() + " foi devolvido com sucesso!");
                        }
                    }

                    break;
                case 5:
                    System.out.println("- Informe o ID do livro que deseja excluir: ");
                    int idExcluirLivro = read.nextInt();
                    for (int i = 0; i < listaLivrosAlugados.size(); i++) {
                        if (listaLivrosAlugados.get(i).getIdLivro() == idExcluirLivro) {
                            System.out.println("O livro " + listaLivrosAlugados.get(i).getNomeLivro() + " não pode ser excluído, existe um exemplar alugado.");
                        } else {
                            listaLivrosAlugados.remove(i);
                            System.out.println("- O livro " + listaLivros.get(i).getNomeLivro() + " foi excluído com sucesso!");
                        }
                    }
                    break;
                case 6: // Alterar Status
                    break;
                case 7:
                    System.out.println("Fim da execução do programa.. :)");
                    break;

            }
        }
    }
}