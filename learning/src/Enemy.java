class Enemy extends Unit {
    public Enemy(String name,
                 Integer currentHitPoints,
                 Integer attackDamage,
                 Integer maxHitPoints) {
        super(name, currentHitPoints, attackDamage, maxHitPoints);
    }
    @Override
    public void bark() {
        System.out.println("I am the enemy!");
    }
}
