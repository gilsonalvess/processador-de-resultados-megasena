class MontadorDeResultados {

    private static String REGEX_RESULTADO = '(?m)Concurso\\s(\\d+)\\s\\(de\\s(\\d{2}\\/\\d{2}\\/\\d{4}).\\n\\|(.*)\\|'

    protected List<Resultado> obtenhaTodosResultados() {
        List<Resultado> resultados = obtenhaConteudoResultado().findAll(REGEX_RESULTADO) { String linha, String numeroConcurso, String data, String dezenas ->
            new Resultado(
                    new Dezenas(dezenas),
                    new Concurso(numeroConcurso, data)
            )
        }

        return resultados
    }

    protected Resultado resultadoConcurso(String numeroConcurso) {
        return obtenhaTodosResultados().find { Resultado resultado -> resultado.concurso.numero == numeroConcurso }
    }

    private static String obtenhaConteudoResultado() {
        String resultadoTexto = new File('src/main/resources/resultados.txt').text
        return resultadoTexto
    }

}
