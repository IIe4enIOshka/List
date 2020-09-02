package com.company;

import java.util.Comparator;

public class Main{

    public static void main(String[] args) {

        PersonList list = new PersonList();
        list.add("Саша", 10);
        list.addLast("Маша", 20);
        list.addLast("Петя", 15);
        list.add("Катя", 11);
        list.addLast("Вася", 9);

        System.out.println("Размер " + list.getSize());

        list.todo(new IForEach() {
            @Override
            public void toDo(Person list) {

                System.out.println(list.Name + ":" + list.age);
            }
        });

        list.sort(new Comparator() {
            public int compare(Object o1, Object o2) {
                int a = (Integer) o1;
                int b = ((Integer) o2).intValue();
                return a < b ? 1 : a == b ? 0 : -1;
            }
        });

        list.todo(new IForEach() {
            @Override
            public void toDo(Person list) {
                list.age = list.age + 2;
                System.out.println(list.Name + ":" + list.age);
            }
        });
    }
}
