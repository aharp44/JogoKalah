package View;

import java.util.ArrayList;

import Model.CasaSimples;
import Model.Silo;

public class View {
    public View() {}

    public void mostrarIniciarJogo() {
        System.out.print("Deseja iniciar jogo? (S/N): ");
    }

    public void mostrarIniciarJogoErro() {
        System.out.println("Insira S ou N apenas.");
    }

    public void escolherCasa(int faz) {
        if(faz == 1){
            System.out.print("Escolha uma casa entre 0 e 5: ");
        }else{
            System.out.print("Escolha uma casa entre 6 e 11: ");
        }
    }

    public void valorInvalido() {
        System.out.println("Insira um valor numerico. ");
    }

    public void numeroInvalido(int faz) {
        if(faz == 1){
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
    public void vezJogador(int fazendeiro, int rodada){
        if(fazendeiro == 1){
            System.out.println("\nVez do Fazendeiro 1 - Rodada " + rodada);
        }else{
            System.out.println("\nVez do Fazendeiro 2 - Rodada " + rodada);
        }
    }

    // Imprime tds as casas e silos
    public void mostrarTabuleiro(ArrayList<CasaSimples> casasSimples, Silo silo1, Silo silo2, int fazendeiro) {
        System.out.println();
        int s2 = silo2.getQntSementes();
        System.out.print("Silo 2: " + s2 + " ");
        
        for (int i = 11; i > 5; i--) {
            int c = casasSimples.get(i).getQntSementes();
            System.out.print("Casa [" + i + "]: " + c + " || ");
        }
        System.out.println();
        System.out.print("          ");
        for (int i = 0; i < 6; i++) {
            int c = casasSimples.get(i).getQntSementes();
            System.out.print("Casa [" + i + "]: " + c + " || ");
        }

        int s1 = silo1.getQntSementes();
        System.out.println("Silo 1: " + s1 + " ");
        System.out.println();
    }
}