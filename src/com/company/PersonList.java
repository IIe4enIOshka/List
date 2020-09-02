package com.company;

import java.util.Comparator;

public class PersonList {
    private Person head;

    public PersonList() {
        head = null;
    }

    //проверка на пустоту списка
    private boolean isEmpty() {
        return head == null;
    }

    //удаление ко ключу
    public void remove_At(int key) {
        Person cur = head;
        Person prev = head;
        if (head != null) {
            for (int i = 0; i < getSize(); i++) {
                if (i == key) {
                    if (cur == head) {
                        head = head.next;
                        break;
                    } else {
                        prev.next = cur.next;
                        break;
                    }
                }
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public int getSize(){
        Person cur = head;
        int i = 0;
        while(cur != null)
        {
            i++;
            cur = cur.next;
        }
        return i;
    }


    public void todo(IForEach forEach) {
        Person tmp = head;
        System.out.println("Вывод списка на печать:");
        while (tmp != null) {
            forEach.toDo(tmp);
            tmp = tmp.next;
        }
    }

    public void printList() {
        Person tmp = head;
        System.out.println("Вывод списка на печать:");
        while (tmp != null) {
            System.out.println(tmp.Name + ":" + tmp.age);
            tmp = tmp.next;
        }
    }

    //добавление узла в начало списка
    public void add(String Name, int age) {
        Person tmp = new Person(Name, age);
        tmp.next = head;
        head = tmp;
    }

    //добавление узла в конец списка
    public void addLast(String Name, int age) {
        Person tmp = new Person(Name, age);
        Person cur = head;
        if (cur == null) {
            tmp.next = head;
            head = tmp;
            return;
        }
        while (cur.next != null)
            cur = cur.next;
        cur.next = tmp;
        tmp.next = null;
    }

    //Извлечение данных узла по ключу
    public void getData(int key) {
        Person cur = head;
        if (head != null) {
            for (int i = 0; i < getSize(); i++) {
                if (i == key) {
                    System.out.println("Извлекаем данные:");
                    System.out.println(cur.Name + ":" + cur.age);
                    System.out.println(cur.getName() + ":" + cur.getAge());
                }
                cur = cur.next;
            }
        }
    }

    //Сортировка узлов списка по возрастанию по полю Age
    public void sort(Comparator comparator) {
        Person prev;
        Person cur;
        Person save;
        Person save2;
        if (head != null) {
            for (int i = 0; i < getSize(); i++) {
                cur = head;
                save = save2 = prev = head;
                while (cur.next != null) {
                    if (comparator.compare(cur.age, cur.next.age) == -1) {
                        save = cur;
                        save2 = cur.next.next;
                        if (cur == head) {
                            head = cur.next;
                            cur.next.next = save;
                            cur.next.next.next = save2;
                        } else if (cur.next.next == null) {
                            prev.next = cur.next;
                            cur.next.next = save;
                            cur.next.next.next = null;
                            break;
                        } else {
                            prev.next = cur.next;
                            cur.next.next = save;
                            cur.next.next.next = save2;
                        }
                    }
                    prev = cur;
                    cur = cur.next;
                }
            }
        } else {
            System.out.println("Список пуст");
        }
    }
}