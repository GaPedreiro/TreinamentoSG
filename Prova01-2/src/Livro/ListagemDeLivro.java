package Livro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class ListagemDeLivro extends CadastroDeLivro{
    public static ArrayList<CadastroDeLivro> listaLivros = new ArrayList<>();
    public static ArrayList<CadastroDeLivro> listaLivrosAlugados = new ArrayList<>();
    public static ArrayList<CadastroDeLivro> listaProvisoria = new ArrayList<>();

    public static void ordenarPorNome() {
        Collections.sort(listaProvisoria, Comparator.comparing(CadastroDeLivro::getNomeLivro));
        imprimirListaLivros();
    }

    public static void pesquisaPorNome(String nome) {
        imprimirListaFiltrada(cadastroDeLivro -> cadastroDeLivro.getNomeLivro().contains(nome));
        imprimirListaFiltrada(cadastroDeLivro -> cadastroDeLivro.getNomeLivro().contains(nome));
    }

    private static void imprimirListaLivros() {
        listaProvisoria.forEach(ImprimirLivro::imprimirLivro);
    }

    private static void imprimirListaFiltrada(Predicate<CadastroDeLivro> condition) {
        listaLivros.stream()
                .filter(book -> condition.test(book))
                .forEach(ImprimirLivro::imprimirLivro);
    }
}
