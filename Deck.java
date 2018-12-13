import java.util.ArrayList;
import java.util.Random;

public class Deck {


	private ArrayList<Card> cards;
	public ArrayList<Card> usedCard = new ArrayList<Card>(); //�NusedCard��l��
	private ArrayList<Card> openCard = new ArrayList<Card>();
	public int nUsed = 0;

	
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		
		for (int i = 1; i <= nDeck; i++) {
			for (Card.Suit s : Card.Suit.values()) {
				for (int k = 1; k <= 13; k++) {
					Card card = new Card(s, k);
					cards.add(card);
				}
			}
		}
		shuffle();  //�o��h��@��shuffle()�A�ϱo�{���C�]�@�� �N�~�@���P
	}
	
	public void printDeck() {
		for(int l = 0; l < cards.size(); l++) {
			Card takecard = cards.get(l);
			takecard.printCard();
		}		
	}
	
	public ArrayList<Card> getAllCards() {
		return cards;
	}

	
	public void shuffle() {		
		Random rnd = new Random();
		
		cards.addAll(usedCard);     //��ϥιL���P��^ cards ��
		usedCard.clear();
		openCard.clear();
		nUsed = 0;
		
		for(int i = 0; i < cards.size(); i++) {    //��cards.size�M�w�n�]�X��
			int nrnd = rnd.nextInt(cards.size());  //��nrnd�s��üƪ��ȡA�ӶüƤ����ѼƧک񪺬Ocards.size()�O�]���ڧƱ���H����@�Ӧ�m���洫
			Card first = cards.get(nrnd);          //���@���ܼƦs�� �üƦ�m ������
			cards.set(nrnd,cards.get(i));          //�Φ��üƦ�m���ȩ�J��i��m����
			cards.set(i,first);                    //��i��m���ȩ�J�ڭ̦s��nrnd����
		}
	}
	
	public Card getOneCard(boolean isOpened) {		
		if(cards.size() == 0 ) {     //��cards�̭��S�P���ɭԡA���� shuffle()
			shuffle();
		}

		Card value = cards.get(0);   //�]�w�@���ܼƦs��a�@�i�P����
		usedCard.add(cards.get(0));  //�⦹�ȩ�JusedCard
		cards.remove(0);             //��Ĥ@�i�P���Ȳ���  
		nUsed ++;                    //nUsed +1
		
		if(nUsed == 1) {
			isOpened = false;
		}
		
		if(isOpened = true) {
			openCard.add(cards.get(nUsed - 1));
		}
		
		return value;                //�����^��
	}
	
	public ArrayList<Card> getOpenedCard(){
		return openCard;
		
	}

}
