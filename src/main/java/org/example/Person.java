package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String Surname;
    private int age;
    private String address = "";

    public Person(String name, String surname, int age) {
        this.name = name;
        this.Surname = surname;
        this.age = age;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.Surname = surname;
        this.age = -1;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return Surname;
    }

    public OptionalInt getAge() {
        return age >= 0 ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age >= 0) {
            age++;
        }
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return address.length() > 0;
    }

    PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(Surname)
                .setAge(0)
                .setAddress(address);

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sName='" + Surname + '\'' +
                (age >=0 ? ", age=" + age : ", age='not present'") +
                (address.length() > 0 ? ", address='" + address + '\'' : ", address='not present'") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(Surname, person.Surname) && Objects.equals(age, person.age) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Surname, age, address);
    }
}
