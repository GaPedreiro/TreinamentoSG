import java.util.*;

public class Exercicio01Ref {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String nome;
        int idade;

        List<String> nomes = new ArrayList<>();
        List<Integer> idades = new ArrayList<>();
        List<String> idadesCrescente = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            System.out.println("Informe um nome: ");
            nome = ler.nextLine();
            nomes.add(nome);
            System.out.println("Informe a idade: ");
            idade = ler.nextInt();
            idades.add(idade);
            ler.nextLine();
        }

        System.out.println("Resultado: ");
        System.out.println("Nomes: " + nomes);
        System.out.println("Idades: " + idades);
        Collections.sort(idades);
        System.out.println(("Idades apresentadas em ordem crescente: " + idades));

    }
}
