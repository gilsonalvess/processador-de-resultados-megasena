import spock.lang.Specification

class MontadorDeResultadosSpec extends Specification {

    void 'obtenhaTodosResultados'() {
        setup:
        MontadorDeResultados montadorDeResultados = new MontadorDeResultados()

        when:
        List<Resultado> resultados = montadorDeResultados.obtenhaTodosResultados()

        then:
        assert 12, resultados.size()
    }

    void 'obtenhaResultadoConurso'() {
        setup:
        MontadorDeResultados montadorDeResultados = new MontadorDeResultados()

        when:
        Resultado resultado = montadorDeResultados.resultadoConcurso('2236')

        then:
        assert '07-20-38-43-45-53', resultado.toString()
        then:
        assert '22/02/2020', resultado.concurso.data
    }
}
