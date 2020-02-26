class ComparadorDeResultados {

    private static LinkedHashMap<String, Integer> dezenasEmJogo = []

    List<String> obtenhaNumerosQueSeRepetiram(List<Resultado> resultados) {
        inicializeDezenasEmJogo()
        for (Resultado resultado in resultados) {
            for (Map.Entry<String, Integer> dezenaEmJogo in dezenasEmJogo) {
                final String dezenasResultado = resultado.dezenas.toString()

                if (dezenasResultado.find(dezenaEmJogo.key).any()) {
                    dezenaEmJogo.value++
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
                dezenasEmJogo.put("0" + dezena.toString(), qtd)
            } else {
                dezenasEmJogo.put(dezena.toString(), qtd)
            }

        }
    }

    private List<String> montaResultadoRepeticoes(LinkedHashMap<String, Integer> dezenasEmJogo) {
        List<String> resultado = dezenasEmJogo.collect { Map.Entry<String, Integer> resultado ->
            return "Dezena: ${resultado.key}  - Vezes que se repetiu: ${resultado.value}"
        } as List<String>
        return resultado
    }
}
