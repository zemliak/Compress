package compress;

import java.io.*;
import java.util.*;

public class Compress1{
	public static void main(String [] args) throws FileNotFoundException{
		ArrayList<Word> words = new ArrayList<Word>();
		PrintWriter outputFile = new PrintWriter("C:\\Users\\Nikita\\Documents\\output.czz");
		FileReader reader = new FileReader("C:\\Users\\Nikita\\Documents\\test1.txt");
		Scanner inputFile = new Scanner(reader);
		int index = 2;
		int wordIndex = 2;
		words.add(new Word("abc", 1, 1));
		ArrayList<String> compLines = new ArrayList<String>();
		while (inputFile.hasNextLine()){
			String compLine = "";
			String curLine = inputFile.nextLine();
			String [] line = curLine.split(" ");
			boolean exists = false;
			for(String l : line){
				exists = false;
				for(Word w : words){
					//System.out.println(w.name + w.getIndex());
					if(l.equals(w.name)){
						exists = true;
						w.incrementFrequency();
						wordIndex = w.getIndex();
					}
				}
				if(!exists){
					words.add(new Word(l, 1, index));
					wordIndex = index;
					index++;
				}
				compLine += wordIndex + " ";
			}
			compLines.add(compLine);
		}
		String keyLine = "";
		outputFile.println("###KEY###");
		for(Word w : words){
			keyLine += w + "#";
		}
		outputFile.println(keyLine);
		outputFile.println();
		outputFile.println();
		for(String s : compLines)
			outputFile.println(s);
		inputFile.close();
		outputFile.close();
	}
	
} 