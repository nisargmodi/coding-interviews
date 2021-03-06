import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HangManMain {
	
	public static void main(String[] args) throws IOException {
		
		boolean play = true;
		while(play) {
			/*System.out.println("Enter P for play, X for exit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			if(br.readLine().equalsIgnoreCase("P")) {
				System.out.println("playing");
				playGame();
			}
			else {
				play = false;
			}*/
			
		}
				
	}

	private static void playGame() {
		
		HangManBrain brain = new HangManBrain();
		RestInterface restInterface = new RestInterface();
		HangManServer gameContext = restInterface.startGame();
		
		int errorCount = 0;
		int totalGuesses = 0;
		
		while(!gameContext.getGameStatus().equals("DEAD") && !gameContext.getGameStatus().equals("FREE")) {
			
			System.out.println(gameContext.getState());
			
			char guess = brain.makeGuess(gameContext.getState()); //Let HangMan Brain make a guess
			
			HangManServer gameContextAfterGuess = restInterface.makeGuess(gameContext, guess); //Update the state
			
			totalGuesses++;
			
			if(gameContext.getState().equals(gameContextAfterGuess.getState())){
				brain.update(guess, false);
				errorCount++;
			}
			else{
				brain.update(guess, true);
			}
			gameContext = gameContextAfterGuess;
		}
		
		if(gameContext.getGameStatus().equals("DEAD")){
			System.out.println("Failed!");
		}
		if(gameContext.getGameStatus().equals("FREE")){
			System.out.println("Success!");
		}

	}
}