public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        //AbstractDuckFactory duckFactory = new CountingDuckFactory();  //สำหรับ test Abstract CounterDuckFactory
        //AbstractDuckFactory duckFactory = new CounterEchoDuckFactory();
        //simulator.simulate(duckFactory);
        simulator.simulateCompositeLeader();
    }
    void simulate(AbstractDuckFactory duckFactory){
        //Quackable mallardDuck =new QuackCounter(new QuackEcho(new MallardDuck())) ;
        //Quackable redHeadDuck =new QuackCounter (new QuackEcho(new RedheadDuck()));    ตรงนี้สำหรับการรันส่วน Decorator
        //Quackable duckCall = new QuackCounter(new QuackEcho(new DuckCall()));
        //Quackable rubberDuck = new QuackCounter(new QuackEcho(new RubberDuck())) ;
        //Quackable gooseDuck = new GooseAdapter(new Goose());
        //Quackable pigeon = new PigeonAdapter(new Pigeon());
        //Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckcall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator : With Composite - Flocks");

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redHeadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);
        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);


        //simulate(mallardDuck);
        //simulate(redHeadDuck);
        //simulate(duckCall);
        //simulate(rubberDuck);
        //simulate(gooseDuck);
        //simulate(pigeon);

        System.out.println("The ducks quacked "+ QuackCounter.getQuacks() + " times");

    }
    private void simulateCompositeLeader() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckcall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        LeaderFlock flock = new LeaderFlock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);

        flock.quack();
    }

    void simulate(Quackable duck){
        duck.quack();
    }
}
