//This class creates methods to govern the basic movements of the robot.
//The robot moves on a Cartesian plane with origin (1,1) and turns at 90˚ angles.
//Created 02/08/2016 by Trevor B. (Stack Exchange user Eridan)
//Last updated 02/18/2016

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
		move(1);
	}
	
	public void leftTurns(int turns) {
		for(int i = 0; i < turns; i++) {
			super.turnLeft();
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
	
	public void faceNorth() {
		while(!facingNorth()) {
			turnLeft();
		}
		currentDirection = North;
	}
	
	public void faceSouth() {
		while(!facingSouth()) {
			turnLeft();
		}
		currentDirection = South;
	}
	
	public void faceEast() {
		while(!facingEast()) {
			turnLeft();
		}
		currentDirection = East;
	}
	
	public void faceWest() {
		while(!facingWest()) {
			turnLeft();
		}
		currentDirection = West;
	}
	
	//COORDINATE CHANGE
	
	public void coordinateChange(int xDestination, int yDestination) {
		int xDifference = xDestination - xCoordinate;
		int yDifference = yDestination - yCoordinate;
		
		if(xDifference > 0) {
			faceEast();
		}
		else if(xDifference < 0) {
			faceWest();
		}
		move(Math.abs(xDifference));
		
		if(yDifference > 0) {
			faceNorth();
		}
		else if(yDifference < 0) {
			faceSouth();
		}
		move(Math.abs(yDifference));
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
		move();
	}
	
	public void pickBeeperAndMove() {
		pickBeeper();
		move();
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
	
	public String getRobotName() {
		return robotName;
	}
	
	public int getXCoordinate() {
		return xCoordinate;
	}
	
	public int getYCoordinate() {
		return yCoordinate;
	}
	
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	
	public int getBeeperCount() {
		return beeperCount;
	}
	
	public void printRobotInformation() {
		if(beeperCount!=infinity) {
			System.out.printf("Information about the robot %s \nLocation: (%d, %d) \nFacing: %s \nBeepers: %d", getRobotName(), getXCoordinate(), getYCoordinate(), getCurrentDirection(), getBeeperCount());
		}
		else {
			System.out.printf("Information about the robot %s \nLocation: (%d, %d) \nFacing: %s \nBeepers: Infinity", getRobotName(), getXCoordinate(), getYCoordinate(), getCurrentDirection());
		}
	}
}