import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Jogador {

    // atributos
    private String nome;
    private int idade;
    private int pontuacao;
    private int numeroTentativas;


    // construtor
    public Jogador(String nome, int idade) {
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


    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getNumeroTentativas() {
        return numeroTentativas;
    }

    public void setNumeroTentativas(int numeroTentativas) {
        this.numeroTentativas = numeroTentativas;
    }


    public static List<Jogador> melhoresJogadores = new ArrayList<>();

    private static void atualizarMelhoresJogadores() {
        melhoresJogadores.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());
    }

    public static void rankingJogadores() {
        atualizarMelhoresJogadores();
        int top10 = Math.min(10, melhoresJogadores.size());
        System.out.println("Ranking dos jogadores:");
        for (int i = 0; i < top10; i++) {
            Jogador jogador = melhoresJogadores.get(i);
            System.out.println(jogador.getNome() + " - " + (i + 1));
        }
    }
}
