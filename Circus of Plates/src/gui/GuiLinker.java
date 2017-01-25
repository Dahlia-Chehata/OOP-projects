package gui;

import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;

import components.IGameController;
import components.IGameMaster;
import components.IGamePlayer;
import componentsImpl.BasePlayer;
import componentsImpl.Game;
import componentsImpl.KeyPlayer;
import componentsImpl.MousePlayer;
import control.GameWriter;
import control.Log4j;
import control.XmlWriter;

/**
 * class functionalities.
 * 
 * @author Helana or Dahlia
 *
 */
public class GuiLinker {
  private IGameMaster game;
  private JPanel gui;
  private GameWriter saver;
  private JLabel p1, p2;
  private int s1, s2;
  private Guibuilder source;
  private File out;

  public GuiLinker(Guibuilder source,JLabel p1,JLabel p2) {
    this.gui = source.gui;
    saver = new XmlWriter();
    this.source = source;
    this.p1 = p1;
    this.p2 = p2;
    Thread running = new RunningThread();
    running.start();
  }

  public void startGame() {
    try {
      game = new Game(gui);
    } catch (Exception e) {
      Log4j.fail(e.getMessage());
    }
  }

  private void setLabel(JLabel toset, int ind) {
    if (ind == 0)
      p1 = toset;
    else if (ind == 1)
      p2 = toset;
  }

  public void setFile(File out) {
    this.out = out;
    if (out.getPath().contains(".xml")) {
      saver = new XmlWriter(out);
    }
  }

  public void save() {
    // game.save(out);
    try {
    saver.save((Game) game);
    Log4j.success("game saved at "+out);
    } catch(Exception e) {
      Log4j.fail("failed to save game at "+out+"due to\n"+e.getMessage());
    }
  }

  public void load() {
    
    try {
      game = (IGameMaster) saver.load();
      Log4j.success("game loaded from "+out);
      } catch(Exception e) {
        Log4j.fail("failed to load game at "+out+"due to\n"+e.getMessage());
      }
  }

  public void pause() {
    game.pause();

    Log4j.success("Game Paused");
  }

  public void run() {

    Log4j.success("Game progressed");
    game.run();
  }

  public void addPlayer(int index) {
    System.out.println("ssss");
    BasePlayer player = null;
    switch (index) {
    case 1:
      player = new KeyPlayer(KeyPlayer.leftCharCode, KeyPlayer.rightCharCode);
      player.getEvent().attachListener(source);
      break;
    case 2:
      player = new KeyPlayer(KeyPlayer.leftArrowCode, KeyPlayer.rightArrowCode);
      player.getEvent().attachListener(source);
      break;
    case 3:
      player = new MousePlayer();
      break;
    default:
      break;

    }
    if (player != null)
      game.addPlayer(player);
  }

  public void announceWinner() {
    if (s1 > s2) {
      p1.setText("winner");
      p2.setText("loser");
    } else if (s2 > s1) {
      p2.setText("winner");
      p1.setText("loser");
    }

  }

  public void endGame() {

    Log4j.success("Game Ended with" + s1 + " " + s2);
    game.pause();
    game = null;
  }

  private void updateScores() {
    while (true) {
      int level;
      try {
        s1 = game.getScoreOf(0);
        level = game.getLevel();
      } catch (Exception e) {
        s1 = 0;
        level = 0;
      }
      try {
        s2 = game.getScoreOf(1);
        level = game.getLevel();
      } catch (Exception e) {
        s2 = 0;
        level = 0;
      }
      p1.setText(s1 + "");

      p2.setText(s2 + "");
      if (Math.abs(s1 - s2) > 6) {
        announceWinner();
        endGame();
      }
      if (s1 > 3 * level + 3 && s2 > 3 * level + 3)
        game.upgradeLevel();
    }
  }
  private class RunningThread extends Thread {
    public RunningThread() {

    }

    public void run() {
      updateScores();
    }
  }
}
