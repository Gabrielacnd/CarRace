public class Car extends Thread{
    private String name;
    private int distance = 0;
    private CarPanel carPanel;
    private int time=0;

    public Car(String name, CarPanel carPanel) {
        //set thread name;
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
    }

    public void run() {
        while (distance < 520) {
            // simulate the car moving at a random speed
            int speed = (int) (Math.random() * 10) + 1;
            distance += speed;

            carPanel.updateCarPosition(name, distance);

            try {

                // pause for a moment to simulate the passage of time
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;
        }

        carPanel.carFinished(name);
        CarRace.finishTimes.put(name, time);
        System.out.println(Thread.currentThread().getName());
    }
    public int getTime(){
        return this.time;
    }
}
