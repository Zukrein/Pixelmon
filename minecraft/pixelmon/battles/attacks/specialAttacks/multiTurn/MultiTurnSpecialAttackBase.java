package pixelmon.battles.attacks.specialAttacks.multiTurn;

import java.util.ArrayList;

import pixelmon.battles.attacks.Attack;
import pixelmon.battles.attacks.EffectBase;
import pixelmon.battles.attacks.Value;
import pixelmon.entities.pixelmon.EntityPixelmon;

public abstract class MultiTurnSpecialAttackBase extends EffectBase {

	public int getTurnCount(EntityPixelmon user) {
		return user.battleVariables.get(getClass());
	}

	public void decrementTurnCount(EntityPixelmon user) {
		user.battleVariables.decrement(getClass());
	}

	public void setTurnCount(EntityPixelmon user, int value) {
		user.battleVariables.set(getClass(), 0);
	}

	@Override
	public boolean doesPersist(EntityPixelmon user) {
		return user.battleVariables.getBoolean(getClass());
	}

	protected void setPersists(EntityPixelmon user, boolean value) {
		user.battleVariables.setBoolean(getClass(), value);
	}

	public MultiTurnSpecialAttackBase(Value... values) {
		super(ApplyStage.During, true);
	}

	public abstract boolean ApplyEffect(EntityPixelmon user, EntityPixelmon target, Attack a, ArrayList<String> attackList, ArrayList<String> targetAttackList) throws Exception;

	@Override
	public void ApplyEffect(EntityPixelmon user, EntityPixelmon target, ArrayList<String> attackList) {
	}

	public abstract boolean cantMiss(EntityPixelmon user) throws Exception;
}