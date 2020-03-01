import br.com.apostacerta.lotofacil.CriadorDeJogos
import br.com.apostacerta.lotofacil.JogoLotoFacil
import br.com.apostacerta.lotofacil.ProcessadorDeResultados
import br.com.apostacerta.megasena.ComparadorDeRepeticoes
import br.com.apostacerta.megasena.DezenasParaJogo
import br.com.apostacerta.megasena.MontadorDeResultados
import br.com.apostacerta.megasena.Resultado
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
        List<DezenasParaJogo> numerosQueSeRepetiram = comparadorDeRepeticoes.obtenhaDezenasQueSeRepetiram(resultados, 'lotofacil')
        List<String> dezenasParaExcluir = obtenhaAsCincoMenoresOcorrencias(numerosQueSeRepetiram)
        List<JogoLotoFacil> jogosDoAlgoritmo = criadorDeJogos.crieJogosCombinados(dezenasParaExcluir, 'lotofacil')
        List<JogoLotoFacil> jogosConferidos = processadorDeResultados.confereResultaDeJogos(jogosDoAlgoritmo)

        then:
        jogosConferidos
        numerosQueSeRepetiram
    }

    //TODO mudar o algorimtmo para sempre combinar jogos com os numeros de maiores ocorrencias
    //TODO aumentar o range de verificação de ocorrencias

    List<String> obtenhaAsCincoMenoresOcorrencias(List<DezenasParaJogo> numerosQueSeRepetiram) {
        List<String> dezenasParaExcluir = []
        numerosQueSeRepetiram.sort { DezenasParaJogo dezenasParaJogo -> dezenasParaJogo.qtdRepeticoes }.eachWithIndex { DezenasParaJogo entry, int i ->
            if (i < 5) {
                dezenasParaExcluir.add(entry.dezena)
            }
        }
        dezenasParaExcluir
    }
}
