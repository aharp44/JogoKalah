package Model;
public class CasaSimples implements ICasaSimples
{
    Casa casaCampo = new Casa();
    
    // retorna a qnt de sementes da casa
    public int getQntSementes(){
        return casaCampo.getSementes();
    }
    
    // adiciona uma quantidade de sementes
    public void addSementes(int qnt){
        casaCampo.addSementes(qnt);
    }
    
    // remove tds as sementes da casa
    public void removerTdsSementes(){
        casaCampo.zerarSementes();
    }

    // Mostra qual o índice da casa oposta
    public int casaOposta(int id){
        int idOposta = 0;

        // Mapeamento dos opostos
        switch(id){
            case 0: idOposta = 11; break;
            case 1: idOposta = 10; break;
            case 2: idOposta = 9; break;
            case 3: idOposta = 8; break;
            case 4: idOposta = 7; break;
            case 5: idOposta = 6; break;
            case 6: idOposta = 5; break;
            case 7: idOposta = 4; break;
            case 8: idOposta = 3; break;
            case 9: idOposta = 2; break;
            case 10: idOposta = 1; break;
            case 11: idOposta = 0; break;
        }
        return idOposta;
    }
}