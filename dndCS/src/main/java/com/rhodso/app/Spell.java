package com.rhodso.app;

public class Spell {
    private String name;
    private String hitDR;
    private String dmgDR;
    private Dice hit;
    private Dice dmg;
    private String range;
    private String damageType;
    private int proficiency;
    private int spellLevel;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the spellLevel
     */
    public int getSpellLevel() {
        return spellLevel;
    }

    /**
     * @param spellLevel the spellLevel to set
     */
    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    /**
     * @return the proficiency
     */
    public int getProficiency() {
        return proficiency;
    }

    /**
     * @param proficiency the proficiency to set
     */
    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    /**
     * @return the damageType
     */
    public String getDamageType() {
        return damageType;
    }

    /**
     * @param damageType the damageType to set
     */
    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    /**
     * @return the range
     */
    public String getRange() {
        return range;
    }

    /**
     * @param range the range to set
     */
    public void setRange(String range) {
        this.range = range;
    }

    /**
     * @return the dmg
     */
    public Dice getDmg() {
        return dmg;
    }

    /**
     * @param dmg the dmg to set
     */
    public void setDmg(Dice dmg) {
        this.dmg = dmg;
    }

    /**
     * @return the hit
     */
    public Dice getHit() {
        return hit;
    }

    /**
     * @param hit the hit to set
     */
    public void setHit(Dice hit) {
        this.hit = hit;
    }

    /**
     * @return the dmgDR
     */
    public String getDmgDR() {
        return dmgDR;
    }

    /**
     * @param dmgDR the dmgDR to set
     */
    public void setDmgDR(String dmgDR) {
        this.dmgDR = dmgDR;
    }

    /**
     * @return the hitDR
     */
    public String getHitDR() {
        return hitDR;
    }

    /**
     * @param hitDR the hitDR to set
     */
    public void setHitDR(String hitDR) {
        this.hitDR = hitDR;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public Spell() {
    }

    /**
     * @param name
     * @param hitDR
     * @param dmgDR
     */
    public Spell(String name, String hitDR, String dmgDR) {
        this.name = name;
        this.hitDR = hitDR;
        this.dmgDR = dmgDR;
    }

    /**
     * @param name
     * @param hitDR
     * @param dmgDR
     * @param hit
     * @param dmg
     * @param range
     * @param damageType
     * @param proficiency
     * @param spellLevel
     */
    public Spell(String name, String hitDR, String dmgDR, Dice hit, Dice dmg, String range,
            String damageType, int proficiency, int spellLevel) {
        this.name = name;
        this.hitDR = hitDR;
        this.dmgDR = dmgDR;
        this.hit = hit;
        this.dmg = dmg;
        this.range = range;
        this.damageType = damageType;
        this.proficiency = proficiency;
        this.spellLevel = spellLevel;
    }
}
