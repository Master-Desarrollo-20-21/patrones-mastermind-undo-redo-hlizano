package usantatecla.mastermind.models;

import java.util.List;
import java.util.ArrayList;

class GameRegistry {

  private List<GameMemento> mementos;
  private Game game;
  private int position;

  GameRegistry(Game game) {
    this.game = game;
    this.mementos = new ArrayList<GameMemento>();
    this.position = 0;
    this.mementos.add(this.position, this.game.createMemento());   
  }

  // hay una pulga que no encontre, cada vez que se intenta registrar despuès de hacer undo 
  // se sobre escribe la proposed combination en position y en la position++ 
  void register() {
    int times = this.mementos.size() - this.position - 1; 
    for (int i = 0; i < times; i++) {
      this.mementos.remove(mementos.size()-1);      
    }
    this.position++;
    this.mementos.add(this.position, this.game.createMemento());
  }

  void undo() {
    this.position--;
    this.game.set(this.mementos.get(this.position));
  }

  void redo() {
    this.position++;
    this.game.set(this.mementos.get(this.position));
  }

  boolean isUndoable() {
    return this.position > 0;
  }

  boolean isRedoable() {
    return this.position < mementos.size() - 1;
  }

}
