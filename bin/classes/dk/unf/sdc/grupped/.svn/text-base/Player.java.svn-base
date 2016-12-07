package dk.unf.sdc.grupped;

import java.util.ArrayList;

public class Player {

	private ArrayList<Integer> cards = new ArrayList<Integer>();

	public void addCard(int id) {
		cards.add(id);

	}

	public void removeCard(Integer id) {
		cards.remove(cards.indexOf(id));
	}

	public int playCard() {

		if (cards.size() != 0) {
			int tmp = cards.get(0);
			cards.remove(0);
			return tmp;
		} else {
			return -1;
		}
	}

	public ArrayList<Integer> getCards() {
		return cards;
	}
}
