package Transport;

public class Sponsor {
    private final String name;
    private final int sum;

    public Sponsor(String name, int sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public void toSponsorRace() {
        System.out.printf("спонсор %s профинансировал заезд %d%n",name,sum);
    }

    @Override
    public String toString() {
        return "Имя:' " + getName() + '\'' +
                ", Сумма: " + getSum();
    }
}
