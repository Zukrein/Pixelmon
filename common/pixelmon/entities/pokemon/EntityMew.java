package pixelmon.entities.pokemon;

import pixelmon.entities.pixelmon.EntityPixelmon;
import net.minecraft.src.World;

public class EntityMew extends EntityPixelmon
{
	
	public EntityMew(World world)
	{
		super(world);
		init();
	}

	public void init()
	{
		super.init("Mew");
	}
}
