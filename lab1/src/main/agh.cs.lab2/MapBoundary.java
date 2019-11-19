package agh.cs.lab2;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private static final Comparator<Vector2d> Xcomp = new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d t1, Vector2d t2) {
            return t1.x -t2.x!=0?t1.x-t2.x : t1.y-t2.y;
        }
    };
    private static final Comparator<Vector2d> Ycomp = new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d t1, Vector2d t2) {
            return t1.y - t2.y!=0 ? t1.y - t2.y : t1.x -t2.x;
        }
    };
    private SortedSet<Vector2d> xCoords = new TreeSet<>(Xcomp);
    private SortedSet<Vector2d> yCoords = new TreeSet<>(Ycomp);
    public Vector2d getUpperRight(){
        return xCoords.last().upperRight(yCoords.last());
    }
    public Vector2d getLowerLeft(){
        return xCoords.first().lowerLeft(yCoords.first());
    }
    public void positionChanged(Vector2d oldPos, Vector2d newPos){
        xCoords.remove(oldPos);
        yCoords.remove(oldPos);
        xCoords.add(newPos);
        yCoords.add(newPos);
    }
    public void insert(Vector2d v){
        xCoords.add(v);
        yCoords.add(v);
    }
}
