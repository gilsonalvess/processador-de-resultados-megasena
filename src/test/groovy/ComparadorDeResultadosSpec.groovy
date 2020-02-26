import spock.lang.Specification

class ComparadorDeResultadosSpec extends Specification {

    void 'obtemNumerosRepetidos'() {
        setup:
        MontadorDeResultados montadorDeResultados = new MontadorDeResultados()
        ComparadorDeResultados comparadorDeResultados = new ComparadorDeResultados()

        when:
        List<String> numerosQueSeRepetiram = comparadorDeResultados.obtenhaNumerosQueSeRepetiram(montadorDeResultados.obtenhaTodosResultados())

        then:
        numerosQueSeRepetiram
    }
}
