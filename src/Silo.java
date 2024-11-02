
public class Silo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    Casa cavaCampo = new Casa();

    public Silo()
    {
        
    }
    
    // retorna a qnt de sementes
    public int getQntSementes(){
        return cavaCampo.getSementes();
    }
    
    // adiciona uma qnt de sementes
    public void addSementes(int qnt){
        cavaCampo.addSementes(qnt);
    }
    
    // remove tds as sementes da casa
    public void removerTdsSementes(){
        cavaCampo.zerarSementes();
    }
    

    
    

    
}
