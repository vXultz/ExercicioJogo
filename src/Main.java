import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String jogarNovamente = "s";

        Jogo jogo = new Jogo();

        while (jogarNovamente.equalsIgnoreCase("s")) {
            jogo.jogar();

            System.out.println("Criar outro jogador e jogar novamente? (s/n)");
            jogarNovamente = entrada.nextLine();

        }
        entrada.close();
        Jogador.listaJogadores();

        System.out.println("-------------------");

        System.out.println("Sua posição no ranking " + Jogo.ultimoJogador.getNome() + " - " + Jogo.posicao + "º lugar");

        System.out.println("-------------------");

        System.out.println("O jogo foi jogado " + jogo.getNumeroJogadas() + " vezes");

    }
}