public class Jogador {

    public String nome;
    public int idade;
    public int pontuacao;
    public int numeroTentativas;


    public Jogador(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = 0;
        this.numeroTentativas = 0;
    }


    public void ganhaPontos(int pontos) {
        this.pontuacao += pontos;
    }

    public void perdePontos(int pontos) {
        this.pontuacao -= pontos;
        if (this.pontuacao < 0) {
            this.pontuacao = 0;
        }
    }

    public void adicionaTentativas() {
        this.numeroTentativas++;
    }

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
}
