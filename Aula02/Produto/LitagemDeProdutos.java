package Produto;

public class LitagemDeProdutos extends Produto {

    public LitagemDeProdutos(String nomeProduto, int estoqueProduto, int idProduto) {
        super(nomeProduto, estoqueProduto, idProduto);
    }

    public static void imprimirMenuDeListagens() {
        System.out.println("\n Escolha uma opção de impressão: " +
                "\n 1 - Ordem crescente de código. " +
                "\n 2 - Ordem alfabética. " +
                "\n 3 - Ordem de quantidade de estoque maior. " +
                "\n 4 - Ordem de quantidade de estoque menor. " +
                "\n 5 - Somente produtos ativos. " +
                "\n 6 - Somente produtos inativos. " +
                "\n 7 - Somente produtos com estoque. " +
                "\n 8 - Somente produtos sem estoque. " +
                "\n 9 - Pesquisar por nome.");
    }


}
