package Produto;

public class ImprimirProduto {
    public static void imprimirProduto(Produto produto) {
        System.out.println("---------------------------" +
                "\n ID: " + produto.getIdProduto() +
                "\n Nome: " + produto.getNomeProduto() +
                "\n Estoque: " + produto.getEstoqueProduto() +
                "\n Status: " + produto.getStatusProduto());
    }
}
