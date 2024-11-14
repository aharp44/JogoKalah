package Controller;

import Model.CasaSimples;
import Model.Silo;
import Model.Turno;
import View.View;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Input implements IInput{
    Scanner scanner = new Scanner(System.in);
    View view = new View();

    // Verifica se a casa escolhida possui alguma semente em si
    public boolean checarCasaVazia(ArrayList<CasaSimples> casasSimples, int posicao) {
        CasaSimples casa = casasSimples.get(posicao);
        boolean vazia = casa.getQntSementes() <= 0;

        if (vazia) {
            view.casaVazia();
        }

        return vazia;
    }

    // Habilita ao jogador a possibilidade de escolher uma casa
    public int escolherCasa(Turno turnoAtual, ArrayList<CasaSimples> casasSimples) {
        view.escolherCasa(turnoAtual);
        int posicao = 0;

        // Repete loop ateh usuario1 colocar entre 0 e 5, ou o usuario2 colocar entre 6 e 11
        try {
            // Para a primeira inserção possível de casa escolhida
            posicao = scanner.nextInt();

            // Para uma possível segunda escolha de casa escolhida na mesma rodada
            if (turnoAtual == Turno.FAZENDEIRO_A) {
                while ((posicao < 0 || posicao > 5) || (checarCasaVazia(casasSimples, posicao))) {
                    if((posicao < 0 || posicao > 5)){
                        view.numeroInvalido(turnoAtual);
                    }
                    view.escolherCasa(turnoAtual);
                    posicao = scanner.nextInt();
                }
            } else {
                while ((posicao < 6 || posicao > 11) || (checarCasaVazia(casasSimples, posicao))) {
                    if((posicao < 6 || posicao > 11)){
                        view.numeroInvalido(turnoAtual);
                    }
                    view.escolherCasa(turnoAtual);
                    posicao = scanner.nextInt();
                }
            }
        }

        // Printa um erro caso usuario coloque algo q n seja um int
        catch (InputMismatchException e) {
            view.valorInvalido();
        }
        return posicao;
    }

    // Puxa a funcao mostrarTabuleiro de VIEW
    public void mostrarTabuleiro(ArrayList<CasaSimples> casasSimples, Silo silo1, Silo silo2, Turno turnoAtual) {
        view.mostrarTabuleiro(casasSimples, silo1, silo2, turnoAtual);
    }

    // Exibe as opções do jogador para dar seguimento ao jogo
    public int sistemaDecisao() {
        boolean valido = false;
        int acao = 0;

        // Repete loop ateh usuario colocar um valor entre 1 e 2
        do {
            try {
                view.proximaAcao();
                acao = scanner.nextInt();
                if (acao > 0 && acao < 3) {
                    valido = true;
                } else {
                    view.acaoInvalida();
                }
            }
            // Printa um erro caso usuario coloque algo q n seja um int
            catch (InputMismatchException e) {
                view.acaoInvalida();
            }
        } while (valido == false);

        return acao;
    }
}