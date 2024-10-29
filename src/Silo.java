
public class Silo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    Cava cavaCampo = new Cava();

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
    
    // remove tds as sementes da cava
    public void removerTdsSementes(){
        cavaCampo.zerarSementes();
    }
    

    
    

    
}
