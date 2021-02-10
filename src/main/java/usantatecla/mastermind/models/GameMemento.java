package usantatecla.mastermind.models;

import java.util.List;

class GameMemento {

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

  public GameMemento(SecretCombination secretCombination, List<ProposedCombination> proposedCombinations,
      List<Result> results, int attempts) {
    this.secretCombination = secretCombination;
    this.proposedCombinations = proposedCombinations;
    this.results = results;
    this.attempts = attempts;
  }

  public SecretCombination getSecretCombination() {
    return secretCombination;
  }

  public void setSecretCombination(SecretCombination secretCombination) {
    this.secretCombination = secretCombination;
  }

  public List<ProposedCombination> getProposedCombinations() {
    return proposedCombinations;
  }

  public void setProposedCombinations(List<ProposedCombination> proposedCombinations) {
    this.proposedCombinations = proposedCombinations;
  }

  public List<Result> getResults() {
    return results;
  }

  public void setResults(List<Result> results) {
    this.results = results;
  }

  public int getAttempts() {
    return attempts;
  }

  public void setAttempts(int attempts) {
    this.attempts = attempts;
  }

}
