import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TagMatching extends StringStackImpl {	
	  
	 public static void main(String args[])  {
		
		StringStackImpl stack = new StringStackImpl();
		
		try { //gia to diavasma tou arxeiou
			String filename = args[0];
			File file = new File(filename);
			FileReader fr=new FileReader(file);   //reads the file  
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			String line; 
			boolean open = false;
			//to ch einai to kathe tag , arxika einai keno
			String ch = "";
			while((line=br.readLine())!=null)  {  //diavasma grammhs
				
				for(int i = 0; i<line.length();i++) {
					/*gia olo to megethos ths grammhs
					 * koitame enan enan olous tous xarakthres an vroume xar/ra "<" tote shmainei
					 * oti sto ch tha grapsoume kapoio tag, sunexizoume mexri na vroume to kleisimo ">"
					 * kai to vazoume sthn stoiva.
					 * */
					if(line.charAt(i) == '<') {
						open = true;
						ch+=line.charAt(i);
						
					}
					else if(line.charAt(i) == '>'  ) {
						
						ch+=line.charAt(i);
						if(ch.startsWith("</")) {
							/*an vroume xarakthra "/" meta apo to "<" tote
							 * diavazoume mexri pali na kleisei ">" kai koitame
							 * an to antistoixo anoixto tag exei mpei sthn stoiva 
							 * an exei mpei to afairoume. Skopos mas einai h stoiva sto telos
							 * na einai adeia, ara shmainei oti ola ta tags ekleinan swsta.*/
							String top = stack.peek();
							String cTop = top.substring(1, top.length()-1); //to substring kovei ta html tags gia na mporei na sugkrinei an einai idio auto pou anoigei (vrisketai sthn stoiva) me auto pou kleinei
							if(ch.contains(cTop) ) {
								stack.pop();
								ch = "";
							}
							else {
								ch = "";
							}
						}
						if(ch!="") {
							stack.push(ch);	
						}
						
						open = false;
						ch="";
					}
					else if(open) {
						ch+=line.charAt(i);
						
					
					}
				}
			}
			fr.close();    //closes the stream and release the resources  
			
			
			if(stack.isEmpty()) {
				System.out.println("HTML tags are matching!");
			}
			else {
				System.out.println("HTML tags do not match!");
			}
				
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	 }
}


	
