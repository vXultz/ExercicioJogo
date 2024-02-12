import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Jogo jogo = new Jogo();

        while (true) {
            System.out.println("Bem-vindo ao menu principal!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Identificar-se ou criar novo jogador");
            System.out.println("2 - Escolher um jogo");
            System.out.println("3 - Ver ranking dos jogadores");
            System.out.println("4 - Ver Top 10 jogadores");
            System.out.println("5 - Encerrar o jogo");
            System.out.print("Opção: ");
            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    jogo.criarJogador();
                    break;
                case 2:
                    escolherJogo(jogo, entrada);
                    break;
                case 3:
                    System.out.println("----------------");
                    System.out.println("Ranking dos jogadores");
                    System.out.println("----------------");
                    Jogador.listaJogadores();
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("----------------");
                    System.out.println("Top 10 jogadores");
                    System.out.println("----------------");
                    Jogador.rankingJogadores();
                    break;
                case 5:
                    System.out.println("Encerrando o jogo. Obrigado por jogar!");
                    entrada.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    public static void escolherJogo(Jogo jogo, Scanner entrada) {
        System.out.println("Escolha o jogo:");
        System.out.println("1 - Pedra, Papel e Tesoura");
        System.out.println("2 - Adivinhação");
        System.out.print("Opção: ");
        int opcaoJogo = entrada.nextInt();
        entrada.nextLine();

        switch (opcaoJogo) {
            case 1:
                jogo.jogar();
                break;
            case 2:
                jogo.jogar(3);
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
    }
}