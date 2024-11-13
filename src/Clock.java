public interface Clock {
    public void tickUp(int tickAmount);
    public void tickDown(int tickAmount);
    public int clockStatus();
    public boolean isFull();
    public void clearClock();
    public int thresholdNum();
}
