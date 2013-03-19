package pixelmon.battles.attacks;

import java.beans.ConstructorProperties;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import pixelmon.battles.attacks.specialAttacks.attackModifiers.*;
import pixelmon.battles.attacks.specialAttacks.basic.*;
import pixelmon.battles.attacks.specialAttacks.multiTurn.*;
import pixelmon.battles.attacks.specialAttacks.statusAppliers.*;

public class EffectRegistry {
	public static HashMap<String, Class> effectMap = new HashMap<String, Class>();

	static {
		// Status Appliers
		effectMap.put("burn", ApplyBurn.class);
		effectMap.put("confusion", ApplyConfusion.class);
		effectMap.put("firespin", ApplyFireSpin.class);
		effectMap.put("flee", ApplyFlee.class);
		effectMap.put("freeze", ApplyFreeze.class);
		effectMap.put("immobilize", ApplyImmobilize.class);
		effectMap.put("infatuated", ApplyInfatuated.class);
		effectMap.put("leech", ApplyLeech.class);
		effectMap.put("lightscreen", ApplyLightScreen.class);
		effectMap.put("mist", ApplyMist.class);
		effectMap.put("paralysis", ApplyParalysis.class);
		effectMap.put("perish", ApplyPerish.class);
		effectMap.put("poison", ApplyPoison.class);
		effectMap.put("poisonbadly", ApplyPoisonBadly.class);
		effectMap.put("protect", ApplyProtect.class);
		effectMap.put("rest", ApplyRest.class);
		effectMap.put("safeguard", ApplySafeGuard.class);
		effectMap.put("sleep", ApplySleep.class);
		effectMap.put("sunny", ApplySunny.class);
		effectMap.put("trickroom", ApplyTrickRoom.class);
		effectMap.put("waitafter", ApplyWaitAfter.class);
		effectMap.put("yawn", ApplyYawn.class);

		// Attack Modifiers
		effectMap.put("alwayshit", AlwaysHit.class);
		effectMap.put("criticalhit", CriticalHit.class);
		effectMap.put("damage", Damage.class);
		effectMap.put("flinch", Flinch.class);
		effectMap.put("multiplehit", MultipleHit.class);
		effectMap.put("priority", Priority.class);
		effectMap.put("recoil", Recoil.class);

		// Basic Attacks
		effectMap.put("acrobatics", Acrobatics.class);
		effectMap.put("acupressure", Acupressure.class);
		effectMap.put("curse", Curse.class);
		effectMap.put("echoedvoice", EchoedVoice.class);
		effectMap.put("eruption", Eruption.class);
		effectMap.put("facade", Acrobatics.class);
		effectMap.put("frustration", Frustration.class);
		effectMap.put("guillotine", Guillotine.class);
		effectMap.put("gyroball", GyroBall.class);
		effectMap.put("heavyslam", HeavySlam.class);
		effectMap.put("hiddenpower", HiddenPower.class);
		effectMap.put("horndrill", HornDrill.class);
		effectMap.put("jumpkick", JumpKick.class);
		effectMap.put("magnitude", Magnitude.class);
		effectMap.put("nightshade", NightShade.class);
		effectMap.put("painsplit", PainSplit.class);
		effectMap.put("payday", PayDay.class);
		effectMap.put("psychup", PsychUp.class);
		effectMap.put("psywave", Psywave.class);
		effectMap.put("punishment", Punishment.class);
		effectMap.put("raisestats", RaiseStats.class);
		effectMap.put("restore", Restore.class);
		effectMap.put("return", Return.class);
		effectMap.put("reversal", Reversal.class);
		effectMap.put("seismictoss", SeismicToss.class);
		effectMap.put("smackdown", SmackDown.class);
		effectMap.put("venoshock", Venoshock.class);

		// Multi-Turn Attacks
		effectMap.put("bide", Bide.class);
		effectMap.put("fly", Fly.class);
		effectMap.put("petaldance", PetalDance.class);
		effectMap.put("razorwind", RazorWind.class);
		effectMap.put("solarbeam", SolarBeam.class);
	}

	public static EffectBase getEffect(String effectTypeString, Value[] values) {

		EffectBase effect = null;

		try {
			Class effectClass = (Class) effectMap.get(effectTypeString.toLowerCase());

			if (effectClass != null) {
				Constructor c = effectClass.getConstructors()[0];
				if (c.isVarArgs())
					effect = (EffectBase) effectClass.getConstructors()[0].newInstance(new Object[] { values });
				else
					effect = (EffectBase) effectClass.getConstructors()[0].newInstance(new Object[] {});
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		return effect;
	}
}