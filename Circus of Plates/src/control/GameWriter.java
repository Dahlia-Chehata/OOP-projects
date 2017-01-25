package control;

import java.io.File;

import components.IGameController;

public interface GameWriter {

      public void setFile(File writer) ;

    public void save(IGameController game) ;

    public IGameController load() ;
  
}
