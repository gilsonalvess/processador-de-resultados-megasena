import br.com.apostacerta.lotofacil.CriadorDeJogos
import br.com.apostacerta.lotofacil.JogoLotoFacil
import spock.lang.Specification

class CriadorDeJogosSpec extends Specification {

    void 'test_criarJogosCombinados'() {
        setup:
        CriadorDeJogos criadorDeJogos = new CriadorDeJogos()

        when:
        List<String> dezenasExcluidas = ['02', '04', '15', '20', '10']
        List<JogoLotoFacil> jogoLotoFacilList = criadorDeJogos.crieJogosCombinados(dezenasExcluidas, 'lotofacil', 15)
        then:
        15 == jogoLotoFacilList.size()
    }
}
