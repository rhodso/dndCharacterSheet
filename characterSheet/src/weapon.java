public class weapon {
    private String name;
    private String hitDR;
    private String dmgDR;
    private dice hit;
    private dice dmg;
    private String range;
    private String damageType;
    private int proficiency;

    /**
     * @return the name
     */
    public String getName() {
        return name;
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
    public dice getDmg() {
        return dmg;
    }

    /**
     * @param dmg the dmg to set
     */
    public void setDmg(dice dmg) {
        this.dmg = dmg;
    }

    /**
     * @return the hit
     */
    public dice getHit() {
        return hit;
    }

    /**
     * @param hit the hit to set
     */
    public void setHit(dice hit) {
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
    public weapon() {
    }

    /**
     * @param name
     * @param hitDR
     * @param dmgDR
     * @param range
     * @param damageType
     * @param proficiency
     */
    public weapon(String name, String hitDR, String dmgDR, String range, String damageType,
            int proficiency) {
        this.name = name;
        this.hitDR = hitDR;
        this.dmgDR = dmgDR;
        this.range = range;
        this.damageType = damageType;
        this.proficiency = proficiency;
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
     */
    public weapon(String name, String hitDR, String dmgDR, dice hit, dice dmg, String range,
            String damageType, int proficiency) {
        this.name = name;
        this.hitDR = hitDR;
        this.dmgDR = dmgDR;
        this.hit = hit;
        this.dmg = dmg;
        this.range = range;
        this.damageType = damageType;
        this.proficiency = proficiency;
    }

}
