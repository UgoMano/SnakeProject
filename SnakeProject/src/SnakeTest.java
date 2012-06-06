
import javax.swing.JFrame;

public class SnakeTest 
{
	public static void main ( String [] args )
	{
		JFrame frame = new JFrame( "Snake Game" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		SnakeProject ss = new SnakeProject();
		frame.add( ss );
		ss.setFocusable(true);
		ss.requestFocus();
		frame.setSize( 420, 490 );
		frame.setVisible( true );
		ss.playGame();
	}
}