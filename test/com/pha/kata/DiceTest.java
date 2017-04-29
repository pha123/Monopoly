package com.pha.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {
	
	@Test
	public void testRollDice_CheckifNumbersInAllowedRange() throws Exception {
		// initialize variables;
		int maxDiceResult = 6;
		List<Integer> diceResults = new ArrayList<>();
		
		// initialize mocks
		
		// initialize test class
		Dice testClass = new Dice(maxDiceResult);
		
		for(int i=0;i<20;i++) {
			int result  = testClass.rollDice();
			diceResults.add(result);
		}
		
		// assert
		for (Integer result : diceResults) {
			if(result < 1 || result > maxDiceResult) {
				Assert.fail(String.format("Dice Roll retured invalid value. Allowed value :- 1 to %d, Dice returned :- %d", maxDiceResult, result));
			}
		}
		
		// verify
	}
	
	@Test
	public void testRollDice_RandomnessOfDiceNumbers() {
		// initialize variables;
		int maxDiceResult = 6;
		Map<Integer, Integer> resultCount = new HashMap<>();
		
		// initialize mocks
		
		// initialize test class
		Dice testClass = new Dice(maxDiceResult);
		
		for(int i=0;i<10;i++) {
			int result  = testClass.rollDice();
			if(resultCount.containsKey(result)) {
				resultCount.put(result, resultCount.get(result)+1);
			}
			else {
				resultCount.put(result, 1);
			}
		}
		
		// assert
		for (Entry<Integer, Integer> entry : resultCount.entrySet()) {
			if(resultCount.get(entry.getKey()) > 4) {
				Assert.fail(String.format("Dice results are not random. On 10 times roll, No %d occured %d times.", entry.getKey(), entry.getValue()));
			}
		}
	}

}
