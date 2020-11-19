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
    private static Weapon checkedWeapon;

    public Weapon getCheckedWeapon() {
        return checkedWeapon;
    }

    public void setCheckedWeapon(Weapon _checkedWeapon) {
        checkedWeapon = _checkedWeapon;
    }

    public Player loadSheet(String sheetFP) {
        // Settings.setLastFile(sheetFP);

        Player p = new Player();

        p.setSheetFP(sheetFP);

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
            reader = new FileReader(sheetFP);
            Object obj = jsonParser.parse(reader);
            player = (JSONObject) obj;

            // Assign player vars
            p.setName(player.get("name").toString());
            p.setRace(player.get("race").toString());
            p.setChrClass(player.get("class").toString());
            p.setChrSubclass(player.get("subclass").toString());
            p.setHp(Integer.parseInt((player.get("hp").toString())));
            p.setHpMax(Integer.parseInt((player.get("hpMax").toString())));
            p.setAc(Integer.parseInt((player.get("ac").toString())));
            p.setXp(Integer.parseInt((player.get("xp").toString())));
            p.setLvl(Integer.parseInt((player.get("lvl").toString())));
            p.setStr(Integer.parseInt((player.get("str").toString())));
            p.setDex(Integer.parseInt((player.get("dex")).toString()));
            p.setCon(Integer.parseInt((player.get("con")).toString()));
            p.setIntl(Integer.parseInt((player.get("int")).toString()));
            p.setWis(Integer.parseInt((player.get("wis")).toString()));
            p.setCha(Integer.parseInt((player.get("cha")).toString()));
            p.setAthletics(Integer.parseInt((player.get("athletics")).toString()));
            p.setAcrobatics(Integer.parseInt((player.get("acrobatics")).toString()));
            p.setSleightOfHand(Integer.parseInt((player.get("sleightOfHand")).toString()));
            p.setStealth(Integer.parseInt((player.get("stealth")).toString()));
            p.setArcana(Integer.parseInt((player.get("arcana")).toString()));
            p.setHistory(Integer.parseInt((player.get("history")).toString()));
            p.setInvestigation(Integer.parseInt((player.get("investigation")).toString()));
            p.setNature(Integer.parseInt((player.get("nature")).toString()));
            p.setReligion(Integer.parseInt((player.get("religion")).toString()));
            p.setAnimalHandling(Integer.parseInt((player.get("animalHandling")).toString()));
            p.setInsight(Integer.parseInt((player.get("insight")).toString()));
            p.setMedicine(Integer.parseInt((player.get("medicine")).toString()));
            p.setPerception(Integer.parseInt((player.get("perception")).toString()));
            p.setSurvival(Integer.parseInt((player.get("survival")).toString()));
            p.setDeception(Integer.parseInt((player.get("deception")).toString()));
            p.setIntimidation(Integer.parseInt((player.get("intimidation")).toString()));
            p.setPerformance(Integer.parseInt((player.get("performance")).toString()));
            p.setPersuasion(Integer.parseInt((player.get("persuasion")).toString()));
            p.setProf(Integer.parseInt((player.get("prof")).toString()));
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
            int[] ss = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int i = 0; i < 9; i++) {
                ss[i] = Integer.parseInt(spellSlots.get(i).toString());
            }
            p.setSpellSlots(ss);

            spellSlotsLeft = (JSONArray) player.get("spellSlotsLeft");
            int[] ssL = {0, 0, 0, 0, 0, 0, 0, 0, 0};
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

            // Inferred types
            p.setStrMod(getModifier(p.getStr()));
            p.setDexMod(getModifier(p.getDex()));
            p.setConMod(getModifier(p.getCon()));
            p.setIntlMod(getModifier(p.getIntl()));
            p.setWisMod(getModifier(p.getWis()));
            p.setChaMod(getModifier(p.getCha()));

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

    // Suppress unchecked warning about some haskmap thing. If it's stupid but it works then it's
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
            player.put("athletics", p.getAthletics());
            player.put("acrobatics", p.getAcrobatics());
            player.put("sleightOfHand", p.getSleightOfHand());
            player.put("stealth", p.getStealth());
            player.put("arcana", p.getArcana());
            player.put("history", p.getHistory());
            player.put("investigation", p.getInvestigation());
            player.put("nature", p.getNature());
            player.put("religion", p.getReligion());
            player.put("animalHandling", p.getAnimalHandling());
            player.put("insight", p.getInsight());
            player.put("medicine", p.getMedicine());
            player.put("perception", p.getPerception());
            player.put("survival", p.getSurvival());
            player.put("deception", p.getDeception());
            player.put("intimidation", p.getIntimidation());
            player.put("performance", p.getPerformance());
            player.put("persuasion", p.getPersuasion());
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

            String playerStr = player.toString();

            File fp = new File(sheetFP);
            String newfp = fp.getParent();
            newfp = newfp + "/" + p.getName() + ".json"; // Add tmp for the moment
            File newFile = new File(newfp);
            if (newFile.exists()) {
                newFile.delete();
            }
            newFile.createNewFile();

            FileOutputStream os = new FileOutputStream(newfp);
            byte[] strToBytes = playerStr.getBytes();
            os.write(strToBytes);
            os.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getModifier(int base) {
        int res = 0;

        res = Math.floorDiv(base, 2);
        res -= 5;

        return res;
    }

    public void launchWeaponModifier(int _weaponID, Player p) {
        Weapon w = null;
        for (Weapon wpn : p.getWeaponsList()) {
            if (wpn.getID() == _weaponID) {
                w = wpn;
                break;
            }
        }
        weaponModifierUI wm;

        if (w == null) {
            wm = new weaponModifierUI(p);
        } else {
            wm = new weaponModifierUI(p, w);
        }

        wm.setVisible(true);
    }

    public void launchSpellModifier(int _spellID, Player p) {
        Spell s = null;
        for (Spell spl : p.getSpellsList()) {
            if (spl.getID() == _spellID) {
                s = spl;
                break;
            }
        }
        spellModifierUI sm;

        if (s == null) {
            sm = new spellModifierUI(p);
        } else {
            sm = new spellModifierUI(p, s);
        }

        sm.setVisible(true);
    }

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

    public int getSave(String stat, Player p) {

        int res = 0;
        String cls = p.getChrClass();
        int prof = p.getProf();

        cls = cls.toLowerCase();

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

    public void loadUI(String sheetFP) {
        ui = new CharacterSheetUI(loadSheet(sheetFP), this.sheetFP);
        ui.setVisible(true);
    }

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

    /**
     *
     */
    public CharacterSheet() {
    }

    /**
     * @param sheetFP
     */
    public CharacterSheet(String sheetFP) {
        this.sheetFP = sheetFP;
    }


}
