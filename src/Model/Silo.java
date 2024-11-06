package Model;
public class Silo extends Casa implements ISilo{
    public Silo(){
        super(0);
    }
    
    // adiciona uma qnt de sementes
    public void addSementes(int qnt){
        campo += qnt;
    }
}