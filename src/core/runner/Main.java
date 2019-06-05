package core.runner;

import core.game.GameEvent;

public class Main {

    public static void main(String[] args) {

    	GameEvent oucChampion = new GameEvent();
     	
    	oucChampion.addPlayer(new baseline.player.AI());
    	
    	oucChampion.addPlayer(new g01.player.AI());
    	oucChampion.addPlayer(new g02.player.AI());
    	
    	oucChampion.arrangeMatches(2);
    	
    	oucChampion.run();
    }
}
