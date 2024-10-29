
public class CavaSimples
{

    Cava cavaCampo = new Cava();
    
    // Construtor
    public CavaSimples()
    {
        
    }
    
    // retorna a qnt de sementes da cava
    public int getQntSementes(){
        return cavaCampo.getSementes();
    }
    
    // adiciona uma quantidade de sementes
    public void addSementes(int qnt){
        cavaCampo.addSementes(qnt);
    }
    
    // remove tds as sementes da cava
    public void removerTdsSementes(){
        cavaCampo.zerarSementes();
    }
    
    

    
}
