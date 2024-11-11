package Model;

public class Casa{
    protected int campo;

    public Casa(int campo)
    {
        this.campo = campo;
    }
    
    public void zerarSementes(){
        campo = 0;
    }
    
    public int getQntSementes(){
        return campo;
    }
}