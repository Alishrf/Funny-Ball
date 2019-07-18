public class Ball implements Cloneable {
    private double accelerationY;
    private double accelerationX;
    private double velocityY;
    private double velocityX;
    private double currentX;
    private double currentY;
    private double time;
    private double timeConstant;

    public Ball(double accelerationY, double accelerationX, double velocityY, double velocityX, double currentX, double currentY, double timeConstant) {
        this.accelerationY = accelerationY;
        this.accelerationX = accelerationX;
        this.velocityY = velocityY;
        this.velocityX = velocityX;
        this.currentX = currentX;
        this.currentY = currentY;
        this.timeConstant = timeConstant;
    }

    public double nextY(){
        time +=timeConstant;
        currentY = ((0.5) * accelerationY * (time)*(time))+ currentY + (velocityY *time);
        return currentY;
    }
    public double nextX(){
        currentX = ((0.5) * accelerationX * (time)*(time))+ currentX + (velocityX *time);
        return currentX;
    }
    public double getVelocityYNow(){
        return accelerationY *time + velocityY ;
    }
    public double getVelocityXNow(){
        return accelerationX *time + velocityX ;
    }


    public void setTime(double time) {
        this.time = time;
    }


    public double getCurrentX() {
        return currentX;
    }

    public double getCurrentY() {
        return currentY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public void setCurrentX(double currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(double currentY) {
        this.currentY = currentY;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Ball ball = new Ball(accelerationY,accelerationX,velocityY,velocityX,currentX,currentY,timeConstant);
        ball.setTime(time);
        return ball;
    }
}
