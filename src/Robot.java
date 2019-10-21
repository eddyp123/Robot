

public class Robot {
    //private variables set to default values and names
    private String robotName = "Robot";
    private int xPos = 0;
    private int yPos = 0;
    private String direction = "North";

    //default constructor
    public Robot(String robotName, int xPos, int yPos, String direction){
        this.robotName = robotName;
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    //constructor to initialize robot class so there are no stack overflow errors
    public Robot(){
    }

    public Robot(int x, int y){
        Robot robot = new Robot();
        robot.setXPos(x);
        robot.setYPos(y);
    }

    public Robot(String name){
        Robot robot = new Robot();
        robot.setXPos(0);
        robot.setYPos(0);
        robot.setDirection("North");
        robotName = name;
    }

    //getters and setters

    public String getRobotName() { return robotName; }

    public void setRobotName(String robotName) { this.robotName = robotName; }

    public int getXPos() { return xPos; }

    public void setXPos(int xPos) { this.xPos = xPos; }

    public int getYPos() { return yPos; }

    public void setYPos(int yPos) { this.yPos = yPos; }

    public String getDirection() { return direction; }

    public void setDirection(String direction) { this.direction = direction; }

    //calculate a distance between two robot using Manhattan distance calculation
    public int distanceTo(Robot robot1){
        Robot robot2 = new Robot();

        int x1 = robot1.xPos;
        int y1 = robot1.yPos;

        int x2 = robot2.xPos;
        int y2 = robot2.yPos;

        int distance = Math.abs(x1 - x2) + Math.abs(y1-y2);

        return distance;
    }

    //add input number to x or y position based on which way robot is facing
    public void forward(int df){
        String direction = getDirection();
        int x = getXPos();
        int y = getYPos();

        switch (direction){
            case "East":
                x += df;
                setXPos(x);
            case "North":
                y += df;
                setYPos(y);
            case "West":
                x -= df;
                setXPos(x);
            case "South":
                y -= df;
                setYPos(y);
        }
        System.out.println(getRobotName() + " moved forward " + df);
        //move the robot forward (in the direction the robot is facing) the number of units given
    }

    //set direction based on value of last direction. Return message stating value
    public void turnRight(){
        String direction = getDirection();
        switch (direction){
            case "East":
                setDirection("South");
                break;
            case "South":
                setDirection("West");
                break;
            case "West":
                setDirection("North");
                break;
            case "North":
                setDirection("East");
                break;
        }
        System.out.println(getRobotName() + " is now facing " + getDirection());
        //robot turns right 90 degrees (north -> east -> south -> west -> north
    }

    //retrieve information via getters in string format to the user. Returning null to override original toString() method
    public String toString(){
        System.out.println(getRobotName() + " is at (" + getXPos() + ", " + getYPos() + ") facing " + getDirection());
        return null;
    }
}
