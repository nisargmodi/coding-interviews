import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.io.InputStreamReader;
import java.util.regex.*;

public class RestInterface {
	public static HangManServer initializeGame(String s){
		HangManServer hangManServer = new HangManServer();
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new URL("http://gallows.hulu.com/play?code=nisarg92modi@gmail.com" + s).openStream()));
			String info = in.readLine(); 

			Pattern p = Pattern.compile("(ALIVE|DEAD|FREE)");
			Matcher m = p.matcher(info);

			Pattern p1 = Pattern.compile("(\\d+)");
			Matcher m1 = p1.matcher(info);

			
			Pattern p2 = Pattern.compile("(\\d)(,)");
			Matcher m2 = p2.matcher(info);
			
			Pattern p3 = Pattern.compile("([A-Z_'\\s]+)(\"})");
			Matcher m3 = p3.matcher(info);

			
			if(m.find() && m1.find() && m2.find() && m3.find()){
				hangManServer.setGameStatus(m.group());
				hangManServer.setToken(m1.group());
				hangManServer.setRemaining(Integer.parseInt(m2.group(1)));
				hangManServer.setState(m3.group(1));
			}
		}catch(IOException e){
			System.err.println(e);
		}
		return hangManServer;
	}
	
	public HangManServer startGame(){
		return initializeGame("");
	}
	
	public HangManServer makeGuess(HangManServer hangManServer, char guess){
		return initializeGame(String.format("&token=%s&guess=%s", hangManServer.getToken(), guess));
	}
}