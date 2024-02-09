import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MelhoresJogadores {
    private List<Jogador> listaJogadores;

    public MelhoresJogadores(List<Jogador> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }

    public List<Jogador> getJogadoresOrdemPontuacao() {
        Collections.sort(listaJogadores, Comparator.comparingInt(Jogador::getPontuacao).reversed());

        return listaJogadores;
    }
}