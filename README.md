# Specification Pattern

[![Build Status](https://travis-ci.org/uetoyo/specification-pattern-java.svg?branch=master)](https://travis-ci.org/uetoyo/specification-pattern-java)

This package is in active development but incomplete.

## Simple use case

Simple use case: We have a person class with a birthdate attribute and we want to know if he is an adult.
The straigtforward approach is create the custom parametrized specification.

```java
import java.time.Period;
import java.time.LocalDate;

public class FluentSpecificationExample {

    public static void main(String[] args) {
       
        IsAdultPersonSpecification spec = new IsAdultPersonSpecification(18);
        
        Person p1 = new Person(LocalDate.of(1990, 1, 1));
        Person p2 = new Person(LocalDate.of(2016, 1, 1));
        
        System.out.println(spec.isSatisfiedBy(p1));
        System.out.println(spec.isSatisfiedBy(p2));
    }
}

class Person {
    
    private final LocalDate birthdate;

    public Person(final LocalDate birthdate) {
        // Check for `null` omitted.
        this.birthdate = birthdate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}

class IsAdultPersonSpecification<T extends Person> {

    public final int limit;

    public IsAdultPersonSpecification(int limit) {
        this.limit = limit;
    }

    public boolean isSatisfiedBy(T candidate) {
        return candidate.getAge() >= limit;
    }
}
```
