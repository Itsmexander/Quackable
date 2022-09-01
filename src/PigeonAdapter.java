public class PigeonAdapter implements Quackable {
    Pigeon pigeon;

    public PigeonAdapter (Pigeon pigeon){
        this.pigeon = pigeon;
    }
    public void quack(){
        pigeon.coo();
        pigeon.coo();
    }
}
