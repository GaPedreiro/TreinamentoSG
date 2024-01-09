import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Exercicio03Ref {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int i = 0;

        String palavra = "";

        List<String> palavras = new ArrayList<>();

        while (palavras.getFirst() != "vertebrado" && palavras.getFirst() != "invertebrado") {
            System.out.println("Informe uma das seguintes palavras: VERTEBRADO | INVERTEBRADO: ");
            palavras.add(read.nextLine());
            read.nextLine();
            if (palavras.getFirst().equals("vertebrado")) {
                while (palavras.getFirst() != "ave" && palavras.getFirst() != "mamifero") {
                    System.out.println("Agora, informe a segunda palavra: AVE | MAMIFERO");
                    palavras.add(read.nextLine());
                }
            }
        }
    }
}
