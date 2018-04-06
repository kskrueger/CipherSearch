package multiGlyph.position;

public class PositionTracking {

    private int xOffset = 1000;
    private int yOffset = 1000;

    private int prevX = 0;
    int prevY = 0;
    private int prevHeading = 0;

    private int xPositionAbs = 0;
    private int yPositionAbs = 0;

    public PositionTracking () {

    }

    public void position (int xInput, int yInput, int heading) {
        double angleDelta = heading - prevHeading;
        prevHeading = heading;

        int xDelta = xInput - prevX;
        prevX = xInput;

        int yDelta = yInput - prevY;
        prevY = yInput;

        double strafe = xDelta - (xOffset*angleDelta/360);
        double forwrd = yDelta - (yOffset*angleDelta/360);

        double gyro_radians = heading * Math.PI/180;
        double temp = forwrd * Math.cos(gyro_radians) +
                strafe * Math.sin(gyro_radians);
        strafe = -forwrd * Math.sin(gyro_radians) +
                strafe * Math.cos(gyro_radians);
        forwrd = temp;

        yPositionAbs = (int)forwrd;
        xPositionAbs = (int)strafe;
    }

    public int xPosition() {
        return xPositionAbs;
    }

    public int yPosition() {
        return yPositionAbs;
    }

}
