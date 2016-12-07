package dk.unf.sdc.grupped;

import java.util.Random;


public class Game {
	private int Current1;
	private int Current2;
	private boolean netVærkSpil;

	private Player player1;
	private Player player2;
	private int win;

	public Game(boolean net) {
		if (net) {
			player1 = new Player();
			Random rand = new Random();
			for(int i=0; i<=9;i++){
			player1.addCard(rand.nextInt(20));
			}
		} else {
			player1 = new Player();
			player2 = new Player();

			Random rand = new Random();
			for(int i=0; i<=9;i++){
			player1.addCard(rand.nextInt(20));
			player2.addCard(rand.nextInt(20));
			}
		}

		
		netVærkSpil = net;
		this.drawCard();
	}

	private void drawCard() {
		if (netVærkSpil) {
			Current1 = player1.playCard();
			if(Current1==-1){
				win = 2;
			}
		} else {
			Current1 = player1.playCard();
			Current2 = player2.playCard();
		}
	}
	
	public void won(int wonCard){
		player1.addCard(wonCard);
		player1.addCard(Current1);
		drawCard();
	}
	
	public void lost(){
		drawCard();
	}

	public void setWinner(Player winner) {
		if (netVærkSpil) {
			winner.addCard(Current1);
		} else {
			winner.addCard(Current1);

			winner.addCard(Current2);
		}
		this.drawCard();
	}


	public void tied() {
		if (netVærkSpil) {
			player1.addCard(Current1);
		} else {
			player1.addCard(Current1);
			player2.addCard(Current2);
		}
		this.drawCard();
	}

	public int getCurrent1() {
		return Current1;
	}

	public void setCurrent1(int current1) {
		Current1 = current1;
	}

	public int getCurrent2() {
		return Current2;
	}

	public void setCurrent2(int current2) {
		Current2 = current2;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public int getWin() {
		return win;
	}

}
