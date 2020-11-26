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

    public static boolean canMove(String a, String bStr, String cStr) { // 5.2
        char[] b = bStr.toCharArray();
        char[] c = cStr.toCharArray();
        if ((b.length == 2 && c.length == 2) && ((b[0] >= 'A' && b[0] <= 'H') || (b[0] >= 'a' && b[0] <= 'h')) &&
                ((c[0] >= 'A' && c[0] <= 'H') || (c[0] >= 'a' && c[0] <= 'h')) && (b[1] >= '1' && b[1] <= '8')
                && (c[1] >= '1' && c[1] <= '8')) {
            if (a.trim().toLowerCase().equals("пешка")) {
                if (b[0] == c[0]) {
                    if (b[1] == '1') {
                        return false;
                    }
                    if (b[1] == '2' && c[1] == '4') {
                        return true;
                    }
                    int begin = (int) b[1];
                    int end = (int) c[1];
                    return begin + 1 == end;
                } else {
                    return false;
                }
            } else if (a.trim().toLowerCase().equals("конь")) {
                return ((Math.abs((b[1] - c[1])) == 2 && Math.abs(b[0] - c[0]) == 1) ||
                        (Math.abs((b[0] - c[0])) == 2 && Math.abs(b[1] - c[1]) == 1));
            } else if (a.trim().toLowerCase().equals("слон")) {
                return (Math.abs(b[0] - c[0]) == Math.abs(b[1] - c[1]));
            } else if (a.trim().toLowerCase().equals("ладья")) {
                return b[0] == c[0] || b[1] == c[1];
            } else if (a.trim().toLowerCase().equals("ферзь")) {
                return (b[0] == c[0] || b[1] == c[1]) || (Math.abs(b[0] - c[0]) == Math.abs(b[1] - c[1]));
            } else if (a.trim().toLowerCase().equals("король")) {
                return ((b[0] == c[0]) && (b[1] + 1 == c[1]) || (b[1] == c[1]) && (b[0] + 1 == c[0]) ||
                        (b[0] == c[0]) && (b[1] - 1 == c[1]) || (b[1] == c[1]) && (b[0] - 1 == c[0]));
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public static boolean canComplete(String a, String b) { // 5.3
        for (char let: a.toCharArray()) {
            int curSymPos = b.indexOf(let);
            if ((curSymPos != -1)) {
                b = b.substring(curSymPos+1);
            }
            else return false;
        }
        return true;
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
                System.out.println("Введите фигуру:");
                String a2 = sc.nextLine();
                System.out.println("Введите положение фигуры на шахматной доске:");
                String b2 = sc.nextLine();
                System.out.println("Введите целевую позицию:");
                String c2 = sc.nextLine();
                System.out.println("Результат: " + canMove(a2, b2, c2));
            }
            case 43 -> {
                System.out.println("canComplete()");
                System.out.println("Введите подстроку:");
                String a3 = sc.nextLine();
                System.out.println("Введите входную строку:");
                String b3 = sc.nextLine();
                System.out.println("Результат: " + canComplete(a3, b3));
            }
        }
    }
}
