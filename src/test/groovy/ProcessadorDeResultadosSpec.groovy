import br.com.apostacerta.lotofacil.CriadorDeJogos
import br.com.apostacerta.lotofacil.JogoLotoFacil
import br.com.apostacerta.lotofacil.ProcessadorDeResultados
import br.com.apostacerta.megasena.ComparadorDeRepeticoes
import br.com.apostacerta.megasena.DezenasParaJogo
import br.com.apostacerta.megasena.MontadorDeResultados
import br.com.apostacerta.megasena.Resultado
import br.com.apostacerta.utils.UtilJogos
import spock.lang.Specification

class ProcessadorDeResultadosSpec extends Specification {

    void 'test_conferirResultadoJogos'() {
        setup:
        CriadorDeJogos criadorDeJogos = new CriadorDeJogos()
        ProcessadorDeResultados processadorDeResultados = new ProcessadorDeResultados()
        ComparadorDeRepeticoes comparadorDeRepeticoes = new ComparadorDeRepeticoes()
        MontadorDeResultados montadorDeResultados = new MontadorDeResultados()

        when:
        List<Resultado> resultados = montadorDeResultados.obtenhaTodosResultados('resultados_lotofacil.txt')
        resultados.remove(0)
        List<DezenasParaJogo> repeticoesDezenas = comparadorDeRepeticoes.obtenhaRepeticoesDezenas(resultados, 'lotofacil')
        List<String> dezenasParaExcluir = UtilJogos.obtenhaAsMenoresOcorrencias(repeticoesDezenas, 5)
        List<String> dezenasParaAdicionar = UtilJogos.obtenhaAsMaioresOcorrencias(repeticoesDezenas, 5)
        List<JogoLotoFacil> jogosDoAlgoritmo = criadorDeJogos.crieJogosCombinados(dezenasParaExcluir, 'lotofacil', 12)
        List<JogoLotoFacil> jogosConferidos = processadorDeResultados.confereResultadoDeJogos(jogosDoAlgoritmo, '2006')

        List<JogoLotoFacil> jogosGanhadores = jogosConferidos.findAll { it.isApostaGanhadora }
        UtilJogos.imprimeResultado(jogosGanhadores)

        then:

        repeticoesDezenas
    }

}
