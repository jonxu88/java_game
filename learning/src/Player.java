class Player extends Unit {
    public Player(String name,
                Integer currentHitPoints,
                Integer currentAttackDamage,
                Integer maxHitPoints) {
        super(name, currentHitPoints, currentAttackDamage, maxHitPoints);
    }
    @Override
    public String bark() {
        return "I am the player!";
    }

    @Override
    public String deathMessage() {
        return String.format("The player, whose name is %s, has died...", this.getName());
    }
}
