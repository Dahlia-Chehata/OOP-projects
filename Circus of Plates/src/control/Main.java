package control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import components.IGameMaster;
import componentsImpl.BasePlayer;
import componentsImpl.Game;
import componentsImpl.KeyPlayer;
import componentsImpl.MousePlayer;
import componentsImpl.Plate;
import gui.Guibuilder;
import listeners.GuiKeyListener;
import listeners.GuiMouseListener;

/**
 * class responisble for running classes only.
 * @author Ahmed Hamdy
 *
 */
public class Main {
  public static void main(final String[] args) {
    Log4j.loadLogger();
    Guibuilder window = new Guibuilder();
    window.setVisible(true);
  }

}

