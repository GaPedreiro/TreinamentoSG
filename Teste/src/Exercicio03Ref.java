import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Exercicio03Ref {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int i = 0;

        String palavra = "";

        List<String> palavras = new ArrayList<>();

        while (palavra != "vertebrado" && palavra != "invertebrado") {
            System.out.println("Informe uma das seguintes palavras: VERTEBRADO | INVERTEBRADO: ");
            palavra = read.nextLine();
            
        }
    }
}
