public class Test {

    public static void main(String[] args) {

        Car gtr = new HybridCar("Nissan GTR", 25, 8, 0, 3000, 0);
        gtr.carInfo();
        gtr.startEngine();
        gtr.drive();
    }
}
