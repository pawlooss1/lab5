package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractWorldMap implements IWorldMap{
    protected List<Car> cars = new ArrayList<Car>();

    public boolean place(Car car){
        if(canMoveTo(car.getPosition())){
            cars.add(car);
            return true;
        }
        else
            return false;
    }
    public void run(MoveDirection[] directions){
        if (cars.size() == 0)
            return;
        for(int i = 0; i<directions.length; i++){
            cars.get(i%cars.size()).move(directions[i], this);
        }
    }
    public boolean isOccupied(Position position){
        return this.objectAt(position) != null;
    }
    public Object objectAt(Position position){
        for(Car car: cars){
            if(car.getPosition().equals(position))
                return car;
        }
        return null;
    }
}
