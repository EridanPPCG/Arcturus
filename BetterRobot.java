//This class creates methods to govern the basic movements of the robot.
//The robot moves on a Cartesian plane with origin (1,1) and turns at 90˚ angles.
//Created 02/08/2016 by Trevor B. (Stack Exchange user Eridan)
//Last updated 02/21/2016

import kareltherobot.Robot;

public class BetterRobot extends Robot {
    public int xCoordinate;
    public int yCoordinate;
    public Direction currentDirection;
    public int beeperCount;
    public String robotName;

    public BetterRobot(String name, int avenue, int street, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);

        robotName = name;
        xCoordinate = avenue;
        yCoordinate = street;
        currentDirection = direction;
        beeperCount = beepers;
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
                System.out.println("Error shutoff: Ran into wall");
                turnOff();
                break;
            }
        }
    }

    public void move() {
        System.err.println("You forgot to type a 1.");
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
    
    public void faceThisDirection(Direction newDirection) {
    	if(newDirection == North) {
    		while(!facingNorth()) {
                turnLeft();
            }
    	}
    	
    	if(newDirection == South) {
    		while(!facingSouth()) {
                turnLeft();
            }
    	}
    	
    	if(newDirection == East) {
    		while(!facingEast()) {
                turnLeft();
            }
    	}
    	
    	if(newDirection == West) {
    		while(!facingWest()) {
                turnLeft();
            }
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
            }
            else {
                System.out.println("Error shutoff: Not enough beepers in bag");
                turnOff();
                break;
            }
        }
        beeperCount -= drops;
    }

    public void pickBeeper(int drops) {
        for(int i = 0; i < drops; i++) {
            if(nextToABeeper()) {
                super.pickBeeper();
            }
            else {
                System.out.println("Error shutoff: Not next to a beeper");
                turnOff();
                break;
            }
        }
        beeperCount -= drops;
    }

    public void putAllBeepers() {
        while(anyBeepersInBeeperBag()) {
            putBeeper();
        }
    }

    public void pickAllBeepers() {
        while(nextToABeeper()) {
            pickBeeper();
        }
    }

    public void putBeeperAndMove() {
        putBeeper();
        move(1);
    }

    public void pickBeeperAndMove() {
        pickBeeper();
        move(1);
    }

    public void beeperToASCII() {
        int beepersPickedUp = 0;

        while(nextToABeeper()) {
            pickBeeper();
            beepersPickedUp++;
        }

        System.out.println((char) beepersPickedUp);
    }

    //ACQUIRING INFORMATION ABOUT ROBOT STATE

    public void printRobotInformation() {
        if(beeperCount!=infinity) {
            System.out.printf("Information about the robot %s \nLocation: (%d, %d) \nFacing: %s \nBeepers: %d", robotName, xCoordinate, yCoordinate, currentDirection, beeperCount);
        }
        else {
            System.out.printf("Information about the robot %s \nLocation: (%d, %d) \nFacing: %s \nBeepers: Infinity", robotName, xCoordinate, yCoordinate, currentDirection);
        }
    }
}
