import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String jogarNovamente = "s";

        Jogo jogo = new Jogo();

        jogo.criarJogador();

        while (jogarNovamente.equalsIgnoreCase("s")) {

            jogo.jogar();
            jogo.jogar(3);

            System.out.println("Jogar novamente? (s/n)");
            jogarNovamente = entrada.nextLine();

        }
        entrada.close();
        Jogador.listaJogadores();

        System.out.println("-------------------");

        System.out.println("Sua posição no ranking " + jogo.getMelhorJogador().getNome() + " - " + Jogo.posicao + "º lugar");

        System.out.println("-------------------");

        System.out.println("O jogo foi jogado " + jogo.getNumeroJogadas() + " vezes");

    }
}