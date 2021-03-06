package usantatecla.mastermind.views.console;

import java.util.List;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.MessageView;

class ProposalCommand extends Command {

  ProposalCommand(ProposalController proposalController) {
    super(MessageView.ACTION_COMMAND.getMessage(), proposalController);
  }

  @Override
  protected void execute() {

    Error error;
		do {
			List<Color> colors = new ProposedCombinationView(proposalController).read();
			error = proposalController.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);		
  }

  @Override
  protected boolean isActive() {
    return true;
  }

}
