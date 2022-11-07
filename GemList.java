import java.util.List;

public class GemList
{
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);

		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);

		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);

		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);

		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);

		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);

		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);
	}

	int size;
	Node start;

	private class Node
	{
		public Gem gem;
		public Node next;

		public Node(Gem gem)
		{
			this.gem = gem;
		}

		@Override
		public String toString() {
			return "" + this.gem;
		}
	}

	GemList()
	{
		this.start = null;
		size = 0;
	}

	int size()
	{
		return size;
	}

	void draw(double y)
	{
		Node temp = start;
		int index = 0;

		while (temp != null)
		{
			temp.gem.draw(GemGame.indexToX(index), y);
			index++;
			temp = temp.next;
		}
	}

	void insertBefore(Gem gem, int i)
	{
			int index = i;
			if(index > size) index = size;
			Node current = start;

			if (size() == 0)
			{
				Node temp = start;
				start = new Node(gem);
				start.next = temp;

				size++;
			}

			else if (index == 0)
			{

				System.out.println("2");

				Node temp = new Node(gem);
				temp.next = start;
				start = temp;
				size++;

			}
			/*else if (index >= size())
			{

				System.out.println("3");
				Node temp = start;
				while (temp.next != null)
				{
					temp = temp.next;
				}
				temp.next = new Node(gem);
				size++;
			} */

			else
			{

				System.out.println("4");
				for(int j =0;j<i-1;j++) {
					current = current.next;d+

				}
				Node temp = current.next;
				current.next = new Node(gem);
				current.next.next = temp;
		}
	}

	int score()
	{
		return 0;
		/*Node temp = start;
		int score = 0;
		GemType last = null;
		int curSum = 0;
		int run = 1;
		while (temp != null)
		{
			if (!temp.gem.getType().equals(last))
			{
				score += curSum * run;
				run = 0;
				curSum = 0;
			}
			run++;
			curSum += temp.gem.getPoints();
			last = temp.gem.getType();
		}
		return score;

		 */
	}

	@Override
	public String toString() {
		Node temp = start;
		String str = "";
		if (temp == null)
		{
			return null;
		}
		while (temp.next != null)
		{
			str += temp.gem;
		}
		return str;
	}
}
