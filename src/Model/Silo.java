package Model;
public class Silo implements ISilo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    Casa casaCampo = new Casa();
    
    // retorna a qnt de sementes
    public int getQntSementes(){
        return casaCampo.getSementes();
    }
    
    // adiciona uma qnt de sementes
    public void addSementes(int qnt){
        casaCampo.addSementes(qnt);
    }
    
    // remove tds as sementes da casa
    public void removerTdsSementes(){
        casaCampo.zerarSementes();
    }
}