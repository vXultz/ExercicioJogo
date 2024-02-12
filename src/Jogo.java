import java.util.Scanner;

public class Jogo {

    private Jogador melhorJogador;
    private int numeroJogadas;

    static Jogador ultimoJogador = null;
    static int posicao;

    public Jogo() {
        this.melhorJogador = null;
        this.numeroJogadas = 0;
    }

    public void jogar() {
        Scanner entrada = new Scanner(System.in);
        String jogarNovamente = null;


        String nome;
        boolean nomeValido = false;

        System.out.println("Bem-vindo ao jogo Pedra, Papel e Tesoura!");

        do {
            System.out.print("Digite seu nome: ");
            nome = entrada.nextLine();

            if (Jogador.verificacaoJogador(nome)) {
                System.out.println("Nome já existe! Por favor escolha outro.");
            } else {
                nomeValido = true;
            }
        } while (!nomeValido);

        System.out.print("Digite sua idade: ");
        int idade = entrada.nextInt();
        entrada.nextLine();

        Jogador jogador = new Jogador(nome, idade);
        Jogador.melhoresJogadores.add(jogador);
        ultimoJogador = jogador;


        do {

            this.numeroJogadas++;

            System.out.println("Faça sua escolha:");
            System.out.println("1. Pedra");
            System.out.println("2. Papel");
            System.out.println("3. Tesoura");
            System.out.print("Escolha: ");
            int escolhaJogador = entrada.nextInt();
            entrada.nextLine();

            int escolhaComputador = (int) (Math.random() * 3) + 1;

            System.out.println("O computador escolheu: " + converterEscolha(escolhaComputador));

            int resultado = determinarResultado(escolhaJogador, escolhaComputador);
            if (resultado == 1) {
                System.out.println("Parabéns! Você ganhou!");
                jogador.ganhaPontos();
            } else if (resultado == -1) {
                System.out.println("Você perdeu! Tente novamente.");
                jogador.perdePontos();
            } else {
                System.out.println("Empate! Tente novamente.");
            }

            jogador.adicionaTentativas();

            System.out.println("Jogar pedra, papel ou tesoura novamente? (s/n)");
            jogarNovamente = entrada.nextLine();

            if (Jogador.melhoresJogadores.contains(ultimoJogador)) {
                posicao = Jogador.melhoresJogadores.indexOf(ultimoJogador) + 1;
            } else {
                Jogador.melhoresJogadores.add(ultimoJogador);
                Jogador.atualizarMelhoresJogadores();
                posicao = Jogador.melhoresJogadores.indexOf(ultimoJogador) + 1;
            }

        } while (jogarNovamente.equalsIgnoreCase("s"));
    }


    private String converterEscolha(int escolha) {
        switch (escolha) {
            case 1:
                return "Pedra";
            case 2:
                return "Papel";
            case 3:
                return "Tesoura";
            default:
                return "";
        }
    }

    private int determinarResultado(int escolhaJogador, int escolhaComputador) {
        if (escolhaJogador == escolhaComputador) {
            return 0;
        } else if ((escolhaJogador == 1 && escolhaComputador == 3) ||
                (escolhaJogador == 2 && escolhaComputador == 1) ||
                (escolhaJogador == 3 && escolhaComputador == 2)) {
            return 1;
        } else {
            return -1;
        }
    }

    public Jogador getMelhorJogador() {
        return melhorJogador;
    }

    public void setMelhorJogador(Jogador melhorJogador) {
        this.melhorJogador = melhorJogador;
    }

    public int getNumeroJogadas() {
        return numeroJogadas;
    }
}