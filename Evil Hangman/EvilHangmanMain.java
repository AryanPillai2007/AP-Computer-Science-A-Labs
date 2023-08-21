
public class EvilHangmanMain
{
	public static void main(String[] args)
	{
		EvilHangman evil = new EvilHangman("test.txt", true);
		EvilHangman evil = new EvilHangman("dictionary.txt", false);
		evil.playGame();
	}
}