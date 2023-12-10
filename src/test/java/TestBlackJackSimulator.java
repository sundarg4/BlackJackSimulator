package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.model.Card;
import main.java.model.Player;
import main.java.service.GameService;
import main.java.utils.CardBuilder;

class TestBlackJackSimulator {

	@Test
	void testBlackJackSimulatorWithSamWinning() {
		
		// GIVEN 
		
		List<Card> cardDeck = getCardDeck(Arrays.asList("CA", "D5", "H9", "HQ", "S8"));
		GameService newGame = new GameService();
		// create two players dealer and sam
		Player sam = new Player("sam");
		Player dealer = new Player("dealer");
		
		// WHEN		
		Player winner = newGame.startGame(cardDeck, sam, dealer);
		
		assertEquals(winner.getPlayerName(),"sam");
	}
	
	@Test
	void testBlackJackSimulatorWithDealerWinning() {
		
		// GIVEN 
		
		List<Card> cardDeck = getCardDeck(Arrays.asList("D5", "CA", "HQ", "H9", "S8"));
		GameService newGame = new GameService();
		// create two players dealer and sam
		Player sam = new Player("sam");
		Player dealer = new Player("dealer");
		
		// WHEN		
		Player winner = newGame.startGame(cardDeck, sam, dealer);
		
		assertEquals(winner.getPlayerName(),"dealer");
	}
	
	
	// test utils
	
	private List<Card> getCardDeck(List<String> cardList) {
		List<Card> cardDeck = new ArrayList<>();
		
		for(String card: cardList) {
			cardDeck.add(CardBuilder.buildCard(card));
		}
		
		return cardDeck;
	}
	
	
}
