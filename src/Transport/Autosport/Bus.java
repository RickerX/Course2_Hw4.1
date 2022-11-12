package Transport.Autosport;


import Transport.Car;

public class Bus extends Car {

    private Capacity capacity;

    public Bus(String brand, String model, double engineVolume, Capacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public void startMoving() {

    }

    @Override
    public void stopMoving() {

    }

    @Override
    public void printType() {
        if (capacity == null) {
            System.out.println("данных по авто не достаточно");
        } else {
            System.out.println("Максимум пассажиров: " + "от " + capacity.getFrom() + " до " + capacity.getTo());
        }
    }

    @Override
    public boolean service() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " в диагностике не требуется");
        return true;
    }

    @Override
    public void repair() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " отремонтирован!");
    }

    @Override
    public String pitStop() {
        return "еду на пит-стоп";
    }

    @Override
    public String bestLapTime() {
        return "2 минуты 36 секунд";
    }

    @Override
    public String maxSpeed() {
        return "120 км/ч";
    }

}
