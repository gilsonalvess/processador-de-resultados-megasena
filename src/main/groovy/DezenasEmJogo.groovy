class DezenasEmJogo {
    String dezena
    Integer qtdRepeticoes

    DezenasEmJogo(String dezena, Integer qtdRepeticoes) {
        this.dezena = dezena
        this.qtdRepeticoes = qtdRepeticoes
    }

    @Override
    public String toString() {
        return "Dezena: $dezena - Vezes que se repetiu: $qtdRepeticoes"
    }
}
