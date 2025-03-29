package my.particleSim;

public class Particle {
    private int xCoordinate;
    private int yCoordinate;
    private int size = 10;

    public Particle(int x, int y) {
        //Temporary sets for the Coordinates
        xCoordinate = x;
        yCoordinate = y;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public int getSize() {
        return size;
    }
}
