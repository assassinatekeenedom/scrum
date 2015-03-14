package com.keene.mepbm.pdfparser.sections;

import com.keene.mepbm.models.Artifact;
import com.keene.mepbm.models.ResourceDetails;
import com.keene.mepbm.models.Upkeep;
import com.keene.mepbm.models.impl.ArtifactImpl;
import com.keene.mepbm.models.impl.NationImpl;
import com.keene.mepbm.models.impl.ResourceDetailsImpl;
import com.keene.mepbm.models.impl.TurnNumberImpl;
import com.keene.mepbm.models.impl.UpkeepImpl;

public final class Miscellaneous extends TurnPDFSection {

    public Miscellaneous() {
    }

    @Override
    public final void process() {
        this.parseMaintenance();
        this.parseShips();
        this.parseDoubleAgents();
        this.parseHostages();
        this.parseHeldArtifacts();
        this.parseHiddenArtifacts();
    }

    private void parseHiddenArtifacts() {
        if (this.getData().getToken().contains("hidden the following additional artifacts:")) {
            boolean first = true;
            while (!(this.getData().getToken().contains("NATION MESSAGES"))) {
                if (first) {
                    if (this.getData().nextToken().contains("None")) {
                        this.getData().nextToken();
                        break;
                    }
                }
                if (first) {
                    this.getData().nextToken();
                    this.getData().nextToken();
                    this.getData().nextToken();
                    first = false;
                }
                Artifact artifact = this.parseHiddenArtifactDetails();
                this.getData().nextToken();
            }

        }
        this.getData().nextToken();
    }

    private void parseHeldArtifacts() {
        if (this.getData().getToken().contains("possess")) {
            boolean first = true;
            while (!(this.getData().getToken().contains("hidden"))) {
                if (first) {
                    if (this.getData().nextToken().contains("None")) {
                        this.getData().nextToken();
                        break;
                    }
                }

                if (first) {
                    this.getData().nextToken();
                    this.getData().nextToken();
                    this.getData().nextToken();
                    this.getData().nextToken();
                    this.getData().nextToken();
                    this.getData().nextToken();
                    first = false;
                }
                Artifact artifact = this.parseArtifactDetails();
                this.getData().nextToken();
            }
        }
    }

    private void parseHostages() {
        if (this.getData().getToken().contains("hostages")) {
            if (this.getData().nextToken().contains("None")) {
                this.getData().nextToken();
                return;
            } else {
                while (!(this.getData().getToken().contains("You possess the following artifacts"))) {
                    String name = this.getData().getToken();
                    String baseInfo = this.getData().nextToken();
                    String nation = baseInfo.substring(baseInfo.indexOf("of the ") + "of the ".length(), baseInfo.indexOf(" is held by"));
                    String heldBy = baseInfo.substring(baseInfo.indexOf("is held by ") + "is held by ".length(), baseInfo.indexOf(" at"));
                    String hex = baseInfo.substring(baseInfo.indexOf("at ") + 3, baseInfo.length());

                    this.getData().nextToken();
                    this.getData().nextToken();
//                    CharacterImpl heldByAgent = (CharacterImpl) this.getData().getPersistence().getCharacterDAO().load(heldBy, this.getData().getActiveGame(), this.getData().getActiveNationTurn().getTurnNumber());
//                    CharacterImpl character = (CharacterImpl) this.getData().getPersistence().getCharacterDAO().load(name, this.getData().getActiveGame(), this.getData().getActiveNationTurn().getTurnNumber());
//                    NationImpl nationImpl = (NationImpl) this.getData().getPersistence().getNationDAO().load(nation, this.getData().getActiveGame());
//                    NationTurnImpl nationTurn = (NationTurnImpl) this.getData().getPersistence().getNationTurnDAO().load(nationImpl, this.getData().getActiveNationTurn().getTurnNumber());
//                    Climate climate = this.getData().getPersistence().getClimateDAO().load("unknown");
//                    Terrain terrain = this.getData().getPersistence().getTerrainDAO().load("unknown");
//                    HexImpl hexImpl = (HexImpl) this.getData().getPersistence().getHexDAO().load(Integer.parseInt(hex.trim()), climate, terrain);
//                    character.setHostageOf((NationImpl) this.getData().getActiveNation());
//                    character.setHeldBy(heldByAgent);
//                    character.setNationTurn(nationTurn);
//                    character.setHex(hexImpl);
//                    this.getData().getPersistence().getCharacterDAO().save(character);
                }
            }
        }
    }

    private void parseDoubleAgents() {
        if (this.getData().getToken().contains("double agents")) {
            if (this.getData().nextToken().contains("None")) {
                this.getData().nextToken();
                return;
            } else {
                while (!(this.getData().getToken().contains("hostages"))) {
                    String name = this.getData().getToken();
                    String baseInfo = this.getData().nextToken();
                    String nation = baseInfo.substring(baseInfo.indexOf("of the ") + "of the ".length(), baseInfo.indexOf(" @"));
                    String hex = baseInfo.substring(baseInfo.indexOf("@ ") + 2, baseInfo.length());

                    StringBuilder orders = new StringBuilder();                    
                    if(this.getData().nextToken().trim().length()==0){
                        this.getData().nextToken();
                    }
                    if (this.getData().getToken().contains("Double agent")) {
                        orders.append(this.getData().getToken());
                        this.getData().nextToken();
                        while (!(this.getData().getToken().contains("hostages"))) {
                            orders.append(this.getData().getToken());
                            if(!this.getData().nextToken().contains(" ") && !(this.getData().getToken().contains("."))){
                                break;
                            }

                        }
                    }
//                    CharacterImpl character = (CharacterImpl) this.getData().getPersistence().getCharacterDAO().load(name, this.getData().getActiveGame(), this.getData().getActiveNationTurn().getTurnNumber());
//                    NationImpl nationImpl = (NationImpl) this.getData().getPersistence().getNationDAO().load(nation, this.getData().getActiveGame());
//                    NationTurnImpl nationTurn = (NationTurnImpl) this.getData().getPersistence().getNationTurnDAO().load(nationImpl, this.getData().getActiveNationTurn().getTurnNumber());
//                    Climate climate = this.getData().getPersistence().getClimateDAO().load("unknown");
//                    Terrain terrain = this.getData().getPersistence().getTerrainDAO().load("unknown");
//                    HexImpl hexImpl = (HexImpl) this.getData().getPersistence().getHexDAO().load(Integer.parseInt(hex.trim()), climate, terrain);
//                    character.setDoubleAgentOf((NationImpl) this.getData().getActiveNation());
//                    character.setNationTurn(nationTurn);
//                    character.setHex(hexImpl);
//                    character.setOrderSummary(orders.toString());
//                    this.getData().getPersistence().getCharacterDAO().save(character);
                }
            }
        }
    }

    private void parseShips() {
        if (this.getData().getToken().contains("Ships")) {
            while (!(this.getData().getToken().contains("double agents"))) {
                if (this.getData().nextToken().contains("None")) {
                    this.getData().nextToken();
                    break;
                } else {
                    if (this.getData().getToken().contains("warships")) {
                        this.getData().getActiveNationTurn().setWarships(Integer.parseInt(this.getData().getToken().substring(0, this.getData().getToken().indexOf(" "))));
                    } else if (this.getData().getToken().contains("transports")) {
                        this.getData().getActiveNationTurn().setTransports(Integer.parseInt(this.getData().getToken().substring(0, this.getData().getToken().indexOf(" "))));
                    }
                }
            }
        }
    }

    private void parseMaintenance() {
        this.getData().nextToken();
        this.getData().nextToken();
        this.getData().nextToken();
        this.getData().nextToken();
        Upkeep upkeep = new UpkeepImpl();
        ResourceDetails resources = new ResourceDetailsImpl();
        while (!(this.getData().nextToken().contains("Ships"))) {
            if (this.getData().getToken().contains("Armies/Navies")) {
                upkeep.setArmiesAndNavies(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            } else if (this.getData().getToken().contains("Leather")) {
                resources.setLeatherStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                resources.setLeatherProduction(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            } else if (this.getData().getToken().contains("Pop Centers")) {
                upkeep.setPopCenters(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            } else if (this.getData().getToken().contains("Bronze")) {
                resources.setBronzeStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                resources.setBronzeProduction(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            } else if (this.getData().getToken().contains("Characters")) {
                upkeep.setCharacters(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            } else if (this.getData().getToken().contains("Steel")) {
                resources.setSteelStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                resources.setSteelProduction(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            } else if (this.getData().getToken().contains("Mithril")) {
                resources.setMithrilStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                resources.setMithrilProduction(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            } else if (this.getData().getToken().contains("Total")) {
                upkeep.setTotalUpkeep(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            } else if (this.getData().getToken().contains("Food")) {
                resources.setFoodStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                resources.setFoodProduction(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            } else if (this.getData().getToken().contains("Timber")) {
                resources.setTimberStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                resources.setTimberProduction(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            } else if (this.getData().getToken().contains("Current Tax rate")) {
                upkeep.setTaxRate(this.getData().isolateRightColumnNumber(this.getData().nextToken(), "%"));
            } else if (this.getData().getToken().contains("Mounts")) {
                resources.setMountsStore(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                resources.setMountsProduction(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            } else if (this.getData().getToken().contains("Revenue")) {
                upkeep.setGrossGold(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
                this.getData().nextToken();
                String net = this.getData().nextToken().replace("(", "").replace(")", "");
                System.out.println("...... "+net);
                net = net.replace("+", "");
                upkeep.setNetGold(this.getData().isolateRightColumnNumber(net, " "));
            } else if (this.getData().getToken().contains("Gold reserve")) {
                upkeep.setReserves(this.getData().isolateRightColumnNumber(this.getData().nextToken(), " "));
            }
        }
        resources.setUpkeep(upkeep);
        resources.setTurnNumber((TurnNumberImpl) this.getData().getActiveNationTurn().getTurnNumber());
        resources.setNation((NationImpl) this.getData().getActiveNation());
        this.getData().getActiveNationTurn().setUpkeep(upkeep);
        this.getData().getActiveNationTurn().setResourceDetails(resources);


    }

    private Artifact parseArtifactDetails() {
        String name = this.getData().getToken();
        String type = this.getData().nextToken();
        int number = Integer.parseInt(this.getData().nextToken().trim());
        String latent = this.getData().nextToken();
        String alignment = this.getData().nextToken();
        Artifact artifact = new ArtifactImpl();

//        if (alignment.contains("Evil")) {
//            artifact.setAlignment(this.getData().getPersistence().getAllegianceDAO().load("Dark Servant"));
//        } else if (alignment.contains("Good")) {
//            artifact.setAlignment(this.getData().getPersistence().getAllegianceDAO().load("Free People"));
//        } else if (alignment.contains("Neutral")) {
//            artifact.setAlignment(this.getData().getPersistence().getAllegianceDAO().load("Neutral"));
//        }

        artifact.setName(name);
        artifact.setNumber(number);
        artifact.setType(type);
        artifact.setLatent(latent);
        artifact.setGame(this.getData().getActiveGame());
        artifact.setKnownPowers(this.getData().nextToken());
        artifact.setNationTurn(this.getData().getActiveNationTurn());

        if (this.getData().getToken().contains("COMBAT")) {
            artifact.setCombatDamage(this.isolateCombatDamage(this.getData().getToken()));
        }
        if (this.getData().getToken().contains("Command")) {
            artifact.setCommandSkill(this.isolateSkillBonus(this.getData().getToken(), "Command"));
        }
        if (this.getData().getToken().contains("Mage")) {
            artifact.setMageSkill(this.isolateSkillBonus(this.getData().getToken(), "Mage"));
        }
        if (this.getData().getToken().contains("Agent")) {
            artifact.setAgentSkill(this.isolateSkillBonus(this.getData().getToken(), "Agent"));
        }
        if (this.getData().getToken().contains("Emissary")) {
            artifact.setEmissarySkill(this.isolateSkillBonus(this.getData().getToken(), "Emissary"));
        }
        return artifact;
    }

    private Artifact parseHiddenArtifactDetails() {
        String name = this.getData().getToken();
        int number = this.getData().isolateRightColumnNumber(this.getData().nextToken(), "");
        Artifact artifact = new ArtifactImpl();
        artifact.setName(name);
        artifact.setGame(this.getData().getActiveGame());
        artifact.setLocation(this.getData().nextToken());
        artifact.setHidden(true);
        artifact.setNationTurn(this.getData().getActiveNationTurn());
        return artifact;
    }

    private int isolateCombatDamage(String token) {
        token = token.replaceAll("COMBAT - Increases damage by ", "");
        token = token.replaceAll(" points.", "");
        return Integer.parseInt(token);
    }

    private int isolateSkillBonus(String token, String type) {
        token = token.replaceAll("Increases " + type + " Rank by ", "");
        token = token.replace(".", "");
        return Integer.parseInt(token);
    }
}
