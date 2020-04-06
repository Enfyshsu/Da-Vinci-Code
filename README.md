# Da-Vinci-Code
Socket Programming

### Part 1. Program Introduction
* Program name: <b>Da Vinci Code （終極密碼遊戲）</b>
* Program characteristic:
    * Implement Language: Java
    * Multithreading
    * Implement with GUI （JOptionPane）
* Java class:
    * <b>Client.java (main)</b>: Create a client thread.
    * <b>ServerConnection.java</b>: Handle the communication between clients and server.
    * <b>Server.java (main)</b>: Generate a random number and waiting for client connections using ArrayList<>.
    * <b>ClientHandler.java</b>: Handle number range limits by clients’ input.
    
### Part 2. Game Introduction
* 遊戲介紹：此程式由Server端產生一個介於0~1000的亂數，供多位Client同時參加，由Client輸入數字猜測終極密碼，猜中者即為輸家。
* 註：若Client輸入的數字不在限定範圍，會顯示範圍錯誤訊息，Client可藉由輸入''stop ''離開遊戲。
