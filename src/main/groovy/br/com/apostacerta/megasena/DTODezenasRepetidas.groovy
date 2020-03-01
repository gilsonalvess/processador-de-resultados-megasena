package br.com.apostacerta.megasena

class DTODezenasRepetidas {
    String dezena
    Integer qtdRepeticoes

    DTODezenasRepetidas(String dezena, Integer qtdRepeticoes) {
        this.dezena = dezena
        this.qtdRepeticoes = qtdRepeticoes
    }

    @Override
    public String toString() {
        return "Dezena: $dezena - Vezes que se repetiu: $qtdRepeticoes"
    }
}
