package ru.nippyfox.java_tasks_part5;

import java.util.*;

public class Main {

    public static int[] encrypt(String a) { // 5.1
        int[] res = new int[a.length()];
        int lastChar = 0;
        char[] charArray = a.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int charSym = (int) charArray[i];
            res[i] = charSym - lastChar;
            lastChar = charSym;
        }
        return res;
    }

    public static String decrypt(int[] a) {
        String res = "";
        int lastCode = 0;
        for (int i = 0; i < a.length; i++) {
            char newAscii = (char) (lastCode + a[i]);
            lastCode = lastCode + a[i];
            res += String.valueOf(newAscii);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.ENGLISH);
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер задачи (от 41 до 50):");
        int n = in.nextInt();
        switch (n) {
            case 41 -> {
                System.out.println("encrypt() - 1");
                System.out.println("decrypt() - 2");
                int n1 = in.nextInt();
                if (n1 == 1) {
                    System.out.println("Введите строку:");
                    String s1 = sc.nextLine();
                    int[] res = encrypt(s1);
                    System.out.println("Результат: ");
                    for (int i: res) {
                        System.out.print(i + " ");
                    }
                }
                else if (n1 == 2) {
                    System.out.println("Введите количество элементов массива:");
                    int len1 = in.nextInt();
                    int[] m1 = new int[len1];
                    for (int i = 0; i < m1.length; i++) {
                        System.out.println("Введите " + (i + 1) + " элемент массива:");
                        m1[i] = in.nextInt();
                    }
                    System.out.println("Результат: " + decrypt(m1));
                }
                else {
                    System.out.println("Возможно выбрать только 1 или 2");
                }
            }
            case 42 -> {
                System.out.println("canMove()");
            }
        }
    }
}
