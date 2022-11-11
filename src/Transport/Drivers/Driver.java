package Transport.Drivers;

import Transport.Car;

public class Driver < T extends Car > {
    private String fio;
    private String experience;
    private String driversLicense;

    public Driver(String fio, String experience, String driversLicense) {
        this.fio = validOrDefaultFio(fio);
        this.experience = validOrDefaultExperience(experience);
        setDriversLicense(driversLicense);
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        if (driversLicense == null) {
            throw new IllegalArgumentException("Необходимо указать категорию прав!");
        }
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }
    private static String validOrDefaultFio(String fio) {
        if (fio == null || fio.isEmpty() || fio.isBlank()) {
            return  "Имя водителя не укаано";
        } else {
            return fio;
        }
    }
    private static String validOrDefaultDriversLicense(String driversLicense) {
        if (driversLicense == null || driversLicense.isEmpty() || driversLicense.isBlank()) {
            return  "Нет прав";
        } else {
            return driversLicense;
        }
    }
    private static String validOrDefaultExperience(String experience) {
        if (experience == null || experience.isEmpty() || experience.isBlank()) {
            return  "Нет стажа вождения";
        } else {
            return experience;
        }
    }
    @Override
    public String toString() {
        return "Водитель: " + fio + " стаж: " + experience +  " лет, наличие водительских прав: " + driversLicense;
    }
    public void driveCar(T car) {
        System.out.println("Водитель " + getFio() + " водит легковую машину " + car.getBrand() + " " + car.getModel() +
                " и будет учавствовать в заезде");
    }



}
