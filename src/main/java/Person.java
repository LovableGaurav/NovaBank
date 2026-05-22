public abstract class Person {
public int PersonId;
String name;
int PhoneNumber;

    public Person(int personId, String name, int phoneNumber) {
        PersonId = personId;
        this.name = name;
        PhoneNumber = phoneNumber;
    }

    public abstract void displayDetails();
    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
