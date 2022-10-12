public enum AttackCommand {
    NO_WEAPON_EQUIPPED("No weapon equipped"),
    NO_ENEMY("No enemy"),
    NO_ENEMY_NAME("No enemy name"),
    NO_AMMO("No ammo"),
    Succesful("Successful");

    private String value;

    AttackCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static String mapAttackCommand1(AttackCommand cmd) {
        return cmd.getValue();
    }


    public static String mapAttackCommand2(AttackCommand cmd) {
        switch (cmd) {
            case NO_WEAPON_EQUIPPED -> {
                return "No weapon equipped";
            }
            case NO_ENEMY -> {
                return "No enemy";
            }
            case NO_ENEMY_NAME -> {
                return "No enemy name";
            }
            case NO_AMMO -> {
                return "No ammo";
            }
            case Succesful -> {
                return "Successful";
            }
        }
        return null;
    }
}

