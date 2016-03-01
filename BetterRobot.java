//This class creates methods to govern the basic movements of the robot.
//The robot moves on a Cartesian plane with origin (1,1) and turns at 90˚ angles.
//Created 02/08/2016 by Trevor B. (Stack Exchange user Eridan)
//Last updated 03/01/2016

import kareltherobot.Robot;

public class BetterRobot extends Robot {
    private int xCoordinate;
    private int yCoordinate;
    private Direction currentDirection;
    private int beeperCount;
    private final String ROBOT_NAME;

    public BetterRobot(String name, int avenue, int street, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);

        ROBOT_NAME = name;
        xCoordinate = avenue;
        yCoordinate = street;
        currentDirection = direction;
        beeperCount = beepers;
    }
    
    //SETTERS AND GETTERS
    
    public void setXCoordinate(int xCoordinate) {
    	xCoordinate = this.xCoordinate;
    }
    
    public int getXCoordinate() {
    	return xCoordinate;
    }
    
    public void setYCoordiante(int yCoordinate) {
    	yCoordinate = this.yCoordinate;
    }
    
    public int getYCoordinate() {
    	return yCoordinate;
    }
    
    public void setCurrentDirection(Direction currentDirection) {
    	currentDirection = this.currentDirection;
    }
    
    public Direction getCurrentDirection() {
    	return currentDirection;
    }
    
    public void setBeeperCount(int beeperCount) {
    	beeperCount = this.beeperCount;
    }
    
    public int getBeeperCount() {
    	return beeperCount;
    }
    
    public String getRobotName() {
    	return ROBOT_NAME;
    }

    //MOVEMENT

    public void move(int steps) {
        for(int i = 0; i < steps; i++) {
            if(frontIsClear()) {
                super.move();

                if(facingNorth()) {
                    yCoordinate++;
                }
                else if(facingSouth()) {
                    yCoordinate--;
                }
                else if(facingEast()) {
                    xCoordinate++;
                }
                else if(facingWest()) {
                    xCoordinate--;
                }
            }
            else {
                System.err.println("Error shutoff: Ran into wall");
                turnOff();
                break;
            }
        }
    }
    
    public void updateCurrentDirection() {
    	if(facingNorth()) {
    		currentDirection = North;
    	}
    	
    	if(facingSouth()) {
    		currentDirection = South;
    	}
    	
    	if(facingEast()) {
    		currentDirection = East;
    	}
    	
    	if(facingWest()) {
    		currentDirection = West;
    	}
    }

    private void leftTurns(int turns) {
        for(int i = 0; i < turns; i++) {
            super.turnLeft();
            updateCurrentDirection();
        }
    }

    public void turnLeft() {
        leftTurns(1);
    }

    public void turnRight() {
        leftTurns(3);
    }

    public void turnAround() {
        leftTurns(2);
    }

    //DIRECTIONS
    
    public boolean isFacingDirection(Direction currentDirection) {
    	boolean isFacing = false;
    	
    	if(currentDirection == North && this.facingNorth()) {
    		isFacing = true;
    	}
    	else if(currentDirection == South && this.facingSouth()) {
    		isFacing = true;
    	}
    	else if(currentDirection == East && this.facingEast()) {
    		isFacing = true;
    	}
    	else if(currentDirection == West && this.facingWest()) {
    		isFacing = true;
    	}
    	
    	return isFacing;
    }
    
    public void faceThisDirection(Direction newDirection) {
    	while(!this.isFacingDirection(newDirection)) {
    		turnLeft();
    	}
    }

    //COORDINATE CHANGE

    public void coordinateChange(int xDestination, int yDestination) {
        Direction initialDirection = currentDirection;
    	
    	int xDifference = xDestination - xCoordinate;
        int yDifference = yDestination - yCoordinate;

        if(xDifference > 0) {
            faceThisDirection(East);
        }
        else if(xDifference < 0) {
            faceThisDirection(West);
        }
        move(Math.abs(xDifference));

        if(yDifference > 0) {
            faceThisDirection(North);
        }
        else if(yDifference < 0) {
            faceThisDirection(South);
        }
        move(Math.abs(yDifference));
        
        faceThisDirection(initialDirection);
    }

    //BEEPER MANAGEMENT

    public void putBeeper(int drops) {
        for(int i = 0; i < drops; i++) {
            if(anyBeepersInBeeperBag()) {
                super.putBeeper();
                beeperCount -= 1;
            }
            else {
                System.err.println("Error shutoff: Not enough beepers in bag");
                turnOff();
                break;
            }
        }
    }

    public void pickBeeper(int drops) {
        for(int i = 0; i < drops; i++) {
            if(nextToABeeper()) {
                super.pickBeeper();
                beeperCount += 1;
            }
            else {
                System.err.println("Error shutoff: Not next to a beeper");
                turnOff();
                break;
            }
        }
    }

    public void putAllBeepers() {
        while(anyBeepersInBeeperBag()) {
            putBeeper(1);
        }
    }

    public void pickAllBeepers() {
        while(nextToABeeper()) {
            pickBeeper(1);
        }
    }

    public void putBeeperAndMove() {
        putBeeper(1);
        move(1);
    }

    public void pickBeeperAndMove() {
        pickBeeper(1);
        move(1);
    }

    public void beeperToASCII() {
        int beepersPickedUp = 0;

        while(nextToABeeper()) {
            pickBeeper(1);
            beepersPickedUp++;
        }

        System.out.println((char) beepersPickedUp);
    }

    //ACQUIRING INFORMATION ABOUT ROBOT STATE

    public void printRobotInformation() {
        if(beeperCount!=infinity) {
            System.out.printf("Information about the robot %s \nLocation: (%d, %d) \nFacing: %s \nBeepers: %d", ROBOT_NAME, xCoordinate, yCoordinate, currentDirection, beeperCount);
        }
        else {
            System.out.printf("Information about the robot %s \nLocation: (%d, %d) \nFacing: %s \nBeepers: Infinity", ROBOT_NAME, xCoordinate, yCoordinate, currentDirection);
        }
    }
    
    //CATCHING TYPOES BY FORGETTING ARGUMENTS
    
    public void move() {
        System.err.println("You forgot to type a 1. (move statement)");
    }
    
    public void putBeeper() {
        System.err.println("You forgot to type a 1. (putBeeper statement");
    }
    
    public void pickBeeper() {
        System.err.println("You forgot to type a 1. (pickBeeper statement");
    }
    
}
