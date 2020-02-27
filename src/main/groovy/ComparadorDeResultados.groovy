class ComparadorDeResultados {

    private static List<DezenasEmJogo> dezenasEmJogo = []

    List<String> obtenhaNumerosQueSeRepetiram(List<Resultado> resultados) {
        inicializeDezenasEmJogo()
        for (Resultado resultado in resultados) {
            final List<String> dezenasDoResultado = resultado.dezenas.toList()
            for (String dezena in dezenasDoResultado) {
                DezenasEmJogo dezenaEmJogoAtual = dezenasEmJogo.find { DezenasEmJogo dezenasEmJogo -> dezenasEmJogo.dezena == dezena }
                if (dezenaEmJogoAtual) {
                    dezenaEmJogoAtual.qtdRepeticoes++
                }
            }
        }
        montaResultadoRepeticoes(dezenasEmJogo)
    }

    private void inicializeDezenasEmJogo() {
        List<Integer> list = 1..60
        list.eachWithIndex { Integer dezena, Integer i ->
            Integer qtd = 0
            if (i < 9) {
                dezenasEmJogo.add(new DezenasEmJogo("0" + dezena.toString(), qtd))
            } else {
                dezenasEmJogo.add(new DezenasEmJogo(dezena.toString(), qtd))
            }

        }
    }

    private List<String> montaResultadoRepeticoes(List<DezenasEmJogo> dezenasEmJogo) {
        List<String> resultado = dezenasEmJogo.collect { DezenasEmJogo resultado ->
            return resultado.toString()
        } as List<String>
        return resultado
    }
}
