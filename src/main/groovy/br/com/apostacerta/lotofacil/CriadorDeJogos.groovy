package br.com.apostacerta.lotofacil

import br.com.apostacerta.megasena.Dezenas
import br.com.apostacerta.utils.UtilJogos

class CriadorDeJogos {

    List<JogoLotoFacil> crieJogosCombinados(List<String> dezenasAExcluir, String loteria) {
        List<List<String>> combinacoesDeJogos = []
        List<String> dezenasEmJogo = UtilJogos.obtenhaDezenasParaJogo(25).dezena
        dezenasEmJogo.removeAll(dezenasAExcluir)

        20.times {
            combinacoesDeJogos.add(dezenasEmJogo.sort { Math.random() }.take(15))
        }

        obtenhaListaDeJogosOrdenadas(combinacoesDeJogos)
    }

    private List<JogoLotoFacil> obtenhaListaDeJogosOrdenadas(List<List<String>> dezenasEmJogo) {
        List<JogoLotoFacil> jogoLotoFacilList = []
        for (List<String> jogo in dezenasEmJogo) {
            jogoLotoFacilList.add(
                    new JogoLotoFacil(new Dezenas(jogo.sort()))
            )
        }
        jogoLotoFacilList
    }
}
