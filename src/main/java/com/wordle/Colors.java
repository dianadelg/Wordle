package com.wordle;

public class Colors {

	public static final String clearColors = "\u001B[0m";
	public static final String clearBackground = "\033[49m";

	// Used for Welcome Message
	public static final String textBlue = "\u001B[34m";

	// For letter tile colors
	public static final String tileGreen = "\u001B[42m";
	public static final String tileYellow = "\u001B[43m";
	public static final String tileGray = "\u001B[100m";

	public static String blueText(String text) {
		return textBlue + text + clearColors;
	}

	public static String greenBackground(String text) {
		return tileGreen + text + clearBackground;
	}

	public static String yellowBackground(String text) {
		return tileYellow + text + clearBackground;
	}

	public static String grayBackground(String text) {
		return tileGray + text + clearBackground;
	}
}
