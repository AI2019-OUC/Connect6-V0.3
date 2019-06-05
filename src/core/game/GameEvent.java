package core.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import core.player.Player;

public class GameEvent {
	/**
	 * 无参构造函数，创建六子棋游戏
	 */
	public GameEvent() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 向游戏中添加玩家
	 * @param player 向游戏中添加的玩家
	 */
	public void addPlayer(Player player) {
		players.add(player);
		playerScore.put(player.name(), 0);
	}
	/**
	 * 记录游戏玩家和得分
	 */
	Map<String, Integer> playerScore=new HashMap<String, Integer>();
	
	/**
	 * 存放此次六子棋游戏的所有玩家
	 */
	ArrayList<Player> players = new ArrayList<>();
	/**
	 * 所有的玩家两两对弈，存放每场对弈的游戏结果
	 */
	ArrayList<GameResult> gameResults=new ArrayList<>();
	/**
	 * 所有参赛者的比赛(match)安排
	 * @param gameNumbers 每场比赛（match）对弈几局
	 */
	public void arrangeMatches(int gameNumbers) {
		
		
		int size = players.size();		
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				matches.add(new Match(gameNumbers, players.get(i), players.get(j)));
			}
		}
	}
	
	/**
	 * 存放此次六子棋游戏的所有比赛
	 */
	ArrayList<Match> matches = new ArrayList<>();
	
	/**
	 * 两两对弈的比赛过程，并打印比赛结果
	 */
	public void run() {
		Iterator<Match> itr = matches.iterator();
		while (itr.hasNext()) {
			Match match = itr.next();
			match.process();
			GameResult gameResult = match.getGameResult();
			gameResults.add(gameResult);
			playerScore.replace(gameResult.getBlackName(),playerScore.get(gameResult.getBlackName())+gameResult.getBlackWin()*2+gameResult.getTie()*1);
			playerScore.replace(gameResult.getWhiteName(),playerScore.get(gameResult.getWhiteName())+gameResult.getWhiteWin()*2+gameResult.getTie()*1);
		}
		printResult(gameResults);
		for(String name:playerScore.keySet()) {
			Integer score=playerScore.get(name);
			System.out.println(name+"得分:"+score);
		}
	}
	/**
	 * 打印最终的比赛结果
	 * @param gameResults 比赛集合
	 */
	public void printResult(ArrayList<GameResult> gameResults) {
		System.out.println("----------对弈结果----------");
		for(int i=0;i<gameResults.size();i++) {
			GameResult gameResult = gameResults.get(i);
			System.out.println(gameResult.getBlackName()+"和"+gameResult.getWhiteName()+"共对弈"+gameResult.getGameNumbers()+"次，其中:");
			System.out.println(gameResult.getBlackName()+"的胜利次数:"+gameResult.getBlackWin());
			System.out.println(gameResult.getWhiteName()+"的胜利次数:"+gameResult.getWhiteWin());
			System.out.println("平局次数:"+gameResult.getTie());
			System.out.println("--------------------------");
		}
	}
	
	
}
