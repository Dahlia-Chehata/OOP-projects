package gui;

import java.util.Properties;

public class tempObvo implements Observer {
  
  public static int I=0;
  @Override
  public void handleEvent() {
    System.out.println("here b2a" + I++);

  }

  @Override
  public void handleEvent(Properties eventType) {
    if ( eventType.containsKey("Key") && (char)eventType.get("Key")=='g')
      System.out.println("enta katabt omak");
    
  }

}
