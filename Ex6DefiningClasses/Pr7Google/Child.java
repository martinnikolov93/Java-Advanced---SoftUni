package Ex6DefiningClasses.Pr7Google;

public class Child {
    private String name;
    private String birthDate;

    public Child(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return this.name + " " + this.birthDate;
    }
}
