package compress;

import java.io.*;
import java.util.*;

public class DeCompress {
	public static void main(String [] args) throws FileNotFoundException{
		PrintWriter outputFile = new PrintWriter("C:\\Users\\Nikita\\Documents\\outputd.czz");
		FileReader reader = new FileReader("C:\\Users\\Nikita\\Documents\\output.czz");
		Scanner inputFile = new Scanner(reader);
		ArrayList<Word> words = new ArrayList<Word>();
		String key = "";
		while(inputFile.hasNextLine()){
			if(inputFile.nextLine().equals("###KEY###")){
				key = inputFile.nextLine();
				break;
			}
		}
		String [] wobjs = key.split("#");		
		for(String s : wobjs){
			String [] ws = s.split(" ");
			int f = Integer.parseInt(ws[1]);
			int i = Integer.parseInt(ws[2]);
			words.add(new Word(ws[0], f, i));
		}
		while(inputFile.hasNextLine()){
			String cLine = inputFile.nextLine();
			if(!(cLine.equals(""))){
				String bLine = "";
				String [] strnums = cLine.split(" ");
				ArrayList<Integer> nums = new ArrayList<Integer>();
				for(int i = 0; i < strnums.length; i++){
					nums.add(Integer.parseInt(strnums[i]));
				}
				for(Integer i: nums){
					for(Word w: words){
						if(w.getIndex() == i)
							bLine += w.name + " ";
					}
				}
				outputFile.println(bLine);
			}		
		}
		inputFile.close();
		outputFile.close();
	}
}
