package ru.nippyfox.java_lab2;

public class Point3d {
    /* координата X */
    private double xCoord;
    /* координата Y */
    private double yCoord;
    /* координата Z */
    private double zCoord;
    /* конструктор инициализации */
    public Point3d (double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
    /* Конструктор по умолчанию. */
    public Point3d () {
        //Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0, 0);
    }
    /* Возвращение координаты X */
    public double getX () {
        return xCoord;
    }
    /* Возвращение координаты Y */
    public double getY () {
        return yCoord;
    }
    /* Возвращение координаты Y */
    public double getZ () {
        return zCoord;
    }
    /* Установка значения координаты X. */
    public void setX (double val) {
        xCoord = val;
    }
    /* Установка значения координаты Y. */
    public void setY (double val) {
        yCoord = val;
    }
    /* Установка значения координаты Y. */
    public void setZ (double val) {
        zCoord = val;
    }
    /* Сравнивание */
    public boolean comparison(Point3d point){
        return this.getX() == point.getX() && this.getY() == point.getY() && this.getZ() == point.getZ();
    }
    /* Подсчёт расстояния между двумя точками */
    public Double distanceTo(Point3d point){
        double distance = Math.sqrt(Math.pow(this.getX() - point.getX(), 2) + Math.pow(this.getY() - point.getY(), 2) + Math.pow(this.getZ() - point.getZ(), 2));
        return (double) Math.round(distance * 100) / 100;
    }
}
