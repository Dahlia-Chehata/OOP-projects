package control;

import java.io.File;

import javax.swing.JPanel;

import components.IGameController;

public interface GameWriter {

      public void setFile(File writer) ;

    public void save(IGameController game) ;

    public IGameController load(JPanel gui) ;
  
}
