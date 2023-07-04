// import org.javatuples.Tuple;

public class TurnResolver {
    private Unit unitOne;
    private Unit unitTwo;

    // constructor
    public TurnResolver(Unit unitOne, Unit unitTwo) {
        this.unitOne = unitOne;
        this.unitTwo = unitTwo;
    }

    // getter and setter
    public Unit getUnitOne() {
        return unitOne;
    }

    public void setUnitOne(Unit unitOne) {
        this.unitOne = unitOne;
    }

    public Unit getUnitTwo() {
        return unitTwo;
    }

    public void setUnitTwo(Unit unitTwo) {
        this.unitTwo = unitTwo;
    }

    // TODO: Maybe use tuples?
    // resolve turn
    public static void resolveTurn(Unit unitOne, Unit unitTwo) {
        String combinedTurnChoice = unitOne.getCurrentTurnChoice() + "_" + unitTwo.getCurrentTurnChoice();
        switch (combinedTurnChoice) {
            case "CHARGE_CHARGE" -> {
                unitOne.setIsCharging(true);
                unitOne.setCurrentAttackDamage(unitOne.getCurrentAttackDamage() * unitOne.CHARGE_FACTOR);
                unitTwo.setIsCharging(true);
                unitTwo.setCurrentAttackDamage(unitTwo.getCurrentAttackDamage() * unitTwo.CHARGE_FACTOR);
                System.out.println("Both players are charging...");
            }
            case "CHARGE_ATTACK" -> {
                unitTwo.attack(unitOne);
                unitOne.setIsCharging(false);
                unitOne.setCurrentAttackDamage(unitOne.initialAttackDamage);
                String outString = String.format("%s attacks, %s is charging so the charge is broken!", unitTwo.getName(), unitOne.getName());
                System.out.println(outString);
            }
            case "CHARGE_DEFEND" -> {
                unitOne.setIsCharging(true);
                unitOne.setCurrentAttackDamage(unitOne.getCurrentAttackDamage() * unitOne.CHARGE_FACTOR);
                String outString = String.format("%s charges, %s defends...",
                        unitOne.getName(), unitTwo.getName());
                System.out.println(outString);
            }
            case "ATTACK_CHARGE" -> resolveTurn(unitTwo, unitOne);
            case "ATTACK_ATTACK" -> {
                unitOne.attack(unitTwo);
                unitTwo.attack(unitOne);
                unitOne.setIsCharging(false);
                unitOne.setCurrentAttackDamage(unitOne.initialAttackDamage);
                unitTwo.setIsCharging(false);
                unitTwo.setCurrentAttackDamage(unitTwo.initialAttackDamage);
                String outString = String.format("%s and %s attack each other!",
                        unitOne.getName(), unitTwo.getName());
                System.out.println(outString);
            }
            case "ATTACK_DEFEND" -> {
                unitTwo.setIsDefending(true);
                unitOne.attack(unitTwo);
                unitTwo.setIsDefending(false);
                String outString = String.format("%s attacks and %s defends!",
                        unitOne.getName(), unitTwo.getName());
                System.out.println(outString);
            }
            case "DEFEND_ATTACK" -> resolveTurn(unitTwo, unitOne);
            case "DEFEND_CHARGE" -> resolveTurn(unitTwo, unitOne);
            case "DEFEND_DEFEND" -> {
                String outString = String.format("%s and %s both choose defend, how boring...",
                        unitOne.getName(), unitTwo.getName());
                System.out.println(outString);
            }
        }
    }
}
