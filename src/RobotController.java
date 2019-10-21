import java.util.Scanner;

public class RobotController {
    public static void main(String args[]) {
        //create a robot object
        Scanner in = new Scanner(System.in);
        Robot rob = new Robot();

        //command will be assigned input from user, name is robot name assigned from user
        String command;
        String name;
        int distance = 0;

        do{ //command takes in "t": to turn; "n": to set name; "r": to return formatted String;
            //"f": to move forward; or "e" to end program
            System.out.print("Enter a command: ");
            command = in.next();

            switch (command) {
                case "t":
                    rob.turnRight();
                    break;
                case "n":
                    name = in.next();
                    rob.setRobotName(name);
                    System.out.println("My name is " + rob.getRobotName() + "\n");
                    break;
                case "r":
                    rob.toString();
                    break;
                case "f":
                    distance = in.nextInt();
                    rob.forward(distance);
                    break;
                case "e":
                    break;
                //print message and instructions if none of the values are entered
                default:
                    System.out.println(rob.getRobotName() + " has absolutely no clue what '" + command + "' means. ");
                    System.out.println("Please enter 'f' for forward\n 'n' *name* to name the robot\n " +
                            "'t' to turn robot right 90 degrees\n 'r' to show name, position, and direction of robot");
            }

            //continue loop while user does not enter "e" to end program
        }while(!command.equals("e"));

        //exit message
        System.out.println("\nYou have ended the program");
    }
}
