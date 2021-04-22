package me.landervanlaer.math;

import me.landervanlaer.objects.Drawable;
import me.landervanlaer.objects.Updatable;

import java.text.MessageFormat;

/**
 * A {@link Drawable} {@link Object} that has a position, velocity and acceleration.
 * It represents an Object that can move
 *
 * @author Lander Van laer
 * @version 1.0 2021/01/5
 */
abstract public class Mover implements Drawable, Updatable {
    /**
     * <strong>Position</strong>
     * <p>
     * The current position of the {@link Mover} Object
     *
     * @see #getPos()
     * @see #setPos(Coordinate)
     */
    private Coordinate pos;

    /**
     * <strong>Velocity</strong>
     * <p>
     * The current velocity of the {@link Mover} Object.
     * <p>
     * The velocity {@link Vector} represents the speed at which the {@link #pos} of the object changes.
     * The magnitude of a velocity vector indicates the speed of a object,
     * while the Vectors {@link Angle} indicates the direction.
     *
     * @see #getVel()
     * @see #setVel(Vector)
     * @see Vector#getAngle()
     * @see Vector#getMag()
     */
    private Vector vel;

    /**
     * <strong>Acceleration</strong>
     * <p>
     * The Acceleration of an {@link Object} is the change
     * in its {@link #vel} over a certain period of time,
     * or the Velocity at which the speed increases.
     *
     * @see #getAcc()
     * @see #setAcc(Vector)
     */
    private Vector acc;

    /**
     * Defines the mass of the {@link Object} itself.
     * <p>
     * When applying a {@link Vector} to the {@link Mover},
     * the Vector will be divided by the mass and then added.
     *
     * @see #getMass()
     * @see #setMass(double)
     * @see #applyForce(Vector)
     */
    private double mass;

    /**
     * Defines a new {@link Mover} Object, with a given position, mass and velocity of {@code zero}.
     *
     * @param pos  {@link #pos}, The current position of the Object
     * @param mass {@link #mass}, The mass of the Object
     * @see #Mover(Coordinate, Vector, double)
     */
    public Mover(Coordinate pos, double mass) {
        this(pos, new Vector(), mass);
    }

    /**
     * Defines a new {@link Mover} Object, with a given position, mass and velocity.
     *
     * @param pos  {@link #pos}, The current position of the Object
     * @param vel  {@link #vel}, The current velocity that the Object has
     * @param mass {@link #mass}, The mass of the Object
     * @see #Mover(Coordinate, double)
     */
    public Mover(Coordinate pos, Vector vel, double mass) {
        this.pos = pos;
        this.vel = vel;
        this.mass = mass;
        this.acc = new Vector();
    }

    /**
     * The {@link #acc} will be added to the {@link #vel}, while the @code vel} will be added to the current {@link #pos}.
     * <pre>
     *     add acc to vel
     *     add vel to current pos
     *     set acc = empty {@link Vector};
     * </pre>
     *
     * @see Coordinate#add(Vector)
     */
    public void update() {
        getVel().add(getAcc());
        getPos().add(getVel());
        getAcc().zero();
    }

    /**
     * Adds the force to the {@link #acc} by first dividing it by the {@link #mass}
     *
     * @param force The force you want to add to the {@link #acc}
     * @see #mass
     */
    public void applyForce(Vector force) {
        getAcc().add(Vector.div(force, getMass()));
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getPos().hashCode();
        result = 31 * result + getVel().hashCode();
        result = 31 * result + getAcc().hashCode();
        temp = Double.doubleToLongBits(getMass());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Mover)) return false;

        Mover mover = (Mover) o;

        if(Double.compare(mover.getMass(), getMass()) != 0) return false;
        if(!getPos().equals(mover.getPos())) return false;
        if(!getVel().equals(mover.getVel())) return false;
        return getAcc().equals(mover.getAcc());
    }

    @Override
    public String toString() {
        return MessageFormat.format("Mover'{'pos={0}, vel={1}, acc={2}, mass={3}'}'", pos.toString(), vel.toString(), acc.toString(), mass);
    }

    // GETTERS AND SETTERS
    public Coordinate getPos() {
        return pos;
    }

    public void setPos(Coordinate pos) {
        this.pos = pos;
    }

    public Vector getVel() {
        return vel;
    }

    public void setVel(Vector vel) {
        this.vel = vel;
    }

    public Vector getAcc() {
        return acc;
    }

    public void setAcc(Vector acc) {
        this.acc = acc;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
