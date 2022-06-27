package model;

import java.time.LocalDate;

public class Dog extends Pet{

    public Dog(){

    }

    public Dog(String name, LocalDate dateOfBirth){
        super(name, dateOfBirth);
    }
    public void bark(){
        System.out.println("Ruff ruff!!");
    }
}
