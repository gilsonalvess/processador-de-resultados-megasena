package br.com.apostacerta.megasena

import br.com.apostacerta.utils.UtilJogos

class ComparadorDeRepeticoes {

    List<String> obtenhaDezenasQueSeRepetiramString(List<Resultado> resultados, String loteria = null) {
        List<DezenasParaJogo> dezenasEmJogo = processeRepeticoesDasDezenas(resultados, loteria)
        List<String> resultadoRepeticoes = dezenasEmJogo.collect { DezenasParaJogo resultado ->
            return resultado.toString()
        } as List<String>
        return resultadoRepeticoes
    }

    List<DezenasParaJogo> obtenhaDezenasQueSeRepetiram(List<Resultado> resultados, String loteria = null) {
        List<DezenasParaJogo> resultadoRepeticoes = processeRepeticoesDasDezenas(resultados, loteria)
        return resultadoRepeticoes
    }

    private List<DezenasParaJogo> processeRepeticoesDasDezenas(List<Resultado> resultados, String loteria = null) {
        List<DezenasParaJogo> dezenasEmJogo = []
        if (loteria == 'lotofacil') {
            dezenasEmJogo = UtilJogos.obtenhaDezenasParaJogo(25)
        } else {
            dezenasEmJogo = UtilJogos.obtenhaDezenasParaJogo(60)
        }
        for (Resultado resultado in resultados) {
            final List<String> dezenasDoResultado = resultado.dezenas.toList()
            for (String dezena in dezenasDoResultado) {
                DezenasParaJogo dezenaEmJogoAtual = dezenasEmJogo.find { DezenasParaJogo dezenasParaJogo -> dezenasParaJogo.dezena == dezena }
                if (dezenaEmJogoAtual) {
                    dezenaEmJogoAtual.qtdRepeticoes++
                }
            }
        }
        dezenasEmJogo
    }
}
