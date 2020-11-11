package com.rhodso.app;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CharacterSheet {
    private String sheetFP;
    private CharacterSheetUI ui;

    public Player loadSheet(String sheetFP) {
        System.out.println("Filepath = " + sheetFP);
        // Settings.setLastFile(sheetFP);

        Player p = new Player();
        JSONObject player = null;
        FileReader reader;
        JSONParser jsonParser = new JSONParser();
        JSONArray weaponList;
        JSONArray spellList;
        JSONArray curr;

        // Populate player with data from JSON
        try {
            reader = new FileReader(sheetFP);
            Object obj = jsonParser.parse(reader);
            player = (JSONObject) obj;

            // Assign player vars
            p.setName(player.get("name").toString());
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
            p.setProf(Integer.parseInt((player.get("weapponProf")).toString()));
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
                spellsList.add(s);
            }
            p.setSpellsList(spellsList);

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

    private int getModifier(int base) {
        int res = 0;

        res = Math.floorDiv(base, 2);
        res -= 5;

        return res;
    }

    private int getSave(String stat, Player p) {

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
        ui = new CharacterSheetUI(loadSheet(sheetFP));
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
