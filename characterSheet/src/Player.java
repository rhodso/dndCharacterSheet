import java.util.ArrayList;

public class Player {
    // Vars

    // Character attributes
    private String name;
    private String chrClass;
    private String chrSubclass;

    // Battle stats
    private int hp;
    private int hpMax;
    private int ac;
    private int xp;
    private int lvl;
    private int weaponProf;
    private int weaponResource;
    private int cLevel;
    private int spellAttack;
    private int spellDC;

    // Base stats
    private int str;
    private int dex;
    private int con;
    private int wis;
    private int cha;

    // Extra stats
    private int athletics;
    private int acrobatics;
    private int sleightOfHand;
    private int stealth;
    private int arcana;
    private int history;
    private int investigation;
    private int nature;
    private int religion;
    private int animalHandling;
    private int insight;
    private int medicine;
    private int perception;
    private int survival;
    private int deception;
    private int intimidation;
    private int performance;
    private int persuasion;

    // Info
    int PP;
    int GP;
    int SP;
    int CP;
    int EP;
    String background;
    String alignment;
    String notes;

    // Lists
    private ArrayList<Weapon> weaponsList;
    private ArrayList<ArrayList<Spell>> spellsList;

    /**
     * @return the persuasion
     */
    public int getPersuasion() {
        return persuasion;
    }

    /**
     * @return the spellDC
     */
    public int getSpellDC() {
        return spellDC;
    }

    /**
     * @param spellDC the spellDC to set
     */
    public void setSpellDC(int spellDC) {
        this.spellDC = spellDC;
    }

    /**
     * @return the spellAttack
     */
    public int getSpellAttack() {
        return spellAttack;
    }

    /**
     * @param spellAttack the spellAttack to set
     */
    public void setSpellAttack(int spellAttack) {
        this.spellAttack = spellAttack;
    }

    /**
     * @return the cLevel
     */
    public int getcLevel() {
        return cLevel;
    }

    /**
     * @param cLevel the cLevel to set
     */
    public void setcLevel(int cLevel) {
        this.cLevel = cLevel;
    }

    /**
     * @return the weaponResource
     */
    public int getWeaponResource() {
        return weaponResource;
    }

    /**
     * @param weaponResource the weaponResource to set
     */
    public void setWeaponResource(int weaponResource) {
        this.weaponResource = weaponResource;
    }

    /**
     * @return the weaponProf
     */
    public int getWeaponProf() {
        return weaponProf;
    }

    /**
     * @param weaponProf the weaponProf to set
     */
    public void setWeaponProf(int weaponProf) {
        this.weaponProf = weaponProf;
    }

    /**
     * @return the spellsList
     */
    public ArrayList<ArrayList<Spell>> getSpellsList() {
        return spellsList;
    }

    /**
     * @param spellsList the spellsList to set
     */
    public void setSpellsList(ArrayList<ArrayList<Spell>> spellsList) {
        this.spellsList = spellsList;
    }

    /**
     * @return the weaponsList
     */
    public ArrayList<Weapon> getWeaponsList() {
        return weaponsList;
    }

    /**
     * @param weaponsList the weaponsList to set
     */
    public void setWeaponsList(ArrayList<Weapon> weaponsList) {
        this.weaponsList = weaponsList;
    }

    /**
     * @param persuasion the persuasion to set
     */
    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    /**
     * @return the performance
     */
    public int getPerformance() {
        return performance;
    }

    /**
     * @param performance the performance to set
     */
    public void setPerformance(int performance) {
        this.performance = performance;
    }

    /**
     * @return the intimidation
     */
    public int getIntimidation() {
        return intimidation;
    }

    /**
     * @param intimidation the intimidation to set
     */
    public void setIntimidation(int intimidation) {
        this.intimidation = intimidation;
    }

    /**
     * @return the deception
     */
    public int getDeception() {
        return deception;
    }

    /**
     * @param deception the deception to set
     */
    public void setDeception(int deception) {
        this.deception = deception;
    }

    /**
     * @return the survival
     */
    public int getSurvival() {
        return survival;
    }

    /**
     * @param survival the survival to set
     */
    public void setSurvival(int survival) {
        this.survival = survival;
    }

    /**
     * @return the perception
     */
    public int getPerception() {
        return perception;
    }

    /**
     * @param perception the perception to set
     */
    public void setPerception(int perception) {
        this.perception = perception;
    }

    /**
     * @return the medicine
     */
    public int getMedicine() {
        return medicine;
    }

    /**
     * @param medicine the medicine to set
     */
    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }

    /**
     * @return the insight
     */
    public int getInsight() {
        return insight;
    }

    /**
     * @param insight the insight to set
     */
    public void setInsight(int insight) {
        this.insight = insight;
    }

    /**
     * @return the animalHandling
     */
    public int getAnimalHandling() {
        return animalHandling;
    }

    /**
     * @param animalHandling the animalHandling to set
     */
    public void setAnimalHandling(int animalHandling) {
        this.animalHandling = animalHandling;
    }

    /**
     * @return the religion
     */
    public int getReligion() {
        return religion;
    }

    /**
     * @param religion the religion to set
     */
    public void setReligion(int religion) {
        this.religion = religion;
    }

    /**
     * @return the nature
     */
    public int getNature() {
        return nature;
    }

    /**
     * @param nature the nature to set
     */
    public void setNature(int nature) {
        this.nature = nature;
    }

    /**
     * @return the investigation
     */
    public int getInvestigation() {
        return investigation;
    }

    /**
     * @param investigation the investigation to set
     */
    public void setInvestigation(int investigation) {
        this.investigation = investigation;
    }

    /**
     * @return the history
     */
    public int getHistory() {
        return history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(int history) {
        this.history = history;
    }

    /**
     * @return the arcana
     */
    public int getArcana() {
        return arcana;
    }

    /**
     * @param arcana the arcana to set
     */
    public void setArcana(int arcana) {
        this.arcana = arcana;
    }

    /**
     * @return the stealth
     */
    public int getStealth() {
        return stealth;
    }

    /**
     * @param stealth the stealth to set
     */
    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    /**
     * @return the sleightOfHand
     */
    public int getSleightOfHand() {
        return sleightOfHand;
    }

    /**
     * @param sleightOfHand the sleightOfHand to set
     */
    public void setSleightOfHand(int sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    /**
     * @return the acrobatics
     */
    public int getAcrobatics() {
        return acrobatics;
    }

    /**
     * @param acrobatics the acrobatics to set
     */
    public void setAcrobatics(int acrobatics) {
        this.acrobatics = acrobatics;
    }

    /**
     * @return the athletics
     */
    public int getAthletics() {
        return athletics;
    }

    /**
     * @param athletics the athletics to set
     */
    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    /**
     * @return the cha
     */
    public int getCha() {
        return cha;
    }

    /**
     * @param cha the cha to set
     */
    public void setCha(int cha) {
        this.cha = cha;
    }

    /**
     * @return the wis
     */
    public int getWis() {
        return wis;
    }

    /**
     * @param wis the wis to set
     */
    public void setWis(int wis) {
        this.wis = wis;
    }

    /**
     * @return the con
     */
    public int getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(int con) {
        this.con = con;
    }

    /**
     * @return the dex
     */
    public int getDex() {
        return dex;
    }

    /**
     * @param dex the dex to set
     */
    public void setDex(int dex) {
        this.dex = dex;
    }

    /**
     * @return the str
     */
    public int getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(int str) {
        this.str = str;
    }

    /**
     * @return the lvl
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * @param lvl the lvl to set
     */
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    /**
     * @return the xp
     */
    public int getXp() {
        return xp;
    }

    /**
     * @param xp the xp to set
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * @return the ac
     */
    public int getAc() {
        return ac;
    }

    /**
     * @param ac the ac to set
     */
    public void setAc(int ac) {
        this.ac = ac;
    }

    /**
     * @return the hpMax
     */
    public int getHpMax() {
        return hpMax;
    }

    /**
     * @param hpMax the hpMax to set
     */
    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    /**
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * @return the chrSubclass
     */
    public String getChrSubclass() {
        return chrSubclass;
    }

    /**
     * @param chrSubclass the chrSubclass to set
     */
    public void setChrSubclass(String chrSubclass) {
        this.chrSubclass = chrSubclass;
    }

    /**
     * @return the chrClass
     */
    public String getChrClass() {
        return chrClass;
    }

    /**
     * @param chrClass the chrClass to set
     */
    public void setChrClass(String chrClass) {
        this.chrClass = chrClass;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
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
    public Player() {
    }

    /**
     * @param name
     * @param chrClass
     * @param chrSubclass
     */
    public Player(String name, String chrClass, String chrSubclass) {
        this.name = name;
        this.chrClass = chrClass;
        this.chrSubclass = chrSubclass;
    }

    /**
     * @param name
     * @param chrClass
     * @param chrSubclass
     * @param hp
     * @param hpMax
     * @param ac
     * @param xp
     * @param lvl
     * @param str
     * @param dex
     * @param con
     * @param wis
     * @param cha
     * @param athletics
     * @param acrobatics
     * @param sleightOfHand
     * @param stealth
     * @param arcana
     * @param history
     * @param investigation
     * @param nature
     * @param religion
     * @param animalHandling
     * @param insight
     * @param medicine
     * @param perception
     * @param survival
     * @param deception
     * @param intimidation
     * @param performance
     * @param persuasion
     */
    public Player(String name, String chrClass, String chrSubclass, int hp, int hpMax, int ac,
            int xp, int lvl, int str, int dex, int con, int wis, int cha, int athletics,
            int acrobatics, int sleightOfHand, int stealth, int arcana, int history,
            int investigation, int nature, int religion, int animalHandling, int insight,
            int medicine, int perception, int survival, int deception, int intimidation,
            int performance, int persuasion) {
        this.name = name;
        this.chrClass = chrClass;
        this.chrSubclass = chrSubclass;
        this.hp = hp;
        this.hpMax = hpMax;
        this.ac = ac;
        this.xp = xp;
        this.lvl = lvl;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.wis = wis;
        this.cha = cha;
        this.athletics = athletics;
        this.acrobatics = acrobatics;
        this.sleightOfHand = sleightOfHand;
        this.stealth = stealth;
        this.arcana = arcana;
        this.history = history;
        this.investigation = investigation;
        this.nature = nature;
        this.religion = religion;
        this.animalHandling = animalHandling;
        this.insight = insight;
        this.medicine = medicine;
        this.perception = perception;
        this.survival = survival;
        this.deception = deception;
        this.intimidation = intimidation;
        this.performance = performance;
        this.persuasion = persuasion;
    }

    /**
     * @param name
     * @param chrClass
     * @param chrSubclass
     * @param hp
     * @param hpMax
     * @param ac
     * @param xp
     * @param lvl
     * @param str
     * @param dex
     * @param con
     * @param wis
     * @param cha
     * @param athletics
     * @param acrobatics
     * @param sleightOfHand
     * @param stealth
     * @param arcana
     * @param history
     * @param investigation
     * @param nature
     * @param religion
     * @param animalHandling
     * @param insight
     * @param medicine
     * @param perception
     * @param survival
     * @param deception
     * @param intimidation
     * @param performance
     * @param persuasion
     * @param weaponsList
     * @param spellsList
     */
    public Player(String name, String chrClass, String chrSubclass, int hp, int hpMax, int ac,
            int xp, int lvl, int str, int dex, int con, int wis, int cha, int athletics,
            int acrobatics, int sleightOfHand, int stealth, int arcana, int history,
            int investigation, int nature, int religion, int animalHandling, int insight,
            int medicine, int perception, int survival, int deception, int intimidation,
            int performance, int persuasion, ArrayList<Weapon> weaponsList,
            ArrayList<ArrayList<Spell>> spellsList) {
        this.name = name;
        this.chrClass = chrClass;
        this.chrSubclass = chrSubclass;
        this.hp = hp;
        this.hpMax = hpMax;
        this.ac = ac;
        this.xp = xp;
        this.lvl = lvl;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.wis = wis;
        this.cha = cha;
        this.athletics = athletics;
        this.acrobatics = acrobatics;
        this.sleightOfHand = sleightOfHand;
        this.stealth = stealth;
        this.arcana = arcana;
        this.history = history;
        this.investigation = investigation;
        this.nature = nature;
        this.religion = religion;
        this.animalHandling = animalHandling;
        this.insight = insight;
        this.medicine = medicine;
        this.perception = perception;
        this.survival = survival;
        this.deception = deception;
        this.intimidation = intimidation;
        this.performance = performance;
        this.persuasion = persuasion;
        this.weaponsList = weaponsList;
        this.spellsList = spellsList;
    }
}
