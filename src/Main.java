import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String jogarNovamente = "s";
        int multiplicador = 1;

            System.out.println("Bem vindo ao jogo!");
            System.out.println("Primeiramente crie o seu jogador!");

        while (jogarNovamente.equalsIgnoreCase("s")) {
            System.out.print("Nome: ");
            String nome = entrada.nextLine();
            System.out.print("Idade: ");
            int idade = entrada.nextInt();
            entrada.nextLine();

            Jogador jogador = new Jogador(nome, idade);
            jogador.setPontuacao(multiplicador * 50);
            Jogador.melhoresJogadores.add(jogador);

            System.out.println("Criar outro jogador? (s/n)");
            jogarNovamente = entrada.nextLine();
            multiplicador++;
        }
        entrada.close();


        Jogador.rankingJogadores();

    }
}