abstract class Unit {
    private String name;
    private Integer maxHitPoints;
    private Integer currentHitPoints;
    private Integer currentAttackDamage;

    // what is the current move?
    public enum TurnChoice {
        ATTACK,
        NEUTRAL
    }
    private TurnChoice currentTurnChoice = TurnChoice.NEUTRAL;
    public void setCurrentTurnChoice(TurnChoice currentTurnChoice) {
        this.currentTurnChoice = currentTurnChoice;
        String turnInfo = String.format("%s has chosen %s", this.name, this.currentTurnChoice);
        System.out.println(turnInfo);
    }

    // constructor
    public Unit(String name,
                Integer currentHitPoints,
                Integer currentAttackDamage,
                Integer maxHitPoints) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = currentHitPoints;
        this.currentAttackDamage = currentAttackDamage;
    }

    // setter
    public void setCurrentAttackDamage(Integer currentAttackDamage) {
        this.currentAttackDamage = currentAttackDamage;
    }

    // getters
    public String getName() { return name; }
    public Integer getMaxHitPoints() {
        return maxHitPoints;
    }
    public Integer getCurrentHitPoints() {
        return currentHitPoints;
    }
    public Integer getCurrentAttackDamage() {
        return currentAttackDamage;
    }
    public TurnChoice getCurrentTurnChoice() { return currentTurnChoice; }


    public abstract String bark();
    public abstract String deathMessage();

    public String unitInfo() {
        String unitInfo = String.format("Name: %s, MaxHP: %d, CurrentHP: %d, CurrentAttackDamage: %d",
                name, maxHitPoints, currentHitPoints, currentAttackDamage);
        return unitInfo;
    }

    public void disableAttack() {setCurrentAttackDamage(0);}

    public void attack(Unit unit) {
        unit.currentHitPoints -= this.currentAttackDamage;
    }

    // add defend mode which halves the damage
    // two possible actions: attack and defend (defend means damage received is 0)
    // add enemy actions: just do a random action for now
    // future: charge attack (2x damage, but charge is gone if attacked!)
}
