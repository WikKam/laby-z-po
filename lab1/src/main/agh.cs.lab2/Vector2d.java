package agh.cs.lab2;

public class Vector2d {
    public final int x;
    public final int y;
    public Vector2d(int x, int y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return "(" + x + "," + y + ")";

    }
    public boolean precides(Vector2d other){
        return (this.x<=other.x&&this.y<=other.y);
    }
    public boolean follows(Vector2d other){
        return (this.x>=other.x&&this.y>=other.y);
    }
    public Vector2d upperRgiht(Vector2d other){
        return new Vector2d(Math.max(this.x,other.x),Math.max(this.y,other.y));
    }
    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(this.x,other.x),Math.min(this.y,other.y));
    }
    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x,this.y+other.y);
    }
    public Vector2d opposite(){
        return new Vector2d(-this.x,-this.y);
    }
    public Vector2d substract(Vector2d other){
        return new Vector2d(this.x-other.x,this.y-other.y);
    }
    public boolean equals(Object other){
        if(super.equals(other)) return true;
        if(!(other instanceof Vector2d))return false;
        Vector2d temp = (Vector2d)other;
        return(this.x==temp.x&&this.y==temp.y);
    }
}
