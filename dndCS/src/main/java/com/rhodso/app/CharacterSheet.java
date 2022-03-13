package com.rhodso.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CharacterSheet {
    private String sheetFP;
    private static CharacterSheetUI ui;

    int getValue(boolean readValue, int thisMod, int proficiency){
        if(readValue){
            return thisMod + proficiency;
        }
        return thisMod;
    }

    boolean setValue(int attValue, int mod){
        return attValue > mod;
    }

    // Load the sheet
    public Player loadSheet(String sheetFP) {

        // Crreate new player to store info in
        Player p = new Player();
        p.setSheetFP(sheetFP);

        // Create objects to store the JSON data
        JSONObject player = null;
        FileReader reader;
        JSONParser jsonParser = new JSONParser();
        JSONArray weaponList;
        JSONArray spellList;
        JSONArray spellSlots;
        JSONArray spellSlotsLeft;
        JSONArray curr;

        // Populate player with data from JSON
        try {
            // Create reader object
            reader = new FileReader(sheetFP);
            Object obj = jsonParser.parse(reader);
            player = (JSONObject) obj;

            // Assign player vars that can be directly read
            p.setName(player.get("name").toString());
            p.setRace(player.get("race").toString());
            p.setChrClass(player.get("class").toString());
            p.setChrSubclass(player.get("subclass").toString());
            p.setHp(Integer.parseInt((player.get("hp").toString())));
            p.setHpMax(Integer.parseInt((player.get("hpMax").toString())));
            p.setAc(Integer.parseInt((player.get("ac").toString())));
            p.setXp(Integer.parseInt((player.get("xp").toString())));
            p.setLvl(Integer.parseInt((player.get("lvl").toString())));
            p.setProf(Integer.parseInt((player.get("prof")).toString()));
            p.setStr(Integer.parseInt((player.get("str").toString())));
            p.setDex(Integer.parseInt((player.get("dex")).toString()));
            p.setCon(Integer.parseInt((player.get("con")).toString()));
            p.setIntl(Integer.parseInt((player.get("int")).toString()));
            p.setWis(Integer.parseInt((player.get("wis")).toString()));
            p.setCha(Integer.parseInt((player.get("cha")).toString()));

            //Mods
            p.setStrMod(getModifier(p.getStr()));
            p.setDexMod(getModifier(p.getDex()));
            p.setConMod(getModifier(p.getCon()));
            p.setIntlMod(getModifier(p.getIntl()));
            p.setWisMod(getModifier(p.getWis()));
            p.setChaMod(getModifier(p.getCha()));

            //Str
            p.setAthletics(getValue(Boolean.parseBoolean(player.get("athletics").toString()), p.getStrMod(), p.getProf()));
            
            //Dex
            p.setAcrobatics(getValue(Boolean.parseBoolean(player.get("acrobatics").toString()), p.getDexMod(), p.getProf()));
            p.setSleightOfHand(getValue(Boolean.parseBoolean(player.get("sleightOfHand").toString()), p.getDexMod(), p.getProf()));
            p.setStealth(getValue(Boolean.parseBoolean(player.get("stealth").toString()), p.getDexMod(), p.getProf()));
            
            //Intl
            p.setArcana(getValue(Boolean.parseBoolean(player.get("arcana").toString()), p.getIntlMod(), p.getProf()));
            p.setHistory(getValue(Boolean.parseBoolean(player.get("history").toString()), p.getIntlMod(), p.getProf()));
            p.setInvestigation(getValue(Boolean.parseBoolean(player.get("investigation").toString()), p.getIntlMod(), p.getProf()));
            p.setNature(getValue(Boolean.parseBoolean(player.get("nature").toString()), p.getIntlMod(), p.getProf()));
            p.setReligion(getValue(Boolean.parseBoolean(player.get("religion").toString()), p.getIntlMod(), p.getProf()));
            
            //Wis
            p.setAnimalHandling(getValue(Boolean.parseBoolean(player.get("animalHandling").toString()), p.getWisMod(), p.getProf()));
            p.setInsight(getValue(Boolean.parseBoolean(player.get("insight").toString()), p.getWisMod(), p.getProf()));
            p.setMedicine(getValue(Boolean.parseBoolean(player.get("medicine").toString()), p.getWisMod(), p.getProf()));
            p.setPerception(getValue(Boolean.parseBoolean(player.get("perception").toString()), p.getWisMod(), p.getProf()));
            p.setSurvival(getValue(Boolean.parseBoolean(player.get("survival").toString()), p.getWisMod(), p.getProf()));
            
            //Cha
            p.setDeception(getValue(Boolean.parseBoolean(player.get("deception").toString()), p.getChaMod(), p.getProf()));
            p.setIntimidation(getValue(Boolean.parseBoolean(player.get("intimidation").toString()), p.getChaMod(), p.getProf()));
            p.setPerformance(getValue(Boolean.parseBoolean(player.get("performance").toString()), p.getChaMod(), p.getProf()));
            p.setPersuasion(getValue(Boolean.parseBoolean(player.get("persuasion").toString()), p.getChaMod(), p.getProf()));
            
            p.setHitDieDR(player.get("hitDieDR").toString());
            p.setSpeed(Integer.parseInt((player.get("speed").toString())));
            p.setWeaponResource(Integer.parseInt((player.get("weaponResource")).toString()));
            p.setcLevel(Integer.parseInt((player.get("cLevel")).toString()));
            p.setSpellAttack(Integer.parseInt((player.get("spellAttack")).toString()));
            p.setSpellDC(Integer.parseInt((player.get("spellDC")).toString()));
            p.setBackground((player.get("background").toString()));
            p.setAlignment((player.get("alignment").toString()));
            p.setNotes((player.get("info").toString()));

            // Player weapons
            weaponList = (JSONArray) player.get("weapons");
            ArrayList<Weapon> wl = new ArrayList<>();

            // For each weapon in weapon list
            for (int i = 0; i < weaponList.size(); i++) {
                JSONObject wpn = (JSONObject) weaponList.get(i);
                Weapon w = new Weapon();
                w.setName(wpn.get("name").toString());
                w.setHitDR(wpn.get("hitDR").toString());
                w.setDmgDR(wpn.get("dmgDR").toString());
                w.setRange(wpn.get("range").toString());
                w.setDamageType(wpn.get("damageType").toString());
                w.setProficiency(Integer.parseInt((wpn.get("Proficiency").toString()).toString()));

                // Calculated fields
                w.setHit(new Dice(w.getHitDR()));
                w.setDmg(new Dice(w.getDmgDR()));

                wl.add(w);
            }
            p.setWeaponsList(wl);

            // Player spells
            spellList = (JSONArray) player.get("spells");
            ArrayList<Spell> spellsList = new ArrayList<>();
            for (int i = 0; i < spellList.size(); i++) {
                JSONObject spl = (JSONObject) spellList.get(i);
                Spell s = new Spell();
                s.setName(spl.get("name").toString());
                s.setHitDR(spl.get("hitDR").toString());
                s.setDmgDR(spl.get("dmgDR").toString());
                s.setRange(spl.get("range").toString());
                s.setDamageType(spl.get("damageType").toString());
                s.setSpellLevel(Integer.parseInt((spl.get("spellLevel").toString()).toString()));

                // Calculated fields
                if (!s.getDmgDR().equals("0")) {
                    s.setDmg(new Dice(s.getDmgDR()));
                }
                s.setHit(new Dice(s.getHitDR()));

                spellsList.add(s);
            }
            p.setSpellsList(spellsList);

            // player spell slots
            spellSlots = (JSONArray) player.get("spellSlots");
            int[] ss = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            for (int i = 0; i < 9; i++) {
                ss[i] = Integer.parseInt(spellSlots.get(i).toString());
            }
            p.setSpellSlots(ss);

            spellSlotsLeft = (JSONArray) player.get("spellSlotsLeft");
            int[] ssL = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            for (int i = 0; i < 9; i++) {
                ssL[i] = Integer.parseInt(spellSlotsLeft.get(i).toString());
            }
            p.setSpellSlotsLeft(ssL);

            // Player currency
            curr = (JSONArray) player.get("currency");
            p.setPP(Integer.parseInt((curr.get(0).toString())));
            p.setGP(Integer.parseInt((curr.get(1).toString())));
            p.setSP(Integer.parseInt((curr.get(2).toString())));
            p.setCP(Integer.parseInt((curr.get(3).toString())));
            p.setEP(Integer.parseInt((curr.get(4).toString())));

            // Generate player mod
            p.setStrMod(getModifier(p.getStr()));
            p.setDexMod(getModifier(p.getDex()));
            p.setConMod(getModifier(p.getCon()));
            p.setIntlMod(getModifier(p.getIntl()));
            p.setWisMod(getModifier(p.getWis()));
            p.setChaMod(getModifier(p.getCha()));

            // Generate player save
            p.setStrSave(p.getStrMod() + getSave("str", p));
            p.setDexSave(p.getDexMod() + getSave("dex", p));
            p.setConSave(p.getConMod() + getSave("con", p));
            p.setIntlSave(p.getIntlMod() + getSave("int", p));
            p.setWisSave(p.getWisMod() + getSave("wis", p));
            p.setChaSave(p.getChaMod() + getSave("cha", p));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    // Suppress unchecked warning about some haskmap thing. If it's stupid but it
    // works then it's
    // not stupid. Probably
    @SuppressWarnings("unchecked")
    public void SaveSheet(Player p) {
        try {
            // Create string
            JSONObject player = new JSONObject();

            // Add shit to the JSON string
            player.put("name", p.getName());
            player.put("race", p.getRace());
            player.put("class", p.getChrClass());
            player.put("subclass", p.getChrSubclass());
            player.put("hp", p.getHp());
            player.put("hpMax", p.getHpMax());
            player.put("ac", p.getAc());
            player.put("xp", p.getXp());
            player.put("lvl", p.getLvl());
            player.put("str", p.getStr());
            player.put("dex", p.getDex());
            player.put("con", p.getCon());
            player.put("int", p.getIntl());
            player.put("wis", p.getWis());
            player.put("cha", p.getCha());

            player.put("athletics", setValue(p.getAthletics(), p.getStrMod()));
            
            player.put("acrobatics", setValue(p.getAcrobatics(), p.getDexMod()));
            player.put("sleightOfHand", setValue(p.getSleightOfHand(), p.getDexMod()));
            player.put("stealth", setValue(p.getStealth(), p.getDexMod()));
            
            player.put("arcana", setValue(p.getArcana(), p.getIntlMod()));
            player.put("history", setValue(p.getHistory(), p.getIntlMod()));
            player.put("investigation", setValue(p.getInvestigation(), p.getIntlMod()));
            player.put("nature", setValue(p.getNature(), p.getIntlMod()));
            player.put("religion", setValue(p.getReligion(), p.getIntlMod()));
            
            player.put("animalHandling", setValue(p.getAnimalHandling(), p.getWisMod()));
            player.put("insight", setValue(p.getInsight(), p.getWisMod()));
            player.put("medicine", setValue(p.getMedicine(), p.getWisMod()));
            player.put("perception", setValue(p.getPerception(), p.getWisMod()));
            player.put("survival", setValue(p.getSurvival(), p.getWisMod()));
            
            player.put("deception", setValue(p.getDeception(), p.getChaMod()));
            player.put("intimidation", setValue(p.getIntimidation(), p.getChaMod()));
            player.put("performance", setValue(p.getPerformance(), p.getChaMod()));
            player.put("persuasion", setValue(p.getPersuasion(), p.getChaMod()));
            
            player.put("prof", p.getProf());
            player.put("hitDieDR", p.getHitDieDR());
            player.put("speed", p.getSpeed());
            player.put("weaponResource", p.getWeaponResource());
            player.put("cLevel", p.getcLevel());
            player.put("spellAttack", p.getSpellAttack());
            player.put("spellDC", p.getSpellDC());

            // Create array of objects for weapons
            JSONArray weaponObjects = new JSONArray();
            for (Weapon w : p.getWeaponsList()) {
                JSONObject weaponsObject = new JSONObject();
                weaponsObject.put("name", w.getName());
                weaponsObject.put("hitDR", w.getHitDR());
                weaponsObject.put("dmgDR", w.getDmgDR());
                weaponsObject.put("range", w.getRange());
                weaponsObject.put("damageType", w.getDamageType());
                weaponsObject.put("Proficiency", w.getProficiency());
                weaponObjects.add(weaponsObject);
            }
            player.put("weapons", weaponObjects);

            // Create array of objects for spells
            JSONArray spellObjects = new JSONArray();
            for (Spell s : p.getSpellsList()) {
                JSONObject spellsObject = new JSONObject();
                spellsObject.put("name", s.getName());
                spellsObject.put("hitDR", s.getHitDR());
                spellsObject.put("dmgDR", s.getDmgDR());
                spellsObject.put("range", s.getRange());
                spellsObject.put("damageType", s.getDamageType());
                spellsObject.put("spellLevel", s.getSpellLevel());
                spellObjects.add(spellsObject);
            }
            player.put("spells", spellObjects);

            // Create array for currency
            JSONArray currObject = new JSONArray();
            currObject.add(0, p.getPP());
            currObject.add(1, p.getGP());
            currObject.add(2, p.getSP());
            currObject.add(3, p.getCP());
            currObject.add(4, p.getEP());
            player.put("currency", currObject);

            // Spell slots
            JSONArray ss = new JSONArray();
            int[] spellSlots = p.getSpellSlots();
            for (int i = 0; i < 9; i++) {
                ss.add(i, spellSlots[i]);
            }
            player.put("spellSlots", ss);

            JSONArray ssL = new JSONArray();
            int[] spellSlotsLeft = p.getSpellSlotsLeft();
            for (int i = 0; i < 9; i++) {
                ssL.add(i, spellSlotsLeft[i]);
            }
            player.put("spellSlotsLeft", ssL);

            // Add rest of info
            player.put("background", p.getBackground());
            player.put("alignment", p.getAlignment());
            player.put("info", p.getNotes());

            // Get string representation of the JSON object
            String playerStr = player.toString();

            // Create the file path
            File fp = new File(sheetFP);
            String newfp = fp.getParent();
            newfp = newfp + "/" + p.getName() + ".json";

            // Check if the file exists. If it does then delete it
            File newFile = new File(newfp);
            if (newFile.exists()) {
                newFile.delete();
            }
            newFile.createNewFile();

            // Write to file, then close it
            FileOutputStream os = new FileOutputStream(newfp);
            byte[] strToBytes = playerStr.getBytes();
            os.write(strToBytes);
            os.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Launch the weapon modifier
    public void launchWeaponModifier(int _weaponID, Player p) {

        // Create a weapon object
        Weapon w = null;

        // Match it to the selected weapon
        for (Weapon wpn : p.getWeaponsList()) {
            if (wpn.getID() == _weaponID) {
                w = wpn;
                break;
            }
        }

        // Create instance of the UI, depending on if we're creating a new weapon or not
        weaponModifierUI wm;
        if (w == null) {
            wm = new weaponModifierUI(p);
        } else {
            wm = new weaponModifierUI(p, w);
        }

        // Set visible
        wm.setVisible(true);
    }

    // Launch the spell modifier
    public void launchSpellModifier(int _spellID, Player p) {

        // Create new spell to put it into
        Spell s = null;

        // Then match the spell
        for (Spell spl : p.getSpellsList()) {
            if (spl.getID() == _spellID) {
                s = spl;
                break;
            }
        }

        // Create spell modifier UI
        spellModifierUI sm;
        if (s == null) {
            sm = new spellModifierUI(p);
        } else {
            sm = new spellModifierUI(p, s);
        }

        // Set visible
        sm.setVisible(true);
    }

    // Info modifier doesn't need any fancy stuff
    public void launchInfoModifier(Player p) {
        infoModifier im = new infoModifier(p);
        im.setVisible(true);
    }

    /*
     * @return the number formatted as a string
     */
    public String formatStr(int i) {
        if (i > 0) {
            return "+" + Integer.toString(i);
        } else {
            return Integer.toString(i);
        }
    }

    // Modifier goes up by +1 every two attribute levels, starting from 10
    public int getModifier(int base) {
        int res = 0;

        res = Math.floorDiv(base, 2);
        res -= 5;

        return res;
    }

    public int getSave(String stat, Player p) {

        // Create vers for working it out
        int res = 0;
        String cls = p.getChrClass();
        int prof = p.getProf();

        cls = cls.toLowerCase();

        // If the player's class matches, then add proficiency to matching stats
        // If else, then do nothing
        if (cls.equals("barbarian")) {
            if (stat.equals("str") || stat.equals("con")) {
                res += prof;
            }
        } else if (cls.equals("bard")) {
            if (stat.equals("dex") || stat.equals("cha")) {
                res += prof;
            }
        } else if (cls.equals("cleric")) {
            if (stat.equals("wis") || stat.equals("cha")) {
                res += prof;
            }
        } else if (cls.equals("druid")) {
            if (stat.equals("int") || stat.equals("wis")) {
                res += prof;
            }
        } else if (cls.equals("monk")) {
            if (stat.equals("str") || stat.equals("dex")) {
                res += prof;
            }
        } else if (cls.equals("paladin")) {
            if (stat.equals("wis") || stat.equals("cha")) {
                res += prof;
            }
        } else if (cls.equals("ranger")) {
            if (stat.equals("str") || stat.equals("dex")) {
                res += prof;
            }
        } else if (cls.equals("rogue")) {
            if (stat.equals("dex") || stat.equals("int")) {
                res += prof;
            }
        } else if (cls.equals("sorcerer")) {
            if (stat.equals("con") || stat.equals("cha")) {
                res += prof;
            }
        } else if (cls.equals("warlock")) {
            if (stat.equals("wis") || stat.equals("cha")) {
                res += prof;
            }
        } else if (cls.equals("wizard")) {
            if (stat.equals("int") || stat.equals("wis")) {
                res += prof;
            }
        }

        return res;
    }

    // Load the UI with a sheet FP
    public void loadUI(String sheetFP) {
        ui = new CharacterSheetUI(loadSheet(sheetFP), this.sheetFP);
        ui.setVisible(true);
    }

    // Load the UI with a player
    public void loadUI(Player p) {
        ui = new CharacterSheetUI(p, p.getSheetFP());
        ui.setVisible(true);
    }

    /**
     * @return the sheetFP
     */
    public String getSheetFP() {
        return sheetFP;
    }

    /**
     * @param sheetFP the sheetFP to set
     */
    public void setSheetFP(String sheetFP) {
        this.sheetFP = sheetFP;
    }

    // Blank constructor
    public CharacterSheet() {
    }

    /**
     * @param sheetFP
     */
    public CharacterSheet(String sheetFP) {
        this.sheetFP = sheetFP;
    }

}
