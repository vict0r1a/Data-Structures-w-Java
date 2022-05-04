import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class NetBenefit extends IntQueueImpl {
	public static void main(String[] args)  {
		String filename = args[0];
		IntQueueImpl q = new IntQueueImpl();
		try {
			File file = new File(filename);
			FileReader fr=new FileReader(file);   //reads the file  
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			String line;  
			int profit = 0;
			boolean validProfit = true;
			while((line=br.readLine())!=null)  
			{  
				if (!line.equals("")) {//an den einai kenh grammh
					
					String array[] = line.split(" ");//diavasma grammhs, diaxwrismos grammhs me keno, eisagwgh se pinaka 
					//System.out.println(array[1]); 
					if(array[0].contains("buy")) { //diavasma prwths thesis 0 an einai buy
						//System.out.println(array[1]);
						for(int i = 0; i<Integer.valueOf(array[1]); i++) { //eisagwgh sthn oura timhs oses fores einai to buy, casting se int
							q.put(Integer.valueOf(array[3]));
						}
					}
					else {//an einai sell 
						for(int i = 0; i< Integer.valueOf(array[1]); i++) {
							if(!q.isEmpty()) {
								//upologismos kerdous afairwntas apo thn oura oses times leei to sell
								profit = profit + (Integer.valueOf(array[3])-q.peek());
							
								q.get();
							}
							else {
								validProfit = false; //periptwsh pou sell > buy 
							}
						}
						
					}	
					
				}
				else { //an einai kenh pame sthn epomenh 
					continue;
				}
			}
			if(validProfit) {
				System.out.println("Profit is: " + profit); //ektupwsh apotelesmatos
			}
			else { 
				System.out.println("Sell price is not valid.");
			}
			fr.close();    //closes the stream and release the resources  
 
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
