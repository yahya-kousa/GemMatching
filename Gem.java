import javax.print.DocFlavor;
import java.awt.*;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{

	GemType type;
	int points;

	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;

		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);

		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}

	Gem()
	{
		int rand = (int) (Math.random() * (3));
		if (rand == 1)
		{
			type = GemType.GREEN;
		}
		else if (rand == 2)
		{
			type = GemType.BLUE;
		}
		else
		{
			type = GemType.ORANGE;
		}
		int[] pointvals = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
		int randp = (int) ((Math.random()) * pointvals.length);
		points = pointvals[randp];
	}

	Gem(GemType type, int points)
	{
		this.type = type;
		this.points = points;
	}

	GemType getType()
	{
		return type;
	}

	int getPoints()
	{
		return points;
	}

	void draw(double x, double y)
	{
		if (type == GemType.GREEN)
		{
			StdDraw.picture(x, y, "gem_green.png");
			StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(x, y, "" + points);
		}
		else if (type == GemType.BLUE)
		{
			StdDraw.picture(x, y, "gem_blue.png");
			StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(x, y, "" + points);
		}
		else
		{
			StdDraw.picture(x, y, "gem_orange.png");
			StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(x, y, "" + points);
		}

	}

	@Override
	public String toString() {
		return type + " " + points;
	}
}
