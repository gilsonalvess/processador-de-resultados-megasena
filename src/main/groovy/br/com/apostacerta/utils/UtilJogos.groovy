package br.com.apostacerta.utils

import br.com.apostacerta.lotofacil.JogoLotoFacil
import br.com.apostacerta.megasena.DezenasParaJogo

class UtilJogos {

    static List<DezenasParaJogo> obtenhaDezenasParaJogo(Integer numeroDeDezenas) {
        final List<DezenasParaJogo> dezenasEmJogo = []
        List<Integer> list = 1..numeroDeDezenas
        list.eachWithIndex { Integer dezena, Integer i ->
            Integer qtd = 0
            if (i < 9) {
                dezenasEmJogo.add(new DezenasParaJogo("0" + dezena.toString(), qtd))
            } else {
                dezenasEmJogo.add(new DezenasParaJogo(dezena.toString(), qtd))
            }
        }
        dezenasEmJogo
    }

    // todo deixar parametrizável
    static List<String> obtenhaAsMenoresOcorrencias(List<DezenasParaJogo> repeticoesDezenas, Integer quantidade) {
        List<String> dezenasComMenoresOcorrencias = []
        repeticoesDezenas.sort { DezenasParaJogo dezenasParaJogo -> dezenasParaJogo.qtdRepeticoes }.each { DezenasParaJogo dezenaParaJogo ->
            if (dezenasComMenoresOcorrencias.size() < quantidade) {
                // if((dezenaParaJogo.dezena as Integer) % 2 != 0){
                dezenasComMenoresOcorrencias.add(dezenaParaJogo.dezena)
                //}
            }
        }
        return dezenasComMenoresOcorrencias
    }

    static List<String> obtenhaAsMaioresOcorrencias(List<DezenasParaJogo> numerosQueSeRepetiram, Integer quantidade) {
        List<String> dezenasParaExcluir = []
        numerosQueSeRepetiram.sort { DezenasParaJogo dezenasParaJogo -> dezenasParaJogo.qtdRepeticoes }.reverse().each { DezenasParaJogo dezenaParaJogo ->
            if (dezenasParaExcluir.size() < quantidade) {
                dezenasParaExcluir.add(dezenaParaJogo.dezena)
            }
        }
        return dezenasParaExcluir
    }

    static imprimeResultado(List<JogoLotoFacil> jogosGanhadores) {
        if (jogosGanhadores) {
            BigDecimal somaTotal = 0
            [11, 12, 13, 14, 15].each { Integer qtdAcertos ->
                Integer qtdAcertado = jogosGanhadores.findAll { it.qtdDeAcertos == qtdAcertos }.size()
                BigDecimal total = valorPremiacaoPeloNumDeAcertos(qtdAcertos.toString()) * qtdAcertado
                somaTotal += total
                println "Apostas ganhoras com ${qtdAcertos} numeros: ${qtdAcertado} Total ganho = R\$ ${total}"
            }
            println "Valor total ganho: ${somaTotal}"
        } else {
            println 'Nenhuma apostada premiada!'
        }

    }

    private static BigDecimal valorPremiacaoPeloNumDeAcertos(String qtdAcertos) {
        Map<String, BigDecimal> valorPremiacao = [
                '11': 5.0,
                '12': 10.0,
                '13': 25.0,
                '14': 1772.03,
                '15': 1597282.60
        ]
        return valorPremiacao.getAt(qtdAcertos)

    }
}
