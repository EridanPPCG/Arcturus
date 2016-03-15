//This is the main class where the program will be run.
//Created 03/13/16 by Trevor B. (Stack Exchange user Eridan)
//Last updated 03/15/16

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Map;
import kareltherobot.Directions.Direction;

public enum Type {
	STRING        (       "string"),
	DOUBLE        (       "double"),
	INTEGER       (      "integer"),
	STRING_ARRAY  ( "string array"),
	DOUBLE_ARRAY  ( "double array"),
	INTEGER_ARRAY ("integer array");

	private final int string;
	
	Side(int string) {
		this.string = string;
	}
	
	public int toString() { return string; }
}

//unneeded start
//TODO: test all
public enum Side {
	LEFT  (-1),
	RIGHT ( 1);
	
	private final int multiplier;
	
	Side(int multiplier) {
		this.multiplier = multiplier;
	}
	
	public int multiplier() { return multiplier; }
}

public class Value {
	private String value;
	private ArrayList<String> arrayValue;
	private boolean isArray;
	private Type type;
	
	public Value(String s) {
		this.type = Type.STRING;
		this.value = s;
	}

	public Value(int i) {
		this.type = Type.INTEGER;
		this.value = i.toString();
	}

	public Value(double d) {
		this.type = Type.DOUBLE;
		this.value = d.toString();
	}
	
	public Value(ArrayList<string> s) {
		this.arrayValue = s;
		this.isArray = true;
		this.type = Type.STRING_ARRAY;
	}

	public Value(ArrayList<int> i) {
		this.arrayValue = new ArrayList<String>(i.length());
		for (int integer: i) {
			this.arrayValue.add(integer.toString());
		}
		this.isArray = true;
		this.type = Type.INTEGER_ARRAY;
	}

	public Value(ArrayList<double> d) {
		this.arrayValue = new ArrayList<String>(d.length());
		for (double doubl: d) {
			this.arrayValue.add(doubl.toString());
		}
		this.isArray = true;
		this.type = Type.DOUBLE_ARRAY;
	}

	//Mostly for internal use
	public String getString() {
		return this.value;
	}
	
	public int getInteger() {
		if (this.type = Type.INTEGER) {
			return Integer.parseInt(this.value);
		}
	}
	
	public double getDouble() {
		if (this.type = Type.DOUBLE) {
			return Double.parseDouble(this.value);
		}
	}

	public ArrayList<String> getStrings() {
		return this.arrayValue;
	}

	public ArrayList<int> getIntegers() {
		if (this.type = Type.INTEGER) {
			ArrayList<int> returns = new ArrayList<int>(this.arrayValue.length());
			for (String s: this.arrayValue) {
				returns.add(Int.parseInt(s));
			}
			return returns;
		}
	}

	public ArrayList<double> getDoubles() {
		if (this.type = Type.INTEGER) {
			ArrayList<double> returns = new ArrayList<double>(this.arrayValue.length());
			for (String s: this.arrayValue) {
				returns.add(Double.parseDouble(s));
			}
			return returns;
		}
	}

	public Type getType() {
		return this.type;
	}

	public String toString() {
		if (str != null && !str.isEmpty()) {
			return this.value;
		}
		else {
			return this.arrayValue.toString();
		}
	}
}

@FunctionalInterface
interface Function<One, Two, Three> {
    public Three apply(One one, Two two);
}

private class NoOperationException extends Exception {
	public NoOperationException(String message) {
		super(message);
	}

	public NoOperationException(Type left, Type right) {
		super("No operator found for types " + left.toString() + " and " + right.toString ".");
	}
}

public static class Operations {
	private String stringTimes(String s, double d) {
		//TODO: contracts
		int rounded = Math.ceil(d);
		return new String(new char[rounded]).replace("\0", s)).substring(0, Math.round(s.length() * d));
	}
	//TODO: add array types
	private Map<Type, Map<Type, Function<Value, Value, Value>>> addDictionary = new HashMap() {{
		put(Type.STRING, new HashMap() {{
			put(Type.STRING, (left, right) -> new Value(left.getString() + right.getString()));
			put(Type.INTEGER, (left, right) -> new Value(left.getString() + right.getString()));
			put(Type.DOUBLE, (left, right) -> new Value(left.getString() + right.getString()));
		}});
		put(Type.INTEGER, new HashMap() {{
			put(Type.STRING, (left, right) -> new Value(left.getString() + right.getString()));
			put(Type.INTEGER, (left, right) -> new Value(left.getInteger() + right.getInteger()));
			put(Type.DOUBLE, (left, right) -> new Value(left.getDouble() + right.getDouble()));
		}});
		put(Type.DOUBLE, new HashMap() {{
			put(Type.STRING, (left, right) -> new Value(left.getString() + right.getString()));
			put(Type.INTEGER, (left, right) -> new Value(left.getDouble() + right.getDouble()));
			put(Type.DOUBLE, (left, right) -> new Value(left.getDouble() + right.getDouble()));
		}});
	}}
	private Map<Type, Map<Type, Function<Value, Value, Value>>> subtractDictonary = new HashMap() {{
		put(Type.INTEGER, new HashMap() {{
			put(Type.INTEGER, (left, right) -> new Value(left.getInteger() - right.getInteger()));
			put(Type.DOUBLE, (left, right) -> new Value(left.getDouble() - right.getDouble()));
		}});
		put(Type.DOUBLE, new HashMap() {{
			put(Type.INTEGER, (left, right) -> new Value(left.getDouble() - right.getDouble()));
			put(Type.DOUBLE, (left, right) -> new Value(left.getDouble() - right.getDouble()));
		}});
	}}
	private Map<Type, Map<Type, Function<Value, Value, Value>>> multiplyDictionary = new HashMap() {{
		put(Type.STRING, new HashMap() {{
			put(Type.INTEGER, (left, right) -> new Value(stringTimes(left.getString(), right.getDouble())));
			put(Type.DOUBLE, (left, right) -> new Value(stringTimes(left.getString(), right.getDouble())));
		}});
		put(Type.INTEGER, new HashMap() {{
			put(Type.STRING, (left, right) -> new Value(stringTimes(left.getDouble(), right.getString())));
			put(Type.INTEGER, (left, right) -> new Value(left.getInteger() * right.getInteger()));
			put(Type.DOUBLE, (left, right) -> new Value(left.getDouble() * right.getDouble()));
		}});
		put(Type.DOUBLE, new HashMap() {{
			put(Type.STRING, (left, right) -> new Value(stringTimes(left.getDouble(), right.getString())));
			put(Type.INTEGER, (left, right) -> new Value(left.getDouble() * right.getDouble()));
			put(Type.DOUBLE, (left, right) -> new Value(left.getDouble() * right.getDouble()));
		}});
	}}
	private Map<Type, Map<Type, Function<Value, Value, Value>>> divideDictionary = new HashMap() {{
		put(Type.STRING, new HashMap() {{
			put(Type.INTEGER, (left, right) -> new Value(stringTimes(left.getString(), 1 / right.getDouble())));
			put(Type.DOUBLE, (left, right) -> new Value(stringTimes(left.getString(), 1 / right.getDouble())));
		}});
		put(Type.INTEGER, new HashMap() {{
			put(Type.INTEGER, (left, right) -> new Value(left.getInteger() / right.getInteger()));
			put(Type.DOUBLE, (left, right) -> new Value(left.getDouble() / right.getDouble()));
		}});
		put(Type.DOUBLE, new HashMap() {{
			put(Type.INTEGER, (left, right) -> new Value(left.getDouble() / right.getDouble()));
			put(Type.DOUBLE, (left, right) -> new Value(left.getDouble() / right.getDouble()));
		}});
	}}
	private Value performOperation(Map<Type, Map<Type, Function<Value, Value, Value>>> dictionary, Value left, Value right) throws NoOperationException {
		Type leftType = left.getType();
		Type rightType = right.getType();
		if (dictionary.containsKey(leftType) && dictionary.get(leftType).containsKey(rightType)) {
			return dictionary.get(leftType).get(rightType)(left, right);
		}
		else {
			throw new NoOperationException(leftType, rightType);
		}
	}
	//TODO: return a null value if operation not supposed to happen? (then handle error in below functions)
	public Value add(Value left, Value right) {
		return performOperation(addDictionary, left, right);
	}
	public Value subtract(Value left, Value right) {
		return performOperation(subtractDictonary, left, right);
	}
	public Value multiply(Value left, Value right) {
		return performOperation(multiplyDictionary, left, right);
	}
	public Value divide(Value left, Value right) {
		return performOperation(divideDictionary, left, right);
	}
}

public class Tape {
	private String[] tape;
	//private Value[] tape;
	private Type[] types;
	private int size;
	private int origin;
	
	public Tape(int size, int offset) {
		this.tape = new Value[size];
		this.types = new Type[size];
		this.size = size;
		this.origin = offset;
	}
	
	public void setValue(int position, String s) {
		this.tape[this.calculatePosition(position + this.origin)] = new Value(s);
	}

	public void setValue(int position, int i) {
		this.tape[this.calculatePosition(position + this.origin)] = new Value(i);
	}

	public void setValue(int position, double d) {
		this.tape[this.calculatePosition(position + this.origin)] = new Value(d);
	}
	
	public void setValue(int position, Value v) {
		this.tape[this.calculatePosition(position + this.origin)] = v;
	}
	
	public int calculatePosition(int position) {
		return (position + this.size) % this.size; //So negative values will work
	}
	
	public String getValue(int position) {
		return this.tape[this.calculatePosition(position)];
	}
	
	public void print(int position) {
		System.out.println(this.getValue(position));
	}
	
	public void print(int start, int end) {
		int step = 0;
		if (start <= end) {
			step = 1;
		}
		else {
			step = -1;
		}
		for (int i = start; i * step <= end * step; i += step) { //* step because negative comparisons are reversed
			System.out.println(this.getValue(i));
		}
	}

	public void print() {
		for (String value: tape) {
			System.out.println(value);
		}
	}

	public void printDebug() {
		int i = -origin; //TODO: check
		for (String value: tape) {
			System.out.print(i);
			System.out.print(' ');
			System.out.println(value);
			i++;
		}
	}
}

public class Robot {
	private int position;
	private int startPosition;
	private Side facing; //popdir
	private Tape tape;
	private ArrayList<int> positions; //TODO: change to Stack if want to remove
	private ArrayList<string> registers;
	private boolean record;
	
	public Robot(int start) {
		this.startPosition = start;
		this.position = start;
	}
	
	public void face(Side side) {
		this.facing = side;
	}
	
	public void printAll() {
		this.record = false;
	}
	
	public void printEnd() {
		this.record = true;
	}
	
	public void togglePrint() {
		this.record = !this.record;
	}
	
	public void move() {
		this.move(this.facing, 1);
	}
	
	public void move(int steps) { //named Side so Karel's Direction still works
		int oldPosition = this.position;
		this.position = this.tape.calculatePosition(this.position + this.facing.multiplier() * steps);
		if (this.record) {
			this.tape.print(oldPosition, this.position);
		}
		else {
			this.tape.print(this.position);
		}
	}
	
	public void goHome() {
		this.move(this.startPosition);
	}
	
	public void swap() {
		Value temporary = this.tape.getValue(this.position + this.facing.multiplier());
		this.tape.setValue(this.position + this.facing.multiplier(), this.tape.getValue(this.position));
		this.tape.setValue(this.position, temporary);
	}
	
	//TODO: rotate
	
	public void duplicate() {
		this.tape.setValue(this.position + this.facing.multiplier(), this.tape.getValue(this.position));
	}
	
	public void saveLocation(int position) {
		this.positions.add(position);
	}
	
	public void gotoLocation(int index) {
		this.position = this.positions[index];
	}
	
	public void copy() {
		registers.add(tape.getValue(this.position));
	}
	
	public void reg(int index) {
		tape.setValue(this.position, this.register[index]);
	}
	
	public void showOnTape() {
		int i = -origin; //TODO: check
		for (String value: tape) {
			System.out.print(i);
			if (i != this.position) {
				System.out.print("   ");
			}
			else {
				System.out.print(" R ");
			}
			System.out.println(value);
			i++;
		}
	}
}
//unneeded end

public class Arcturus extends LetterRobot {
	public Arcturus(String name, int avenue, int street, Direction direction, int beepers) {
		super(name, avenue, street, direction, beepers);
	}
	
	public static void main(String[] args) {
		//temporary
		ArrayList<String> code = new ArrayList<String>();
		for (String line : Files.readAllLines(Paths.get(args[0]))) {
		    code.add(line);
		}
		
		Arcturus bot = new Arcturus();
		Pattern rDouble = Pattern.compile("[\d,]+\.\d+");
		Pattern rInteger = Pattern.compile("[\d,]+");
		Scanner stdin = new Scanner(System.in);
		String program = stdin.nextLine();
		Type inputType = null; //TODO
		String input = stdin.nextLine(); //TODO: read only if there is input
		
		if(input.charAt(0) == '"') {
			inputType = Type.STRING;
		}
		else if(input.charAt(0) == '[') {
			inputType = Type.ARRAY; //TODO: differentiate between element type
		}
		else if(rDouble.Matcher(input).Matches()) {
			inputType = Type.DOUBLE;
		}
		else if(rInteger.Matcher(input).Matches()) {
			inputType = Type.INTEGER;
		}
		
		
		currentType = inputType;
		
		//Interpreting input
		
		if(currentType == Type.STRING) {
			for (char character: input) {
				bot.putBeeper((int) character);
			}
			/*for(int characterIndex = 0; characterIndex < input.length(); characterIndex++) {
				char currentCharacter = input.charAt(characterIndex);
				int ASCIIValue = (int) currentCharacter;
				bot.putBeeper(ASCIIValue); //can't make static reference to non-static method???
			}*/
		}
		if(currentType == Type.ARRAY) {
		}
		if(currentType == Type.DOUBLE) {
			//double d = Double.parseDouble(input);
		}
		if(currentType == Type.INTEGER) {
			//int i = Integer.parseInt(input);
		}
		//when double, set variable "a" equal double and give separate row.
		
		//commands have different functions depending on currentType, so can have 255*4 possible builtins
		
		//printing
	}
}
