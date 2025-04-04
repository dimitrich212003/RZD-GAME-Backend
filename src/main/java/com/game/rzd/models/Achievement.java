package com.game.rzd.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "achievements")
public class Achievement extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private boolean unlocked;
    @ManyToOne
    @JoinColumn(name = "fox_id", nullable = false)
    private Fox fox;

    public Achievement(String name, boolean unlocked, Fox fox) {
        this.name = name;
        this.unlocked = unlocked;
        this.fox = fox;
    }

    public Achievement() {

    }

    public String getName() {
        return name;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public Fox getFox() {
        return fox;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public void setFox(Fox fox) {
        this.fox = fox;
    }
}

