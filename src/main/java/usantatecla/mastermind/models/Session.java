package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;
import java.util.List;

public class Session {

  private Game game;
  private GameRegistry registry;
  private State state;

  public Session() {
    this.state = new State();
    this.game = new Game();
    this.registry = new GameRegistry(game);
  }

  public void addProposedCombination(List<Color> colors) {
    this.game.addProposedCombination(colors);
    this.registry.register();
}

  public StateValue getValueState() {
    return this.state.getValueState();
  }

  public void next() {
    this.state.next();
  }

  public int getWidth() {
		return this.game.getWidth();
	}

  public void start() {
		this.state.next();
	}  

  public void undo() {
    this.registry.undo();
  }

  public boolean isUndoable() {
    return this.registry.isUndoable();
  }

  public void redo() {
    this.registry.redo();
  }

  public boolean isRedoable() {
    return this.registry.isRedoable();
  }

public void clear() {
  this.game.clear();
}

public void reset() {
  this.state.reset();
}

public boolean isWinner() {
	return this.game.isWinner();
}

public boolean isLooser() {
	return this.game.isLooser();
}

public int getAttempts() {
	return this.game.getAttempts();
}

public List<Color> getColors(int position) {
	return this.game.getColors(position);
}

public int getBlacks(int position) {
	return this.game.getBlacks(position);
}

public int getWhites(int position) {
	return this.game.getWhites(position);
}

}
