// 문제 : 46p
// 답 : 255p
// Exercise7_1
package yoo;

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	public SutdaDeck() {
		for (int i = 0; i < cards.length; i++) {
			int num = i+1;
			boolean isKwang = false;
			if(num == 1 || num == 3 || num == 8) {
				isKwang = true;
			}
			if(num > 10) num -= 10;
			
			cards[i] = new SutdaCard(num, isKwang);
		}
	}
	
	public void shuffle() {
		for (int i = 0; i < cards.length; i++) {
			int randomIndex = (int)(Math.random() * 20);
			SutdaCard temp = cards[i];
			cards[i] = cards[randomIndex];
			cards[randomIndex] = temp;
		}
	}
	
	public SutdaCard pick(int index) {
		return cards[index];
	}
	
	public SutdaCard pick() {
		int randomIndex = (int)(Math.random() * 20);
		return cards[randomIndex];
	}
	
	
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

class Excercise7_1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
		
		deck.shuffle();
		
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println(deck.pick(0));
		
		System.out.println();
		System.out.println();
		
		System.out.println(deck.pick());
		
	}
}