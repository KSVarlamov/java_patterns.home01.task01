package org.example;

public class PersonBuilder {
    private String name = null;
    private String sName = null;
    private int age = -1;
    private String address = "";

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String sName) {
        this.sName = sName;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age > 200 || age < 0) {
            throw new IllegalArgumentException("Возраст должен быть в диапазоне 0..200");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Не указано имя");
        }
        if (sName == null) {
            throw new IllegalStateException("Не указана фамилия");
        }
        Person person = new Person(name, sName, age);
        person.setAddress(address);
        return person;
    }
}
