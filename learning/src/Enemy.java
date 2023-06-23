class Enemy extends Unit {
    public Enemy(String name,
                 Integer currentHitPoints,
                 Integer currentAttackDamage,
                 Integer maxHitPoints) {
        super(name, currentHitPoints, currentAttackDamage, maxHitPoints);
    }
    @Override
    public String bark() {
        return "I am the enemy!";
    }

    @Override
    public String deathMessage() {
        return String.format("The enemy, whose name is %s, has died...", this.getName());
    }
}
