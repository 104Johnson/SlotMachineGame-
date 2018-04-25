package org.johnson.SlotMachineGame;

import com.genesis.exams.slot.Evaluator;
import com.genesis.exams.slot.Reel;
import com.genesis.exams.slot.SlotMachine;
import com.genesis.exams.slot.SpinResult;
import com.genesis.exams.slot.Spinner;
import com.genesis.exams.slot.Symbol;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

/**
 * 實作Spinner & Evaluator
 * 
 */
public class PlayGame implements Spinner, Evaluator {
	static Map<Integer, Symbol> weightMap = new HashMap();
	static Reel[] reels;
	static Spinner spinner = new PlayGame();
	static Evaluator evaluator = new PlayGame();

	public static void main(String[] args) {
		try {
			// 參數設定
			config();

			SlotMachine slotMachine = new SlotMachine(reels, spinner, evaluator);

			System.out.println("请输入籌碼：(離開請輸入-1)");
			 Scanner scanner = new Scanner(System.in);
			 Long bet;
			 
			do {
				bet = scanner.nextLong();
				if (bet<-1) {
					throw new Exception("籌碼不正常，已強制結束");
				}
				SpinResult spinResult = slotMachine.spin(bet);

				String spinResultString = "";
				for (Symbol symbol : spinResult.getSymbols()) {
					spinResultString += symbol.getName();
				}
				System.out.println("本次結果為: " + spinResultString + "下注:" + bet + "共獲得:" + spinResult.getPayout());
			
			}while(bet!=-1);
			
			scanner.close();

		} catch (InputMismatchException e) {
			System.out.println("輸入字元不正常，已強制結束");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void config() {

		// setup symbol & weight
		Symbol[] arrSymbol1 = { new Symbol("A", 1), new Symbol("B", 1), new Symbol("C", 1), new Symbol("X", 2),
				new Symbol("Y", 3), new Symbol("Z", 4) };

		Symbol[] arrSymbol2 = { new Symbol("Z", 4), new Symbol("Y", 3), new Symbol("X", 2), new Symbol("A", 1),
				new Symbol("B", 1), new Symbol("C", 1) };
		Reel reel1 = new Reel(arrSymbol1);
		Reel reel2 = new Reel(arrSymbol2);
		Reel reel3 = new Reel(arrSymbol1);
		reels = new Reel[] { reel1, reel2, reel3 };

	}

	public long evaluate(Symbol[] symbols, long bet) {
		// 檢查賠率
		// 定義得獎
		String[][] winningMap = { { "A,A,A", "20" }, { "B,B,B", "20" }, { "C,C,C", "20" }, { "A,B,C", "30" } };

		String inputSymbolStr = "";
		for (Symbol symbol : symbols) {
			inputSymbolStr += symbol.getName() + ",";
		}
		// 去掉最後一個逗號
		inputSymbolStr = inputSymbolStr.substring(0, inputSymbolStr.length() - 1);

		int betMultiplier = 0; // default

		for (String[] SymbolStrs : winningMap) {
			if (SymbolStrs[0].equals(inputSymbolStr)) {
				betMultiplier = Integer.parseInt(SymbolStrs[1]);
			}
		}

		// 籌碼與倍率換算
		return bet * betMultiplier;
	}

	/**
	 * spin 亂數產生滾輪的字母
	 * 
	 * @param symbols
	 */
	public Symbol spin(Reel reel) {
		int totalWeight = 0;
		Symbol[] symbols = reel.getSymbols();

		int index = 1;
		for (Symbol symbol : symbols) {
			// 權重總合
			totalWeight += symbol.getWeight();

			// 1:A,2:B,3:C,4:X,5:X.....12:Z
			for (int i = 0; i < symbol.getWeight(); i++) {
				weightMap.put(index, symbol);
				index += 1;
			}

		}

		// 亂數1~12
		int randomInt = new Random().nextInt(totalWeight) + 1;
		return weightMap.get(randomInt);

	}
}
