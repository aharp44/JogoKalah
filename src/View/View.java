package View;

import Model.CasaSimples;
import Model.Silo;
import Model.Turno;

import java.util.ArrayList;

public class View {
    public View() {}

    public void mostrarIniciarJogo() {
        System.out.print("Deseja iniciar jogo? (S/N): ");
    }

    public void mostrarIniciarJogoErro() {
        System.out.println("Insira S ou N apenas.");
    }

    public void escolherCasa(Turno turnoAtual) {
        if(turnoAtual == Turno.FAZENDEIRO_A){
            System.out.print("Escolha uma casa entre 0 e 5: ");
        }else{
            System.out.print("Escolha uma casa entre 6 e 11: ");
        }
    }

    public void valorInvalido() {
        System.out.println("Insira um valor numerico. ");
    }

    public void numeroInvalido(Turno turnoAtual) {
        if(turnoAtual == Turno.FAZENDEIRO_A){
            System.out.println("Insira um numero entre 0 e 5 apenas. ");
        }else{
            System.out.println("Insira um numero entre 6 e 11 apenas. ");
        }
    }

    public void acaoInvalida() {
        System.out.println("Insira um 1 ou 2 apenas.");
    }

    public void proximaAcao() {
        System.out.print("O que deseja fazer agora?\n 1 - Proxima Jogada\n 2 - Interromper Jogo\n ->  Acao: ");
    }

    public void capturarSementeCasa() {
        System.out.print(
                "De qual casa você deseja capturar as sementes adversarias?\n Requisito: A quantidade de sementes na sua casa deve ser igual a 1!");
    }

    public void casaVazia(){
        System.out.println("Escolha uma casa com 1 ou mais sementes!");
    }

    public void interromperJogo(){
        System.out.println("O jogo foi interrompido\n\n");
    }

    public void fazendeiroVencedor(int fazendeiro){
        if(fazendeiro == 1){
            System.out.println("\nO fazendeiro 1 venceu o jogo!\n\n");
        }else if(fazendeiro == 2){
            System.out.println("\nO fazendeiro 2 venceu o jogo!\n\n");
        }else{
            System.out.println("\nOcorreu um empate! Ninguém venceu o jogo.\n\n");
        }
    }

    public void fimDeJogo(int vencedor){
        System.out.println("Fim de jogo! Vencedor: ");
        // Verifica se houve empate
        if (vencedor == 0){
            System.out.print("nao ha vencedores, houve empate!");
        }else{
            System.out.print(vencedor);
        }
    }

    // Mostra visualmente qual fazendeiro ira jogar agora
    public void vezJogador(Turno turnoAtual, int rodada){
        if(turnoAtual == Turno.FAZENDEIRO_A){
            System.out.println("\nVez do Fazendeiro 1 - Rodada " + rodada);
        }else{
            System.out.println("\nVez do Fazendeiro 2 - Rodada " + rodada);
        }
    }

    // Imprime tds as casas e silos
    public void mostrarTabuleiro(ArrayList<CasaSimples> casasSimples, Silo silo1, Silo silo2, Turno turnoAtual) {
        System.out.println();

        // Parte superior - Silo do Jogador 2
        System.out.printf("         Fazendeiro 2 (Silo 2: %2d)\n", silo2.getQntSementes());
        System.out.println();

        // Índice das casas de cima (11 a 6) - Alinhado com as casas
        for (int i = 11; i > 5; i--) {
            System.out.printf("   %2d  ", i);
        }
        System.out.println();
        System.out.println("╔═════════════════════════════════════════╗");

        // Linha das casas de cima
        System.out.print("║");
        for (int i = 11; i > 5; i--) {
            System.out.printf("  %2d  ║", casasSimples.get(i).getQntSementes());
        }
        System.out.println();

        // Divisor entre as casas de cima e de baixo
        System.out.println("╠══════╬══════╬══════╬══════╬══════╬══════╣");

        // Linha das casas de baixo
        System.out.print("║");
        for (int i = 0; i < 6; i++) {
            System.out.printf("  %2d  ║", casasSimples.get(i).getQntSementes());
        }
        System.out.println();
        System.out.println("╚═════════════════════════════════════════╝");

        // Índice das casas de baixo (0 a 5) - Alinhado com as casas
        for (int i = 0; i < 6; i++) {
            System.out.printf("   %2d  ", i);
        }
        System.out.println();
        System.out.println();

        // Parte inferior - Silo do Jogador 1
        System.out.printf("         Fazendeiro 1 (Silo 1: %2d)\n", silo1.getQntSementes());
        System.out.println();
    }
}