package Transport;

public abstract class Car implements Competing{

    private final String brand;
    private final String model;
    private final double engineVolume;

    public Car(String brand, String model, double engineVolume) {
        this.brand = validOrDefaultBrand(brand);
        this.model = validOrDefaultModel(model);
        this.engineVolume = validOrDefaultEngineVolume(engineVolume);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }
    private static String validOrDefaultModel(String model) {
        if (model == null || model.isBlank() || model.isBlank()) {
            return "default";
        } else {
            return model;
        }
    }

    private static String validOrDefaultBrand(String brand) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            return  "default";
        } else {
            return brand;
        }
    }
    private static double validOrDefaultEngineVolume(double engineVolume) {
        if (engineVolume == 0 || engineVolume < 0) {
            return 1.5;
        } else {
            return engineVolume;
        }
    }

    public abstract void startMoving();
    public abstract void stopMoving();

    public abstract void printType();


    @Override
    public String toString() {
        return "Бренд: " + getBrand() + '\'' + " модель: " + getModel() + '\'' + " объем двигателя: " +getEngineVolume() + " литра. " ;
    }

    public abstract boolean service();
}
