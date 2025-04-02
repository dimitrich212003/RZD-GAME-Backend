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
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public GameRecord(Game game, int score, User user) {
        this.game = game;
        this.score = score;
        this.user = user;
    }

    public GameRecord() {

    }

    public Game getGame() {
        return game;
    }

    public int getScore() {
        return score;
    }

    public User getUser() {
        return user;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
