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
    public ParticleSim(int amount, int startingXCoordinate, int startingYCoordinate, int gridSpace, int rows, int cols) {
        if(amount > rows*cols) {
            System.out.println("Too many particles entered for number of rows and columns. Grid has been filled, and extra particles omitted.");
            return;
        }
        int particlesCreated = 0;
        for(int i=0; i < rows; i++) {
            int yCoordinate = startingYCoordinate + i*gridSpace;
            for(int j=0; j < cols; j++) {
                int xCoordinate = startingXCoordinate + j*gridSpace;
                if(particlesCreated < amount) {
                    Particle p = new Particle(xCoordinate, yCoordinate);
                    particles.add(p);
                    particlesCreated++;
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
