package Transport.Autosport;

import Transport.Car;

public class PassengerCars extends Car {

    private TypeOfBody typeOfBody;

    public PassengerCars(String brand, String model, double engineVolume,TypeOfBody typeOfBody) {
        super(brand, model, engineVolume);
        this.typeOfBody = typeOfBody;
    }

    public TypeOfBody getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(TypeOfBody typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    @Override
    public void startMoving() {

    }

    @Override
    public void stopMoving() {

    }

    @Override
    public void printType() {
        if (typeOfBody == null) {
            System.out.println("данных по авто не достаточно");
        } else {
            System.out.println("Тип кузова: " + typeOfBody.getTypeOfBody());
        }
    }

    @Override
    public boolean service() {
        return Math.random() > 0.7;
    }

    @Override
    public String pitStop() {
        return "Еду на пит-стоп";
    }

    @Override
    public String bestLapTime() {
        return "1 минуты 25 секунд";
    }

    @Override
    public String maxSpeed() {
        return "160 км/ч";
    }

}
