import javax.swing.*;
import java.awt.*;

public class GameOverDialog {

    public static void show(String winnerName, int time, Runnable onReplay) {
        JFrame dialog = new JFrame("🏁 Game Over");
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(400, 220);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());

        JLabel title = new JLabel("🏆 WINNER!", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(new Color(0, 102, 204));

        JLabel winnerLabel = new JLabel("🚗 " + winnerName + " finished in " + time + " seconds", SwingConstants.CENTER);
        winnerLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        winnerLabel.setForeground(Color.DARK_GRAY);

        JPanel buttonPanel = new JPanel();
        JButton closeButton = new JButton("Close");
        JButton replayButton = new JButton("Replay");

        closeButton.addActionListener(e -> dialog.dispose());
        replayButton.addActionListener(e -> {
            dialog.dispose();   // Închide fereastra
            onReplay.run();     // Apelează logica de replay
        });

        buttonPanel.add(replayButton);
        buttonPanel.add(closeButton);

        dialog.add(title, BorderLayout.NORTH);
        dialog.add(winnerLabel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
}
