import java.util.ArrayList;

public abstract class Player extends Person {

	private String name;
	private int chips;
	private int bet;
	private ArrayList<Card> oneRoundCard = new ArrayList<Card>();

	public Player(String name, int chips) {
		this.name = name; // 把name指定給this.name
		this.chips = chips; // 把chips指定給this.chips
	}

	public String getName() {
		return name;
	}

	public int makeBet() {
		if (chips == 0) { // 使用if判斷是否還有錢，如果chips = 0，則把設為0，使得玩家不得下注
			bet = 0;
		}

		bet = 1; // 假設bet = 1
		return bet;
	}

	public boolean hit_me(Table table) {
		int value = 0; // value用來存放現在卡牌點數
		for (int i = 0; i < oneRoundCard.size(); i++) { // 使用迴圈，把oneRoundCard裡面的值存放於value中
			Card oPRC = oneRoundCard.get(i);
			value = value + oPRC.getRank();
		}

		if (value < 17) { // 如果點數小於17繼續要牌
			return true;
		}

		return false; // 如果>=17則停止要牌
	}

	public int getCurrentChips() {
		return chips;
	}

	public void increaseChips(int diff) {
		chips = diff;
	}

	public void sayHello() {
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
	}
}
