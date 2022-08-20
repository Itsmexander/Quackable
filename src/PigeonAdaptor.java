public class PigeonAdaptor implements Quackable{

    Pigeon pigeon;

    public PigeonAdaptor(Pigeon pigeon){
        this.pigeon=pigeon;
    }
    public void quack(){
        pigeon.coo();
    }
}
