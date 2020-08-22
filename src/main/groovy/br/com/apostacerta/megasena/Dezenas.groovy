package br.com.apostacerta.megasena

class Dezenas {
    List<String> valores = []
    Integer qtdImpares = 0
    Integer qtdPares = 0

    Dezenas(String conteudoDezenas) {
        List<String> dezenas = conteudoDezenas.tokenize('-').sort()
        for (String dezena in dezenas) {
            (dezena as Integer) % 2 == 0 ? this.qtdPares++ : this.qtdImpares++
            this.valores.add(dezena)
        }
    }

    Dezenas(List<String> conteudoDezenas) {
        for (String dezena in conteudoDezenas) {
            (dezena as Integer) % 2 == 0 ? this.qtdPares++ : this.qtdImpares++
            this.valores.add(dezena)
        }
    }

    List<String> toList() {
        return this.toString().tokenize('-').sort()
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
