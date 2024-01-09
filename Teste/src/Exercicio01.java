import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Exercicio01 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String nome1;
        String nome2;
        String nome3;
        String nome4;
        String nome5;

        int idade1;
        int idade2;
        int idade3;
        int idade4;
        int idade5;

        System.out.println("Informe o primeiro nome: ");
        nome1 = ler.nextLine();
        System.out.println("Informe a idade de " + nome1 + ":");
        idade1 = ler.nextInt();
        ler.nextLine();
        System.out.println("Informe o segundo nome: ");
        nome2 = ler.nextLine();
        System.out.println("Informe a idade de " + nome2 + ":");
        idade2 = ler.nextInt();
        ler.nextLine();
        System.out.println("Informe o terceiro nome: ");
        nome3 = ler.nextLine();
        System.out.println("Informe a idade de " + nome3 + ":");
        idade3 = ler.nextInt();
        ler.nextLine();
        System.out.println("Informe o quarto nome: ");
        nome4 = ler.nextLine();
        System.out.println("Informe a idade de " + nome4 + ":");
        idade4 = ler.nextInt();
        ler.nextLine();
        System.out.println("Informe o quinto nome: ");
        nome5 = ler.nextLine();
        System.out.println("Informe a idade de " + nome5 + ":");
        idade5 = ler.nextInt();
        ler.nextLine();

        System.out.println("Resultado: ");
        System.out.println("Nome: " + nome1 + " - Idade: " + idade1);
        System.out.println("Nome: " + nome2 + " - Idade: " + idade2);
        System.out.println("Nome: " + nome3 + " - Idade: " + idade3);
        System.out.println("Nome: " + nome4 + " - Idade: " + idade4);
        System.out.println("Nome: " + nome5 + " - Idade: " + idade5);


    }
}
