package compress;

public class Word {
	String name = "";
	int frequency = 0;
	final int index;
	public Word(String n, int f, int i){
		this.name = n;
		this.frequency = f;
		this.index = i;
	}
	void incrementFrequency(){
		this.frequency++;
	}
	String getName(){
		return name;
	}
	int getIndex(){
		return index;
	}
	public String toString(){
		return name + " " + frequency + " " + index;
	}
}
