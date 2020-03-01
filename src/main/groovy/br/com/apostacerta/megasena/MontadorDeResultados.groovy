package br.com.apostacerta.megasena

class MontadorDeResultados {

    private static String REGEX_RESULTADO = '(?m)Concurso\\s(\\d+)\\s\\(de\\s(\\d{2}\\/\\d{2}\\/\\d{4}).\\n\\|(.*)\\|'

    List<Resultado> obtenhaTodosResultados(String fileName) {
        List<Resultado> resultados = obtenhaConteudoResultado(fileName).findAll(REGEX_RESULTADO) { String linha, String numeroConcurso, String data, String dezenas ->
            new Resultado(
                    new Dezenas(dezenas),
                    new Concurso(numeroConcurso, data)
            )
        }

        return resultados
    }

    Resultado resultadoConcurso(String numeroConcurso, String loteria) {
        String fileName = loteria == 'lotofacil' ? 'resultados_lotofacil.txt' : 'resultados_megasena.txt'
        return obtenhaTodosResultados(fileName).find { Resultado resultado -> resultado.concurso.numero == numeroConcurso }
    }

    private static String obtenhaConteudoResultado(String fileName) {
        String resultadoTexto = new File("src/main/resources/$fileName").text
        return resultadoTexto
    }

}
