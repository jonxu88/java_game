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

    // resolve turn
    public static void resolveTurn(Unit unitOne, Unit unitTwo) {
        switch (unitOne.getCurrentTurnChoice()) {
            case NEUTRAL -> {
                switch (unitTwo.getCurrentTurnChoice()) {
                    case NEUTRAL -> System.out.println("Nothing happened!");
                    case ATTACK -> {
                        unitTwo.attack(unitOne);
                        String outString = String.format("%s attacks %s", unitTwo.getName(), unitOne.getName());
                        System.out.println(outString);
                    }
                }
            }
            case ATTACK -> {
                switch (unitTwo.getCurrentTurnChoice()) {
                    case NEUTRAL -> {
                        unitOne.attack(unitTwo);
                        String outString = String.format("%s attacks %s", unitOne.getName(), unitTwo.getName());
                        System.out.println(outString);
                    }
                    case ATTACK -> {
                        unitOne.attack(unitTwo);
                        unitTwo.attack(unitOne);
                        String outString_mutual = String.format("%s and %s attack each other!",
                                unitOne.getName(), unitTwo.getName());
                        System.out.println(outString_mutual);
                    }
                }
            }
        }
    }
}
