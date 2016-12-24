package com.example.brian.chinesechess.ai;

import com.example.brian.chinesechess.model.Position;

/**
 * Created by Brian on 16/12/4.
 */
public class Move {
    private Position before;
    private Position after;

    public Move(Position before, Position after) {
        this.before = before;
        this.after = after;
    }

    // Getters and setters
    public Position getBefore() {
        return before;
    }

    public void setBefore(Position before) {
        this.before = before;
    }

    public Position getAfter() {
        return after;
    }

    public void setAfter(Position after) {
        this.after = after;
    }
}
