package ru.nippyfox.java_tasks_part1;

import java.util.*;
import java.lang.*;

public class Main {

    public static int remainder(int a, int b) { // 1.1
        return a % b;
    }

    public static double triArea(int a, int b) { // 1.2
        return 0.5 * a * b;
    }

    public static int animals(int a, int b, int c) { // 1.3
        return (a * 2) + (b * 4) +(c * 4);
    }

    public static boolean profitableGamble(double a, int b, int c) { // 1.4
        return a * b > c;
    }

    public static String operation(int res, int a, int b){ // 1.5
        if (res == a + b) {
            return "added";
        }
        else if (res == a - b){
            return "substracted";
        }
        else if (res == a * b) {
            return "multiplied";
        }
        else if (res == a / b) {
            return "divided";
        }
        else {
            return "none";
        }
    }

    public static int ctoa(char s) { // 1.6
        return (int) s;
    }

    public static int addUpTo(int n) { // 1.7
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int nextEdge(int a, int b) { // 1.8
        return a + b - 1;
    }

    public static int sumOfCubes(int[] array) { //1.9
        int sum = 0;
        for (int i : array) {
            sum += Math.pow(i, 3);
        }
        return sum;
    }

    public static boolean abcmath(int a, int b, int c) { // 1.10
        while (b > 0) {
            a += a;
            b--;
        }
        return a % c == 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер задачи (от 1 до 10):");
        int n = in.nextInt();
        switch (n) {
            case 1 -> {
                System.out.println("remainder()");
                System.out.println("Введите a:");
                int a1 = in.nextInt();
                System.out.println("Введите b:");
                int b1 = in.nextInt();
                System.out.println("Результат: " + remainder(a1, b1));
            }
            case 2 -> {
                System.out.println("triArea()");
                System.out.println("Введите a:");
                int a2 = in.nextInt();
                System.out.println("Введите b:");
                int b2 = in.nextInt();
                System.out.println("Результат: " + triArea(a2, b2));
            }
            case 3 -> {
                System.out.println("animals()");
                System.out.println("Введите a:");
                int a3 = in.nextInt();
                System.out.println("Введите b:");
                int b3 = in.nextInt();
                System.out.println("Введите c:");
                int c3 = in.nextInt();
                System.out.println("Результат: " + animals(a3, b3, c3));
            }
            case 4 -> {
                System.out.println("profitableGamble()");
                System.out.println("Введите a:");
                double a4 = in.nextDouble();
                System.out.println("Введите b:");
                int b4 = in.nextInt();
                System.out.println("Введите c:");
                int c4 = in.nextInt();
                System.out.println("Результат: " + profitableGamble(a4, b4, c4));
            }
            case 5 -> {
                System.out.println("operation()");
                System.out.println("Введите N:");
                int N5 = in.nextInt();
                System.out.println("Введите a:");
                int a5 = in.nextInt();
                System.out.println("Введите b:");
                int b5 = in.nextInt();
                System.out.println("Результат: " + operation(N5, a5, b5));
            }
            case 6 -> {
                Scanner sc = new Scanner(System.in);
                System.out.println("ctoa()");
                System.out.println("Введите символ:");
                String a6 = sc.nextLine();
                char b6 = a6.charAt(0);
                System.out.println("Результат: " + ctoa(b6));
            }
            case 7 -> {
                System.out.println("addUpTo()");
                System.out.println("Введите N:");
                int n7 = in.nextInt();
                System.out.println("Результат: " + addUpTo(n7));
            }
            case 8 -> {
                System.out.println("nextEdge()");
                System.out.println("Введите a:");
                int a8 = in.nextInt();
                System.out.println("Введите b:");
                int b8 = in.nextInt();
                System.out.println("Результат: " + nextEdge(a8, b8));
            }
            case 9 -> {
                System.out.println("sumOfCubes()");
                System.out.println("Сколько элементов будет в массиве?");
                int n9 = in.nextInt();
                int[] array9 = new int[n9];
                for (int i : array9) {
                    System.out.println("Введите " + i + " элемент массива:");
                    array9[i] = in.nextInt();
                }
                System.out.println("Результат: " + sumOfCubes(array9));
            }
            case 10 -> {
                System.out.println("abcmath()");
                System.out.println("Введите a:");
                int a10 = in.nextInt();
                System.out.println("Введите b:");
                int b10 = in.nextInt();
                System.out.println("Введите c:");
                int c10 = in.nextInt();
                System.out.println("Результат: " + abcmath(a10, b10, c10));
            }
        }
    }
}
