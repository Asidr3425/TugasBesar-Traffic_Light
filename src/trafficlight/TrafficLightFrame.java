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

    /**
     * TODO:
     * Add a timer here (javax.swing.Timer) to change the traffic light state every
     * 5 seconds and call panel.setTrafficLightState(...). Order: RED -> YELLOW ->
     * GREEN -> RED
     */
  }

  public TrafficLightPanel getTrafficLightPanel() {
    return panel;
  }
}