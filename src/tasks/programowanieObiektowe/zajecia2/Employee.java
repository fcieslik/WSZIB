package tasks.programowanieObiektowe.zajecia2;

public class Employee {

    private String name;
    private String surname;
    private String emailAdress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public Employee(String name, String surname, String emailAdress) {
        this.name = name;
        this.surname = surname;
        this.emailAdress = emailAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null) return false;
        return emailAdress != null ? emailAdress.equals(employee.emailAdress) : employee.emailAdress == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (emailAdress != null ? emailAdress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee personal data " +
                "name = " + name +
                ", surname = " + surname +
                ", emailAdress = " + emailAdress;
    }
}
