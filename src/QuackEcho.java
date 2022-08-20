public class QuackEcho implements Quackable{

    Quackable duck;

    public QuackEcho(Quackable duck){
        this.duck=duck;
    }

    public void quack() {
        duck.quack();
        System.out.println("Echo : \n");
        duck.quack();
        System.out.println("\n");
    }
}
