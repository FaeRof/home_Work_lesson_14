package com.home_Work_lesson_14;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;



public class Launch {

    public static void main(String[] args) {
	ArrayList<Integer> strings = new ArrayList<>();
	Scanner scanner =new Scanner(System.in);
	System.out.println("Хотите добавить свои int элементы в коллекцию?");
	System.out.println("ответьте yes/no:");
    String answer =scanner.next();


    if (answer.equals("yes")){
        System.out.println("Какое количество? ");
        System.out.println("Введите целое число: ");
        int i=scanner.nextInt();
        System.out.println("Вводите коллекцию целых чисел:");
        for (int j = 0; j<i; j++){

            strings.add(scanner.nextInt());
            }
        }else if (answer.equals("no")){
            System.out.println("Загружаю.....");
            System.out.println();
        }
        scanner.close();



    strings.add(-234);
    strings.add(231);
    strings.add(33);
    strings.add(11);
    strings.add(-2);
    strings.add(44);
    strings.add(11);
    strings.add(33);
    strings.add(2);


    System.out.println("Удалить дубликаты:");
        Stream<Integer> stream_1 = strings.stream();
        Set<Integer> set = stream_1.collect(Collectors.toSet());
        strings.removeAll(strings);

        set.forEach((x) -> {
            strings.add(x);
            System.out.println(x);
        });


        System.out.println();

        System.out.println("Вывести все четные элементы в определенном диапазоне(например, в диапазоне от 10 до 100):");
        Stream<Integer> stream_2 = strings.stream().
                filter((x) -> x%2 == 0).
                filter((x) -> (x > 9)&(x < 101));
        stream_2.forEach((x) -> System.out.println(x));

        System.out.println();

        System.out.println("Каждый элемент умножить на 2:");
        Stream<Integer> stream_3 =strings.stream().map((x) -> x*2);
        stream_3.forEach((x) -> System.out.println(x));

        System.out.println();

        System.out.println("Отсортировать и вывести на экран первых 4 элемента:");
        Stream<Integer> stream_4 =strings.stream().sorted();
        stream_4.limit(4).forEach((x) -> System.out.println(x));

        System.out.println();

        System.out.println("Вывести количество элементов в стриме:");
        System.out.println(strings.stream().count());

        System.out.println();

        System.out.println("Вывести среднее арифметическое всех чисел в стриме:");
        Optional<Integer> optional = strings.stream().reduce((x,y) -> x+y);
        System.out.println(optional.get()/strings.stream().count());
    }
}
