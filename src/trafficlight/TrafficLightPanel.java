package trafficlight;

import javax.swing.*;
import java.awt.*;

public class TrafficLightPanel extends JPanel {
  private TrafficLightState currentState = TrafficLightState.RED;

  public TrafficLightPanel() {
    setPreferredSize(new Dimension(200, 400));
    setBackground(Color.DARK_GRAY);

    /**
     * TODO:
     * create timer logic outside of the panel here
     * use setTrafficLightState(...) every 5 seconds
     */
  }

  /**
   * * This method is called from outside for change the traffic light state
   * * Use this inside the timer to switch between states RED -> YELLOW -> GREEN
   */
  public void setTrafficLightState(TrafficLightState state) {
    this.currentState = state;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Size of circle's position
    int diameter = 60;
    int spacing = 30;
    int x = (getWidth() - diameter) / 2;
    int y = 50;

    // Red light
    g.setColor(currentState == TrafficLightState.RED ? Color.RED : Color.DARK_GRAY);
    g.fillOval(x, y, diameter, diameter);

    // Yellow light
    g.setColor(currentState == TrafficLightState.YELLOW ? Color.YELLOW : Color.DARK_GRAY);
    g.fillOval(x, y, diameter, diameter);

    // Green Light
    y += diameter + spacing;
    g.setColor(currentState == TrafficLightState.GREEN ? Color.GREEN : Color.GRAY);
    g.fillOval(x, y, diameter, diameter);
  }
}