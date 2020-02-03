import api.party.Party;
import games.tictactoe.AppliTicTacToe;
import parties.PerfectParty;
import games.devinettes.DevinettesGame;
import games.intrus.IntrusGame;

public class Main {

	public static void main(String[] args) throws Exception {
		Party party = (new PerfectParty(3).add(new AppliTicTacToe(), new DevinettesGame()));

		party.start();
	}

}
