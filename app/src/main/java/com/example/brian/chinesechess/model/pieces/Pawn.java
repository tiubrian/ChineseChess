package com.example.brian.chinesechess.model.pieces;

import com.example.brian.chinesechess.model.ChineseChessModel;
import com.example.brian.chinesechess.model.Position;

import java.util.ArrayList;

/**
 * Created by Brian on 16/12/1.
 */
public class Pawn extends Piece {
    public Pawn(ChineseChessModel model, char color, Position position) {
        super(model, color, position);
        if(color == 'r') {
            type = 'P';
        } else {
            type = 'p';
        }
    }

    @Override
    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> validMoves = new ArrayList<>();
        int row = position.getRow();
        int col = position.getCol();
        Position p;

        if(color == 'r') {
            p = new Position(row-1, col);
            if(whatColor(p) != color && inMap(p)) {
                validMoves.add(p);
            }
            if(inUpperHalf(position)) {
                p = new Position(row, col + 1);
                if(whatColor(p) != color && inMap(p)) {
                    validMoves.add(p);
                }
                p = new Position(row, col - 1);
                if(whatColor(p) != color && inMap(p)) {
                    validMoves.add(p);
                }
            }

        } else if(color == 'b') {
            p = new Position(row+1, col);
            if(whatColor(p) != color && inMap(p)) {
                validMoves.add(p);
            }
            if(inLowerHalf(position)) {
                p = new Position(row, col + 1);
                if(whatColor(p) != color && inMap(p)) {
                    validMoves.add(p);
                }
                p = new Position(row, col - 1);
                if(whatColor(p) != color && inMap(p)) {
                    validMoves.add(p);
                }
            }
        }

        return filterMoves(validMoves);
   }

    @Override
    public ArrayList<Position> noFilterGetPossibleMoves() {
        if(color == 'r') {
            if(type != 'P') {
                return new ArrayList<>();
            }
        } else {
            if(type != 'p') {
                return new ArrayList<>();
            }
        }
        ArrayList<Position> validMoves = new ArrayList<>();
        int row = position.getRow();
        int col = position.getCol();
        Position p;

        if(color == 'r') {
            p = new Position(row-1, col);
            if(whatColor(p) != color && inMap(p)) {
                validMoves.add(p);
            }
            if(inUpperHalf(position)) {
                p = new Position(row, col + 1);
                if(whatColor(p) != color && inMap(p)) {
                    validMoves.add(p);
                }
                p = new Position(row, col - 1);
                if(whatColor(p) != color && inMap(p)) {
                    validMoves.add(p);
                }
            }

        } else if(color == 'b') {
            p = new Position(row+1, col);
            if(whatColor(p) != color && inMap(p)) {
                validMoves.add(p);
            }
            if(inLowerHalf(position)) {
                p = new Position(row, col + 1);
                if(whatColor(p) != color && inMap(p)) {
                    validMoves.add(p);
                }
                p = new Position(row, col - 1);
                if(whatColor(p) != color && inMap(p)) {
                    validMoves.add(p);
                }
            }
        }

        return validMoves;
    }

    @Override
    public char getType() {
        return type;
    }
}
