package br.com.apostacerta.utils

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
}
