class Dezenas {
    String dezena01
    String dezena02
    String dezena03
    String dezena04
    String dezena05
    String dezena06

    Dezenas(String conteudoDezenas) {
        List<String> dezenas = conteudoDezenas.tokenize('-')
        this.dezena01 = dezenas.get(0)
        this.dezena02 = dezenas.get(1)
        this.dezena03 = dezenas.get(2)
        this.dezena04 = dezenas.get(3)
        this.dezena05 = dezenas.get(4)
        this.dezena06 = dezenas.get(5)
    }

    List<String> toList() {
        return this.toString().tokenize('-')
    }

    @Override
    String toString() {
        return "$dezena01-$dezena02-$dezena03-$dezena04-$dezena05-$dezena06"
    }
}
