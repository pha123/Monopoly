package com.pha.kata;

import java.util.Random;

public class Dice {
	
	private final int maxDiceNumber;
	private static Random random;
	
	public Dice(int maxDiceNumber) {
		this.maxDiceNumber = maxDiceNumber;
		random = new Random();
	}
	
	public int rollDice() {
		return random.nextInt(maxDiceNumber)+1;
	}

}
