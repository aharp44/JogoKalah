package Model;
import java.util.ArrayList;

public class Fazendeiro {

    private int semsAAdicionarS1 = 0;
    private int semsAAdicionarS2 = 0;
    private boolean maisUmaJogada = false;

    public Fazendeiro() {}

    // Distribui as sementes da casa escolhida e captura-as se possivel
    @SuppressWarnings("rawtypes")
    public ArrayList distribuirSementes(int casaEscolhida, ArrayList<CasaSimples> casasSimples, int fazendeiro) {

        CasaSimples inicial = casasSimples.get(casaEscolhida);
        int casaAtual = casaEscolhida;
        boolean emSilo = false;
        semsAAdicionarS1 = 0;           // Armazena a qnt de sementes a serem adicionadas no silo 1
        semsAAdicionarS2 = 0;           // Armazena a qnt de sementes a serem adicionadas no silo 2
        maisUmaJogada = false;          // Define se o jogador podera fazer mais uma jogada ou nao

        // Distribui 1 semente em cada casa seguinte ateh o numero de sementes acabar
        for (int i=0; i < inicial.getQntSementes(); i++){
            casaAtual++;

            // Reseta a posicao qnd chega no fim das casas
            if(casaAtual == 12){
                casaAtual = 0;
            }

            // Verifica se esta ou nao em um silo
            if(casaAtual == 6 && emSilo == false && fazendeiro == 1){
                // Adiciona 1sem pro silo 1
                emSilo = true;
                semsAAdicionarS1++;
                casaAtual--;
            } else if (casaAtual == 0 && emSilo == false && fazendeiro == 2){
                // Adiciona 1sem pro silo 2
                emSilo = true;
                semsAAdicionarS2++;
                casaAtual--;
            } else{
                // Adiciona 1sem na casa atual
                emSilo = false;
                casasSimples.get(casaAtual).addSementes(1);
            }
        }
        inicial.removerTdsSementes();       // Remove tds as sementes da casa escolhida

        // Verifica se a ultima semente semeada caiu no silo
        if(emSilo == true){
            // Verifica se este silo pertence ao jogador
            if(casaAtual == 5 && fazendeiro == 1){
                // REPETE A JOGADA
                maisUmaJogada = true;
            }else if(casaAtual == -1 && fazendeiro == 2){
                maisUmaJogada = true;
            }
        }

        // Verifica se eh possivel capturar as sementes
        else if(capturarSementes(casaAtual, casasSimples, fazendeiro)){
            // Captura as sementes
            capturaDeSementes(casaAtual, casasSimples, fazendeiro);
        }

        return casasSimples;                // Retorna todo o array de casas novo
    }

    // Retorna TRUE se for possivel capturar as sementes do adversario, e captura se sim
    public boolean capturarSementes(int ultimaCasa, ArrayList<CasaSimples> casaSimples, int fazendeiro){
        boolean possivel = false;
        CasaSimples casa = casaSimples.get(ultimaCasa);

        // Verifica se a ultima casa estava vazia antes de distribuir
        if(casa.getQntSementes() == 1){
            // Verifica se a casa oposta tem pelo menos 1 semente
            if(casaSimples.get(casa.casaOposta(ultimaCasa)).getQntSementes() >= 1){
                // Verifica se a ultima casa pertence ao jogador
                if(fazendeiro == 1 && ultimaCasa >= 0 && ultimaCasa <=5){
                    possivel = true;
                } else if(fazendeiro == 2 && ultimaCasa >= 6 && ultimaCasa <=11){
                    possivel = true;
                }
            }
        }
        return possivel;
    }

    // Captura as sementes da casa e da casa oposta e joga pro silo
    public void capturaDeSementes(int casaEscolhida, ArrayList<CasaSimples> casaSimples, int fazendeiro) {
        // Pega todas as sementes da casa oposta, incluindo a da própira semeadura e joga para o silo daquele jogador que executou a jogada
        CasaSimples casa = casaSimples.get(casaEscolhida);
        CasaSimples casaAdversaria = casaSimples.get(casa.casaOposta(casaEscolhida));

        // Adiciona as sementes pro silo
        if(fazendeiro == 1){
            semsAAdicionarS1 += casa.getQntSementes() + casaAdversaria.getQntSementes();
        } else{
            semsAAdicionarS2 += casa.getQntSementes() + casaAdversaria.getQntSementes();
        }
        // Remove as sementes das casas
        casa.removerTdsSementes();
        casaAdversaria.removerTdsSementes();
    }

    // Retorna TRUE caso o jogador ganhe mais uma jogada
    public boolean getMaisUmaJogada(){
        return this.maisUmaJogada;
    }

    // Retorna TRUE caso o jogo tenha terminado
    public boolean fimDeJogo(ArrayList<CasaSimples> casasSimples){
        boolean ret = true;
        // roda as 12 casas verificando se estao tds vazias
        for(int i=0; i<=11; i++){
            if(casasSimples.get(i).getQntSementes() != 0){
                ret = false;
                break;
            }
        }
        return ret;
    }

    // Retorna qm foi o vencedor
    public int getVencedor(Silo silo1, Silo silo2){
        int ret;
        // Retorna 1 se o silo1 tiver mais sementes
        if(silo1.getQntSementes() > silo2.getQntSementes()){
            ret = 1;
        } 
        // Retorna 2 se o silo2 tiver mais sementes
        else if (silo1.getQntSementes() < silo2.getQntSementes()){
            ret = 2;
        } 
        // Retorna 0 se os 2 silos tiverem a msm qnt
        else{
            ret = 0;
        }
        return ret;
    }

    // Retorna a qnt de sementes a ser adicionado ao silo1
    public int getQntSementesAdicionaisS1(){
        return semsAAdicionarS1;
    }
    // Retorna a qnt de sementes a ser adicionado ao silo2
    public int getQntSementesAdicionaisS2(){
        return semsAAdicionarS2;
    }
}