package Transport;

public class Mechanic<T extends Car> {
    String firstName;
    String lastName;
    String company;


    public Mechanic(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }


    public boolean service(T t) {
        return t.service();
    }

    public void repair(T t) {
        
    }

    @Override
    public String toString() {
        return "Имя:' " + getFirstName() + '\'' +
                ", Фамилия:'" + getLastName() + '\'' +
                ", Компания:'" + getCompany();
    }
}
