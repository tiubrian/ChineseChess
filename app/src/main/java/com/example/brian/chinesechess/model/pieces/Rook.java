package com.example.brian.chinesechess.model.pieces;

import com.example.brian.chinesechess.model.ChineseChessModel;
import com.example.brian.chinesechess.model.Position;

import java.util.ArrayList;

/**
 * Created by Brian on 16/12/1.
 */
public class Rook extends Piece {
    public Rook(ChineseChessModel model, char color, Position position) {
        super(model, color, position);
        if(color == 'r') {
            type = 'R';
        } else {
            type = 'r';
        }
    }


    @Override
    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> validMoves = new ArrayList<>();
        int setRow = position.getRow();
        int setCol = position.getCol();

        // Up
        int row = setRow;
        row--;
        while(row >= 0) {
            Position p = new Position(row, setCol);
            char tempColor = whatColor(p);
            if(tempColor == 'e') {
                validMoves.add(p);
            } else if(tempColor == color) {
                break;
            } else {
                validMoves.add(p);
                break;
            }
            row--;
        }

        // Down
        row = setRow;
        row++;
        while(row < 10) {
            Position p = new Position(row, setCol);
            char tempColor = whatColor(p);
            if(tempColor == 'e') {
                validMoves.add(p);
            } else if(tempColor == color) {
                break;
            } else {
                validMoves.add(p);
                break;
            }
            row++;
        }

        // Left
        int col = setCol;
        col--;
        while(col >= 0) {
            Position p = new Position(setRow, col);
            char tempColor = whatColor(p);
            if(tempColor == 'e') {
                validMoves.add(p);
            } else if(tempColor == color) {
                break;
            } else {
                validMoves.add(p);
                break;
            }
            col--;
        }

        // Right
        col = setCol;
        col++;
        while(col < 9) {
            Position p = new Position(setRow, col);
            char tempColor = whatColor(p);
            if(tempColor == 'e') {
                validMoves.add(p);
            } else if(tempColor == color) {
                break;
            } else {
                validMoves.add(p);
                break;
            }
            col++;
        }
        return filterMoves(validMoves);
   }

    @Override
    public ArrayList<Position> noFilterGetPossibleMoves() {
        if(color == 'r') {
            if(type != 'R') {
                return new ArrayList<>();
            }
        } else {
            if(type != 'r') {
                return new ArrayList<>();
            }
        }
        ArrayList<Position> validMoves = new ArrayList<>();
        int setRow = position.getRow();
        int setCol = position.getCol();

        // Up
        int row = setRow;
        row--;
        while(row >= 0) {
            Position p = new Position(row, setCol);
            char tempColor = whatColor(p);
            if(tempColor == 'e') {
                validMoves.add(p);
            } else if(tempColor == color) {
                break;
            } else {
                validMoves.add(p);
                break;
            }
            row--;
        }

        // Down
        row = setRow;
        row++;
        while(row < 10) {
            Position p = new Position(row, setCol);
            char tempColor = whatColor(p);
            if(tempColor == 'e') {
                validMoves.add(p);
            } else if(tempColor == color) {
                break;
            } else {
                validMoves.add(p);
                break;
            }
            row++;
        }

        // Left
        int col = setCol;
        col--;
        while(col >= 0) {
            Position p = new Position(setRow, col);
            char tempColor = whatColor(p);
            if(tempColor == 'e') {
                validMoves.add(p);
            } else if(tempColor == color) {
                break;
            } else {
                validMoves.add(p);
                break;
            }
            col--;
        }

        // Right
        col = setCol;
        col++;
        while(col < 9) {
            Position p = new Position(setRow, col);
            char tempColor = whatColor(p);
            if(tempColor == 'e') {
                validMoves.add(p);
            } else if(tempColor == color) {
                break;
            } else {
                validMoves.add(p);
                break;
            }
            col++;
        }
        return validMoves;
    }

    @Override
    public char getType() {
        return type;
    }
}
