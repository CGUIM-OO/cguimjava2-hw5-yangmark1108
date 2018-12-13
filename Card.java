
public class Card {


	public enum Suit{Club, Diamond, Heart, Spade}; // 用 enum 放 Clubs, Diamonds, Hearts, Spades
	private Suit suit;
	private int rank; // 1~13

	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(Suit s, int r) {    //將s的型態改為Suit
		suit = s;
		rank = r;
	}
	
	public void printCard() {		
		String su = "";
		String rk = "";

		
		switch(suit) {       //使用switch迴圈判斷suit是哪一個
		case Club:
			su = "Club";
			break;
		case Diamond:
			su = "Diamond";
			break;
		case Heart:
			su = "Heart";
			break;
		case Spade:
			su = "Spade";
			break;
		}

		switch (rank) {
		case 1:
			rk = "Ace";
			break;
		case 2:
			rk = "Two";
			break;
		case 3:
			rk = "Three";
			break;
		case 4:
			rk = "Four";
			break;
		case 5:
			rk = "Five";
			break;
		case 6:
			rk = "Six";
			break;
		case 7:
			rk = "Seven";
			break;
		case 8:
			rk = "Eight";
			break;
		case 9:
			rk = "Nine";
			break;
		case 10:
			rk = "Ten";
			break;
		case 11:
			rk = "Jack";
			break;
		case 12:
			rk = "Queen";
			break;
		case 13:
			rk = "King";
			break;
		}

		System.out.println(suit + "," + rank + " as " + su + " " + rk);
	}

	public Suit getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}
