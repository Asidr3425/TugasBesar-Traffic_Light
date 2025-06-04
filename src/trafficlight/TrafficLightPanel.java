package trafficlight;

import javax.swing.*;
import java.awt.*;

public class TrafficLightPanel extends JPanel {
  private TrafficLightState currentState = TrafficLightState.RED;

  public TrafficLightPanel() {
    setPreferredSize(new Dimension(200, 400));
    setBackground(Color.LIGHT_GRAY);

    ActionListener changeLight = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        switch (currentState) {
          case RED:
            setTrafficLightState(TrafficLightState.YELLOW);
            break;
          case YELLOW:
            setTrafficLightState(TrafficLightState.GREEN);
            break;
          case GREEN:
            setTrafficLightState(TrafficLightState.RED);
            break;
        }
      }
    };

    Timer timer = new Timer(5000, changeLight);
    timer.setInitialDelay(5000);
    timer.start();
  }

  /**
   * * This method is called from outside for change the traffic light state
   * * Use this inside the timer to switch between states RED -> YELLOW -> GREEN
   */
  public void setTrafficLightState(TrafficLightState state) {
    this.currentState = state;
    repaint();
  }

  private void drawLight(Graphics2D g2, int x, int y, int diameter, int glowSize, TrafficLightState state,
      TrafficLightState current) {
    Color colorOn;
    switch (state) {
      case RED:
        colorOn = Color.RED;
        break;
      case YELLOW:
        colorOn = Color.YELLOW;
        break;
      case GREEN:
        colorOn = Color.GREEN;
        break;
      default:
        colorOn = Color.GRAY;
    }

    if (state == current) {
      // GLOW effect
      int glowDiameter = diameter + glowSize;
      int glowX = x - glowSize / 2;
      int glowY = y - glowSize / 2;
      Color glowColor = new Color(colorOn.getRed(), colorOn.getGreen(), colorOn.getBlue(), 80);
      g2.setColor(glowColor);
      g2.fillOval(glowX, glowY, glowDiameter, glowDiameter);
      g2.setColor(colorOn);
    } else {
      g2.setColor(Color.DARK_GRAY);
    }

    g2.fillOval(x, y, diameter, diameter);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    // Size of circle's position
    int diameter = 60;
    int spacing = 30;
    int glowSize = 20;
    int boxWidth = 100;
    int boxHeight = 3 * diameter + 2 * spacing + 40;
    int boxX = (getWidth() - boxWidth) / 2;
    int boxY = 30;
    int x = boxX + (boxWidth - diameter) / 2;
    int y = boxY + 20;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(new Color(30, 30, 30));
    g2.fillRoundRect(boxX, boxY, boxWidth, boxHeight, 20, 20);

    // Red light
    drawLight(g2, x, y, diameter, glowSize, TrafficLightState.RED, currentState);

    // Yellow light
    y += diameter + spacing;
    drawLight(g2, x, y, diameter, glowSize, TrafficLightState.YELLOW, currentState);

    // Green Light
    y += diameter + spacing;
    drawLight(g2, x, y, diameter, glowSize, TrafficLightState.GREEN, currentState);
  }
}
