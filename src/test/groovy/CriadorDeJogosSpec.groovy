import br.com.apostacerta.lotofacil.CriadorDeJogos
import br.com.apostacerta.lotofacil.JogoLotoFacil
import spock.lang.Specification

class CriadorDeJogosSpec extends Specification {

    void 'test_criarJogosCombinados'() {
        setup:
        CriadorDeJogos criadorDeJogos = new CriadorDeJogos()

        when:
        List<String> dezenasExcluidas = ['02', '04', '15', '20', '10']
        List<JogoLotoFacil> jogoLotoFacilList = criadorDeJogos.crieJogosCombinados(dezenasExcluidas, 'lotofacil')
        //todo criar processador de resultados lotofacil
        //todo criar teste que passa numeros que menos sai do algoritimo
        //todo os resultados devem mostrar o numero de acerto em cada aposta (lógica para comparação de acerto vai ser a mesma do repetidor de de repetições)
        then:
        jogoLotoFacilList
    }
}
