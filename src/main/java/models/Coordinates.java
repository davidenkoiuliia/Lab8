package models;

public class Coordinates {
    private Integer x; //Поле не может быть null
    private Integer y; //Поле не может быть null

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public boolean validate() {
        return x != null && y != null;
    }

    @Override
    public String toString() {
        return x + ";" + y;
    }
}

