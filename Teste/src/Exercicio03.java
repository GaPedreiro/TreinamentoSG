import java.util.Scanner;
public class Exercicio03 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        String palavra1;
        String palavra2;
        String palavra3;

        System.out.println("Informe a primeira palavra: ");
        palavra1 = read.nextLine();

        if ((palavra1.equals("vertebrado"))) {
            System.out.println("Informe a segunda palavra: ");
            palavra2 = read.nextLine();
            if ((palavra2.equals("ave"))) {
                System.out.println("Informe a terceira palavra: ");
                palavra3 = read.nextLine();
                if ((palavra3.equals("carnivoro"))) {
                    System.out.println("O animal escolhido foi: Águia");
                } else if ((palavra3.equals("onivoro"))) {
                    System.out.println("O animal escolhido foi: Pomba");
                } else {
                    System.out.println(("A palavra informada é inválida."));
                }
            } else if ((palavra2.equals("mamifero"))) {
                System.out.println("Informe a terceira palavra: ");
                palavra3 = read.nextLine();
                if ((palavra3.equals("onivoro"))) {
                    System.out.println("O animal escolhido foi: Homem");
                } else if ((palavra3.equals("herbivoro"))) {
                    System.out.println("O animal escolhido foi: Vaca");
                } else {
                    System.out.println(("A palavra informada é inválida."));
                }
            }
        } else if ((palavra1.equals("invertebrado"))) {
            System.out.println("Informe a segunda palavra: ");
            palavra2 = read.nextLine();
            if ((palavra2.equals("inseto"))) {
                System.out.println("Informe a terceira palavra: ");
                palavra3 = read.nextLine();
                if ((palavra3.equals("hematofago"))) {
                    System.out.println("O animal escolhido foi: Pulga");
                } else if ((palavra3.equals("herbivoro"))) {
                    System.out.println("O animal escolhido foi: Lagarta");
                }
            } else if ((palavra2.equals("anelideo"))) {
                System.out.println("Informe a terceira palavra: ");
                palavra3 = read.nextLine();
                if ((palavra3.equals("hematofago"))) {
                    System.out.println("O animal escolhido foi: Sanguessuga");
                } else if ((palavra3.equals("onivoro"))) {
                    System.out.println("O animal escolhido foi: Minhoca");
                } else {
                    System.out.println("A palavra informada é inválida.");
                }
            } else {
                System.out.println("A palavra informada é inválida.");
            }
        } else {
            System.out.println("A palavra informada é inválida");
        }
    }
}
