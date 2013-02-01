package pixelmon.battles.attacks.statusEffects;

import java.util.ArrayList;

import pixelmon.battles.attacks.Attack;
import pixelmon.comm.ChatHandler;
import pixelmon.entities.pixelmon.EntityPixelmon;

public class WaitAfter extends StatusEffectBase {

	private int numTurns;

	public WaitAfter(int value) {
		super(StatusEffectType.WaitAfter, false, true, false);
		numTurns = value;
	}

	@Override
	public void ApplyEffect(EntityPixelmon user, EntityPixelmon target, ArrayList<String> attackList) throws Exception {
		user.battleVariables.set(type, 0);
		user.status.add(this);
	}

	@Override
	public boolean canAttackThisTurn(EntityPixelmon user, EntityPixelmon target) throws Exception {
		ChatHandler.sendBattleMessage(user.getOwner(), target.getOwner(), user.getName() + " is recharging!");
		return false;
	}

	@Override
	public double adjustDamage(Attack a, double damage, EntityPixelmon user, EntityPixelmon target, double crit) {
		return 0;
	}

	@Override
	public void turnTick(EntityPixelmon user, EntityPixelmon target) throws Exception {
		user.battleVariables.increment(type);
		if (user.battleVariables.get(type) == numTurns)
			user.status.remove(this);
	}

}
