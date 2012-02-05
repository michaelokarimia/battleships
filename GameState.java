import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class GameState {

	private static final int WidthOfGrid = 10;
	private static final int HeightOfGrid = 10;
	private boolean gameOver;
	private boolean playerAircraftCarrierSunk;
	public Grid playerHomeGrid;
	private boolean playerBattleSunk;
	private boolean allAgentShipsSunk;
	private boolean allPlayerShipsSunk;
	boolean playerSubSunk;
	boolean playerDestSunk;
	private boolean agentBattleSunk;
	private boolean agentAirSunk;
	private Grid compHomeGrid;
	public Grid compAtt;
	public Grid playerAtt;
	public InfluenceMap influenceMap;
	private boolean playerMineSunk;
	private boolean agentDestSunk;
	private boolean agentSubSunk;
	private boolean agentMineSunk;
	private boolean playerWins;
	private boolean isGameOver;

	public boolean playerTurn;
	public boolean agentTurn;
	private boolean playerShipsdeployed;
	private boolean agentShipsDeployed;
	private boolean isDeployedComplete;

	public GameState() {
		gameOver = false;
		playerAircraftCarrierSunk = false;
		playerBattleSunk = false;
		allAgentShipsSunk = false;
		allPlayerShipsSunk = false;
		playerSubSunk = false;
		setAgentAirSunk(false);
		setAgentBattleSunk(false);
		playerHomeGrid = new Grid(WidthOfGrid, HeightOfGrid);
		compHomeGrid = new Grid(WidthOfGrid, HeightOfGrid);
		compAtt = new Grid(WidthOfGrid, HeightOfGrid);
		playerAtt = new Grid(WidthOfGrid, HeightOfGrid);
		influenceMap = new InfluenceMap();
		playerTurn = true;
		agentTurn = false;
		playerShipsdeployed = false;

	}

	public void outputHitList(JTextComponent displayTextbox)
	{
		
			if(compHomeGrid.checkAirSunk())
			{
				displayTextbox.setText("You Have sunk the Agent's Aircraft Carrier");
			}
			if(compHomeGrid.checkBattleSunk())
			{
				displayTextbox.setText(displayTextbox.getText() +("You Have sunk the Agent's Battleship"));
			}
			if(compHomeGrid.checkDestSunk())
			{
				displayTextbox.setText(displayTextbox.getText() +("You Have sunk the Agent's Destroyer"));
			}
			if(compHomeGrid.checkSubSunk())
			{
				displayTextbox.setText(displayTextbox.getText() +("You Have sunk the Agent's Submarine"));
			}
			if(compHomeGrid.checkMineSunk())
			{
				displayTextbox.setText(displayTextbox.getText() + ("You Have sunk the Agent's Minesweeper"));
			}
		
	}
	
	public boolean IsGameOver() {
		return gameOver;
	}

	public void gameNotOver() {
		gameOver = false;

	}

	public void SetGameOver() {
		gameOver = false;

	}

	public void setShipSunkStates() {
		if (playerHomeGrid.checkAirSunk()) {
			playerAircraftCarrierSunk = true;
		}
		if (playerHomeGrid.checkBattleSunk()) {
			playerBattleSunk = true;
		}
		if (playerHomeGrid.checkDestSunk()) {
			playerDestSunk = true;
		}
		if (playerHomeGrid.checkSubSunk()) {
			playerSubSunk = true;
		}
		if (playerHomeGrid.checkMineSunk()) {
			playerMineSunk = true;
		}
		if (compHomeGrid.checkAirSunk()) {
			setAgentAirSunk(true);
		}
		if (compHomeGrid.checkBattleSunk()) {
			setAgentBattleSunk(true);
		}
		if (compHomeGrid.checkDestSunk()) {
			agentDestSunk = true;
		}
		if (compHomeGrid.checkSubSunk()) {
			agentSubSunk = true;
		}
		if (compHomeGrid.checkMineSunk()) {
			agentMineSunk = true;

		}

		if (isAgentAirSunk() && isAgentBattleSunk() && agentDestSunk && agentSubSunk
				&& agentMineSunk)
			allAgentShipsSunk = true;

		if (playerAircraftCarrierSunk && playerBattleSunk && playerDestSunk
				&& playerSubSunk && playerMineSunk)
			allPlayerShipsSunk = true;

	}

	public boolean areAllAgentShipsSunk() {
		return allAgentShipsSunk;
	}

	public boolean getPlayerShipsSunk() {
		return allPlayerShipsSunk;
	}

	public void updatePlayerClick(int gridj, int gridi, Graphics attackPanelGraphics) {
		if (playerTurn && !isGameOver && playerShipsdeployed) {
			//System.out.println(acceptPlayerShot(gridi, gridj, attackPanelGraphics));
			setShipSunkStates();
		}
	}
	
	public String acceptPlayerShot(int i, int j, Graphics attackPanelGraphics, JTextField outText)
	{
		int sqr = playerAtt.getGridVal(i,j);
		String out ="";

			if (sqr ==0)
			{
				boolean hit = false;
				hit = compHomeGrid.shot(i,j);
		
				
		
				if(hit)
				{
					HitIcon.paint(attackPanelGraphics,(j*20),(i*20));
					playerAtt.update(i,j,9);
					outText.setText("HIT! Have Another Turn!");
				}
				else
				if(!hit)
				{
					MissIcon.paint(attackPanelGraphics,(j*20),(i*20));
					compHomeGrid.update(i,j,1);
					playerAtt.set(i,j,1);
					out="Miss!"+ playerTurn;
					outText.setText("Miss. Agent's Turn");
					startAgentTurn();
				}
			}
	
		
		
		setShipSunkStates();
		
		out = out + "CompHome " +compHomeGrid.toString();
		out = out + "player Attack = \n" + playerAtt.toString();
	
		
		return out;	
	}
	public void PlayerIsTheWinner() {
		playerWins = true;

	}

	public boolean isPlayerWinner() {
		return playerWins;
	}

	public boolean isBothPlayerAndAgentShipsDeployed() {
		return playerShipsdeployed && agentShipsDeployed;
	}

	public void SetAllShipsDeployed() {
		playerShipsdeployed = true;

	}

	public boolean IsAcceptingPlayerInput() {
		return playerTurn && !gameOver && playerShipsdeployed;
	}

	public void addAgentShips(Grid gridWithAgentShipsPlaced) {
		compHomeGrid = gridWithAgentShipsPlaced;
		agentShipsDeployed = compHomeGrid.allShipsPlaced();
	}

	public boolean isCompHomegridRefIsminus3(int i, int j) {
		return compHomeGrid.getGridVal(i,j) ==-3;
	}

	public boolean isCompHomeGridRefMinus4(int i, int j) {
		return compHomeGrid.getGridVal(i,j) ==-4;
	}

	public boolean isCompHomeGridLessThanMinus1(int i,int j) {
		return compHomeGrid.getGridVal(i,j) < -1;
	}

	public void setAgentAirSunk(boolean agentAirSunk) {
		this.agentAirSunk = agentAirSunk;
	}

	public boolean isAgentAirSunk() {
		return agentAirSunk;
	}

	public void setAgentBattleSunk(boolean agentBattleSunk) {
		this.agentBattleSunk = agentBattleSunk;
	}

	public boolean isAgentBattleSunk() {
		return agentBattleSunk;
	}

	public void startAgentTurn() {
		agentTurn = true;
		playerTurn = false;
		
	}

	public boolean isPlayerTurn() {
		return playerTurn && !agentTurn;
	}
	

	public void setPlayerTurn()
	{
			playerTurn= true;
			agentTurn = false;	
	}

	public String turnToString() {
	
		if(playerTurn)
			return "Player turn, take a shot";
		else if(agentTurn)
			return "Agent turn, please wait";
		else
			return "Error! neither player's turn";
	}

	public boolean isAgentTurn() {
		return agentTurn && ! playerTurn;
	}

	public void deployVessel(int i, int j, int orientation) {
		if(isBothPlayerAndAgentShipsDeployed())
			return;
		if(!playerShipsdeployed)
		{
			if(!playerHomeGrid.checkAirPlaced())
				playerHomeGrid.addAir(i, j,orientation);
			if(!playerHomeGrid.checkBattlePlaced())
				playerHomeGrid.addBattle(i, j, orientation);
			if(!playerHomeGrid.checkDestPlaced())
				playerHomeGrid.addDest(i, j, orientation);
			if(!playerHomeGrid.checkSubPlaced())
				playerHomeGrid.addSub(i, j, orientation);
			if(!playerHomeGrid.checkMinePlaced())
				playerHomeGrid.addMine(i, j, orientation);
		}
	}
	
}