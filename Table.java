import java.util.ArrayList;

public class Table {
	final int MAXPLAYER = 4;

	private Deck AllCards;
	private Player[] AllPlayer;
	private Dealer NextBanker;
	private int[] pos_betArray;

	private int nDeck = 4;

	private Deck deck = new Deck(nDeck);
	//Player player = new Player();

	public void Table(int nDeck) {
		Deck deck = new Deck(nDeck);

		AllPlayer = new Player[MAXPLAYER];
	}

	public void set_player(int pos, Player p) {
		int count = 0; // �s�W�p�ƾ�
		if (count <= MAXPLAYER) { // ��p�ƾ�<=MAXPLAYER���ɭ԰���
			AllPlayer[pos] = p; // �NPlayer p�s�J�P���m���^�Ǫ�pos���a��
			count++; // �p�ƾ��[1
		}
	}

	public Player[] get_player() {
		return AllPlayer; // �^��
	}

	public void set_dealer(Dealer d) {
		NextBanker = d; // �NNextBanker����=d
	}

	public Card get_face_up_card_of_dealer() {
		return null;
	}

	private void ask_each_player_about_bets() {
		int bet = 0;
		for (int i = 0; i < MAXPLAYER; i++) {
			AllPlayer[i].sayHello();
			AllPlayer[i].makeBet();
			pos_betArray[i] += bet;
		}
	}

	private void distribute_cards_to_dealer_and_players() {
		
	}

	private void ask_each_player_about_hits() {

		//�Ѧ�HW4
		boolean hit = false;
		Player player1 = AllPlayer[1];
		ArrayList<Card> player1Card=new ArrayList<Card>();
		do {
			hit = player1.hit_me(null); 
			if (hit) {
				player1Card.add(deck.getOneCard(true));
				player1.setOneRoundCard(player1Card);
				System.out.print("Hit! ");
				System.out.println(player1.getName() + "'s Cards now:");
				for (Card c : player1Card) {
					c.printCard();
				}
			} 
			else {
				System.out.println(player1.getName() + ", Pass hit!");
				System.out.println(player1.getName() + ", Final Card:");
				for (Card c : player1Card) {
					c.printCard();
				}
			}
		} while (hit);

	}

	private void ask_dealer_about_hits() {
		
	}

	private void calculate_chips() {

		System.out.println("Dealer's hit is over!");
	}

	public int[] get_players_bet() {
		return null;
	}

	public void play() {
		ask_each_player_about_bets();
		distribute_cards_to_dealer_and_players();
		ask_each_player_about_hits();
		ask_dealer_about_hits();
		calculate_chips();
	}

}
