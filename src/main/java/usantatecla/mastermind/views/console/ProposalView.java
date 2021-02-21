package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

	void interact(ProposalController proposalController) {
		
		new ProposalMenu(proposalController).execute();

		console.writeln();
		new AttemptsView(proposalController).writeln();
		new SecretCombinationView(proposalController).writeln();
		for (int i = 0; i < proposalController.getAttempts(); i++) {
			new ProposedCombinationView(proposalController).write(i);
			new ResultView(proposalController).writeln(i);
		}
		if(proposalController.getAttempts()>0){
			if (proposalController.isWinner()) {
				console.writeln(MessageView.WINNER.getMessage());
			} else if (proposalController.isLooser()) {
				console.writeln(MessageView.LOOSER.getMessage());
			}
		}
	}

}
