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
    }

    public void perdePontos() {
        this.pontuacao -= 50;
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

}
