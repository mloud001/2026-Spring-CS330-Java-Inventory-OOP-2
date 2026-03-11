package edu.odu.cs.cs330.items;

import java.util.Scanner;

/**
 * This class represents one tool--as found in most video games. This includes
 * pickaxes and shovels.
 *
 * Tools may not be stacked. All Constructors must initialize Item::stackable
 * to false.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.ShortClassName",
})
public class Tool extends Equippable {
    /**
     * Base operation (e.g., harvest/mine) speed.
     */
    protected int speed;

    /**
     * Default to an unstackable tool with an empty name, zero durability, zero
     * speed, an empty material name, no modifier, and a modifier level of 1.
     */
    public Tool()
    {
        super();

        this.speed = 0;
    }

    /**
     * Duplicate a Tool.
     *
     * @param src Tool to duplicate
     */
    public Tool(Tool src)
    {
        super();

        this.setName(src.name);

        // Complete this function
        this.setMaterial(src.material);
        this.setDurability(src.durability);
        this.setSpeed(src.speed);
        this.setModifier(src.modifier);
        this.setModifierLevel(src.modifierLevel);

    }

    /**
     * Retrieve tool speed.
     *
     * @return how quickly a tool operates
     */
    public int getSpeed()
    {
        return this.speed;
    }

    /**
     * Set tool speed.
     *
     * @param spd new speed
     */
    public void setSpeed(int spd)
    {
        this.speed = spd;
    }

    @Override
    public boolean isStackable()
    {
        return false;
    }

    /**
     * Read tool attributes.
     */
    @Override
    public void read(Scanner snr)
    {
        super.name = snr.next();
        super.material = snr.next();

        // Complete this function
        //Tool Axe Stone 10 2 Unbreaking 2
        super.durability = snr.nextInt();
        this.speed = snr.nextInt();
        super.modifier = snr.next();
        super.modifierLevel = snr.nextInt();
        
    }

    /**
     * Clone--i.e., copy--this Tool.
     */
    @Override
    public Item clone()
    {
        Tool cpy = new Tool();

        cpy.setName(this.name);
        cpy.setMaterial(this.material);
        cpy.setDurability(this.durability);
        cpy.setSpeed(this.speed);
        cpy.setModifier(this.modifier);
        cpy.setModifierLevel(this.modifierLevel);

        // Complete this function

        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, and modifier.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Tool)) {
            return false;
        }

        Tool rhsItem = (Tool) rhs;

        // Complete this function
        return super.getName().equals(rhsItem.name)
        && this.getMaterial().equals(rhsItem.material)
        && this.getModifier().equals(rhsItem.modifier);
    }

    /**
     * Generate a hash code by adding the name, material, and modifier hash
     * codes.
     */
    @Override
    public int hashCode()
    {
        // Complete this function
        return this.name.hashCode()
        + this.material.hashCode()
        + this.modifier.hashCode();
    }

    /**
     * *Print* a Tool.
     */
    @Override
    public String toString()
    {
        // This is a free implementation of toString... use it as a hint for
        // Armour and Consumable
        return String.join(
            System.lineSeparator(),
            String.format("  Nme: %s", super.getName()),
            String.format("  Dur: %s", this.getDurability()),
            String.format("  Spd: %d", this.getSpeed()),
            String.format("  Mtl: %s", this.getMaterial()),
            String.format("  Mdr: %s (Lvl %d)", this.getModifier(), this.getModifierLevel()),
            ""
        );
    }
}
