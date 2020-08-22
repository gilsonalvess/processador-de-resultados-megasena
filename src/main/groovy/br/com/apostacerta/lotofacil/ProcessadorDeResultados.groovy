package br.com.apostacerta.lotofacil

import br.com.apostacerta.megasena.Dezenas
import br.com.apostacerta.megasena.MontadorDeResultados
import br.com.apostacerta.megasena.Resultado

class ProcessadorDeResultados {

    List<JogoLotoFacil> confereResultadoDeJogos(List<JogoLotoFacil> jogosAConferir, String concurso) {
        List<JogoLotoFacil> jogosConferidos = []
        MontadorDeResultados montadorDeResultados = new MontadorDeResultados()
        //todo refatorar para trazer sempre o ultimo resultado com default. Permitir conferir passando o numero do concurso
        Resultado resultado = montadorDeResultados.resultadoConcurso(concurso, 'lotofacil')

        for (JogoLotoFacil jogoAposta in jogosAConferir) {
            jogoAposta.dezenasAcertadas = resultado.dezenas.toList().intersect(jogoAposta.dezenasDoJogo.toList()) as Dezenas
            jogoAposta.qtdDeAcertos = jogoAposta.dezenasAcertadas.toList().size()

            if (jogoAposta.qtdDeAcertos >= 11) {
                jogoAposta.isApostaGanhadora = true
            }
            jogosConferidos.add(jogoAposta)
        }
        jogosConferidos
    }
}
