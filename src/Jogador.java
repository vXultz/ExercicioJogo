import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Jogador {

    public static List<Jogador> melhoresJogadores = new ArrayList<>();

    // atributos
    private String nome;
    private int idade;
    private int pontuacao;
    private int numeroTentativas;


    // construtor
    public Jogador(String nome, int idade)  {
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = 0;
        this.numeroTentativas = 0;
    }


    // métodos
    public void ganhaPontos() {
        this.pontuacao += 50;
        atualizarMelhoresJogadores();
    }

    public void perdePontos() {
        this.pontuacao -= 50;
        atualizarMelhoresJogadores();
        if (this.pontuacao < 0) {
            this.pontuacao = 0;
        }
    }

    public void adicionaTentativas() {
        this.numeroTentativas++;
    }

    public static void atualizarMelhoresJogadores() {
        melhoresJogadores.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());
    }

    public static void listaJogadores() {
        atualizarMelhoresJogadores();
        System.out.println("----------------");
        System.out.println("Ranking dos jogadores:");
        System.out.println("----------------");
        for (int i = 0; i < melhoresJogadores.size(); i++) {
            Jogador jogador = melhoresJogadores.get(i);
            System.out.println("Posição - " + (i + 1) + " - Nome: " + jogador.getNome() + " - Idade: " + jogador.getIdade() + " - Pontuação: " + jogador.getPontuacao() + " - Tentativas: " + jogador.getNumeroTentativas());
        }
    }

    public static void rankingJogadores() {
        atualizarMelhoresJogadores();
        int top10 = Math.min(10, melhoresJogadores.size());
        System.out.println("----------------");
        System.out.println("Top 10 jogadores:");
        System.out.println("----------------");
        for (int i = 0; i < top10; i++) {
            Jogador jogador = melhoresJogadores.get(i);
            System.out.println(jogador.getNome() + " - " + (i + 1) + " - Pontuação: " + jogador.getPontuacao());
        }
    }

    public static boolean verificacaoJogador(String nome) {
        for (Jogador jogador : melhoresJogadores) {
            if (jogador.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public static Jogador buscarJogador(String nome) {
        for (Jogador jogador : melhoresJogadores) {
            if (jogador.getNome().equals(nome)) {
                return jogador;
            }
        }
        return null;
    }

    // getters e setters

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getNumeroTentativas() {
        return numeroTentativas;
    }


}