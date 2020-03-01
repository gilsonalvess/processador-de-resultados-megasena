package br.com.apostacerta.megasena

class Dezenas {
    List<String> valores = []

    Dezenas(String conteudoDezenas) {
        List<String> dezenas = conteudoDezenas.tokenize('-')
        for (String dezena in dezenas) {
            this.valores.add(dezena)
        }
    }

    Dezenas(List<String> conteudoDezenas) {
        for (String dezena in conteudoDezenas) {
            this.valores.add(dezena)
        }
    }

    List<String> toList() {
        return this.toString().tokenize('-')
    }

    @Override
    String toString() {
        StringBuilder builderDezenas = new StringBuilder()
        valores.eachWithIndex { String dezena, int i ->
            i == 0 ? builderDezenas.append(dezena) : builderDezenas.append("-$dezena")
        }
        return builderDezenas.toString()
    }
}
