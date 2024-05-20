package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.commonplayer.TargetSPI;

public class PlayerTargetSystem implements TargetSPI {

    private static volatile double x, y = 0;

    @Override
    public double getTargetX() {
        return x;
    }

    @Override
    public double getTargetY() {
        return y;
    }

    public static void updatePlayerPosition(double updatedX, double updatedY) {
        x = updatedX;
        y = updatedY;
    }
}
