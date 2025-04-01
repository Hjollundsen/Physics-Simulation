package my.particleSim;

public class Particle {
    //Spacial values
    private int xCoordinate;
    private int yCoordinate;

    //Movement
    private int xVelocity = 0;
    private int yVelocity = 0;

    //misc
    private int size = 10;
    //Color values:
    private int colRED = 255;
    private int colGREEN = 0;
    private int colBLUE = 0;

    public Particle(int x, int y) {
        //Temporary sets for the Coordinates
        xCoordinate = x;
        yCoordinate = y;
    }

    public void updateParticle() {
        int newXCoordinate = getXCoordinate() + getXVelocity();
        int newYCoordinate = getYCoordinate() + getYVelocity();
        setCoordinates(newXCoordinate, newYCoordinate);
        int newXVelocity = getXVelocity(); //Implement datastructure to keep track of forces
        int newYVelocity = getYVelocity() + 1; //Gravity
        setXVelocity(newXVelocity);
        setYVelocity(newYVelocity);
        // Bounce off edges
        if (getXCoordinate() < 0 || getXCoordinate() > 800) { //800 = framewidth
            setXVelocity(getXVelocity() * -1);
        }
        if (getYCoordinate() < 0 || getYCoordinate() > 600) {//600 = frameheight 
            setYVelocity(getYVelocity() * -1);
        }
        
    }

    /**
     * Getter and setter methods
     */

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public int getSize() {
        return size;
    }

    public void setXVelocity(int x) {
        xVelocity = x;
    }

    public void setYVelocity(int y) {
        yVelocity = y;
    }

    public int getXVelocity() {
        return xVelocity;
    }

    public int getYVelocity() {
        return yVelocity;
    }

    public void setCoordinates(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }
}
