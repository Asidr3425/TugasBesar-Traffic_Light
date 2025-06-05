package trafficlight;

import javax.swing.*;
import java.awt.*;

public class TrafficLightFrame extends JFrame {
  private TrafficLightPanel panel;

  public TrafficLightFrame() {
    super("Traffic Light");

    panel = new TrafficLightPanel();
    add(panel, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);

    final TrafficLightState[] states = TrafficLightState.values();
    panel.setTrafficLightState(states[0]);
    final int[] idx = { 0 };

    Timer timer = new Timer(5000, e -> {
      idx[0] = (idx[0] + 1) % states.length;
      panel.setTrafficLightState(states[idx[0]]);
    });
    timer.setInitialDelay(5000); 
    timer.start();
  }

  public TrafficLightPanel getTrafficLightPanel() {
    return panel;
  }
}
