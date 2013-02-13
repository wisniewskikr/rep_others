package org.wk.services;

import java.util.ArrayList;
import java.util.List;

import org.wk.bo.BowlingFrame;

public class ScoreService {
	
	
	/**
	 * Method transforms input of bowling score to output.
	 * 
	 * @param input object String with input of bowling score
	 * @return object String with output of bowling score
	 * @throws Exception
	 */
	public String transformInputToOutput(String input) throws Exception{
		
		List<BowlingFrame> frames = transformInputToFrames(input);
		frames = countTotalScores(frames);
		return transformFramesToOutput(frames);
		
	}
	
	/**
	 * Method transforms input of bowling score (object String) to list of
	 * objects Frame.
	 * 
	 * @param input object String with input of bowling score
	 * @return list of objects Frame
	 * @throws Exception
	 */
	protected List<BowlingFrame> transformInputToFrames(String input) throws Exception{
		
		List<BowlingFrame> frames = new ArrayList<BowlingFrame>();
		BowlingFrame frame = null;
		int index = 1;
		
		String[] inputArray = input.split(" ");
		for (int i = 0; i < inputArray.length; i++) {
			
			String score = inputArray[i];
			if("strike".equals(score)){				
				
				frame = new BowlingFrame(index, 10);
				frame.setStrike(true);
				frames.add(frame);
				
				frame = null;
				index++;
				continue;
				
			}else if("spare".equals(score)){
				
				if(frame == null){
					throw new Exception("Spare can be placed only as a second score in a frame");
				}
				
				int scoreFirst = frame.getScoreFirst();
				int scoreSecond = 10 - scoreFirst;
				frame.setScoreSecond(scoreSecond);
				frame.setSpare(true);
				frames.add(frame);
				
				frame = null;
				continue;
				
			}else if(frame == null){
				
				int scoreFirst = transformScoreStringToInt(score);
				frame = new BowlingFrame(index, scoreFirst);
								
				index++;
				continue;
				
			}else if(frame != null){
				
				int scoreSecond = transformScoreStringToInt(score);
				frame.setScoreSecond(scoreSecond);
				frames.add(frame);
								
				frame = null;
				continue;
				
			}
			
		}
		
		if(frame != null){
			frames.add(frame);
		}
		
		if(frames.size() < 10){
			throw new Exception("One game should consist of at least 10 frames");
		}
		
		return frames;
		
	}
	
//	private void transformToStrike(List<BowlingFrame> frames, BowlingFrame frame, int index) {
//		
//		frame = new BowlingFrame(index, 10);
//		frame.setStrike(true);
//		frames.add(frame);
//		
//		frame = null;
//				
//	}
	
	// TODO Kwi: check why this not work
//	private void transformToSpare(List<BowlingFrame> frames, BowlingFrame frame) throws Exception{
//		
//		if(frame == null){
//			throw new Exception("Spare can be placed only as a second score in a frame");
//		}
//		
//		int scoreFirst = frame.getScoreFirst();
//		int scoreSecond = 10 - scoreFirst;
//		frame.setScoreSecond(scoreSecond);
//		frame.setSpare(true);
//		frames.add(frame);
//		
//		frame = null;
//		
//	}
	
	/**
	 * Method counts total score of every object Frame from list.
	 * 
	 * @param frames list of objects Frame
	 */
	protected List<BowlingFrame> countTotalScores(List<BowlingFrame> frames){
		
		for (BowlingFrame frame : frames) {
			
			if(frame.getIndex() != 10){
				int scoreTotal = getScoreTotal(frame, frames);
				frame.setScoreTotal(scoreTotal);
			}else{
				int scoreTotal = getScoreTotalLastFrame(frame, frames);
				frame.setScoreTotal(scoreTotal);
				break;
			}
			
		}
		
		return frames.subList(0, 10);
		
	}
	
	/**
	 * Method transforms list of object Frame with total score to output.
	 * 
	 * @param frames list of object Frame with counted total score
	 * @return object String with formatted output
	 */
	protected String transformFramesToOutput(List<BowlingFrame> frames){
		
		StringBuilder sb = new StringBuilder();
		int result = 0;
		
		for (BowlingFrame frame : frames) {
			result += frame.getScoreTotal();
			sb.append(result);
			sb.append(" ");
		}
		
		return sb.toString();
		
	}
	
	/**
	 * Method transforms object String to int with score.
	 * 
	 * @param score object String with score
	 * @return int with score
	 * @throws Exception
	 */
	private int transformScoreStringToInt(String score) throws Exception{
		
		int scoreInt;
		
		try{
			scoreInt = Integer.parseInt(score);
		}catch(Exception e){
			throw new Exception("Following score is forbidden: " + score);
		}
		
		if(scoreInt > 9 || scoreInt < 0){
			throw new Exception("Following score is not valid range (0-9, 'stricke', 'spare')" + score);
		}
		
		return scoreInt;
	}	
	
	/**
	 * Method counts total score for every bowling frame.
	 * 
	 * @param frame current object BowlingFrame
	 * @param frames list of all Frames
	 */
	private int getScoreTotal(BowlingFrame frame, List<BowlingFrame> frames){
		
		if(!frame.isSpare() && !frame.isStrike()){
			
			return frame.getScoreFirst() + frame.getScoreSecond();
			
			
		}if(frame.isSpare()){
			
			int index = frame.getIndex();
			BowlingFrame nextFrame = frames.get(index);
			return 10 + nextFrame.getScoreFirst();
			
			
		}if(frame.isStrike()){
			
			int index = frame.getIndex();
			BowlingFrame nextFrame = frames.get(index);
			return 10 + nextFrame.getScoreFirst() + nextFrame.getScoreSecond();
						
		}
		
		return 0;
		
	}
	
	private int getScoreTotalLastFrame(BowlingFrame frame, List<BowlingFrame> frames){
		
		int scoreTotal = 0;
		
		scoreTotal += getScoreTotal(frame, frames);
		
		for (int i = 10; i <= frames.size() - 1; i++) {
			
			frame = frames.get(i);			
			if(!frame.isSpare() && !frame.isStrike()){
				break;
			}			
			scoreTotal += getScoreTotal(frame, frames);
						
		}
		
		return scoreTotal;
		
	}
	

}
