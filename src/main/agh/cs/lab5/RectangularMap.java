package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student33 on 2018-10-22.
 */
class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    private List<Car> cars = new ArrayList<Car>();

    RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }
    public String toString(){
        MapVisualizer drawer = new MapVisualizer(this);
        Position lowerLeft = new Position(0,0);
        Position upperRight = new Position(this.width, this.height);
        return drawer.draw(lowerLeft, upperRight);
    }

    public boolean canMoveTo(Position position){
        if(position.x <= this.width &&
           position.x >= 0 &&
           position.y <= this.height &&
           position.y >= 0){
            return true;
        }
        else
            return false;
    }
    public boolean place(Car car){
        if(!isOccupied(car.getPosition())){
            cars.add(car);
            return true;
        }
        else
            return false;
    }
    public void run(MoveDirection[] directions){
        for(int i = 0; i<directions.length; i++){
            cars.get(i%cars.size()).move(directions[i], this);
        }
    }
    public boolean isOccupied(Position position){
        return objectAt(position) != null;
    }
    public Object objectAt(Position position){
        for(Car car: cars){
            if(car.getPosition().equals(position))
                return car;
        }
        return null;
    }

}
