package com.dell.glit.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomUtil {
	public static final String BLUE = "rgba(0,0,255,0.3)";
	public static final String LIGHT_BLUE = "rgba(0,0,255,0.6)";
	public static final String YELLOW = "rgba(255, 255, 255, 0.8)";
	public static final String GREEN = "rgba(0,255,0,0.3)";
	public static final String RED = "rgba(255,0,0,0.3)";
	public static final String MAROON = "rgba(128,0,0,0.3)";
	public static final String NAVY = "rgba(0,0,128,0.3)";
	public static final String TEAL = "rgba(0,128,128,0.3)";
	public static final String BROWN = "rgba(165,42,42,0.3)";
	public static final String PERU = "rgba(205,133,63,0.3)";

	public static String getRandomColor(){
		List<String> colorList = new LinkedList<String>();
		colorList.add(BLUE);
		colorList.add(GREEN);
		colorList.add(LIGHT_BLUE);
		colorList.add(RED);
		colorList.add(YELLOW);
		colorList.add(MAROON);
		colorList.add(NAVY);
		colorList.add(TEAL);
		colorList.add(BROWN);
		colorList.add(PERU);
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(colorList.size());
	    return colorList.get(randomInt);
	    }
}
