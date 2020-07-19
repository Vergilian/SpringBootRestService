package ru.mart.spring.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.util.stream.Stream;

@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int age;


    public enum gender {
        gender1("male"),
        gender2("female");

        private String code;

        private gender(String code) {
            this.code = code;
        }

        @JsonCreator
        public static gender decode(final String code) {
            return Stream.of(gender.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
        }

        @JsonValue
        public String getCode() {
            return code;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}