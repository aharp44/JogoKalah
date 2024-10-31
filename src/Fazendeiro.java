import java.util.ArrayList;

public class Fazendeiro {

    private int semsAAdicionarS1 = 0;
    private int semsAAdicionarS2 = 0;
    private boolean maisUmaJogada = false;

    public Fazendeiro() {
        
    }

    // Distribui as sementes da cava escolhida e captura-as se possivel
    @SuppressWarnings("rawtypes")
    public ArrayList distribuirSementes(int cavaEscolhida, ArrayList<CavaSimples> cavasSimples, int fazendeiro) {

        CavaSimples inicial = cavasSimples.get(cavaEscolhida);
        int cavaAtual = cavaEscolhida;
        boolean emSilo = false;
        semsAAdicionarS1 = 0;           // Armazena a qnt de sementes a serem adicionadas no silo 1
        semsAAdicionarS2 = 0;           // Armazena a qnt de sementes a serem adicionadas no silo 2
        maisUmaJogada = false;          // Define se o jogador podera fazer mais uma jogada ou nao

        // Distribui 1 semente em cada cava seguinte ateh o numero de sementes acabar
        for (int i=0; i < inicial.getQntSementes(); i++){
            cavaAtual++;
            // System.out.println("add em silo 1: " + semsAAdicionarS1);
            // System.out.println("add em silo 2: " + semsAAdicionarS2);

            // Reseta a posicao qnd chega no fim das cavas
            if(cavaAtual == 12){
                cavaAtual = 0;
            }

            // Verifica se esta ou nao em um silo
            if(cavaAtual == 6 && emSilo == false && fazendeiro == 1){
                // Adiciona 1sem pro silo 1
                emSilo = true;
                semsAAdicionarS1++;
                System.out.println("DO FOR semsAAdd1: " + semsAAdicionarS1);
                cavaAtual--;
            } else if (cavaAtual == 0 && emSilo == false && fazendeiro == 2){
                // Adiciona 1sem pro silo 2
                emSilo = true;
                semsAAdicionarS2++;
                System.out.println("DO FOR semsAAdd2: " + semsAAdicionarS2);
                cavaAtual--;
            } else{
                // Adiciona 1sem na cava atual
                emSilo = false;
                cavasSimples.get(cavaAtual).addSementes(1);
            }
        }
        inicial.removerTdsSementes();       // Remove tds as sementes da cava escolhida

        // Verifica se a ultima semente semeada caiu no silo
        if(emSilo == true){
            // Verifica se este silo pertence ao jogador
            if(cavaAtual == 5 && fazendeiro == 1){
                // REPETE A JOGADA
                maisUmaJogada = true;
            }else if(cavaAtual == -1 && fazendeiro == 2){
                maisUmaJogada = true;
            }
        }

        // Verifica se eh possivel capturar as sementes
        else if(capturarSementes(cavaAtual, cavasSimples, fazendeiro)){
            // Captura as sementes
            System.out.println("CAPTURANDO AS SEMENTES");
            capturaDeSementes(cavaAtual, cavasSimples, fazendeiro);
        }

        return cavasSimples;                // Retorna todo o array de cavas novo
    }

    // Retorna TRUE se for possivel capturar as sementes do adversario, e captura se sim
    public boolean capturarSementes(int ultimaCava, ArrayList<CavaSimples> cavaSimples, int fazendeiro){
        boolean possivel = false;
        CavaSimples cava = cavaSimples.get(ultimaCava);

        System.out.println("ultima cava: " + ultimaCava);
        // Verifica se a ultima cava estava vazia antes de distribuir
        if(cava.getQntSementes() == 1){
            System.out.println("ultima cava tem 1 semente");
            // Verifica se a cava oposta tem pelo menos 1 semente
            if(cavaSimples.get(cava.cavaOposta(ultimaCava)).getQntSementes() >= 1){
                System.out.println("cava oposta eh a cava " + cava.cavaOposta(ultimaCava));
                System.out.println("cava oposta possui " + cavaSimples.get(cava.cavaOposta(ultimaCava)).getQntSementes() + " sementes");
                // Verifica se a ultima cava pertence ao jogador
                if(fazendeiro == 1 && ultimaCava >= 0 && ultimaCava <=5){
                    possivel = true;
                } else if(fazendeiro == 2 && ultimaCava >= 6 && ultimaCava <=11){
                    possivel = true;
                }
            }
        }
        return possivel;
    }

    // Captura as sementes da cava e da cava oposta e joga pro silo
    public void capturaDeSementes(int cavaEscolhida, ArrayList<CavaSimples> cavaSimples, int fazendeiro) {
        // Pega todas as sementes da casa oposta, incluindo a da própira semeadura e joga para o silo daquele jogador que executou a jogada
        CavaSimples cava = cavaSimples.get(cavaEscolhida);
        CavaSimples cavaAdversaria = cavaSimples.get(cava.cavaOposta(cavaEscolhida));

        // Adiciona as sementes pro silo
        if(fazendeiro == 1){
            System.out.println("ANTES semsAAdd1: " + semsAAdicionarS1);
            System.out.println("cava: " + cava.getQntSementes() + " cavaAdv: " + cava.getQntSementes());
            semsAAdicionarS1 += cava.getQntSementes() + cavaAdversaria.getQntSementes();
            System.out.println("DEPOIS semsAAdd1: " + semsAAdicionarS1);
        } else{
            System.out.println("ANTES semsAAdd2: " + semsAAdicionarS2);
            System.out.println("cava: " + cava.getQntSementes() + " cavaAdv: " + cava.getQntSementes());
            semsAAdicionarS2 += cava.getQntSementes() + cavaAdversaria.getQntSementes();
            System.out.println("DEPOIS semsAAdd2: " + semsAAdicionarS2);
        }
        // Remove as sementes das cavas
        cava.removerTdsSementes();
        cavaAdversaria.removerTdsSementes();
    }

    // Retorna TRUE caso o jogador ganhe mais uma jogada
    public boolean getMaisUmaJogada(){
        return this.maisUmaJogada;
    }

    // Retorna TRUE caso o jogo tenha terminado
    public boolean fimDeJogo(ArrayList<CavaSimples> cavasSimples){
        boolean ret = true;
        // roda as 12 cavas verificando se estao tds vazias
        for(int i=0; i<=11; i++){
            if(cavasSimples.get(i).getQntSementes() != 0){
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