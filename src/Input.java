import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Input
{
    int cavaEscolhida;
    Scanner scanner = new Scanner(System.in);
    View view = new View();

    public Input(){}

    public boolean iniciarJogo(){
        view.mostrarIniciarJogo();
        boolean b = false;
        boolean r = false;
        String s;

        // Repete um loop ateh usuario colocar S,N,s ou n
        do{
            s = scanner.nextLine();
            if (s.equals("S") || s.equals("s")){
                b = true;
                r = true;
            } else if (s.equals("N") || s.equals("n")){
                b = true;
                view.encerrarJogo();
                System.exit(0);
            } else{
                view.mostrarIniciarJogoErro();
                view.mostrarIniciarJogo();
            }
        }while(b == false);
        return r;
    }

    // Pega qual cava foi escolhida com suas respectivas informações
    public int getCavaEscolhida(){
        return cavaEscolhida;
    }

    // Habilita ao jogador a possibilidade de escolher uma cava
    public int escolherCava(){
        view.escolherCava();
        int posicao = 0;
        boolean valido = false;
        // Repete loop ateh usuario colocar um valor entre 1 e 12
        do{
            try{
                posicao = scanner.nextInt();
                if (posicao > 0 && posicao < 13){
                    cavaEscolhida = posicao+1;
                    valido = true;
                } else{
                    view.numeroInvalido();
                }
            }
            // Printa um erro caso usuario coloque algo q n seja um int
            catch(InputMismatchException e){
                view.numeroInvalido();
            }
        }while(valido == false);
        return posicao;
    }
    
    // Puxa a funcao mostrarTabuleiro de VIEW
    public void mostrarTabuleiro(ArrayList<CavaSimples> cavasSimples, Silo silo1, Silo silo2){
        view.mostrarTabuleiro(cavasSimples, silo1, silo2);
    }

    // Exibe as opções do jogador para dar seguimento ao jogo
    public int sistemaDecisao() {
        boolean valido = false;
        int acao = 0;

        // Repete loop ateh usuario colocar um valor entre 1 e 4
        do{
            try{
                view.proximaAcao();
                acao = scanner.nextInt();
                if (acao > 0 && acao < 5){
                    valido = true;
                } else{
                    view.acaoInvalida();
                }
            }
            // Printa um erro caso usuario coloque algo q n seja um int
            catch(InputMismatchException e){
                view.acaoInvalida();
            }
        }while(valido == false);
        
        return acao;
    }
}