import java.util.ArrayList;

import Controller.Input;
import Controller.IInput;
import Model.CasaSimples;
import Model.Fazenda;
import Model.Silo;
import Model.Turno;
import Tests.Teste;
import Tests.ITestes;
import View.View;


public class Kalah {
    Fazenda fazenda = new Fazenda();
    IInput input = new Input();
    View visualizar = new View();
    ITestes testes = new Teste();
    int fazendeiro = 1, rodada = 1;
    Turno turnoAtual = Turno.FAZENDEIRO_A;

    public static void main(String[] args) {
        Kalah kalahJogo = new Kalah();        
        kalahJogo.Jogo();
    }

    // Verifica qual fazendeiro será o responsável por finalizar o jogo
    // private void trocarTurno(int vezFazendeiro) {
    //     if (vezFazendeiro == 1) {
    //         this.fazendeiro = 2;
    //     } else {
    //         this.fazendeiro = 1;
    //     }
    // }

    // Determina qual o vencedor do jogo seguindo as regras padrões
    boolean jogoAcabou = false;
    private void fimDeJogo(ArrayList<CasaSimples> ListCasasSimples, Turno turnoRecebido, Silo silo1, Silo silo2){
        // Ver qual fazendeiro vai jogar agora e Verificar lado do tabuleiro deste fazendeiro
        if(turnoRecebido == Turno.FAZENDEIRO_A){
            // Verifica lado do fazendeiro 1 se ainda há alguma semente
            for(int i = 0; i <= 5; i++){
                CasaSimples casaAtual = ListCasasSimples.get(i);
                if(casaAtual.getQntSementes() != 0) return;
            }

            // Se as sementes deste lado acabarem, jogam-se as sementes restantes do lado oposto no silo adversário
            CasaSimples casaAtual;
            int sementesRestantes;
            for(int i = 6; i <= 11; i++){
                casaAtual = ListCasasSimples.get(i);
                sementesRestantes = casaAtual.getQntSementes();
                silo2.addSementes(sementesRestantes);
            }

        }else{
            // Verifica lado do fazendeiro 2 se ainda há alguma semente
            for(int i = 6; i <= 11; i++){
                CasaSimples casaAtual = ListCasasSimples.get(i);
                if(casaAtual.getQntSementes() != 0) return;
            }

            // Se as sementes deste lado acabarem, jogam-se as sementes restantes do lado oposto no silo adversário
            CasaSimples casaAtual;
            int sementesRestantes;
            for(int i = 0; i <= 5; i++){
                casaAtual = ListCasasSimples.get(i);
                sementesRestantes = casaAtual.getQntSementes();
                silo1.addSementes(sementesRestantes);
            }
        }

        visualizar.mostrarTabuleiro(ListCasasSimples, silo1, silo2, turnoRecebido);
        visualizar.fazendeiroVencedor(fazenda.getVencedor());


        jogoAcabou = true;
    }

    void Jogo() {

        int acao;

        // Referente a primeira jogada possível
        fazenda.iniciarJogo();                  // Cria 12 casas vazias e 2 silos vazios
        input.mostrarTabuleiro(fazenda.getArrayCasas(), fazenda.getSilo1(), fazenda.getSilo2(), turnoAtual);        // Imprime todo tabuleiro
        visualizar.vezJogador(turnoAtual, rodada);      // Imprime de qm eh a vez
        fazenda.distribuirSementes(input.escolherCasa(turnoAtual, fazenda.getArrayCasas()), turnoAtual);     // Distribui as sementes
        if (!fazenda.getMaisUmaJogada()){       // Verifica se o jogador nao ganhou mais uma jogada
            turnoAtual = turnoAtual.alternarTurno();            // Troca a vez de qm esta jogando
        }
        input.mostrarTabuleiro(fazenda.getArrayCasas(), fazenda.getSilo1(), fazenda.getSilo2(), turnoAtual);        // Imprime todo tabuleiro
        rodada++;
        
        // Referente as jogadas subsequentes
        acao = input.sistemaDecisao();
        do {
            switch (acao) {
                case 1:
                    visualizar.vezJogador(turnoAtual, rodada);
                    fazenda.distribuirSementes(input.escolherCasa(turnoAtual, fazenda.getArrayCasas()), turnoAtual);
                    input.mostrarTabuleiro(fazenda.getArrayCasas(), fazenda.getSilo1(), fazenda.getSilo2(), turnoAtual);
                    rodada++;

                    // Verifica se o jogo acabou ou se dá continuidade ao mesmo
                    fimDeJogo(fazenda.getArrayCasas(), turnoAtual, fazenda.getSilo1(), fazenda.getSilo2());
                    if(jogoAcabou){
                        acao = 2;
                    } else{
                        acao = input.sistemaDecisao();
                        if(!fazenda.getMaisUmaJogada()){        // Verifica se o jogador nao ganhou mais uma jogada
                            turnoAtual = turnoAtual.alternarTurno();            // Troca o turno do jogador
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