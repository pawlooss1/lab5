package agh.cs.lab5;

/**
 * Created by Student33 on 2018-10-15.
 */
public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        MoveDirection[] result = new MoveDirection[args.length];
        int i = 0;
        for(String command : args){
            if(command.equals("f") || command.equals("forward")) {
                result[i] = MoveDirection.FORWARD;
                i++;
            }
            if(command.equals("b") || command.equals("backward")) {
                result[i] = MoveDirection.BACKWARD;
                i++;
            }
            if(command.equals("l") || command.equals("left")) {
                result[i] = MoveDirection.LEFT;
                i++;
            }
            if(command.equals("r") || command.equals("right")) {
                result[i] = MoveDirection.RIGHT;
                i++;
            }
        }
        if(i == args.length)
            return result;
        MoveDirection[] correctResult = new MoveDirection[i];
        for(int j=0; j<i; j++)
            correctResult[j] = result[j];
        return correctResult;
    }
}
