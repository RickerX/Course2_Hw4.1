import Other.Data;
import Transport.Autosport.*;
import Transport.Car;
import Transport.Drivers.Driver;
import Transport.Mechanic;
import Transport.ServiceStation;
import Transport.Sponsor;

import java.util.*;

public class Main {

    private static final List<String> NAMES = List.of("Иван","Марат","Геннадий","Роман","Алексей","Ислам","Андрей","Лиза","Семен","Олег","Евгений","Даниил","Дмитрий");
    private static final Random RANDOM = new Random();
    private static final int MAX_SIZE = 5;
    public static void separation() {
        System.out.println("=============================");
    }
    public static void main(String[] args) {
        Mechanic<PassengerCars> gena = new Mechanic<>("Гена", "Иванов", "Вольво-моторс");
        Mechanic<PassengerCars> dima = new Mechanic<>("Дима", "Иванов", "Вольво-bus");
        Mechanic<PassengerCars> timur = new Mechanic<>("Тимур", "Иванов", "Вольво-truck");
        Sponsor bernard = new Sponsor("Бернард", 10_000);
        Sponsor gazprom = new Sponsor("Газпром", 10_000_000);
        Bus volvoBus = new Bus("Вольво", "А1", 5.5, Capacity.AVERAGE);
        volvoBus.addDriver(new Driver<>("Олег", "15", "права категории D"));
        volvoBus.addMechanic(dima);
        volvoBus.addSponsor(bernard,gazprom);
        Bus audiBus = new Bus("Ауди", "А2", 6,Capacity.BIG);
        Bus bmwBus = new Bus("БМВ", "А3", 7,Capacity.SMALL);
        Bus mersedesBus = new Bus("Мерседес", "А4", 5,Capacity.ESPECIALLY_SMALL);
        PassengerCars volvo = new PassengerCars("Вольво", "S 90", 2.5, TypeOfBody.SEDAN);
        volvo.addDriver(new Driver<>("Артем", "5", "права категории В"));
        volvo.addMechanic(gena);
        volvo.addSponsor(bernard);
        PassengerCars audi = new PassengerCars("Ауди", "RS 6", 4.0,TypeOfBody.COUPE);
        PassengerCars bmw = new PassengerCars("БМВ", "M5 CS", 4.4,TypeOfBody.CROSSOVER);
        PassengerCars mersedes = new PassengerCars("Мерседес", "С 63 AMG", 6.3,TypeOfBody.MINIVAN);
        Trucks volvoTruck = new Trucks("Вольво", "Б1", 10,LoadCapacity.N1);
        volvoTruck.addDriver(new Driver<>("Иван", "10", "права категории С"));
        volvoTruck.addMechanic(timur);
        volvoTruck.addSponsor(bernard,gazprom);
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
//        Driver<PassengerCars> artem = new Driver<>("Артем", "5", "права категории В");
//        artem.driveCar(mersedes);
//        Driver<Trucks> ivan = new Driver<>("Иван", "10", "права категории С");
//        ivan.driveCar(volvoTruck);
//        Driver<Bus> oleg = new Driver<>("Олег", "15", "права категории D");
//        oleg.driveCar(mersedesBus);
        separation();
        boolean success = Data.validate("som","reka","reka");
        if (success) {
            System.out.println("Данные валидны!");
        } else {
            System.out.println("Данные не валидны!");
        }
        separation();
        service(volvo,audi,mersedes,bmw,volvoBus,audiBus,mersedesBus,bmwBus,volvoTruck,audiTruck,mersedesTruck,bmwTruck);
        separation();
        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addPassengerCars(volvo);
        serviceStation.addTruck(volvoTruck);
        serviceStation.service();
        serviceStation.service();
        List<Car> cars = List.of(volvo,volvoTruck,volvoBus);
        for (Car car: cars) {
            printInfo(car);
        }
        separation();
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2  = new ArrayDeque<>();
        randomFillig(queue1);
        randomFillig(queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        separation();
        add("Бип",queue1,queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        separation();
        remove(queue1,queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        separation();
        example();

    }

    private static void printInfo(Car car) {
        System.out.println("Информация по автомобилю " + car.getBrand() + " " + car.getModel());
        System.out.println("Водители: " + car.getDrivers());
        System.out.println("Механники: " + car.getMechanics());
        System.out.println("Спонсоры: " + car.getSponsors());
        System.out.println("");
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
    private static void add(String name,Queue<String> queue1,Queue<String> queue2) {
        if (queue1.size() == MAX_SIZE && queue2.size() == MAX_SIZE) {
            System.out.println("Позвать Галю!!!!");
            return;
        }
        if (queue1.size() < queue2.size()) {
            queue1.offer(name);
        } else {
            queue2.offer(name);
        }

    }

    private static void remove(Queue<String> queue1,Queue<String> queue2) {
        if (RANDOM.nextBoolean()) {
            queue1.poll();
        } else {
            queue2.poll();
        }
    }

    private static void randomFillig(Queue<String> queue) {
        int size = RANDOM.nextInt(MAX_SIZE + 1);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }

    }
    private static void example() {
        List<List<String>> biDemArrList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            biDemArrList.add(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                biDemArrList.get(i).add(j, ((i + j) % 2 == 1 ? "●" : "◯"));
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(biDemArrList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}