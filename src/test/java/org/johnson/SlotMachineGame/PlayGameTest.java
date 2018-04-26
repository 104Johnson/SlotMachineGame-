package org.johnson.SlotMachineGame;

import com.genesis.exams.slot.Symbol;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PlayGameTest 
    extends TestCase
{
	static PlayGame playGame = new PlayGame();
   

    /**
     * 獎金倍率測試
     * 2018/04/26新增4種案例
     * 1.AAA中獎應得金額2000
     * 2.BBB中獎應得金額2000
     * 3.CCC中獎應得金額2000
     * 4.ABC中獎應得金額3000
     */
    public void testEvaluate()
    {
    	
    	Long bet=(long) 100;
    	//Case A中獎預設回傳值要2000
    	Long dResult = (long)2000;
    	//傳入中A獎
    	Symbol[] symbolsByA = {new Symbol("A", 1),new Symbol("A", 1),new Symbol("A", 1)};
    
    	Long caseResult = playGame.evaluate(symbolsByA, bet);
    	assertEquals(dResult, caseResult);
    	
    	
    	//Case B中獎預設回傳值要2000
    	dResult = (long)2000;
    	//傳入中B獎
    	Symbol[] symbolsByB = {new Symbol("B", 1),new Symbol("B", 1),new Symbol("B", 1)};
    
    	caseResult = playGame.evaluate(symbolsByB, bet);
    	assertEquals(dResult, caseResult);
    	
    	//Case C中獎預設回傳值要2000
    	dResult = (long)2000;
    	//傳入中B獎
    	Symbol[] symbolsByC = {new Symbol("C", 1),new Symbol("C", 1),new Symbol("C", 1)};
    
    	caseResult = playGame.evaluate(symbolsByC, bet);
    	assertEquals(dResult, caseResult);
    	
    	//Case ABC中獎預設回傳值要2000
    	dResult = (long)3000;
    	//傳入中B獎
    	Symbol[] symbolsByABC = {new Symbol("A", 1),new Symbol("B", 1),new Symbol("C", 1)};
    
    	caseResult = playGame.evaluate(symbolsByABC, bet);
    	assertEquals(dResult, caseResult);
    }
}
