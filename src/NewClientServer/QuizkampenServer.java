package NewClientServer;

import java.net.ServerSocket;

/**
 * Created by Axel Jeansson
 * Date: 2020-11-20
 * Time: 12:09
 * Project: SigrunsTicTacToe
 * Copyright: MIT
 */
public class QuizkampenServer {
    /**
     * Runs the application. Pairs up clients that connect.
     */
    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(5000);
        System.out.println("QuizkampenClient Server is Running");
        try {
            while (true) {
                ServerSideGame game = new ServerSideGame();
                ServerSidePlayer playerX
                        = new ServerSidePlayer(listener.accept(), "playerOne", game);
                ServerSidePlayer playerO
                        = new ServerSidePlayer(listener.accept(), "playerTwo", game);
                playerX.setOpponent(playerO);
                playerO.setOpponent(playerX);
                game.currentPlayer = playerX;
                playerX.start();
                playerO.start();
               // playerX.endMessage();
               // playerO.endMessage();
            }
        } finally {
            listener.close();
        }
    }
}

