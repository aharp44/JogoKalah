import java.util.ArrayList;

import Controller.Input;
import Controller.IInput;
import Model.CasaSimples;
import Model.Fazenda;
import Model.Silo;
import View.View;

public class Kalah {
    Fazenda fazenda = new Fazenda();
    IInput input = new Input();
    View visualizar = new View();
    int fazendeiro = 1, rodada = 1;

    // A ARRUMAR AINDA:
    // - fazer td interface visual

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

    // Determina qual o vencedor do jogo seguindo as regras padrões
    boolean jogoAcabou = false;
    private void fimDeJogo(ArrayList<CasaSimples> casasSimples, int vezFazendeiro, Silo silo1, Silo silo2){
        // Ver qual fazendeiro vai jogar agora e Verificar lado do tabuleiro deste fazendeiro
        if(vezFazendeiro == 1){
            // Verifica lado do fazendeiro 1 se ainda há alguma semente
            for(int i = 0; i <= 5; i++){
                CasaSimples casaAtual = casasSimples.get(i);
                if(casaAtual.getQntSementes() != 0) return;
            }

            // Se as sementes deste lado acabarem, jogam-se as sementes restantes do lado oposto no silo adversário
            CasaSimples casaAtual;
            int sementesRestantes;
            for(int i = 6; i <= 11; i++){
                casaAtual = casasSimples.get(i);
                sementesRestantes = casaAtual.getQntSementes();
                silo2.addSementes(sementesRestantes);
            }

        }else{
            // Verifica lado do fazendeiro 2 se ainda há alguma semente
            for(int i = 6; i <= 11; i++){
                CasaSimples casaAtual = casasSimples.get(i);
                if(casaAtual.getQntSementes() != 0) return;
            }

            // Se as sementes deste lado acabarem, jogam-se as sementes restantes do lado oposto no silo adversário
            CasaSimples casaAtual;
            int sementesRestantes;
            for(int i = 0; i <= 5; i++){
                casaAtual = casasSimples.get(i);
                sementesRestantes = casaAtual.getQntSementes();
                silo1.addSementes(sementesRestantes);
            }
        }

        // Decide qual jogador venceu o jogo
        if(silo1.getQntSementes() > silo2.getQntSementes()){
            visualizar.fazendeiroVencedor(1);
        }else if(silo2.getQntSementes() > silo1.getQntSementes()){
            visualizar.fazendeiroVencedor(2);
        }else{
            visualizar.fazendeiroVencedor(0);
        }

        jogoAcabou = true;
    }

    void Jogo() {
        int acao;

        // Referente a primeira jogada possível
        if (input.iniciarJogo()) {
            fazenda.iniciarJogo();                  // Cria 12 casas vazias e 2 silos vazios
            input.mostrarTabuleiro(fazenda.getArrayCasas(), fazenda.getSilo1(), fazenda.getSilo2(), fazendeiro);        // Imprime todo tabuleiro
            visualizar.vezJogador(fazendeiro, rodada);      // Imprime de qm eh a vez
            fazenda.distribuirSementes(input.escolherCasa(fazendeiro, fazenda.getArrayCasas()), fazendeiro);     // Distribui as sementes
            if (!fazenda.getMaisUmaJogada()){       // Verifica se o jogador nao ganhou mais uma jogada
                trocarTurno(fazendeiro);            // Troca a vez de qm esta jogando
            }
            input.mostrarTabuleiro(fazenda.getArrayCasas(), fazenda.getSilo1(), fazenda.getSilo2(), fazendeiro);        // Imprime todo tabuleiro
        }
        rodada++;
        
        // Referente as jogadas subsequentes
        acao = input.sistemaDecisao();
        do {
            switch (acao) {
                case 1:
                    visualizar.vezJogador(fazendeiro, rodada);
                    fazenda.distribuirSementes(input.escolherCasa(fazendeiro, fazenda.getArrayCasas()), fazendeiro);
                    input.mostrarTabuleiro(fazenda.getArrayCasas(), fazenda.getSilo1(), fazenda.getSilo2(), fazendeiro);
                    rodada++;

                    // Verifica se o jogo acabou ou se dá continuidade ao mesmo
                    fimDeJogo(fazenda.getArrayCasas(), fazendeiro, fazenda.getSilo1(), fazenda.getSilo2());
                    if(jogoAcabou){
                        acao = 2;
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