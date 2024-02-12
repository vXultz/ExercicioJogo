import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String jogarNovamente = "s";
        int multiplicador = 1;
        Jogador ultimoJogador = null;
        int posicao = Jogador.melhoresJogadores.indexOf(ultimoJogador) + 2;

        System.out.println("Bem vindo ao jogo!");
        System.out.println("Primeiramente crie o seu jogador!");


        while (jogarNovamente.equalsIgnoreCase("s")) {
            String nome;
            boolean nomeValido = false;

            do {
                System.out.print("Nome: ");
                nome = entrada.nextLine();

                if (Jogador.verificacaoJogador(nome)){
                    System.out.println("Nome já existe! Por favor escolha outro.");
                }else {
                    nomeValido = true;
                }
            } while (!nomeValido);

            System.out.print("Idade: ");
            int idade = entrada.nextInt();
            entrada.nextLine();

            Jogador jogador = new Jogador(nome, idade);
            jogador.setPontuacao(multiplicador * 50);
            Jogador.melhoresJogadores.add(jogador);
            ultimoJogador = jogador;

            System.out.println("Criar outro jogador? (s/n)");
            jogarNovamente = entrada.nextLine();
            multiplicador++;
        }
        entrada.close();
        Jogador.listaJogadores();

        System.out.println("-------------------");

        System.out.println("Sua posição no ranking " + ultimoJogador.getNome() + " - " + posicao + "º lugar");
    }
}