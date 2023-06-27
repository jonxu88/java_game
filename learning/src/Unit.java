abstract class Unit {
    public final String name;
    public final Integer maxHitPoints;
    public final Integer initialAttackDamage;
    private Integer currentHitPoints;
    private Integer currentAttackDamage;
    private Boolean isCharging = false;

    public static final int CHARGE_FACTOR = 2;


    // what is the current move?
    public enum TurnChoice {
        ATTACK,
        CHARGE
    }
    private TurnChoice currentTurnChoice;


    // constructor
    public Unit(String name,
                Integer initialAttackDamage,
                Integer maxHitPoints) {
        this.name = name;
        this.initialAttackDamage = initialAttackDamage;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = maxHitPoints;
        this.currentAttackDamage = initialAttackDamage;
    }

    // setters
    public void setIsCharging(Boolean isCharging) {this.isCharging = isCharging; }
    public void setCurrentAttackDamage(Integer currentAttackDamage) {
        this.currentAttackDamage = currentAttackDamage;
    }
    public void setCurrentTurnChoice(TurnChoice currentTurnChoice) {
        this.currentTurnChoice = currentTurnChoice;
        String turnInfo = String.format("%s has chosen %s", this.name, this.currentTurnChoice);
        System.out.println(turnInfo);
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

}
