//This class creates methods to draw characters on the plane.
//In the grids, 1 represents a beeper, and 0 represents empty space
//Created 02/18/2016 by Trevor B. (Stack Exchange user Eridan)
//Last updated 02/18/2016

public class LetterRobot extends BetterRobot {
	
	public LetterRobot(String name, int avenue, int street, Direction direction, int beepers) {
		super(name, avenue, street, direction, beepers);
	}
	
	public void drawLetter(int distanceToTop, String letterGrid) {
		int firstXCoordinate = xCoordinate;
		int firstYCoordinate = yCoordinate;
		int maximumXCoordinate = xCoordinate;
		
		move(distanceToTop);
		
		for(int numberIndex = 0; numberIndex < letterGrid.length(); numberIndex++) {
			if(letterGrid.charAt(numberIndex) == '0') {
				faceEast();
				move(1);
				maximumXCoordinate = Math.max(maximumXCoordinate, xCoordinate);
			}
			else if(letterGrid.charAt(numberIndex) == '1') {
				faceEast();
				putBeeperAndMove();
				maximumXCoordinate = Math.max(maximumXCoordinate, xCoordinate);
			}
			else if(letterGrid.charAt(numberIndex) == ' ') {
				coordinateChange(firstXCoordinate, yCoordinate-1);
			}
			else if(letterGrid.charAt(numberIndex) == 'n') {
				coordinateChange(maximumXCoordinate + 1, firstYCoordinate);
				faceNorth();
			}
		}
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
					    + "1001n");
				break;
			
			case 'B': //42
				drawLetter(4, "11110 "
					    + "10001 "
					    + "11110 "
					    + "10001 "
					    + "11110n");
				break;
				
			case 'C': //43
				drawLetter(4, "0111 "
					    + "1000 "
					    + "1000 "
					    + "1000 "
					    + "0111n");
				break;
		
			case 'D': //44
				drawLetter(4, "1110 "
					    + "1001 "
					    + "1001 "
					    + "1001 "
					    + "1110n");
				break;
				
			case 'E': //45
				drawLetter(4, "1111 "
					    + "1000 "
					    + "1110 "
					    + "1000 "
					    + "1111n");
				break;
			
			case 'F': //46
				drawLetter(4, "1111 "
					    + "1000 "
					    + "1110 "
					    + "1000 "
					    + "1000n");
				break;
			
			case 'G': //47
				drawLetter(4, "01111 "
					    + "10000 "
					    + "10111 "
					    + "10001 "
					    + "01111n");
				break;
			
			case 'H': //48
				drawLetter(4, "1001 "
					    + "1001 "
					    + "1111 "
					    + "1001 "
					    + "1001n");
				break;
			
			case 'I': //49
				drawLetter(4, "11111 "
					    + "00100 "
					    + "00100 "
					    + "00100 "
					    + "11111n");
				break;
			
			case 'J': //4A
				drawLetter(4, "0001 "
					    + "0001 "
					    + "0001 "
					    + "1001 "
					    + "0110n");
				break;
			
			case 'K': //4B
				drawLetter(4, "1001 "
					    + "1010 "
					    + "1100 "
					    + "1010 "
					    + "1001n");
				break;
			
			case 'L': //4C
				drawLetter(4, "1000 "
					    + "1000 "
					    + "1000 "
					    + "1000 "
					    + "1111n");
				break;
			
			case 'M': //4D
				drawLetter(4, "01110 "
					    + "10101 "
					    + "10101 "
					    + "10101 "
					    + "10001n");
				break;
				
			case 'N': //4E
				drawLetter(4, "10001 "
					    + "11001 "
					    + "10101 "
					    + "10011 "
					    + "10001n");
				break;
			
			case 'O': //4F
				drawLetter(4, "01110 "
					    + "10001 "
					    + "10001 "
					    + "10001 "
					    + "01110n");
				break;
				
			case 'P': //50
				drawLetter(4, "1110 "
					    + "1001 "
					    + "1110 "
					    + "1000 "
					    + "1000n");
				break;
				
			case 'Q': //51
				drawLetter(4, "011100 "
					    + "100010 "
					    + "100010 "
					    + "100010 "
					    + "011111n");
				break;
				
			case 'R': //52
				drawLetter(4, "1110 "
					    + "1001 "
					    + "1110 "
					    + "1010 "
					    + "1001n");
				break;
				
			case 'S': //53
				drawLetter(4, "0111 "
					    + "1000 "
					    + "0110 "
					    + "0001 "
					    + "1110n");
				break;
				
			case 'T': //54
				drawLetter(4, "11111 "
					    + "00100 "
					    + "00100 "
					    + "00100 "
					    + "00100n");
				break;
				
			case 'U': //55
				drawLetter(4, "1001 "
					    + "1001 "
					    + "1001 "
					    + "1001 "
					    + "0110n");
				break;
				
			case 'V': //56
				drawLetter(4, "10001 "
					    + "10001 "
					    + "01010 "
					    + "01010 "
					    + "00100n");
				break;
				
			case 'W': //57
				drawLetter(4, "10001 "
					    + "10101 "
					    + "10101 "
					    + "10101 "
					    + "01110n");
				break;
				
			case 'X': //58
				drawLetter(4, "10001 "
					    + "01010 "
					    + "00100 "
					    + "01010 "
					    + "10001n");
				break;
				
			case 'Y': //59
				drawLetter(4, "10001 "
					    + "01010 "
					    + "00100 "
					    + "00100 "
					    + "00100n");
				break;
				
			case 'Z': //5A
				drawLetter(4, "11111 "
					    + "00010 "
					    + "00100 "
					    + "01000 "
					    + "11111n");
				break;
			}
		}
	}
}