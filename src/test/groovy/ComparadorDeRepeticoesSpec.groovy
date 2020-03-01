import br.com.apostacerta.megasena.ComparadorDeRepeticoes
import br.com.apostacerta.megasena.MontadorDeResultados
import br.com.apostacerta.megasena.Resultado
import spock.lang.Specification

class ComparadorDeRepeticoesSpec extends Specification {

    void 'test_obtemNumerosRepetidosMegaSena'() {
        setup:
        MontadorDeResultados montadorDeResultados = new MontadorDeResultados()
        ComparadorDeRepeticoes comparadorDeResultados = new ComparadorDeRepeticoes()

        when:
        List<Resultado> resultados = montadorDeResultados.obtenhaTodosResultados('resultados_megasena.txt')
        List<String> numerosQueSeRepetiram = comparadorDeResultados.obtenhaDezenasQueSeRepetiramString(resultados)

        then:
        numerosQueSeRepetiram.sort().get(05) == 'Dezena: 06 - Vezes que se repetiu: 3'
        numerosQueSeRepetiram.sort().get(10) == 'Dezena: 11 - Vezes que se repetiu: 1'
        numerosQueSeRepetiram.sort().get(31) == 'Dezena: 32 - Vezes que se repetiu: 4'
    }

    void 'test_obtemNumerosRepetidosMegaSenaLotoFacil'() {
        setup:
        MontadorDeResultados montadorDeResultados = new MontadorDeResultados()
        ComparadorDeRepeticoes comparadorDeResultados = new ComparadorDeRepeticoes()

        when:
        List<Resultado> resultados = montadorDeResultados.obtenhaTodosResultados('resultados_lotofacil.txt')
        List<String> numerosQueSeRepetiram = comparadorDeResultados.obtenhaDezenasQueSeRepetiramString(resultados, 'lotofacil')

        then:
        numerosQueSeRepetiram.sort().get(05) == 'Dezena: 06 - Vezes que se repetiu: 5'
        numerosQueSeRepetiram.sort().get(10) == 'Dezena: 11 - Vezes que se repetiu: 6'
        numerosQueSeRepetiram.sort().get(22) == 'Dezena: 23 - Vezes que se repetiu: 8'
    }
}
