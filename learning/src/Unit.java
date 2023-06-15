abstract class Unit {
    private String name;
    private Integer maxHitPoints;
    private Integer currentHitPoints;
    private Integer attackDamage;

    // what is the current move?
    public enum State {
        ATTACK,
        NEUTRAL
    }
    private State currentState = State.NEUTRAL;
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    // constructor
    public Unit(String name,
                Integer currentHitPoints,
                Integer attackDamage,
                Integer maxHitPoints) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = currentHitPoints;
        this.attackDamage = attackDamage;
    }

    // setter
    public void setAttackDamage(Integer attackDamage) {
        this.attackDamage = attackDamage;
    }

    // getters
    public String getName() { return name; }
    public Integer getMaxHitPoints() {
        return maxHitPoints;
    }
    public Integer getCurrentHitPoints() {
        return currentHitPoints;
    }
    public Integer getAttackDamage() {
        return attackDamage;
    }
    public State getCurrentState() { return currentState; }


    public abstract void bark();

    public String unitInfo() {
        String unitInfo = String.format("Name: %s, MaxHP: %d, CurrentHP: %d, AttackDamage: %d",
                name, maxHitPoints, currentHitPoints, attackDamage);
        return unitInfo;
    }

    public void disableAttack() {setAttackDamage(0);}

    public void attack(Unit unit) {
        unit.currentHitPoints -= this.attackDamage;
    }

    // add defend mode which halves the damage
    // two possible actions: attack and defend (defend means damage received is 0)
    // add enemy actions: just do a random action for now
    // future: charge attack (2x damage, but charge is gone if attacked!)
}
