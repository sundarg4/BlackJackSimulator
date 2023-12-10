package main.java.enums;

public enum Suits {
	
	C ("Clubs"),
	D ("Diamonds"),
	H ("Hearts"),
	S ("Spades");
	
	public final String name;

    private Suits(String name) {
        this.name = name;
    }
}
