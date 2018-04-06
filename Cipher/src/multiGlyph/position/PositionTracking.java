package multiGlyph.position;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class PositionTracking {

    final private int xOffset = 1000;
    final private int yOffset = 1000;

    private int prevX = 0;
    private int prevY = 0;
    private int prevHeading = 0;

    private int xPositionAbs = 0;
    private int yPositionAbs = 0;

    private boolean positionThread = false;
    private boolean driveThread = false;

    LinearOpMode opMode;
    DcMotor xWheel, yWheel, frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor;

    public PositionTracking (LinearOpMode opMode,
                             DcMotor rightIntake, DcMotor leftIntake,
                             DcMotor frontLeftMotor, DcMotor rearLeftMotor,
                             DcMotor frontRightMotor, DcMotor rearRightMotor) {
        this.opMode = opMode;
        this.xWheel = rightIntake;
        this.yWheel = leftIntake;
        this.frontLeftMotor = frontLeftMotor;
        this.rearLeftMotor = rearLeftMotor;
        this.frontRightMotor = frontRightMotor;
        this.rearRightMotor = rearRightMotor;
    }

    public int xPosition() {
        return xPositionAbs;
    }

    public int yPosition() {
        return yPositionAbs;
    }

    public void drivePower(double forwards, double horizontal, double turning){
        //uses the orientation of the robot to offset the input powers.
        double forwrd = forwards * -1;
        double strafe = horizontal;

        double gyro_radians = heading * Math.PI/180;
        double temp = forwrd * cos(gyro_radians) + strafe * sin(gyro_radians);
        strafe = -forwrd * sin(gyro_radians) + strafe * cos(gyro_radians);
        forwrd = temp;

        robotCentric(-forwrd,strafe,turning);
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
        double temp = forwrd * cos(gyro_radians) + strafe * sin(gyro_radians);
        strafe = -forwrd * sin(gyro_radians) + strafe * cos(gyro_radians);
        forwrd = temp;

        yPositionAbs = (int)forwrd;
        xPositionAbs = (int)strafe;
    }

    public void stopTracking () {
        positionThread = false;
    }

    public void startEncoderTracking() {
        positionThread = true;
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(!opMode.isStopRequested()&&opMode.opModeIsActive()&&positionThread) {
                    position(1,1,1);
                }
            }
        }).start();
    }

    public void driveToCoordinates(int x, int y, int heading) {
        driveThread = true;
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(!opMode.isStopRequested()&&opMode.opModeIsActive()&&driveThread) {
                    xPID.
                    drivePower();
                }
            }
        }).start();
    }

}
