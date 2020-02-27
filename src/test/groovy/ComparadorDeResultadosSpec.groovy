import spock.lang.Specification

class ComparadorDeResultadosSpec extends Specification {

    void 'obtemNumerosRepetidos'() {
        setup:
        MontadorDeResultados montadorDeResultados = new MontadorDeResultados()
        ComparadorDeResultados comparadorDeResultados = new ComparadorDeResultados()

        when:
        List<String> numerosQueSeRepetiram = comparadorDeResultados.obtenhaNumerosQueSeRepetiram(montadorDeResultados.obtenhaTodosResultados())

        then:
        numerosQueSeRepetiram.sort().get(05) == 'Dezena: 06 - Vezes que se repetiu: 3'
        numerosQueSeRepetiram.sort().get(10) == 'Dezena: 11 - Vezes que se repetiu: 1'
        numerosQueSeRepetiram.sort().get(31) == 'Dezena: 32 - Vezes que se repetiu: 4'
    }
}
