package my.particleSim;

import java.util.*;

public class ParticleSim {
    private ArrayList<Particle> particles = new ArrayList<>();

    /**
     * Constructor for the ParticleSim. For now creates an twodimensional array of particles with a given space between them. If more particles than rows*cols print "too many particles... try again"
     * If there are less particles than the twodimensional array, the rest of the array after the last particle will be empty
     * @param amount                Amount of particles to create
     * @param startingXCoordinate   XCoordinate of the upper leftmost particle
     * @param startingYCoordinate   YCoordinate of the upper leftmost particle
     * @param gridSpace             Space between the particles
     * @param rows                  Number of rows of particles
     * @param cols                  Number of columns of particles
     */
    public ParticleSim(int amount, double startingXCoordinate, double startingYCoordinate, int gridSpace, int rows, int cols) {
        if(amount > rows*cols) {
            System.out.println("Too many particles entered for number of rows and columns. Grid has been filled, and extra particles omitted.");
            return;
        }
        int particlesCreated = 0;
        for(int i=0; i < rows; i++) {
            double yCoordinate = startingYCoordinate + i*gridSpace;
            for(int j=0; j < cols; j++) {
                double xCoordinate = startingXCoordinate + j*gridSpace;
                if(particlesCreated < amount) {
                    Particle p = new Particle(xCoordinate, yCoordinate);
                    particles.add(p);
                    particlesCreated++;
                }
            }
        }
    }

    /**
     * Method for detecting and handling collisions between particles
     */
    public void collisionHandling() {
        for(int i=0; i < particles.size(); i++) {
            for(int j=i+1; j < particles.size(); j++) {
                double distance = Math.sqrt(((particles.get(i).getXCoordinate() - particles.get(j).getXCoordinate()) * (particles.get(i).getXCoordinate() - particles.get(j).getXCoordinate()))
                                          + ((particles.get(i).getYCoordinate() - particles.get(j).getYCoordinate()) * (particles.get(i).getYCoordinate() - particles.get(j).getYCoordinate())));
            if(distance < particles.get(i).getSize() + particles.get(j).getSize()) {
                //Collision detected. Update particles velocities accordingly
                //First we calculate the relative velocities:
                double deltaVx = particles.get(i).getXVelocity() - particles.get(j).getXVelocity();
                double deltaVy = particles.get(i).getYVelocity() - particles.get(j).getYVelocity();
                //Then we calculate the difference in position:
                double deltaX = particles.get(i).getXCoordinate() - particles.get(j).getXCoordinate();
                double deltaY = particles.get(i).getYCoordinate() - particles.get(j).getYCoordinate();
                //Then we calculate the dot product of the velocity difference and the position difference
                double vDot = deltaVx * deltaX + deltaVy * deltaY;
                double distanceSquared = deltaX * deltaX + deltaY * deltaY;
                //Now using the above calculated values we use the elastic collision formula
                particles.get(i).setXVelocity(particles.get(i).getXVelocity() - (2 * vDot * deltaX) / distanceSquared);
                particles.get(i).setYVelocity(particles.get(i).getYVelocity() - (2 * vDot * deltaY) / distanceSquared);
                particles.get(i).setXVelocity(particles.get(j).getXVelocity() - (2 * vDot * deltaX) / distanceSquared);
                particles.get(i).setYVelocity(particles.get(j).getYVelocity() - (2 * vDot * deltaY) / distanceSquared);
            }
            }
        }
        
    }

    /**
     * This method updates all particles in the ArrayList.
     */
    public void updateParticles() {
        for(Particle p : particles) {
            p.updateParticle();
        }
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }
}
