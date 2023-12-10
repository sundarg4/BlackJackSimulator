package main.java.simulator;

import java.util.ArrayList;
import java.util.List;

import main.java.model.Card;
import main.java.model.Player;
import main.java.service.GameService;
import main.java.utils.CardBuilder;

public class BlackJackSimulator {
	
	public static void main(String[] args) {
		
		List<Card> cardDeck = new ArrayList<>();
		
		String path = "";
		
		if(args.length >0) {
			path = args[0];
		}	
		
		cardDeck = CardBuilder.buildCardDeck(path);
		
		// create two players dealer and sam
		Player sam = new Player("sam");
		Player dealer = new Player("dealer");
		
		GameService newGame = new GameService();
		
		newGame.startGame(cardDeck, sam, dealer);
		
	}

}
