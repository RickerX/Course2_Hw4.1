import Other.Data;
import Transport.Autosport.*;
import Transport.Car;
import Transport.Drivers.Driver;

public class Main {
    public static void separation() {
        System.out.println("=============================");
    }
    public static void main(String[] args) {
        Bus volvoBus = new Bus("", "", 0, Capacity.AVERAGE);
        Bus audiBus = new Bus("Ауди", "А2", 6,Capacity.BIG);
        Bus bmwBus = new Bus("БМВ", "А3", 7,Capacity.SMALL);
        Bus mersedesBus = new Bus("Мерседес", "А4", 5,Capacity.ESPECIALLY_SMALL);
        PassengerCars volvo = new PassengerCars("Вольво", "S 90", 2.5, TypeOfBody.SEDAN);
        PassengerCars audi = new PassengerCars("Ауди", "RS 6", 4.0,TypeOfBody.COUPE);
        PassengerCars bmw = new PassengerCars("БМВ", "M5 CS", 4.4,TypeOfBody.CROSSOVER);
        PassengerCars mersedes = new PassengerCars("Мерседес", "С 63 AMG", 6.3,TypeOfBody.MINIVAN);
        Trucks volvoTruck = new Trucks("Вольво", "Б1", 10,LoadCapacity.N1);
        Trucks audiTruck = new Trucks("Ауди", "Б2", 12,LoadCapacity.N1);
        Trucks bmwTruck = new Trucks("БМВ", "Б3", 11,LoadCapacity.N2);
        Trucks mersedesTruck = new Trucks("Мерседес", "Б4", 15,LoadCapacity.N3);
        separation();
        System.out.println(volvoBus);
        volvoBus.printType();
        System.out.println(audiBus);
        audiBus.printType();
        System.out.println(bmwBus);
        bmwBus.printType();
        System.out.println(mersedesBus);
        mersedesBus.printType();
        separation();
        System.out.println(volvoTruck);
        volvoTruck.printType();
        System.out.println(audiTruck);
        audiTruck.printType();
        System.out.println(bmwTruck);
        bmwTruck.printType();
        System.out.println(mersedesTruck);
        mersedesTruck.printType();
        separation();
        System.out.println(volvo);
        volvo.printType();
        System.out.println(audi);
        audi.printType();
        System.out.println(bmw);
        bmw.printType();
        System.out.println(mersedes);
        mersedes.printType();
        separation();
        System.out.println(mersedesBus + " лучший круг: " + mersedesBus.bestLapTime() +
                " максимальная скорость: " + mersedesBus.maxSpeed() + " " + mersedesBus.pitStop());
        System.out.println(mersedes + " лучший круг: " + mersedes.bestLapTime() +
                " максимальная скорость: " + mersedes.maxSpeed() + " " + mersedes.pitStop());
        System.out.println(mersedesTruck + " лучший круг: " + mersedesTruck.bestLapTime() +
                " максимальная скорость: " + mersedesTruck.maxSpeed() + " " + mersedesTruck.pitStop());
        separation();
        Driver<PassengerCars> artem = new Driver<>("Артем", "5", "права категории В");
        artem.driveCar(mersedes);
        Driver<Trucks> ivan = new Driver<>("Иван", "10", "права категории С");
        ivan.driveCar(volvoTruck);
        Driver<Bus> oleg = new Driver<>("Олег", "15", "права категории D");
        oleg.driveCar(mersedesBus);
        separation();
        boolean success = Data.validate("som","reka","reka");
        if (success) {
            System.out.println("Данные валидны!");
        } else {
            System.out.println("Данные не валидны!");
        }
        separation();
        service(volvo,audi,mersedes,bmw,volvoBus,audiBus,mersedesBus,bmwBus,volvoTruck,audiTruck,mersedesTruck,bmwTruck);




    }

    public static void service(Car... cars) {
        for (Car car : cars) {
            serviceCars(car);
        }

    }

    private static void serviceCars(Car car) {
        if (car.service()) {
            try {
                throw new RuntimeException("Автомобиль не прошел Т/О " + " " + car.getBrand() + " " + car.getModel());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}