import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        List<Jogador> listaJogadores = new ArrayList<>();

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
            listaJogadores.add(jogador);

            System.out.println("Criar outro jogador? (s/n)");
            jogarNovamente = entrada.nextLine();
            multiplicador++;
        }
        entrada.close();


        MelhoresJogadores melhoresJogadores = new MelhoresJogadores(listaJogadores);
        List<Jogador> jogadoresOrdemPontuacao = melhoresJogadores.getJogadoresOrdemPontuacao();

        System.out.println("Ranking dos jogadores:");
        for (int i = 0; i < jogadoresOrdemPontuacao.size(); i++) {
            Jogador jogador = jogadoresOrdemPontuacao.get(i);
            System.out.println((i + 1) + ". Nome: " + jogador.getNome() + " - Idade: " +  jogador.getIdade() + " - Pontos: " + jogador.getPontuacao() + " - Tentativas: " + jogador.getNumeroTentativas());
        }

    }
}