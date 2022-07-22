package com.rhodso.app;

public class encounterTrackerEntry {
    // Global encounter vars
    private int highestMiss;
    private int lowestHit;
    private int dmgTaken;
    
    // Per hit vats
    private int hitRoll;
    private int dmgRoll;
    private boolean successfulHit;
    
    // constructor
    public encounterTrackerEntry(int highestMiss, int lowestHit, int dmgTaken, int hitRoll, int dmgRoll,
    boolean successfulHit) {
        this.highestMiss = highestMiss;
        this.lowestHit = lowestHit;
        this.dmgTaken = dmgTaken;
        this.hitRoll = hitRoll;
        this.dmgRoll = dmgRoll;
        this.successfulHit = successfulHit;
    }

    // toString override
    @Override
    public String toString(){
        String str = "";

        str += "HRL: " + this.hitRoll;
        
        if(this.successfulHit){
            str += " IH?: Y";
            str += " DMG: " + this.dmgRoll;
        } else {
            str += " IH?: N";
        }

        return str;
    }

    // getters and setters
    public int getHighestMiss() {
        return highestMiss;
    }

    public void setHighestMiss(int highestMiss) {
        this.highestMiss = highestMiss;
    }

    public int getLowestHit() {
        return lowestHit;
    }

    public void setLowestHit(int lowestHit) {
        this.lowestHit = lowestHit;
    }

    public int getDmgTaken() {
        return dmgTaken;
    }

    public void setDmgTaken(int dmgTaken) {
        this.dmgTaken = dmgTaken;
    }

    public int getHitRoll() {
        return hitRoll;
    }

    public void setHitRoll(int hitRoll) {
        this.hitRoll = hitRoll;
    }

    public int getDmgRoll() {
        return dmgRoll;
    }

    public void setDmgRoll(int dmgRoll) {
        this.dmgRoll = dmgRoll;
    }

    public boolean isSuccessfulHit() {
        return successfulHit;
    }

    public void setSuccessfulHit(boolean successfulHit) {
        this.successfulHit = successfulHit;
    }



}
