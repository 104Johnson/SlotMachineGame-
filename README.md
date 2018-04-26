# 專案簡介
## 專案目的

實作一個吃角子老虎機
### 實作規則如下

1.三個滾輪的排列順序如下

| Reel 1 | Reel 2 | Reel 3 |
|--------|--------|--------|
|A | Z | A |
|B | Y | B |
|C | X | C |
|X | A | X |
|Y | B | Y |
|Z | C | Z |

2.每個符號代表的權重，權重越大出現機率越高

| Symbol Name | Symbol Weight |
|-------------|--------------|
| A | 1 |
| B | 1 |
| C | 1 |
| X | 2 |
| Y | 3 |
| Z | 4 |

3.滾輪的倍率獎金Mapping圖

| Winning Combination | Bet Multiplier |
|-------------|----------------|
| A,A,A | 20  |
| B,B,B | 20  |
| C,C,C | 20  |
| A,B,C | 30  |


## 前置作業確認

電腦已經下載「java-exam-master」專案，並且執行過「mvn clean install」

## 安裝執行
1.將專案Git pull  

2.請進入console介面<CMD>  
  
3.在SlotMachineGame專案目錄下 執行「mvn clean install」打包成Jar檔  

*若測試案例不過，會打包失敗，若須調整測試案例可至 \SlotMachineGame\src\test\java\org\johnson\SlotMachineGame\PlayGameTest.java  

4.前往目錄 \SlotMachineGame\target，執行「java -jar SlotMachineGame-0.0.1-SNAPSHOT-jar-with-dependencies.jar」  

5.輸入要押的籌碼，若輸入為-1或是非數字型態，會關閉遊戲。