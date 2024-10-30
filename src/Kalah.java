public class Kalah {
    Fazenda fazenda = new Fazenda();
    Input input = new Input();
    View visualizar = new View();
    int fazendeiro = 1;

    public static void main(String[] args) {
        Kalah kalahJogo = new Kalah();
        kalahJogo.Jogo();
    }

    private void trocarTurno(int vezFazendeiro) {
        if (vezFazendeiro == 1) {
            this.fazendeiro = 2;
        } else {
            this.fazendeiro = 1;
        }
    }

    void Jogo() {
        int acao;

        // Referente a primeira jogada possível
        if (input.iniciarJogo()) {
            fazenda.iniciarJogo();
            visualizar.vezJogador(fazendeiro);
            fazenda.distribuirSementes(input.escolherCava(fazendeiro), fazendeiro);
            trocarTurno(fazendeiro);
            input.mostrarTabuleiro(fazenda.getArrayCavas(), fazenda.getSilo1(), fazenda.getSilo2(), fazendeiro);
        }
        
        // Referente as jogadas subsequentes
        acao = input.sistemaDecisao();
        do {
            switch (acao) {
                case 1:
                    visualizar.vezJogador(fazendeiro);
                    fazenda.distribuirSementes(input.escolherCava(fazendeiro), fazendeiro);
                    input.mostrarTabuleiro(fazenda.getArrayCavas(), fazenda.getSilo1(), fazenda.getSilo2(), fazendeiro);
                    acao = input.sistemaDecisao();
                    trocarTurno(fazendeiro);
                    break;
                case 2:
                    visualizar.interromperJogo();
                    System.exit(0);
                    break;
            }
        } while (acao != 2);
    }
}