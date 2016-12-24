package com.example.brian.chinesechess.model.pieces;

import com.example.brian.chinesechess.model.ChineseChessModel;
import com.example.brian.chinesechess.model.Position;

import java.util.ArrayList;

/**
 * Created by Brian on 16/12/1.
 */
public class Elephant extends Piece {
    public Elephant(ChineseChessModel model, char color, Position position) {
        super(model, color, position);
        if(color == 'r') {
            type = 'E';
        } else {
            type = 'e';
        }
    }

    @Override
    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> validMoves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getCol();

        if(whatColor(position) == 'b') {
            // up left
            Position p = new Position(row-2, col-2);
            if(inUpperHalf(p) && whatColor(p) != 'b' && whatColor(new Position(row-1, col-1)) == 'e') {
                validMoves.add(p);
            }

            // up right
            p = new Position(row-2, col+2);
            if(inUpperHalf(p) && whatColor(p) != 'b'&& whatColor(new Position(row-1, col+1)) == 'e') {
                validMoves.add(p);
            }

            // down left
            p = new Position(row+2, col-2);
            if(inUpperHalf(p) && whatColor(p) != 'b'&& whatColor(new Position(row+1, col-1)) == 'e') {
                validMoves.add(p);
            }

            // down right
            p = new Position(row+2, col+2);
            if(inUpperHalf(p) && whatColor(p) != 'b'&& whatColor(new Position(row+1, col+1)) == 'e') {
                validMoves.add(p);
            }
        } else if(whatColor(position) == 'r') {
            // up left
            Position p = new Position(row-2, col-2);
            if(inLowerHalf(p) && whatColor(p) != 'r'&& whatColor(new Position(row-1, col-1)) == 'e') {
                validMoves.add(p);
            }

            // up right
            p = new Position(row-2, col+2);
            if(inLowerHalf(p) && whatColor(p) != 'r'&& whatColor(new Position(row-1, col+1)) == 'e') {
                validMoves.add(p);
            }

            // down left
            p = new Position(row+2, col-2);
            if(inLowerHalf(p) && whatColor(p) != 'r'&& whatColor(new Position(row+1, col-1)) == 'e') {
                validMoves.add(p);
            }

            // down right
            p = new Position(row+2, col+2);
            if(inLowerHalf(p) && whatColor(p) != 'r'&& whatColor(new Position(row+1, col+1)) == 'e') {
                validMoves.add(p);
            }
        }
        return filterMoves(validMoves);
    }

    @Override
    public ArrayList<Position> noFilterGetPossibleMoves() {
        if(color == 'r') {
            if(type != 'E') {
                return new ArrayList<>();
            }
        } else {
            if(type != 'e') {
                return new ArrayList<>();
            }
        }
        ArrayList<Position> validMoves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getCol();

        if(whatColor(position) == 'b') {
            // up left
            Position p = new Position(row-2, col-2);
            if(inUpperHalf(p) && whatColor(p) != 'b' && whatColor(new Position(row-1, col-1)) == 'e') {
                validMoves.add(p);
            }

            // up right
            p = new Position(row-2, col+2);
            if(inUpperHalf(p) && whatColor(p) != 'b'&& whatColor(new Position(row-1, col+1)) == 'e') {
                validMoves.add(p);
            }

            // down left
            p = new Position(row+2, col-2);
            if(inUpperHalf(p) && whatColor(p) != 'b'&& whatColor(new Position(row+1, col-1)) == 'e') {
                validMoves.add(p);
            }

            // down right
            p = new Position(row+2, col+2);
            if(inUpperHalf(p) && whatColor(p) != 'b'&& whatColor(new Position(row+1, col+1)) == 'e') {
                validMoves.add(p);
            }
        } else if(whatColor(position) == 'r') {
            // up left
            Position p = new Position(row-2, col-2);
            if(inLowerHalf(p) && whatColor(p) != 'r'&& whatColor(new Position(row-1, col-1)) == 'e') {
                validMoves.add(p);
            }

            // up right
            p = new Position(row-2, col+2);
            if(inLowerHalf(p) && whatColor(p) != 'r'&& whatColor(new Position(row-1, col+1)) == 'e') {
                validMoves.add(p);
            }

            // down left
            p = new Position(row+2, col-2);
            if(inLowerHalf(p) && whatColor(p) != 'r'&& whatColor(new Position(row+1, col-1)) == 'e') {
                validMoves.add(p);
            }

            // down right
            p = new Position(row+2, col+2);
            if(inLowerHalf(p) && whatColor(p) != 'r'&& whatColor(new Position(row+1, col+1)) == 'e') {
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
