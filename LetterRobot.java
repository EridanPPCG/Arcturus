//This class creates methods to draw characters on the plane.
//In the grids, 1 represents a beeper, and 0 represents empty space
//Created 02/18/2016 by Trevor B. (Stack Exchange user Eridan)
//Last updated 03/01/2016

public class LetterRobot extends BetterRobot {
	
	public LetterRobot(String name, int avenue, int street, Direction direction, int beepers) {
		super(name, avenue, street, direction, beepers);
	}
	
	public void drawLetter(int distanceToTop, String letterGrid) {
		int firstXCoordinate =  getXCoordinate();
		int firstYCoordinate = getYCoordinate();
		int maximumXCoordinate = getXCoordinate();
		
		move(distanceToTop);
		
		for(int characterIndex = 0; characterIndex < letterGrid.length(); characterIndex++) {
			char characterInString = letterGrid.charAt(characterIndex);
			
			if(characterInString == '0') {
				faceThisDirection(East);
				move(1);
				maximumXCoordinate = Math.max(maximumXCoordinate, getXCoordinate());
			}
			else if(characterInString == '1') {
				faceThisDirection(East);
				putBeeperAndMove();
				maximumXCoordinate = Math.max(maximumXCoordinate, getXCoordinate());
			}
			else if(characterInString == ' ') {
				coordinateChange(firstXCoordinate, getYCoordinate()-1);
			}
		}
		
		coordinateChange(maximumXCoordinate + 2, firstYCoordinate);
		faceThisDirection(North);
	}
	
	public void drawString(String string) {
		for(int characterIndex = 0; characterIndex < string.length(); characterIndex++) {
			char character = string.charAt(characterIndex);
			
			switch(character) {
			
			case ' ': //20
				drawLetter(0, "000");
				break;
				
			case '!': //21
				drawLetter(4, "1 " +
							  "1 " +
							  "1 " +
							  "0 " +
							  "1");
				break;
				
			case '"': //22
				drawLetter(4, "101 " +
							  "101 " +
							  "000 " +
							  "000 " +
							  "000");
				break;
				
			case '#': //23
				drawLetter(4, "01010 " +
							  "11111 " +
							  "01010 " +
							  "11111 " +
							  "01010");
				break;
				
			case '$': //24
				drawLetter(5, "00100 " +
							  "01111 " +
							  "10100 " +
							  "01110 " +
							  "00101 " +
							  "11110 " +
							  "00100");
				break;
				
			case '%': //25
				drawLetter(4, "11001 " +
							  "11010 " +
							  "00100 " +
							  "01011 " +
							  "10011");
				break;
				
			case '&': //26
				drawLetter(4, "01000 " +
							  "10100 " +
							  "01101 " +
							  "10010 " +
							  "01101");
				break;
				
			case '\'': //27
				drawLetter(4, "1 " +
							  "1 " +
							  "0 " +
							  "0 " +
							  "0");
				break;
				
			case '(': //28
				drawLetter(4, "01 " +
							  "10 " +
							  "10 " +
							  "10 " +
							  "01");
				break;
				
			case ')': //29
				drawLetter(4, "10 " +
							  "01 " +
							  "01 " +
							  "01 " +
							  "10");
				break;
				
			case '*': //2A
				drawLetter(4, "101 " +
							  "010 " +
							  "101 " +
							  "000 " +
							  "000");
				break;
				
			case '+': //2B
				drawLetter(3, "010 " +
							  "111 " +
							  "010 " +
							  "000");
				break;
				
			case ',': //2C
				drawLetter(0, "01 " +
							  "10");
				break;
				
			case '-': //2D
				drawLetter(2, "11 " +
							  "00 " +
							  "00");
				break;
				
			case '.': //2E
				drawLetter(0, "1");
				break;
				
			case '/': //2F
				drawLetter(4, "00001 " +
							  "00010 " +
							  "00100 " +
							  "01000 " +
							  "10000");
				break;
				
			case '0': //30
				drawLetter(4, "0110 " +
							  "1001 " +
							  "1001 " +
							  "1001 " +
							  "0110");
				break;
				
			case '1': //31
				drawLetter(4, "010 " +
							  "110 " +
							  "010 " +
							  "010 " +
							  "111");
				break;
								
			case '2': //32
				drawLetter(4, "0110 " +
							  "1001 " +
							  "0010 " +
							  "0100 " +
							  "1111");
				break;
				
			case '3': //33
				drawLetter(4, "0110 " +
							  "1001 " +
							  "0010 " +
							  "1001 " +
							  "0110");
				break;
				
			case '4': //34
				drawLetter(4, "101 " +
							  "101 " +
							  "111 " +
							  "001 " +
							  "001");
				break;
				
			case '5': //35
				drawLetter(4, "1111 " +
							  "1000 " +
							  "1110 " +
							  "0001 " +
							  "1110");
				break;
				
			case '6': //36
				drawLetter(4, "011 " +
							  "100 " +
							  "111 " +
							  "101 " +
							  "111");
				break;
				
			case '7': //37
				drawLetter(4, "1111 " +
							  "0001 " +
							  "0010 " +
							  "0100 " +
							  "1000");
				break;
				
			case '8': //38
				drawLetter(4, "0110 " +
							  "1001 " +
							  "0110 " +
							  "1001 " +
							  "0110");
				break;
				
			case '9': //39
				drawLetter(4, "111 " +
							  "101 " +
							  "111 " +
							  "001 " +
							  "110");
				break;
				
			case ':': //3A
				drawLetter(3, "1 " +
							  "0 " +
							  "1 " +
							  "0");
				break;
				
			case ';': //3B
				drawLetter(1, "01 " +
							  "01 " +
							  "10");
				break;
				
			case '<': //3C
				drawLetter(4, "001 " +
							  "010 " +
							  "100 " +
							  "010 " +
							  "001");
				break;
				
			case '=': //3D
				drawLetter(3, "1111 " +
							  "0000 " +
							  "1111 " +
							  "0000");
				break;
				
			case '>': //3E
				drawLetter(4, "100 " +
							  "010 " +
							  "001 " +
							  "010 " +
							  "100");
				break;
				
			case '?': //3F
				drawLetter(4, "01110 " +
							  "10001 " +
							  "00110 " +
							  "00000 " +
							  "00100");
				break;
				
			case '@': //40
				drawLetter(5, "0111110 " +
							  "1000001 " +
							  "1011101 " +
							  "1010101 " +
							  "1011111 " +
							  "1000001 " +
							  "0111110");
				break;
				
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
				
			case '[': //5B
				drawLetter(4, "11 " +
							  "10 " +
							  "10 " +
							  "10 " +
							  "11");
				break;
				
			case '\\': //5C
				drawLetter(4, "10000 " +
							  "01000 " +
							  "00100 " +
							  "00010 " +
							  "00001");
				break;
				
			case ']': //5D
				drawLetter(4, "11 " +
							  "01 " +
							  "01 " +
							  "01 " +
							  "11");
				break;
				
			case '^': //5E
				drawLetter(4, "010 " +
							  "101 " +
							  "000 " +
							  "000 " +
							  "000");
				break;
				
			case '_': //5F
				drawLetter(0, "111");
				break;
				
			case '`': //60
				drawLetter(4, "10 " +
							  "01 " +
							  "00 " +
							  "00 " +
							  "00");
				break;
				
			case 'a': //61
				drawLetter(2, "1110 " +
							  "1010 " +
							  "1111");
				break;
				
			case 'b': //62
				drawLetter(4, "100 " +
							  "100 " +
							  "111 " +
							  "101 " +
							  "111");
				break;
				
			case 'c': //63
				drawLetter(2, "111 " +
							  "100 " +
							  "111");
				break;
				
			case 'd': //64
				drawLetter(4, "001 " +
							  "001 " +
							  "111 " +
							  "101 " +
							  "111");
				break;
				
			case 'e': //65
				drawLetter(3, "111 " +
							  "111 " +
							  "100 " +
							  "111");
				break;
				
			case 'f': //66
				drawLetter(4, "011 " +
							  "010 " +
							  "111 " +
							  "010 " +
							  "010");
				break;
				
			case 'g': //67
				drawLetter(2, "111 " +
							  "101 " +
							  "111 " +
							  "001 " +
							  "111");
				break;
				
			case 'h': //68
				drawLetter(4, "100 " +
							  "100 " +
							  "111 " +
							  "101 " +
							  "101");
				break;
				
			case 'i': //69
				drawLetter(3, "1 " +
							  "0 " +
							  "1 " +
							  "1");
				break;
				
			case 'j': //6A
				drawLetter(3, "001 " +
							  "000 " +
							  "001 " +
							  "001 " +
							  "101 " +
							  "010");
				break;
				
			case 'k': //6B
				drawLetter(4, "100 " +
							  "100 " +
							  "101 " +
							  "110 " +
							  "101");
				break;
							
			case 'l': //6C
				drawLetter(4, "10 " +
							  "10 " +
							  "10 " +
							  "10 " +
							  "11");
				break;
				
			case 'm': //6D
				drawLetter(2, "01110 " +
							  "10101 " +
							  "10101");
				break;
				
			case 'n': //6E
				drawLetter(2, "010 " +
							  "101 " +
							  "101");
				break;
				
			case 'o': //6F
				drawLetter(2, "111 " +
							  "101 " +
							  "111");
				break;
				
			case 'p': //70
				drawLetter(2, "111 " +
							  "101 " +
							  "111 " +
							  "100 " +
							  "100");
				break;
				
			case 'q': //71
				drawLetter(2, "111 " +
							  "101 " +
							  "111 " +
							  "001 " +
							  "001");
				break;
				
			case 'r': //72
				drawLetter(2, "011 " +
							  "100 " +
							  "100");
				break;
				
			case 's': //73
				drawLetter(3, "0011 " +
							  "1100 " +
							  "0011 " +
							  "1100");
				break;
				
			case 't': //74
				drawLetter(4, "010 " +
							  "010 " +
							  "111 " +
							  "010 " +
							  "011");
				break;
				
			case 'u': //75
				drawLetter(2, "101 " +
							  "101 " +
							  "111");
				break;
				
			case 'v': //76
				drawLetter(2, "101 " +
							  "101 " +
							  "010");
				break;
				
			case 'w': //77
				drawLetter(2, "10101 " +
							  "10101 " +
							  "01110");
				break;
				
			case 'x': //78
				drawLetter(2, "101 " +
							  "010 " +
							  "101");
				break;
				
			case 'y': //79
				drawLetter(2, "101 " +
							  "101 " +
							  "111 " +
							  "001 " +
							  "111");
				break;
				
			case 'z': //7A
				drawLetter(3, "1111 " +
							  "0010 " +
							  "0100 " +
							  "1111");
				break;
				
			case '{': //7B
				drawLetter(4, "011 " +
							  "010 " +
							  "100 " +
							  "010 " +
							  "011");
				break;
				
			case '|': //7C
				drawLetter(5, "1 " +
							  "1 " +
							  "1 " +
							  "1 " +
							  "1 " +
							  "1 " +
							  "1");
				break;
				
			case '}': //7D
				drawLetter(4, "110 " +
							  "010 " +
							  "001 " +
							  "010 " +
							  "110");
				break;
				
			case '~': //7E
				drawLetter(3, "0101 " +
							  "1010 " +
							  "0000 " +
							  "0000");
				break;
			}
		}
	}
}
