package com.example.brian.chinesechess.model.pieces;

import com.example.brian.chinesechess.model.ChineseChessModel;
import com.example.brian.chinesechess.model.Position;

import java.util.ArrayList;

/**
 * Created by Brian on 16/12/1.
 */
public class Horse extends Piece  {
    public Horse(ChineseChessModel model, char color, Position position) {
        super(model, color, position);
        if(color == 'r') {
            type = 'H';
        } else {
            type = 'h';
        }
    }

    @Override
    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> validMoves = new ArrayList<>();
        int row = position.getRow();
        int col = position.getCol();
        Position p;

        // up
        p = new Position(row-1, col);
        if(inMap(p) && whatColor(p) == 'e') {
            // left
            p = new Position(row-2, col-1);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
            // right
            p = new Position(row-2, col+1);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
        }

        // down
        p = new Position(row+1, col);
        if(inMap(p) && whatColor(p) == 'e') {
            // left
            p = new Position(row+2, col-1);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
            // right
            p = new Position(row+2, col+1);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
        }

        // left
        p = new Position(row, col-1);
        if(inMap(p) && whatColor(p) == 'e') {
            // up
            p = new Position(row-1, col-2);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
            // down
            p = new Position(row+1, col-2);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
        }

        // right
        p = new Position(row, col+1);
        if(inMap(p) && whatColor(p) == 'e') {
            // up
            p = new Position(row-1, col+2);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
            // down
            p = new Position(row+1, col+2);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
        }

        return filterMoves(validMoves);
    }

    @Override
    public ArrayList<Position> noFilterGetPossibleMoves() {
        if(color == 'r') {
            if(type != 'H') {
                return new ArrayList<>();
            }
        } else {
            if(type != 'h') {
                return new ArrayList<>();
            }
        }
        ArrayList<Position> validMoves = new ArrayList<>();
        int row = position.getRow();
        int col = position.getCol();
        Position p;

        // up
        p = new Position(row-1, col);
        if(inMap(p) && whatColor(p) == 'e') {
            // left
            p = new Position(row-2, col-1);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
            // right
            p = new Position(row-2, col+1);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
        }

        // down
        p = new Position(row+1, col);
        if(inMap(p) && whatColor(p) == 'e') {
            // left
            p = new Position(row+2, col-1);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
            // right
            p = new Position(row+2, col+1);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
        }

        // left
        p = new Position(row, col-1);
        if(inMap(p) && whatColor(p) == 'e') {
            // up
            p = new Position(row-1, col-2);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
            // down
            p = new Position(row+1, col-2);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
        }

        // right
        p = new Position(row, col+1);
        if(inMap(p) && whatColor(p) == 'e') {
            // up
            p = new Position(row-1, col+2);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
            // down
            p = new Position(row+1, col+2);
            if(inMap(p) && whatColor(p) != color) {
                validMoves.add(p);
            }
        }

        return validMoves;
    }

    @Override
    public char getType() {
        return type;
    }
}
