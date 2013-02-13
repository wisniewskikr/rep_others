package org.wk.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.wk.bo.BowlingFrame;

public class ScoreServiceTest {
	
	private ScoreService service;

	@Before
	public void setUp() throws Exception {
		service = new ScoreService();
	}
	
	@Test
	public void transformInputToOutput() throws Exception{
		
		String input = "0 0 0 1 0 2 0 3 0 4 0 5 0 6 0 7 0 8 0 9";
		
		String output = service.transformInputToOutput(input);
		
		assertEquals("0 1 3 6 10 15 21 28 36 45 ", output);
		
	}
	
	@Test
	public void transformInputToOutput_spare() throws Exception{
		
		String input = "0 0 0 1 0 2 0 3 0 4 0 5 0 6 0 7 0 spare 0 9";
		
		String output = service.transformInputToOutput(input);
		
		assertEquals("0 1 3 6 10 15 21 28 38 47 ", output);
		
	}
	
	@Test
	public void transformInputToOutput_strike() throws Exception{
		
		String input = "0 0 0 1 0 2 0 3 0 4 0 5 0 6 0 7 strike 0 9";
		
		String output = service.transformInputToOutput(input);
		
		assertEquals("0 1 3 6 10 15 21 28 47 56 ", output);
		
	}
	
	@Test
	public void transformInputToOutput_whole() throws Exception{
		
		String input = "1 4 4 5 6 spare 5 spare strike 0 1 7 spare 6 spare strike 2 spare 6";
		
		String output = service.transformInputToOutput(input);
		
		assertEquals("5 14 29 49 60 61 77 97 117 133 ", output);
		
	}
	
	@Test
	public void transformInputToOutput_whole_strike() throws Exception{
		
		String input = "0 0 0 1 0 2 0 3 0 4 0 5 0 6 0 7 0 8 strike strike 2 5";
		
		String output = service.transformInputToOutput(input);
		
		assertEquals("0 1 3 6 10 15 21 28 36 73 ", output);
		
	}
	
	@Test
	public void transformInputToOutput_whole_spare_strike() throws Exception{
		
		String input = "0 0 0 1 0 2 0 3 0 4 0 5 0 6 0 7 0 8 2 spare strike 2 5";
		
		String output = service.transformInputToOutput(input);
		
		assertEquals("0 1 3 6 10 15 21 28 36 73 ", output);
		
	}
	
	@Test
	public void transformInputToOutput_whole_strike_spare() throws Exception{
		
		String input = "0 0 0 1 0 2 0 3 0 4 0 5 0 6 0 7 0 8 strike 3 spare 2";
		
		String output = service.transformInputToOutput(input);
		
		assertEquals("0 1 3 6 10 15 21 28 36 68 ", output);
		
	}

	@Test
	public void testTransformInputToFrames() throws Exception {
		
		String input = "0 0 0 1 0 2 0 3 0 4 0 5 0 6 0 7 0 8 0 9";
		
		List<BowlingFrame> frames = service.transformInputToFrames(input);
		
		assertEquals(10, frames.size());
		
		BowlingFrame frame1 = frames.get(0);
		assertEquals(1, frame1.getIndex());
		assertEquals(0, frame1.getScoreFirst());
		assertEquals(0, frame1.getScoreSecond());
		assertFalse(frame1.isSpare());
		assertFalse(frame1.isStrike());
		
		BowlingFrame frame2 = frames.get(1);
		assertEquals(2, frame2.getIndex());
		assertEquals(0, frame2.getScoreFirst());
		assertEquals(1, frame2.getScoreSecond());
		assertFalse(frame2.isSpare());
		assertFalse(frame2.isStrike());
		
		BowlingFrame frame10 = frames.get(9);
		assertEquals(10, frame10.getIndex());
		assertEquals(0, frame10.getScoreFirst());
		assertEquals(9, frame10.getScoreSecond());
		assertFalse(frame10.isSpare());
		assertFalse(frame10.isStrike());
		
	}
	
	@Test
	public void testTransformInputToFrames_spare() throws Exception {
		
		String input = "0 0 0 1 0 spare 0 3 0 4 0 5 0 6 0 7 0 8 0 9";
		
		List<BowlingFrame> frames = service.transformInputToFrames(input);
		
		assertEquals(10, frames.size());
		
		BowlingFrame frame1 = frames.get(0);
		assertEquals(1, frame1.getIndex());
		assertEquals(0, frame1.getScoreFirst());
		assertEquals(0, frame1.getScoreSecond());
		assertFalse(frame1.isSpare());
		assertFalse(frame1.isStrike());
		
		BowlingFrame frame2 = frames.get(1);
		assertEquals(2, frame2.getIndex());
		assertEquals(0, frame2.getScoreFirst());
		assertEquals(1, frame2.getScoreSecond());
		assertFalse(frame2.isSpare());
		assertFalse(frame2.isStrike());
		
		BowlingFrame frame3 = frames.get(2);
		assertEquals(3, frame3.getIndex());
		assertEquals(0, frame3.getScoreFirst());
		assertEquals(10, frame3.getScoreSecond());
		assertTrue(frame3.isSpare());
		assertFalse(frame3.isStrike());
		
		BowlingFrame frame10 = frames.get(9);
		assertEquals(10, frame10.getIndex());
		assertEquals(0, frame10.getScoreFirst());
		assertEquals(9, frame10.getScoreSecond());
		assertFalse(frame10.isSpare());
		assertFalse(frame10.isStrike());
		
	}
	
	@Test
	public void testTransformInputToFrames_strike() throws Exception {
		
		String input = "0 0 0 1 strike 0 3 0 4 0 5 0 6 0 7 0 8 0 9";
		
		List<BowlingFrame> frames = service.transformInputToFrames(input);
		
		assertEquals(10, frames.size());
		
		BowlingFrame frame1 = frames.get(0);
		assertEquals(1, frame1.getIndex());
		assertEquals(0, frame1.getScoreFirst());
		assertEquals(0, frame1.getScoreSecond());
		assertFalse(frame1.isSpare());
		assertFalse(frame1.isStrike());
		
		BowlingFrame frame2 = frames.get(1);
		assertEquals(2, frame2.getIndex());
		assertEquals(0, frame2.getScoreFirst());
		assertEquals(1, frame2.getScoreSecond());
		assertFalse(frame2.isSpare());
		assertFalse(frame2.isStrike());
		
		BowlingFrame frame3 = frames.get(2);
		assertEquals(3, frame3.getIndex());
		assertEquals(10, frame3.getScoreFirst());
		assertEquals(0, frame3.getScoreSecond());
		assertFalse(frame3.isSpare());
		assertTrue(frame3.isStrike());
		
		BowlingFrame frame10 = frames.get(9);
		assertEquals(10, frame10.getIndex());
		assertEquals(0, frame10.getScoreFirst());
		assertEquals(9, frame10.getScoreSecond());
		assertFalse(frame10.isSpare());
		assertFalse(frame10.isStrike());
		
	}
	
	@Test(expected = Exception.class)
	public void testTransformInputToFrames_exceptionScoresCount() throws Exception {
		
		String input = "0 0 0 1";
		
		service.transformInputToFrames(input);		
		
	}
	
	@Test(expected = Exception.class)
	public void testTransformInputToFrames_exceptionWrongScore() throws Exception {
		
		String input = "0 0 aaa 1 0 2 0 3 0 4 0 5 0 6 0 7 0 8 0 9";
		
		service.transformInputToFrames(input);		
		
	}
	
	@Test(expected = Exception.class)
	public void testTransformInputToFrames_exceptionScoreTooSmall() throws Exception {
		
		String input = "0 0 0 -1 0 2 0 3 0 4 0 5 0 6 0 7 0 8 0 9";
		
		service.transformInputToFrames(input);		
		
	}
	
	@Test(expected = Exception.class)
	public void testTransformInputToFrames_exceptionScoreTooBig() throws Exception {
		
		String input = "0 0 0 10 0 2 0 3 0 4 0 5 0 6 0 7 0 8 0 9";
		
		service.transformInputToFrames(input);		
		
	}
	
	@Test
	public void countTotalScores(){
		
		List<BowlingFrame> frames = new ArrayList<BowlingFrame>();
		frames.add(new BowlingFrame(1, 0, 0));
		frames.add(new BowlingFrame(2, 0, 1));
		frames.add(new BowlingFrame(3, 0, 2));
		frames.add(new BowlingFrame(4, 0, 3));
		frames.add(new BowlingFrame(5, 0, 4));
		frames.add(new BowlingFrame(6, 0, 5));
		frames.add(new BowlingFrame(7, 0, 6));
		frames.add(new BowlingFrame(8, 0, 7));
		frames.add(new BowlingFrame(9, 0, 8));
		frames.add(new BowlingFrame(10, 0, 9));
		
		frames = service.countTotalScores(frames);
		
		assertEquals(0, frames.get(0).getScoreTotal());
		assertEquals(1, frames.get(1).getScoreTotal());
		assertEquals(2, frames.get(2).getScoreTotal());
		assertEquals(3, frames.get(3).getScoreTotal());
		assertEquals(4, frames.get(4).getScoreTotal());
		assertEquals(5, frames.get(5).getScoreTotal());
		assertEquals(6, frames.get(6).getScoreTotal());
		assertEquals(7, frames.get(7).getScoreTotal());
		assertEquals(8, frames.get(8).getScoreTotal());
		assertEquals(9, frames.get(9).getScoreTotal());
		
	}
	
	@Test
	public void countTotalScores_spare(){
		
		List<BowlingFrame> frames = new ArrayList<BowlingFrame>();
		frames.add(new BowlingFrame(1, 0, 0));
		frames.add(new BowlingFrame(2, 0, 1));
		
		BowlingFrame frame = new BowlingFrame(3, 0, 10);
		frame.setSpare(true);
		frames.add(frame);
		
		frames.add(new BowlingFrame(4, 0, 3));
		frames.add(new BowlingFrame(5, 0, 4));
		frames.add(new BowlingFrame(6, 0, 5));
		frames.add(new BowlingFrame(7, 0, 6));
		frames.add(new BowlingFrame(8, 0, 7));
		frames.add(new BowlingFrame(9, 0, 8));
		frames.add(new BowlingFrame(10, 0, 9));
		
		frames = service.countTotalScores(frames);
		
		assertEquals(0, frames.get(0).getScoreTotal());
		assertEquals(1, frames.get(1).getScoreTotal());
		assertEquals(10, frames.get(2).getScoreTotal());
		assertEquals(3, frames.get(3).getScoreTotal());
		assertEquals(4, frames.get(4).getScoreTotal());
		assertEquals(5, frames.get(5).getScoreTotal());
		assertEquals(6, frames.get(6).getScoreTotal());
		assertEquals(7, frames.get(7).getScoreTotal());
		assertEquals(8, frames.get(8).getScoreTotal());
		assertEquals(9, frames.get(9).getScoreTotal());
		
	}
	
	@Test
	public void countTotalScores_strike(){
		
		List<BowlingFrame> frames = new ArrayList<BowlingFrame>();
		frames.add(new BowlingFrame(1, 0, 0));
		frames.add(new BowlingFrame(2, 0, 1));
		
		BowlingFrame frame = new BowlingFrame(3, 10, 0);
		frame.setStrike(true);
		frames.add(frame);
		
		frames.add(new BowlingFrame(4, 0, 3));
		frames.add(new BowlingFrame(5, 0, 4));
		frames.add(new BowlingFrame(6, 0, 5));
		frames.add(new BowlingFrame(7, 0, 6));
		frames.add(new BowlingFrame(8, 0, 7));
		frames.add(new BowlingFrame(9, 0, 8));
		frames.add(new BowlingFrame(10, 0, 9));
		
		frames = service.countTotalScores(frames);
		
		assertEquals(0, frames.get(0).getScoreTotal());
		assertEquals(1, frames.get(1).getScoreTotal());
		assertEquals(13, frames.get(2).getScoreTotal());
		assertEquals(3, frames.get(3).getScoreTotal());
		assertEquals(4, frames.get(4).getScoreTotal());
		assertEquals(5, frames.get(5).getScoreTotal());
		assertEquals(6, frames.get(6).getScoreTotal());
		assertEquals(7, frames.get(7).getScoreTotal());
		assertEquals(8, frames.get(8).getScoreTotal());
		assertEquals(9, frames.get(9).getScoreTotal());
		
	}
	
	@Test
	public void transformFramesToOutput(){
		
		List<BowlingFrame> frames = new ArrayList<BowlingFrame>();
		frames.add(new BowlingFrame(1, 0, 0, 0));
		frames.add(new BowlingFrame(2, 0, 1, 1));
		frames.add(new BowlingFrame(3, 0, 2, 2));
		frames.add(new BowlingFrame(4, 0, 3, 3));
		frames.add(new BowlingFrame(5, 0, 4, 4));
		frames.add(new BowlingFrame(6, 0, 5, 5));
		frames.add(new BowlingFrame(7, 0, 6, 6));
		frames.add(new BowlingFrame(8, 0, 7, 7));
		frames.add(new BowlingFrame(9, 0, 8, 8));
		frames.add(new BowlingFrame(10, 0, 9, 9));
		
		String output = service.transformFramesToOutput(frames);
		
		assertEquals("0 1 3 6 10 15 21 28 36 45 ", output);
		
	}

}
