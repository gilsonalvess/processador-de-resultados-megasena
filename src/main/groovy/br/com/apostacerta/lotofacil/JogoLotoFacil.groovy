package br.com.apostacerta.lotofacil

import br.com.apostacerta.megasena.Dezenas

class JogoLotoFacil {
    Dezenas dezenasDoJogo
    Dezenas dezenasAcertadas
    Integer qtdDeAcertos = 0
    Boolean isApostaGanhadora = false


    JogoLotoFacil(Dezenas dezenasDoJogo) {
        this.dezenasDoJogo = dezenasDoJogo
    }
}
