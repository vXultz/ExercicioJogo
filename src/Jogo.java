import java.util.Scanner;

public class Jogo {

    private Jogador melhorJogador;
    private int numeroJogadas;

    static int posicao;

    public Jogo() {
        this.melhorJogador = null;
        this.numeroJogadas = 0;
    }

    public void criarJogador() {
        Scanner entrada = new Scanner(System.in);
        String nome;
        boolean nomeValido = false;

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
        this.melhorJogador = jogador;
    }

    public void jogar() {
        Scanner entrada = new Scanner(System.in);
        String jogarNovamente = null;

        System.out.println("Bem-vindo ao jogo Pedra, Papel e Tesoura!");

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
                melhorJogador.ganhaPontos();
            } else if (resultado == -1) {
                System.out.println("Você perdeu! Tente novamente.");
                melhorJogador.perdePontos();
            } else {
                System.out.println("Empate! Tente novamente.");
            }

            melhorJogador.adicionaTentativas();

            System.out.println("Jogar pedra, papel ou tesoura novamente? (s/n)");
            jogarNovamente = entrada.nextLine();

            if (Jogador.melhoresJogadores.contains(melhorJogador)) {
                posicao = Jogador.melhoresJogadores.indexOf(melhorJogador) + 1;
            } else {
                Jogador.melhoresJogadores.add(melhorJogador);
                Jogador.atualizarMelhoresJogadores();
                posicao = Jogador.melhoresJogadores.indexOf(melhorJogador) + 1;
            }

        } while (jogarNovamente.equalsIgnoreCase("s"));
    }

    public void jogar(int num) {
        Scanner entrada = new Scanner(System.in);
        String jogarNovamente = null;

        System.out.println("Bem-vindo ao jogo de Adivinhação!");

        do {

            this.numeroJogadas++;

            System.out.print("Adivinhe um número de 0 até " + num + ": ");
            int escolhaJogador = entrada.nextInt();
            entrada.nextLine();

            int numeroComputador = (int) (Math.random() * (num + 1));

            System.out.println("O computador escolheu o número: " + numeroComputador);

            if (escolhaJogador == numeroComputador) {
                System.out.println("Parabéns! Você acertou!");
                melhorJogador.ganhaPontos();
            } else {
                System.out.println("Você errou! O número correto era: " + numeroComputador);
                melhorJogador.perdePontos();
            }

            melhorJogador.adicionaTentativas();

            System.out.println("Deseja jogar novamente? (s/n)");
            jogarNovamente = entrada.nextLine();

            if (Jogador.melhoresJogadores.contains(melhorJogador)) {
                posicao = Jogador.melhoresJogadores.indexOf(melhorJogador) + 1;
            } else {
                Jogador.melhoresJogadores.add(melhorJogador);
                Jogador.atualizarMelhoresJogadores();
                posicao = Jogador.melhoresJogadores.indexOf(melhorJogador) + 1;
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