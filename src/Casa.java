public class Casa
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int campo;

    public Casa()
    {
        campo = 0;
    }

    public void addSementes(int qnt){
        campo += qnt;
    }
    
    public void zerarSementes(){
        campo = 0;
    }
    
    public int getSementes(){
        return campo;
    }
}
