import java.util.ArrayList;

public abstract class Player extends Person {

	private String name;
	private int chips;
	private int bet;
	private ArrayList<Card> oneRoundCard = new ArrayList<Card>();

	public Player(String name, int chips) {
		this.name = name; // ��name���w��this.name
		this.chips = chips; // ��chips���w��this.chips
	}

	public String getName() {
		return name;
	}

	public int makeBet() {
		if (chips == 0) { // �ϥ�if�P�_�O�_�٦����A�p�Gchips = 0�A�h��]��0�A�ϱo���a���o�U�`
			bet = 0;
		}

		bet = 1; // ���]bet = 1
		return bet;
	}

	public boolean hit_me(Table table) {
		int value = 0; // value�ΨӦs��{�b�d�P�I��
		for (int i = 0; i < oneRoundCard.size(); i++) { // �ϥΰj��A��oneRoundCard�̭����Ȧs���value��
			Card oPRC = oneRoundCard.get(i);
			value = value + oPRC.getRank();
		}

		if (value < 17) { // �p�G�I�Ƥp��17�~��n�P
			return true;
		}

		return false; // �p�G>=17�h����n�P
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
