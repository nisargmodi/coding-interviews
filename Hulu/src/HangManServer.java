public class HangManServer {
	
	private String gameStatus;
	private String token;
	private int remaining;
	private String state;
	
	public String toString(){
		return "'status': " + gameStatus + ", 'token': " + token + ", 'remaining_guesses': " + remaining + ", 'state': " + state;
	}
	
	public String getGameStatus() {
		return gameStatus;
	}
	
	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public int getRemaining() {
		return remaining;
	}
	
	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}