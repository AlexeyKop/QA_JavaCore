import java.util.Objects;

public class Customer {
    private String name;
    private int age;
    private String phone;
    private Gender gender;

    public Customer(String name, int age, String phone, Gender gender) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', age=" + age + ", phone='" + phone + "', gender=" + gender + "}";
    }
}