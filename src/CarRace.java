import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;


public class CarRace {
    public static Map<String, Integer> finishTimes = new LinkedHashMap<>();

    public static void restartRace(JFrame frame) {
        finishTimes.clear();

        CarPanel carPanel = new CarPanel();
        SemaphorePanel semaphorePanel = new SemaphorePanel();

        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(2, 1));
        frame.add(semaphorePanel);
        frame.add(carPanel);
        frame.revalidate();
        frame.repaint();

      try{
                SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
                semaphoreThread.start();
                semaphoreThread.join();

                // PLAY SOUND
                PlaySound sound = new PlaySound();
                sound.playSound();

                // START CAR THREADS
                Car car1 = new Car("Red car", carPanel);
                Car car2 = new Car("Blue car", carPanel);
                Car car3 = new Car("Green car", carPanel);
                Car car4 = new Car("Yellow car", carPanel);

                car1.start();
                car2.start();
                car3.start();
                car4.start();

                car1.join();
                car2.join();
                car3.join();
                car4.join();

                sound.stopSound();

                var winnerEntry = finishTimes.entrySet().stream()
                        .min(Map.Entry.comparingByValue())
                        .orElse(null);

                if (winnerEntry != null) {
                    GameOverDialog.show(winnerEntry.getKey(), winnerEntry.getValue(), () -> restartRace(frame));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Car Race");
        frame.setLayout(new GridLayout(2, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();
        SemaphorePanel semaphorePanel = new SemaphorePanel();
        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        frame.getContentPane().add(semaphorePanel);
        frame.getContentPane().add(carPanel);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
        semaphoreThread.start();
        semaphoreThread.join();
        PlaySound sound = new PlaySound();
        Car car1 = new Car("Red car", carPanel);
        Car car2 = new Car("Blue car", carPanel);
        Car car3 = new Car("Green car", carPanel);
        Car car4 = new Car("Yellow car", carPanel);
        sound.playSound();
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car1.join();
        car2.join();
        car3.join();
        car4.join();
        sound.stopSound();
        System.out.println("\n=== FINISH ORDER ===");
        finishTimes.forEach((name, time) -> System.out.println(name + " - Time: " + time));
        var winnerEntry = finishTimes.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElse(null);

        if (winnerEntry != null) {
            GameOverDialog.show(winnerEntry.getKey(), winnerEntry.getValue(), () -> restartRace(frame));
        } else {
            JOptionPane.showMessageDialog(null, "No cars finished the race.", "Game Over", JOptionPane.WARNING_MESSAGE);
        }

    }

}




