package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

class GameMemento {

	private List<ProposedCombination> proposedCombinations;

  public GameMemento(List<ProposedCombination>proposedCombinations) {
    this.proposedCombinations = new ArrayList<>();

    for (ProposedCombination proposedCombination : proposedCombinations) {
        this.proposedCombinations.add(proposedCombination.copy());
    }
  }

  public List<ProposedCombination> getProposedCombinations() {
    return proposedCombinations;
  }

  public void setProposedCombinations(List<ProposedCombination> proposedCombinations) {
    this.proposedCombinations = proposedCombinations;
  }

  public List<Result> getResults(SecretCombination secretCombination) {
    List<Result> results = new ArrayList<>();
    for(ProposedCombination proposedCombination : proposedCombinations){
      results.add(secretCombination.getResult(proposedCombination));
    }	
    return results;
  }

}
