package agh.cs.lab5;

/**
 * Created by Student33 on 2018-10-15.
 */
public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
    public boolean smaller(Position p){
        if(this.x <= p.x && this.y <= p.y)
            return true;
        else
            return false;
    }
    public boolean larger(Position other){
        if(this.x >= other.x && this.y >= other.y)
            return true;
        else
            return false;
    }
    public Position upperRight(Position other){
        int x = Math.max(this.x, other.x);
        int y = Math.max(this.y, other.y);
        return new Position(x, y);
    }
    public Position lowerLeft(Position other){
        int x = Math.min(this.x, other.x);
        int y = Math.min(this.y, other.y);
        return new Position(x, y);
    }
    public Position add(Position other){
        int x = this.x + other.x;
        int y = this.y + other.y;
        return new Position(x, y);
    }
    public Position sub(Position other){
        int x = this.x - other.x;
        int y = this.y - other.y;
        return new Position(x, y);
    }
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        if(this.x == that.x && this.y == that.y)
            return true;
        else
            return false;
    }
}
