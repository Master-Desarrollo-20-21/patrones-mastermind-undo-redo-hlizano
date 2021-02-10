package usantatecla.mastermind.views.console;

import java.util.List;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;

class ProposalCommand extends Command {

  ProposalCommand(ProposalController proposalController) {
    super(MessageView.ACTION_COMMAND.getMessage(), proposalController);
  }

  @Override
  protected void execute() {
   
    Console console = new Console();

    Error error;
		do {
			List<Color> colors = new ProposedCombinationView(proposalController).read();
			error = proposalController.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		console.writeln();
		new AttemptsView(proposalController).writeln();
		new SecretCombinationView(proposalController).writeln();
		for (int i = 0; i < proposalController.getAttempts(); i++) {
			new ProposedCombinationView(proposalController).write(i);
			new ResultView(proposalController).writeln(i);
		}
		if (proposalController.isWinner()) {
			console.writeln(MessageView.WINNER.getMessage());
		} else if (proposalController.isLooser()) {
			console.writeln(MessageView.LOOSER.getMessage());
		}

  }

  @Override
  protected boolean isActive() {
    return true;
  }

}
