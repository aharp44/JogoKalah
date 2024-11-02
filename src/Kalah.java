public class Kalah {
    Fazenda fazenda = new Fazenda();
    Input input = new Input();
    View visualizar = new View();
    int fazendeiro = 1;

    // A ARRUMAR AINDA:
    // - a funcao capturar sementes n ta funcionando certo qnd da a volta no tabuleiro todo, ele soma 1 a mais
    // - resolver, se der tempo, print quando seleciona uma casa vazia com 0 semente repetindo duas vezes
    //
    // - condições de fim de jogo 
    //          se o jogador da rodada atual não possuir mais nenhuma semente no seu lado, o jogador adversário deverá pegar
    //           as sementes restantes no tabuleiro e colocar no próprio silo
    //              -> Vitória: o jogador que possuir mais sementes no seu próprio silo
    //              -> Empate: A quantidade de sementes em ambos os silos é igual
    //
    // - fazer td interface visual se sobrar tempo

    public static void main(String[] args) {
        Kalah kalahJogo = new Kalah();        
        kalahJogo.Jogo();
    }

    // Verifica qual fazendeiro será o responsável por finalizar o jogo
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
            fazenda.iniciarJogo();                  // Cria 12 casas vazias e 2 silos vazios
            input.mostrarTabuleiro(fazenda.getArrayCasas(), fazenda.getSilo1(), fazenda.getSilo2(), fazendeiro);        // Imprime todo tabuleiro
            visualizar.vezJogador(fazendeiro);      // Imprime de qm eh a vez
            fazenda.distribuirSementes(input.escolherCasa(fazendeiro, fazenda.getArrayCasas()), fazendeiro);     // Distribui as sementes
            if (!fazenda.getMaisUmaJogada()){       // Verifica se o jogador nao ganhou mais uma jogada
                trocarTurno(fazendeiro);            // Troca a vez de qm esta jogando
            }
            input.mostrarTabuleiro(fazenda.getArrayCasas(), fazenda.getSilo1(), fazenda.getSilo2(), fazendeiro);        // Imprime todo tabuleiro
        }
        
        // Referente as jogadas subsequentes
        acao = input.sistemaDecisao();
        do {
            switch (acao) {
                case 1:
                    visualizar.vezJogador(fazendeiro);
                    fazenda.distribuirSementes(input.escolherCasa(fazendeiro, fazenda.getArrayCasas()), fazendeiro);
                    input.mostrarTabuleiro(fazenda.getArrayCasas(), fazenda.getSilo1(), fazenda.getSilo2(), fazendeiro);
                    // Verifica se o jogo acabou
                    if(fazenda.fimDeJogo()){
                        visualizar.fimDeJogo(fazenda.getVencedor());
                    } else{
                        acao = input.sistemaDecisao();
                        if(!fazenda.getMaisUmaJogada()){        // Verifica se o jogador nao ganhou mais uma jogada
                            trocarTurno(fazendeiro);            // Troca o turno do jogador
                        }
                    }
                    break;
                case 2:
                    visualizar.interromperJogo();
                    System.exit(0);
                    break;
            }
        } while (acao != 2);
    }
}