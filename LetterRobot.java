//This class creates methods to draw characters on the plane.
//In the grids, 1 represents a beeper, and 0 represents empty space
//Created 02/18/2016 by Trevor B. (Stack Exchange user Eridan)
//Last updated 02/22/2016

public class LetterRobot extends BetterRobot {
	
	public LetterRobot(String name, int avenue, int street, Direction direction, int beepers) {
		super(name, avenue, street, direction, beepers);
	}
	
	public void drawLetter(int distanceToTop, String letterGrid) {
		int firstXCoordinate = xCoordinate;
		int firstYCoordinate = yCoordinate;
		int maximumXCoordinate = xCoordinate;
		
		move(distanceToTop);
		
		for(int characterIndex = 0; characterIndex < letterGrid.length(); characterIndex++) {
			char characterInString = letterGrid.charAt(characterIndex);
			
			if(characterInString == '0') {
				faceThisDirection(East);
				move(1);
				maximumXCoordinate = Math.max(maximumXCoordinate, xCoordinate);
			}
			else if(characterInString == '1') {
				faceThisDirection(East);
				putBeeperAndMove();
				maximumXCoordinate = Math.max(maximumXCoordinate, xCoordinate);
			}
			else if(characterInString == ' ') {
				coordinateChange(firstXCoordinate, yCoordinate-1);
			}
		}
		
		coordinateChange(maximumXCoordinate + 1, firstYCoordinate);
		faceThisDirection(North);
	}
	
	public void drawString(String string) {
		for(int characterIndex = 0; characterIndex < string.length(); characterIndex++) {
			char character = string.charAt(characterIndex);
			
			switch(character) {
			
			case 'A': //41
				drawLetter(4, "0110 "
							+ "1001 "
							+ "1111 "
							+ "1001 "
							+ "1001");
				break;
			
			case 'B': //42
				drawLetter(4, "11110 "
							+ "10001 "
							+ "11110 "
							+ "10001 "
							+ "11110");
				break;
				
			case 'C': //43
				drawLetter(4, "0111 "
					    	+ "1000 "
					    	+ "1000 "
					    	+ "1000 "
					    	+ "0111");
				break;
		
			case 'D': //44
				drawLetter(4, "1110 "
					    	+ "1001 "
					    	+ "1001 "
					    	+ "1001 "
					    	+ "1110");
				break;
				
			case 'E': //45
				drawLetter(4, "1111 "
					    	+ "1000 "
					    	+ "1110 "
					    	+ "1000 "
					    	+ "1111");
				break;
			
			case 'F': //46
				drawLetter(4, "1111 "
					    	+ "1000 "
					    	+ "1110 "
					    	+ "1000 "
					    	+ "1000");
				break;
			
			case 'G': //47
				drawLetter(4, "01111 "
					    	+ "10000 "
					    	+ "10111 "
					    	+ "10001 "
					    	+ "01111");
				break;
			
			case 'H': //48
				drawLetter(4, "1001 "
					    	+ "1001 "
					    	+ "1111 "
					    	+ "1001 "
					    	+ "1001");
				break;
			
			case 'I': //49
				drawLetter(4, "11111 "
					    	+ "00100 "
					    	+ "00100 "
					    	+ "00100 "
					    	+ "11111");
				break;
			
			case 'J': //4A
				drawLetter(4, "0001 "
					    	+ "0001 "
					    	+ "0001 "
					    	+ "1001 "
					    	+ "0110");
				break;
			
			case 'K': //4B
				drawLetter(4, "1001 "
					    	+ "1010 "
					    	+ "1100 "
					    	+ "1010 "
					    	+ "1001");
				break;
			
			case 'L': //4C
				drawLetter(4, "1000 "
					    	+ "1000 "
					    	+ "1000 "
					    	+ "1000 "
					    	+ "1111");
				break;
			
			case 'M': //4D
				drawLetter(4, "01110 "
					    	+ "10101 "
					    	+ "10101 "
					    	+ "10101 "
					    	+ "10001");
				break;
				
			case 'N': //4E
				drawLetter(4, "10001 "
					    	+ "11001 "
					    	+ "10101 "
					    	+ "10011 "
					    	+ "10001");
				break;
			
			case 'O': //4F
				drawLetter(4, "01110 "
					    	+ "10001 "
					    	+ "10001 "
					    	+ "10001 "
					    	+ "01110");
				break;
				
			case 'P': //50
				drawLetter(4, "1110 "
					    	+ "1001 "
					    	+ "1110 "
					    	+ "1000 "
					    	+ "1000");
				break;
				
			case 'Q': //51
				drawLetter(4, "011100 "
					    	+ "100010 "
					    	+ "100010 "
					    	+ "100010 "
					    	+ "011111");
				break;
				
			case 'R': //52
				drawLetter(4, "1110 "
					    	+ "1001 "
					    	+ "1110 "
					    	+ "1010 "
					    	+ "1001");
				break;
				
			case 'S': //53
				drawLetter(4, "0111 "
					    	+ "1000 "
					    	+ "0110 "
					    	+ "0001 "
					    	+ "1110");
				break;
				
			case 'T': //54
				drawLetter(4, "11111 "
					    	+ "00100 "
					    	+ "00100 "
					    	+ "00100 "
					    	+ "00100");
				break;
				
			case 'U': //55
				drawLetter(4, "1001 "
					    	+ "1001 "
					    	+ "1001 "
					    	+ "1001 "
					    	+ "0110");
				break;
				
			case 'V': //56
				drawLetter(4, "10001 "
					    	+ "10001 "
					    	+ "01010 "
					    	+ "01010 "
					    	+ "00100");
				break;
				
			case 'W': //57
				drawLetter(4, "10001 "
					    	+ "10101 "
					    	+ "10101 "
					    	+ "10101 "
					    	+ "01110");
				break;
				
			case 'X': //58
				drawLetter(4, "10001 "
					    	+ "01010 "
					    	+ "00100 "
					    	+ "01010 "
					    	+ "10001");
				break;
				
			case 'Y': //59
				drawLetter(4, "10001 "
					    	+ "01010 "
					    	+ "00100 "
					    	+ "00100 "
					    	+ "00100");
				break;
				
			case 'Z': //5A
				drawLetter(4, "11111 "
					    	+ "00010 "
					    	+ "00100 "
					    	+ "01000 "
					    	+ "11111");
				break;
			}
		}
	}
}
