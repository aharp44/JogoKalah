public class Kalah {
    Fazenda fazenda = new Fazenda();
    Input input = new Input();
    View visualizar = new View();

    public static void main(String[] args) {
        Kalah kalahJogo = new Kalah();
        kalahJogo.Jogo();
    }

    void Jogo() {
        int acao;

        // Referente a primeira jogada possível
        if (input.iniciarJogo()) {
            fazenda.iniciarJogo();
            fazenda.distribuirSementes(input.escolherCava());
        }

        // Referente as jogadas subsequentes
        input.mostrarTabuleiro(fazenda.getArrayCavas(), fazenda.getSilo1(), fazenda.getSilo2());
        acao = input.sistemaDecisao();
        switch(acao){
            case 1: input.escolherCava(); break;
            //case 2: implementar exibição do capturar sementes, sistema já está pronto
            case 3: visualizar.mostrarTabuleiro(fazenda.getArrayCavas(), fazenda.getSilo1(), fazenda.getSilo2()); break;
            case 4: visualizar.encerrarJogo(); System.exit(0); break;
        }
    }
}