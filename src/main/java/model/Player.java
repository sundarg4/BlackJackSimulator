package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public enum PlayerType {
		DEALER, PLAYER
	}

	private String playerName;

	private List<Card> cards;

	private Integer score;

	public Player(String name) {
		this.playerName = name;
		this.cards = new ArrayList<>();
		this.score = 0;
	}

	public void drawCard(Card newCard) {
		this.cards.add(newCard);
		this.score = this.score + newCard.getPoints();
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer points) {
		this.score = points;
	}

}
