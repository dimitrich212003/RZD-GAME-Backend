package com.game.rzd.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "achievements")
public class Achievement extends BaseEntity {

    @Column(nullable = false)
    private int code;
    @Column(nullable = false)
    private boolean unlocked;
    @ManyToOne
    @JoinColumn(name = "fox_id")
    private Fox fox;

    public Achievement(int code, boolean unlocked, Fox fox) {
        this.code = code;
        this.unlocked = unlocked;
        this.fox = fox;
    }

    public Achievement() {

    }

    public int getCode() {
        return code;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public Fox getFox() {
        return fox;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public void setFox(Fox fox) {
        this.fox = fox;
    }
}

