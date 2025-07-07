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
                    if (i%2 == 0) {
                        Particle p = new Particle(xCoordinate + 10, yCoordinate, 0); //0 is the z-coordinate not implemented yet
                        particles.add(p);
                    }
                    else {
                        Particle p = new Particle(xCoordinate, yCoordinate, 0); //0 is the z-coordinate not implemented yet
                        particles.add(p);
                    }
                    particlesCreated++;
                }
            }
        }
    }

    /*
     * Method for handling collisions
     */
    public void handleCollisions() {
        for(int i = 0; i < particles.size(); i++) {
            for(int j = i+1; j < particles.size(); j++) {
                Particle par1 = particles.get(i);
                Particle par2 = particles.get(j);
                int par1X = par1.getXCoordinate();
                int par1Y = par1.getYCoordinate();
                int par2X = par2.getXCoordinate();
                int par2Y = par2.getYCoordinate();
                if(Math.sqrt(((par1X-par2X)*(par1X-par2X))+((par1Y-par2Y)*(par1Y-par2Y))) < particles.get(j).getSize()) {
                    particles.get(i).setVelocities(-par1.getXVelocity(), -par1.getYVelocity(), 0); //0 is the z-velocity not implemented yet
                    particles.get(j).setVelocities(-par2.getXVelocity(), -par2.getYVelocity(), 0); //0 is the z-velocity not implemented yet
                }
            }
        }
    }

    /**
     * This method updates all particles in the ArrayList.
     */
    public void updateParticles() {
        for(Particle p : particles) {
            p.updateParticle(0.16);
        }
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }
}
