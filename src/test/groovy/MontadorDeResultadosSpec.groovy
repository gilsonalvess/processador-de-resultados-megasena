import br.com.apostacerta.megasena.MontadorDeResultados
import br.com.apostacerta.megasena.Resultado
import spock.lang.Specification

class MontadorDeResultadosSpec extends Specification {

    void 'obtenhaTodosResultadosMegaSena'() {
        setup:
        MontadorDeResultados montadorDeResultados = new MontadorDeResultados()

        when:
        List<Resultado> resultados = montadorDeResultados.obtenhaTodosResultados('resultados_megasena.txt')

        then:
        resultados.size() == 12
    }

    void 'obtenhaTodosResultadosLotoFacil'() {
        setup:
        MontadorDeResultados montadorDeResultados = new MontadorDeResultados()

        when:
        List<Resultado> resultados = montadorDeResultados.obtenhaTodosResultados('resultados_lotofacil.txt')

        then:
        resultados.size() == 10
    }

    void 'obtenhaResultadoConursoMegaSena'() {
        setup:
        MontadorDeResultados montadorDeResultados = new MontadorDeResultados()

        when:
        Resultado resultado = montadorDeResultados.resultadoConcurso('2236', 'resultados_megasena.txt')

        then:
        '07-20-38-43-45-53' == resultado.dezenas.toString()
        then:
        '22/02/2020' == resultado.concurso.data
    }
}
