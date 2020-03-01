package br.com.apostacerta.megasena

class DezenasParaJogo {
    String dezena
    Integer qtdRepeticoes

    DezenasParaJogo(String dezena, Integer qtdRepeticoes) {
        this.dezena = dezena
        this.qtdRepeticoes = qtdRepeticoes
    }

    @Override
    public String toString() {
        return "Dezena: $dezena - Vezes que se repetiu: $qtdRepeticoes"
    }
}
