package com.game.rzd.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "game_records")
public class GameRecord extends BaseEntity {
    @Column(nullable = false)
    private Game game;
    @Column(nullable = false)
    private int score;
    @ManyToOne
    @JoinColumn(name = "fox_id", nullable = false)
    private Fox fox;

    public GameRecord(Game game, int score, Fox fox) {
        this.game = game;
        this.score = score;
        this.fox = fox;
    }

    public GameRecord() {

    }

    public Game getGame() {
        return game;
    }

    public int getScore() {
        return score;
    }

    public Fox getFox() {
        return fox;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setFox(Fox fox) {
        this.fox = fox;
    }
}
