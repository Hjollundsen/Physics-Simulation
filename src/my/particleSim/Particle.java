package my.particleSim;

public class Particle {
    //Spacial values
    private double xCoordinate;
    private double yCoordinate;

    //Movement
    private double xVelocity = 0.0;
    private double yVelocity = 0.0;

    //misc
    private int size = 10;
    //Color values:
    private int colRED = 255;
    private int colGREEN = 0;
    private int colBLUE = 0;

    public Particle(double x, double y) {
        //Temporary sets for the Coordinates
        xCoordinate = x;
        yCoordinate = y;
    }

    public void updateParticle() {
        double newXCoordinate = getXCoordinate() + getXVelocity();
        double newYCoordinate = getYCoordinate() + getYVelocity();
        setCoordinates(newXCoordinate, newYCoordinate);
        double newXVelocity = getXVelocity(); //Implement datastructure to keep track of forces
        double newYVelocity = getYVelocity() + 0.1; //Gravity
        setXVelocity(newXVelocity);
        setYVelocity(newYVelocity);
        // Bounce off edges
        if (getXCoordinate() < 10) { //800 = framewidth
            setCoordinates(10.0, getYCoordinate());
            setXVelocity((getXVelocity() * 0.25) * -1);
        }
        if (getXCoordinate() > 790) {
            setCoordinates(790.0, getYCoordinate());
            setXVelocity((getXVelocity() * 0.25 ) * -1);
        }

        if (getYCoordinate() < 10) {//600 = frameheight 
            setCoordinates(getXCoordinate(), 10.0);
            setYVelocity((getYVelocity() / 2) * -1);
        }
        if (getYCoordinate() > 590) {
            setCoordinates(getXCoordinate(), 590.0);
            setYVelocity((getYVelocity() / 2) * -1);
        }
        
    }

    /**
     * Getter and setter methods
     */

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public int getSize() {
        return size;
    }

    public void setXVelocity(double x) {
        xVelocity = x;
    }

    public void setYVelocity(double y) {
        yVelocity = y;
    }

    public double getXVelocity() {
        return xVelocity;
    }

    public double getYVelocity() {
        return yVelocity;
    }

    public void setCoordinates(double x, double y) {
        xCoordinate = x;
        yCoordinate = y;
    }
}
