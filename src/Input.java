import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Input {
    int cavaEscolhida;
    Scanner scanner = new Scanner(System.in);
    View view = new View();

    public Input() {
    }

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

    // Pega qual cava foi escolhida com suas respectivas informações
    public int getCavaEscolhida() {
        return cavaEscolhida;
    }

    // Habilita ao jogador a possibilidade de escolher uma cava
    public int escolherCava(int fazendeiro) {
        view.escolherCava();
        int posicao = 0;

        // Repete loop ateh usuario colocar um valor entre 0 e 11
        try {
            posicao = scanner.nextInt();
            if (fazendeiro == 1) {
                while (posicao < 0 || posicao > 5) {
                    view.numeroInvalidoFazendeiro1();
                    view.escolherCava();
                    posicao = scanner.nextInt();
                }
            } else {
                while (posicao < 6 || posicao > 11) {
                    view.numeroInvalidoFazendeiro2();
                    view.escolherCava();
                    posicao = scanner.nextInt();

                }
            }
        }

        // Printa um erro caso usuario coloque algo q n seja um int
        catch (InputMismatchException e) {
            view.numeroInvalido();
        }
        return posicao;
    }

    // Puxa a funcao mostrarTabuleiro de VIEW
    public void mostrarTabuleiro(ArrayList<CavaSimples> cavasSimples, Silo silo1, Silo silo2, int fazendeiro) {
        view.mostrarTabuleiro(cavasSimples, silo1, silo2, fazendeiro);
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