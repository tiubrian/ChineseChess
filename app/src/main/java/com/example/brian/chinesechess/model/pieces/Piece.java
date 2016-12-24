package com.example.brian.chinesechess.model.pieces;

import android.widget.ArrayAdapter;

import com.example.brian.chinesechess.model.ChineseChessModel;
import com.example.brian.chinesechess.model.Position;

import java.util.ArrayList;

/**
 * Created by Brian on 16/12/1.
 */
public abstract class Piece {

    protected ChineseChessModel model;
    protected char color;
    protected Position position;
    protected char type;

    public Piece(ChineseChessModel model, char color, Position position) {
        this.model = model;
        this.color = color;
        this.position = position;
    }

    public abstract ArrayList<Position> getPossibleMoves();
    public abstract ArrayList<Position> noFilterGetPossibleMoves();

    protected char whatColor(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        Piece piece;
        if(!inMap(position)) {
           return 'e';
        }
        piece = model.getBoard()[row][col];


        //if(piece == null) {
        if(piece.getType() == '-') {
            return 'e';
        } else {
            if(Character.isUpperCase(piece.getType())) {
                return 'r';
            } else {
                return 'b';
            }

            //return piece.getColor();
        }
    }

    public boolean inUpperHalf(Position p) {
        int row = p.getRow();
        int col = p.getCol();
        if(0 <= row && row <= 4 &&
                0 <= col && col <= 8) {
            return true;
        }

        return false;
    }

    public boolean inLowerHalf(Position p) {
        int row = p.getRow();
        int col = p.getCol();
        if(5 <= row && row <= 9 &&
                0 <= col && col <= 8) {
            return true;
        }

        return false;
    }

    public boolean inMap(Position p) {
        int row = p.getRow();
        int col = p.getCol();
        if(0 <= row && row <= 9 &&
                0 <= col && col <= 8) {
            return true;
        }

        return false;
    }

    protected ArrayList<Position> filterMoves(ArrayList<Position> possible) {
        if(color == 'r') {
            return filterRedMoves(possible);
        } else {
            return filterBlackMoves(possible);
        }
    }



    private ArrayList<Position> filterRedMoves(ArrayList<Position> possible) {
        ArrayList<Position> filtered = new ArrayList<>();

        for(int i = 0; i < possible.size(); i++) {
            // Simulate move
            int sourceRow = position.getRow();
            int sourceCol = position.getCol();
            int targetRow = possible.get(i).getRow();
            int targetCol = possible.get(i).getCol();

            char temp = model.getBoard()[targetRow][targetCol].getType();
            model.getBoard()[targetRow][targetCol].setType(model.getBoard()[sourceRow][sourceCol].getType());
            model.getBoard()[sourceRow][sourceCol].setType('-');

            // See if the king is in check
            if(!model.isRedKingInCheck()) {
                filtered.add(possible.get(i));
            }

            // undo the move
            model.getBoard()[sourceRow][sourceCol].setType(model.getBoard()[targetRow][targetCol].getType());
            model.getBoard()[targetRow][targetCol].setType(temp);

        }
        //return possible;
        return filtered;
    }

    private ArrayList<Position> filterBlackMoves(ArrayList<Position> possible) {
        ArrayList<Position> filtered = new ArrayList<>();

        for(int i = 0; i < possible.size(); i++) {
            // Simulate move
            int sourceRow = position.getRow();
            int sourceCol = position.getCol();
            int targetRow = possible.get(i).getRow();
            int targetCol = possible.get(i).getCol();

            char temp = model.getBoard()[targetRow][targetCol].getType();
            model.getBoard()[targetRow][targetCol].setType(model.getBoard()[sourceRow][sourceCol].getType());
            model.getBoard()[sourceRow][sourceCol].setType('-');

            // See if the king is in check
            if(!model.isBlackKingInCheck()) {
                filtered.add(possible.get(i));
            }

            // undo the move
            model.getBoard()[sourceRow][sourceCol].setType(model.getBoard()[targetRow][targetCol].getType());
            model.getBoard()[targetRow][targetCol].setType(temp);

        }
//        return possible;
        return filtered;
    }

        // Getters and setters
    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public ChineseChessModel getModel() {
        return model;
    }

    public void setModel(ChineseChessModel model) {
        this.model = model;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract char getType();

    public void setType(char type) {
        this.type = type;
    }
}
