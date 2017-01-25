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

  public GuiLinker(Guibuilder source) {
    this.gui = source.gui;
    saver = new XmlWriter();
    this.source = source;
  }

  public void startGame() {
    game = new Game(gui);
  }

  private void setLabel(JLabel toset, int ind) {
    if (ind == 0)
      p1 = toset;
    else if (ind == 1)
      p2 = toset;
  }

  public void setFile(File out) {
    if (out.getPath().contains(".xml")) {
      saver = new XmlWriter(out);
    }
  }

  public void save() {
    saver.save(game);
  }

  public void load() {
    game = (IGameMaster) saver.load();
  }

  public void pause() {
    game.pause();
  }

  public void run() {
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
    if(player!=null)
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
    game.pause();
    game = null;
  }

  private void updateScores() {
    while (true) {

      try {
        s1 = game.getScoreOf(0);
      } catch (Exception e) {
        s1 = 0;
      }
      try {
        s2 = game.getScoreOf(1);
      } catch (Exception e) {
        s2 = 0;
      }
      p1.setText(s1 + "");

      p2.setText(s2 + "");
      if (Math.abs(s1 - s2) > 6){
        announceWinner();
        endGame();
      }
      if (s1 > 3 * game.getLevel() + 3 && s2 > 3 * game.getLevel() + 3)
        game.upgradeLevel();
    }
  }

}
