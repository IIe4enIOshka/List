package com.company;

public class Person{
    public String Name;
    public int age;
    public Person next;

    public Person() {
    }

    public Person(String Name, int age) {
        this.Name = Name;
        this.age = age;
    }


    public Person getnext(){
        return this.next;
    }

    public void SetNext(Person Next)
    {
        this.next = Next;
    }

    public String getName(){
        return this.Name;
    }

    public int getAge(){
        return this.age;
    }
}
