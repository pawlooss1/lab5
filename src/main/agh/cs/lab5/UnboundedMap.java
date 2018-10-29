package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student33 on 2018-10-29.
 */
public class UnboundedMap implements IWorldMap{
    private List<HayStack> hayStacks;
    private List<Car> cars = new ArrayList<Car>();

    public UnboundedMap(List<HayStack> hayStacksToPlace){
        this.hayStacks = hayStacksToPlace;
    }
    public String toString(){
        MapVisualizer drawer = new MapVisualizer(this);
        Position lowerLeft = cars.get(0).getPosition();
        Position upperRight = cars.get(0).getPosition();
        for(Car car: cars){
            if(car.getPosition().smaller(lowerLeft))
                lowerLeft = car.getPosition();
            if(car.getPosition().larger(upperRight))
                upperRight = car.getPosition();
        }
        for(HayStack stack: hayStacks){
            if(stack.getPosition().smaller(lowerLeft))
                lowerLeft = stack.getPosition();
            if(stack.getPosition().larger(upperRight))
                upperRight = stack.getPosition();
        }
        return drawer.draw(lowerLeft, upperRight);
    }

    public boolean canMoveTo(Position position){
        return true;
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
        for(Car car: cars){
            if(car.getPosition().equals(position))
                return true;
        }
        for(HayStack stack: hayStacks){
            if(stack.getPosition().equals(position))
                return true;
        }
        return false;
    }
    public Object objectAt(Position position){
        for(Car car: cars){
            if(car.getPosition().equals(position))
                return car;
        }
        for(HayStack stack: hayStacks){
            if(stack.getPosition().equals(position))
                return stack;
        }
        return null;
    }

}
