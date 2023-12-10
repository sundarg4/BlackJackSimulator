package main.java.model;

import java.util.HashMap;

import main.java.enums.Suits;

public class Card {
	
	private Suits suit;
	
	private String value;
	
	private String cardName;
	
	private Integer points;
	
	private static final HashMap<String, Integer> cardValueToPoints = new HashMap<>();

	static {
		
        cardValueToPoints.put("2", 2);
        cardValueToPoints.put("3", 3);
        cardValueToPoints.put("4", 4);
        cardValueToPoints.put("5", 5);
        cardValueToPoints.put("6", 6);
        cardValueToPoints.put("7", 7);
        cardValueToPoints.put("8", 8);
        cardValueToPoints.put("9", 9);
        cardValueToPoints.put("10", 10);
        cardValueToPoints.put("J", 10);
        cardValueToPoints.put("Q", 10);
        cardValueToPoints.put("K", 10);
        cardValueToPoints.put("A", 11);
    }

	public Card (Suits suit, String value) {
		this.suit = suit;
		this.value = value;
		this.cardName = suit.name() + value.trim();
		this.points = cardValueToPoints.get(value);
	}
	
	public Suits getSuit() {
		return suit;
	}

	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public static HashMap<String, Integer> getCardvaluetopoints() {
		return cardValueToPoints;
	}

}
