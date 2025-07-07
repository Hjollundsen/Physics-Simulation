package my.particleSim;

import java.util.*;
import java.awt.*;

public class Particle {
    //Coordinates
    private double x;
    private double y;
    private double z;
    //Velocities
    private double vX = 0.0;
    private double vY = 0.0;
    private double vZ = 0.0;
    //Accelerations
    private double aX = 0.0;
    private double aY = 0.0;
    private double aZ = 0.0;
    //misc
    private final int size = 15;
    private Color col;

    public Particle(double x, double y, double z) {
        //Temporary sets for the Coordinates
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void updateParticle(double dt) {
        //Positional update
        double newX = x + vX * dt + 0.5 * aX * dt * dt; //xNew = xOld + (veolcity * dt) + 1/2 * (acceleration * dt^2)
        double newY = y + vY * dt + 0.5 * aY * dt * dt; //yNew = yOld + (veolcity * dt) + 1/2 * (acceleration * dt^2)
        double newZ = z + vZ * dt + 0.5 * aZ * dt * dt; //zNew = zOld + (veolcity * dt) + 1/2 * (acceleration * dt^2)
        setCoordinates(newX, newY, newZ);
        //Calculate Accelerations
        double newAX = 0;
        double newAY = 9.81;
        double newAZ = 0;
        //Calculate Velocities
        double newVX = vX + 0.5 * (aX + newAX) * dt; //vNew = vOld + 1/2 * (aOld + aNew) * dt
        double newVY = vY + 0.5 * (aY + newAY) * dt; //vNew = vOld + 1/2 * (aOld + aNew) * dt
        double newVZ = vZ + 0.5 * (aZ + newAZ) * dt; //vNew = vOld + 1/2 * (aOld + aNew) * dt
        setVelocities(newVX, newVY, newVZ);

        //Collosion with walls
        if(x < 0) {
            x = 0;
            vX = -vX * 0.75;
        }
        else if(x > 800) {
            x = 800;
            vX = -vX * 0.75;
        }
        if(y < 0) {
            y = 0;
            vY = -vY * 0.75;
        }
        else if(y > 600) {
            y = 600;
            vY = -vY * 0.75;
        }
    }

    /**
     * Getter and setter methods
     */
    public int getXCoordinate() {
        
        return (int)Math.round(x);
    }

    public int getYCoordinate() {
        return (int)Math.round(y);
    }

    public int getZCoordinate() {
        return (int)Math.round(z);
    }

    public int getSize() {
        return size;
    }

    public void setCoordinates(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setVelocities(double vX, double vY, double vZ) {
        this.vX = vX;
        this.vY = vY;
        this.vZ = vZ;
    }

    public void setAccelerations(double aX, double aY, double aZ) {
        this.aX = aX;
        this.aY = aY;
        this.aZ = aZ;
    }

    public Color getColor() {
        return col;
    }

    public double getXVelocity() {
        return vX;
    }

    public double getYVelocity() {
        return vY;
    }

    public double getZVelocity() {
        return vZ;
    }
}
