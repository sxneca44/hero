package com.sxneca44.hero;

public class Position {
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    private int x;
    private int y;
    public void set_position(Position p){
        this.x= p.x;
        this.y= p.y;
    }
    public Position(int x, int y){
        this.x  = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }
}
