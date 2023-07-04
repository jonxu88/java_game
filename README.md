Main.java is at `java_game/learning/src`.

3 commands:
 - attack: attack opponent, will cause currentAttackDamage amount of damage unless opponent is defending, in which case damage 
is halved. Breaks your opponents charge unless opponent is defending.
 - charge: doubles currentAttackDamage for the next turn. If the opponent attacks while you are charging, your 
currentAttackDamage will be reset to your initialAttackDamage.
 - defend: halves any damage received. Also prevents charge from being broken. 
