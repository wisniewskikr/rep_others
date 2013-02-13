package org.wk.bo;

public class BowlingFrame {
	
	
	private int index;
	private int scoreFirst;
	private int scoreSecond;
	private int scoreTotal;
	private boolean isSpare;
	private boolean isStrike;
	
	
	public BowlingFrame(int index, int scoreFirst) {
		this.index = index;
		this.scoreFirst = scoreFirst;
	}
	
	public BowlingFrame(int index, int scoreFirst, int scoreSecond) {
		this.index = index;
		this.scoreFirst = scoreFirst;
		this.scoreSecond = scoreSecond;
	}
	
	public BowlingFrame(int index, int scoreFirst, int scoreSecond, int scoreTotal) {
		this.index = index;
		this.scoreFirst = scoreFirst;
		this.scoreSecond = scoreSecond;
		this.scoreTotal = scoreTotal;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getScoreFirst() {
		return scoreFirst;
	}
	public void setScoreFirst(int scoreFirst) {
		this.scoreFirst = scoreFirst;
	}
	
	public int getScoreSecond() {
		return scoreSecond;
	}
	public void setScoreSecond(int scoreSecond) {
		this.scoreSecond = scoreSecond;
	}
	
	public int getScoreTotal() {
		return scoreTotal;
	}
	public void setScoreTotal(int scoreTotal) {
		this.scoreTotal = scoreTotal;
	}
	
	public boolean isSpare() {
		return isSpare;
	}
	public void setSpare(boolean isSpare) {
		this.isSpare = isSpare;
	}
	
	public boolean isStrike() {
		return isStrike;
	}
	public void setStrike(boolean isStrike) {
		this.isStrike = isStrike;
	}
	

}
