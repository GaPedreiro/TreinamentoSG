package Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/*
- Adicionar data ao cadastro do produto e também valor.
- Ordenar por data de cadastro crescente e decrescente.

 */
public class ListagemDeProdutos extends Produto {
    public static ArrayList<Produto> listaProdutos = new ArrayList<>();
    public static ArrayList<Produto> listaProvisoria = new ArrayList<>();

    public static void ordenarPorCodigo() {
        Collections.sort(listaProvisoria, Comparator.comparingInt(Produto::getIdProduto));
        imprimirListaProdutos();
    }

    public static void ordenarPorNome() {
        Collections.sort(listaProvisoria, Comparator.comparing(Produto::getNomeProduto));
        imprimirListaProdutos();
    }

    public static void ordenarPorEstoqueMaior() {
        Collections.sort(listaProvisoria, Comparator.comparingInt(Produto::getEstoqueProduto));
        imprimirListaProdutos();
    }

    public static void ordenarPorEstoqueMenor() {
        Collections.sort(listaProvisoria, Comparator.comparingInt(Produto::getEstoqueProduto).reversed());
        imprimirListaProdutos();
    }

    public static void mostrarAtivos() {
        imprimirListaFiltrada(produto -> produto.getStatusProduto());
    }

    public static void mostrarInativos() {
        imprimirListaFiltrada(produto -> !produto.getStatusProduto());
    }

    public static void mostrarProdutosComEstoque() {
        imprimirListaFiltrada(produto -> produto.getEstoqueProduto() > 0);
    }

    public static void mostrarProdutosSemEstoque() {
        imprimirListaFiltrada(produto -> produto.getEstoqueProduto() <= 0);
    }

    public static void pesquisarPorNome(String nome) {
        imprimirListaFiltrada(produto -> produto.getNomeProduto().contains(nome));
    }
    private static void imprimirListaProdutos() {
        listaProvisoria.forEach(ImprimirProduto::imprimirProduto);
    }

    private static void imprimirListaFiltrada(Predicate<Produto> condition) {
        listaProdutos.stream()
                .filter(product -> condition.test(product))
                .forEach(ImprimirProduto::imprimirProduto);
    }

    public static String imprimirMenuDeListagens() {

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
        return null;
    }
}
