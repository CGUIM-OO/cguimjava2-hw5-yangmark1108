import java.util.ArrayList;
import java.util.Random;

public class Deck {


	private ArrayList<Card> cards;
	public ArrayList<Card> usedCard = new ArrayList<Card>(); //將usedCard初始化
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
		shuffle();  //這邊多放一個shuffle()，使得程式每跑一次 就洗一次牌
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
		
		cards.addAll(usedCard);     //把使用過的牌放回 cards 中
		usedCard.clear();
		openCard.clear();
		nUsed = 0;
		
		for(int i = 0; i < cards.size(); i++) {    //用cards.size決定要跑幾圈
			int nrnd = rnd.nextInt(cards.size());  //用nrnd存放亂數的值，而亂數內的參數我放的是cards.size()是因為我希望能隨機找一個位置做交換
			Card first = cards.get(nrnd);          //取一個變數存放 亂數位置 中的值
			cards.set(nrnd,cards.get(i));          //用此亂數位置的值放入第i位置的值
			cards.set(i,first);                    //第i位置的值放入我們存於nrnd的值
		}
	}
	
	public Card getOneCard(boolean isOpened) {		
		if(cards.size() == 0 ) {     //當cards裡面沒牌的時候，執行 shuffle()
			shuffle();
		}

		Card value = cards.get(0);   //設定一個變數存放地一張牌的值
		usedCard.add(cards.get(0));  //把此值放入usedCard
		cards.remove(0);             //把第一張牌的值移除  
		nUsed ++;                    //nUsed +1
		
		if(nUsed == 1) {
			isOpened = false;
		}
		
		if(isOpened = true) {
			openCard.add(cards.get(nUsed - 1));
		}
		
		return value;                //僵直回傳
	}
	
	public ArrayList<Card> getOpenedCard(){
		return openCard;
		
	}

}
