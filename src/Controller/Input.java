package Controller;
import java.util.Scanner;

import Model.CasaSimples;
import Model.Silo;
import View.View;

import java.util.InputMismatchException;
import java.util.ArrayList;

public class Input implements IInput{
    Scanner scanner = new Scanner(System.in);
    View view = new View();

    public boolean iniciarJogo() {
        view.mostrarIniciarJogo();
        boolean b = false;
        boolean r = false;
        String s;

        // Repete um loop ateh usuario colocar S,N,s ou n
        do {
            s = scanner.nextLine();
            if (s.equals("S") || s.equals("s")) {
                b = true;
                r = true;
            } else if (s.equals("N") || s.equals("n")) {
                b = true;
                view.interromperJogo();
                System.exit(0);
            } else {
                view.mostrarIniciarJogoErro();
                view.mostrarIniciarJogo();
            }
        } while (b == false);
        return r;
    }

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
    public int escolherCasa(int fazendeiro, ArrayList<CasaSimples> casasSimples) {
        view.escolherCasa(fazendeiro);
        int posicao = 0;

        // Repete loop ateh usuario1 colocar entre 0 e 5, ou o usuario2 colocar entre 6 e 11
        try {
            // Para a primeira inserção possível de casa escolhida
            posicao = scanner.nextInt();

            // Para uma possível segunda escolha de casa escolhida na mesma rodada
            if (fazendeiro == 1) {
                while ((posicao < 0 || posicao > 5) || (checarCasaVazia(casasSimples, posicao))) {
                    if((posicao < 0 || posicao > 5)){
                        view.numeroInvalido(fazendeiro);
                    }
                    view.escolherCasa(fazendeiro);
                    posicao = scanner.nextInt();
                }
            } else {
                while ((posicao < 6 || posicao > 11) || (checarCasaVazia(casasSimples, posicao))) {
                    if((posicao < 6 || posicao > 11)){
                        view.numeroInvalido(fazendeiro);
                    }
                    view.escolherCasa(fazendeiro);
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
    public void mostrarTabuleiro(ArrayList<CasaSimples> casasSimples, Silo silo1, Silo silo2, int fazendeiro) {
        view.mostrarTabuleiro(casasSimples, silo1, silo2, fazendeiro);
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