package Livro;

public class ImprimirLivro {
    public static void imprimirLivro(CadastroDeLivro cadastroDeLivro) {
        System.out.println("-------------------------" +
                "\nID: " + cadastroDeLivro.getIdLivro() +
                "\n Nome: " + cadastroDeLivro.getNomeLivro() +
                "\n Situação: " + cadastroDeLivro.getStatusLivro() +
                "\n Data de cadastro: " + cadastroDeLivro.getData() +
                "\n Quantidade total: " + cadastroDeLivro.getQuantidadeLivro() +
                "\n Quantidade disponível: " + cadastroDeLivro.getQuantidadeDisponivel() +
                "\n Quantidade alugada: " + cadastroDeLivro.getQuantidadeAlugada());
    }
}
