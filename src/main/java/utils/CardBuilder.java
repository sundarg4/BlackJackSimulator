package main.java.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import main.java.enums.Suits;
import main.java.model.Card;

public class CardBuilder {

	// private static final int TOTAL_DECK_CARDS = 52;

	/**
	 * Searches and builds card deck from path
	 * 
	 * if the file is not correct then initializes a deck of cards
	 * 
	 * @param path
	 * @return List of cards
	 */
	public static List<Card> buildCardDeck(String path) {

		List<Card> cards = new ArrayList<>();

		if (path != null && !path.trim().isEmpty()) {
			cards = buildCardDeckFromFile(path);
		}

		if (cards.isEmpty()) {
			return initializeCardDeck();
		}

		return cards;
	}

	public static List<Card> buildCardDeckFromFile(String path) {

		List<Card> cards = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line;
			while ((line = br.readLine()) != null) {

				String[] values = line.split(",");
				for (String cardValue : values) {
					cards.add(buildCard(cardValue));
				}
			}

			Collections.shuffle(cards, new Random());

			return cards;

		} catch (IOException e) {

			System.err.println("Unable to read file in given path.");
		}

		return new ArrayList<>();
	}

	public static Card buildCard(String cardValue) {
		Card card = null;
		cardValue = cardValue.trim();
		
		if (cardValue.length() > 1) {
			Suits suit = Suits.valueOf(Character.toString(cardValue.charAt(0)));
			card = new Card(suit, cardValue.substring(1));
		}
		
		return card;
	}

	public static List<Card> initializeCardDeck() {

		List<Card> cards = new ArrayList<>();

		for (Suits suit : Suits.values()) {
			for (String value : Card.getCardvaluetopoints().keySet()) {
				cards.add(new Card(suit, value));
			}
		}

		Collections.shuffle(cards, new Random());

		return cards;
	}

}
