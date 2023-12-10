package main.java.service;

import java.util.List;

import main.java.model.Card;
import main.java.model.Player;

public class GameService {

	private static final int PLAYER_MINIMUM = 17;

	private static final int BLACK_JACK_SCORE = 21;

	public Player startGame(List<Card> cardDeck, Player sam, Player dealer) {

		Player winner = null;
		
		int initialCardsToDeal = 2;

		// intial draw of two cards for players
		for (int i = 0; i < initialCardsToDeal; i++) {
			sam.drawCard(cardDeck.remove(0));
			dealer.drawCard(cardDeck.remove(0));
		}

		// initial winning conditions
		if (sam.getScore() == BLACK_JACK_SCORE) {
			declareWinner(sam, dealer);
			return sam;
		}
		if (dealer.getScore() == BLACK_JACK_SCORE
				|| (dealer.getScore() > BLACK_JACK_SCORE && sam.getScore() > BLACK_JACK_SCORE)) {
			declareWinner(dealer, sam);
			return dealer;
		}

		// start drawing cards
		winner = playRounds(sam, dealer, cardDeck);
		
		return winner;

	}

	private Player playRounds(Player sam, Player dealer, List<Card> cardDeck) {

		Player winner = null;
		
		while (sam.getScore() < PLAYER_MINIMUM) {
			sam.drawCard(cardDeck.remove(0));
			winner = checkBlackJackCondition(sam, dealer);
			if(winner != null) {
				return winner;
			}
		}

		while (dealer.getScore() <= sam.getScore()) {
			dealer.drawCard(cardDeck.remove(0));
			winner = checkBlackJackCondition(sam, dealer);
			if(winner != null) {
				return winner;
			}
		}

		return checkWinner(sam, dealer);
		
	}

	private Player checkBlackJackCondition(Player player1, Player player2) {
		

		if (player1.getScore() == BLACK_JACK_SCORE) {
			declareWinner(player1, player2);
			return player1;
		}

		if (player2.getScore() == BLACK_JACK_SCORE) {
			declareWinner(player2, player1);
			return player2;
		}

		if (player1.getScore() > BLACK_JACK_SCORE) {
			declareWinner(player2, player1);
			return player2;
		}

		if (player2.getScore() > BLACK_JACK_SCORE) {
			declareWinner(player1, player2);
			return player1;
		}
		
		return null;
	}

	private Player checkWinner(Player player1, Player player2) {
		
		if (player1.getScore() > player2.getScore()) {
			declareWinner(player1, player2);
			return player1;
		}

		if (player2.getScore() > player1.getScore()) {
			declareWinner(player2, player1);
			return player2;
		}
		
		return null;

	}

	public static void declareWinner(Player winner, Player loser) {

		System.out.println(winner.getPlayerName());
		List<String> winnerCards = winner.getCards().stream().map(card -> card.getCardName()).toList();
		System.out.print(winner.getPlayerName() + ": " + String.join(", ", winnerCards));

		System.out.println();

		List<String> loserCards = loser.getCards().stream().map(card -> card.getCardName()).toList();
		System.out.print(loser.getPlayerName() + ": " + String.join(", ", loserCards));

		System.out.println();
	}

}
