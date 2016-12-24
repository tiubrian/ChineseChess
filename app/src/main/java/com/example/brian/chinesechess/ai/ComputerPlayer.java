package com.example.brian.chinesechess.ai;

import android.util.Log;

import com.example.brian.chinesechess.model.ChineseChessModel;
import com.example.brian.chinesechess.model.Position;
import com.example.brian.chinesechess.model.pieces.Empty;
import com.example.brian.chinesechess.model.pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Brian on 16/12/4.
 */
public class ComputerPlayer {
    private char color;
    private ChineseChessModel model;
    private Piece[][] board;
    private ArrayList<Piece> redPieces;
    private ArrayList<Piece> blackPieces;
    int depth = 3;

    private int[][] fowardRook = {
            {14,14,12,18,16,18,12,14,14},
            {16,20,18,24,26,24,18,20,16},
            {12,12,12,18,18,18,12,12,12},
            {12,18,16,22,22,22,16,18,12},
            {12,14,12,18,18,18,12,14,12},
            {12,16,14,20,20,20,14,16,12},
            {6 ,10,8 ,14,14,14,8 ,10,6 },
            {4 ,8 ,6 ,14,12,14,6 ,8 ,4 },
            {8 ,4 ,8 ,16,8 ,16,8 ,4 ,8 },
            {-2,10,6 ,14,12,14,6 ,10,-2}
    };
    private int[][] fowardCannon = {
            {6  ,4  ,0  ,-10,-12,-10,0  ,4  ,6  },
            {2  ,2  ,0  ,-4 ,-14,- 4,0  ,2  ,2  },
            {2  ,2  ,0  ,-10,-8 ,-10,0  ,2  ,2  },
            {0  ,0  ,-2 ,4  ,10 ,4  ,-2 ,0  ,0  },
            {0  ,0  ,0  ,2  ,8  ,2  ,0  ,0  ,0  },
            {-2 ,0  ,4  ,2  ,6  ,2  ,4  ,0  ,-2 },
            {0  ,0  ,0  ,2  ,4  ,2  ,0  ,0  ,0  },
            {4  ,0  ,8  ,6  ,10 ,6  ,8  ,0  ,4  },
            {0  ,2  ,4  ,6  ,6  ,6  ,4  ,2  ,0  },
            {0  ,0  ,2  ,6  ,6  ,6  ,2  ,0  ,0  }
    };

    private int[][] fowardHorse = {
            {4 ,8 ,16,12,4 ,12,16,8 ,4 },
            {4 ,10,28,16,8 ,16,28,10,4 },
            {12,14,16,20,18,20,16,14,12},
            {8 ,24,18,24,20,24,18,24,8 },
            {6 ,26,14,18,16,18,14,16,6 },
            {4 ,12,16,14,12,14,16,12,4 },
            {2 ,6 ,8 ,6 ,10,6 ,8 ,6 ,2 },
            {4 ,2 ,8 ,8 ,4 ,8 ,8 ,2 ,4 },
            {0 ,2 ,4 ,4 ,-2,4 ,4 ,2 ,0 },
            {0 ,-4,0 ,0 ,0 ,0 ,0 ,-4,0 }
    };

    private int[][] fowardPawn = {
            {0  ,3  ,6  ,9  ,12 ,9  ,6  ,3  ,0  },
            {18 ,36 ,56 ,80 ,120,80 ,56 ,36 ,18 },
            {14 ,26 ,42 ,60 ,80 ,60 ,42 ,26 ,14 },
            {10 ,20 ,30 ,34 ,40 ,34 ,30 ,20 ,10 },
            {6  ,12 ,18 ,18 ,20 ,18 ,18 ,12 ,6  },
            {2  ,0  ,8  ,0  ,8  ,0  ,8  ,0  ,2  },
            {0  ,0  ,-2 ,0  ,4  ,0  ,-2 ,0  ,0  },
            {0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
            {0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
            {0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  }
    };

    private int[][] backwardRook;
    private int[][] backwardCannon;
    private int[][] backwardHorse;
    private int[][] backwardPawn;

    public ComputerPlayer(char color, ChineseChessModel model) {
        this.color = color;
        this.model = model;
        board = model.getBoard();
        redPieces = model.getRedPieces();
        blackPieces = model.getBlackPieces();
        backwardRook = new int[model.getROW()][model.getCOL()];
        backwardCannon = new int[model.getROW()][model.getCOL()];
        backwardHorse = new int[model.getROW()][model.getCOL()];
        backwardPawn = new int[model.getROW()][model.getCOL()];
        createBackwardsMatrices();
    }


    private int evaluateRed() {
        int value = 0;

        // Evaluate the pieces
        for(int i = 0; i < redPieces.size(); i++) {
            switch (redPieces.get(i).getType()) {
                case 'R': value += 600;
                    //value += fowardRook[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                    break;
                case 'H': value += 270;
                    //value += fowardHorse[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                    break;
                case 'E': value += 120;
                    break;
                case 'B': value += 120;
                    break;
                case 'K': value += 6000;
                    break;
                case 'C': value += 285;
                    //value += fowardCannon[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                    break;
                case 'P': value += 30;
                    //value += fowardPawn[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                    break;
            }
        }
        return value;
    }

    private int evaluateBlack() {
        int value = 0;

        // Evaluate the pieces
        for(int i = 0; i < redPieces.size(); i++) {
            switch (redPieces.get(i).getType()) {
                case 'r': value += 600;
                    //value += backwardRook[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                    break;
                case 'h': value += 270;
                    //value += backwardHorse[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                    break;
                case 'e': value += 120;
                    break;
                case 'b': value += 120;
                    break;
                case 'k': value += 6000;
                    break;
                case 'c': value += 285;
                    //value += backwardCannon[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                    break;
                case 'p': value += 30;
                    //value += backwardPawn[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                    break;
            }
        }
        return value;
    }


    private int evaluate(char color) {
        int value = 0;
        if(color == 'r') {
            for(int i = 0; i< 10; i++) {
                for (int j = 0; j < 9; j++) {
                    switch (board[i][j].getType()) {
                        case 'R':
                            value += 600;
                            value += fowardRook[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                            break;
                        case 'H':
                            value += 270;
                            value += fowardHorse[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                            break;
                        case 'E':
                            value += 120;
                            break;
                        case 'B':
                            value += 120;
                            break;
                        case 'K':
                            value += 6000;
                            break;
                        case 'C':
                            value += 285;
                            value += fowardCannon[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                            break;
                        case 'P':
                            value += 30;
                            value += fowardPawn[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                            break;


                        case 'r': value -= 600;
                            value -= backwardRook[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                            break;
                        case 'h': value -= 270;
                            value -= backwardHorse[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                            break;
                        case 'e': value -= 120;
                            break;
                        case 'b': value -= 120;
                            break;
                        case 'k': value -= 6000;
                            break;
                        case 'c': value -= 285;
                            value -= backwardCannon[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                            break;
                        case 'p': value -= 30;
                            value -= backwardPawn[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                            break;
                    }
                }
            }
        } else {
            for(int i = 0; i< 10; i++) {
                for (int j = 0; j < 9; j++) {
                    switch (board[i][j].getType()) {
                        case 'R':
                            value -= 600;
                            value -= fowardRook[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                            break;
                        case 'H':
                            value -= 270;
                            value -= fowardHorse[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                            break;
                        case 'E':
                            value -= 120;
                            break;
                        case 'B':
                            value -= 120;
                            break;
                        case 'K':
                            value -= 6000;
                            break;
                        case 'C':
                            value -= 285;
                            value -= fowardCannon[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                            break;
                        case 'P':
                            value -= 30;
                            value -= fowardPawn[redPieces.get(i).getPosition().getRow()][redPieces.get(i).getPosition().getCol()];
                            break;


                        case 'r': value += 600;
                            value += backwardRook[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                            break;
                        case 'h': value += 270;
                            value += backwardHorse[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                            break;
                        case 'e': value += 120;
                            break;
                        case 'b': value += 120;
                            break;
                        case 'k': value += 6000;
                            break;
                        case 'c': value += 285;
                            value += backwardCannon[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                            break;
                        case 'p': value += 30;
                            value += backwardPawn[blackPieces.get(i).getPosition().getRow()][blackPieces.get(i).getPosition().getCol()];
                            break;
                    }
                }
            }
        }
        return value;
    }


    private Piece simulateMove(Move move) {
        int beforeRow = move.getBefore().getRow();
        int beforeCol = move.getBefore().getCol();
        int afterRow = move.getAfter().getRow();
        int afterCol = move.getAfter().getCol();

        Piece taken = board[afterRow][afterCol];

        board[afterRow][afterCol] = board[beforeRow][beforeCol];
        board[afterRow][afterCol].setPosition(new Position(afterRow,afterCol));

        board[beforeRow][beforeCol] = new Empty(model,'-',new Position(beforeRow,beforeCol));

        if(taken.getColor() == 'r') {
            redPieces.remove(taken);
        } else {
            blackPieces.remove(taken);
        }

        return taken;
    }

    private void undoMove(Move move, Piece taken) {
        int beforeRow = move.getBefore().getRow();
        int beforeCol = move.getBefore().getCol();
        int afterRow = move.getAfter().getRow();
        int afterCol = move.getAfter().getCol();

        board[beforeRow][beforeCol] = board[afterRow][afterCol];
        board[beforeRow][beforeCol].setPosition(new Position(beforeRow, beforeCol));

        board[afterRow][afterCol] = taken;

        if(taken.getColor() == 'r') {
            redPieces.add(taken);
        } else {
            blackPieces.add(taken);
        }

    }



    private double alphaBeta(char turn, double alpha, double beta, int depth) {
        return 0;
    }


















    private void createBackwardsMatrices() {
        for(int i = 0; i < model.getROW(); i++) {
            for(int j = 0; j < model.getCOL(); j++) {
                backwardRook[i][j] = fowardRook[model.getROW()-1-i][j];
                backwardHorse[i][j] = fowardHorse[model.getROW()-1-i][j];
                backwardCannon[i][j] = fowardCannon[model.getROW()-1-i][j];
                backwardPawn[i][j] = fowardPawn[model.getROW()-1-i][j];
            }
        }
    }


    public Move getMove() {



        Move best = null;
        double score = Integer.MIN_VALUE;
        double alpha = Integer.MIN_VALUE;
        double beta = Integer.MAX_VALUE;

        ArrayList<Move> moves = generatePossibleMoves(color);
        Collections.shuffle(moves);return moves.get(0);


    }

    private ArrayList<Move> generatePossibleMoves(char tempColor) {

        ArrayList<Piece> pieces;
        if(tempColor == 'r') {
            pieces = model.getRedPieces();
        } else {
            pieces = model.getBlackPieces();
        }

        ArrayList<Move> moves = new ArrayList<>();
        for(int i = 0; i < pieces.size(); i++) {
            int sourceRow = pieces.get(i).getPosition().getRow();
            int sourceCol = pieces.get(i).getPosition().getCol();
            ArrayList<Position> possibleMoves = pieces.get(i).getPossibleMoves();
            for(int j = 0; j < possibleMoves.size(); j++) {
                int targetRow = possibleMoves.get(j).getRow();
                int targetCol = possibleMoves.get(j).getCol();
                moves.add(new Move(new Position(sourceRow, sourceCol), new Position(targetRow, targetCol)));



            }
        }

        return moves;
    }

}
