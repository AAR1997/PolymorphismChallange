import java.util.Scanner;

public class Car {

    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println(description + "'s Engine is Staring");
    }

    public void drive() {
        runEngine();
        System.out.println("You now Driving the" + description);
    }

    protected void runEngine() {
        System.out.println("The Engine is Running");
    }

    public void carInfo() {
        System.out.println("Name : " + description);
    }
}

class GasPoweredCar extends Car {

    private double avgKmPerLiter;
    private int cylinders;
    private int gasLevel;
    private int addGas;
    private boolean isReady;

    public GasPoweredCar(String description, double avgKmPerLiter, int cylinders, int gasLevel) {

        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
        this.cylinders = cylinders;
        this.gasLevel = (gasLevel > 0 && gasLevel <= 100) ? gasLevel : 0;
    }

    public void carInfo() {
        super.carInfo();
        System.out.printf("Mileage : %f%nNumber of Cylinders : %d%nGas Level : %d%n", avgKmPerLiter, cylinders, gasLevel);
    }

    @Override
    public void startEngine() {

        if(gasLevel == 0) {
            Scanner s = new Scanner(System.in);

            do {
                System.out.println("Add some gas to start");
                addGas = Integer.parseInt(s.nextLine());
            } while(addGas <= 0 || addGas > 100);

            gasLevel += addGas;
            isReady = (gasLevel > 0 && gasLevel <= 100);

        } else if(gasLevel > 0) {
            isReady = true;
        }
    }

    public void drive() {
        if(isReady) {
            super.drive();
        } else {
            System.out.println("The car has some problem");
        }
    }
}

class ElectricCar extends Car {

    private double avgKmPerCharge;
    private int batterySize;

    private int chargeLevel;
    private int addCharge;
    private boolean isReady;


    public ElectricCar(String description, double avgKmPerCharge, int batterySize, int chargeLevel) {

        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
        this.chargeLevel = (chargeLevel > 0 && chargeLevel <= 100) ? chargeLevel : 0;
    }

    public void carInfo() {
        super.carInfo();
        System.out.printf("Mileage : %f%nBattery Size : %d%nCharge Level : %d%n", avgKmPerCharge, batterySize, chargeLevel);
    }

    public void startEngine() {

        if(chargeLevel == 0) {
            Scanner s = new Scanner(System.in);

            do {
                System.out.println("Add some Charge to start");
                addCharge = Integer.parseInt(s.nextLine());
            } while(addCharge <= 0 || addCharge > 100);
            chargeLevel += addCharge;
            isReady = (chargeLevel > 0 && chargeLevel <= 100);

        } else if(chargeLevel > 0) {
            isReady = true;
        }
    }

    public void drive() {
        if(isReady) {
            super.drive();
        } else {
            System.out.println("The car has some problem");
        }
    }
}

class HybridCar extends Car {

    private double avgKmPerLiter;
    private int cylinders;
    private int gasLevel;
    private int addGas;
    private int batterySize;
    private int chargeLevel;
    private int addCharge;
    private boolean isReady;

    public HybridCar(String description, double avgKmPerLiter, int cylinders, int gasLevel, int batterySize, int chargeLevel) {

        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
        this.cylinders = cylinders;
        this.gasLevel = (gasLevel > 0 && gasLevel <= 100) ? gasLevel : 0;
        this.batterySize = batterySize;
        this.chargeLevel = (chargeLevel > 0 && chargeLevel <= 100) ? chargeLevel : 0;
    }

    public void carInfo() {
        super.carInfo();
        System.out.printf("Mileage : %f%nBattery Size : %d%nCharge Level : %d%nGas Level : %d%nNumber of Cylinders : %d%n", avgKmPerLiter, batterySize, chargeLevel, gasLevel, cylinders);
    }

    public void startEngine() {

        if(gasLevel == 0 && chargeLevel == 0) {
            Scanner s = new Scanner(System.in);

            do {
                System.out.println("Add some Gas or Add some Charge to start");
                System.out.println("Gas Amount");
                addGas = Integer.parseInt(s.nextLine());
                System.out.println("Charge Amount");
                addCharge = Integer.parseInt(s.nextLine());
            } while((addGas <= 0 || addGas > 100) && (addCharge <= 0 || addCharge > 100));

            gasLevel += addGas;
            chargeLevel += addCharge;
            isReady = ((gasLevel > 0 && gasLevel <= 100) || (chargeLevel > 0 && chargeLevel <= 100));

        } else if(gasLevel > 0 || chargeLevel > 0) {
            isReady = true;
        }
    }

    public void drive() {
        if(isReady) {
            super.drive();
        } else {
            System.out.println("The car has some problem");
        }
    }
}