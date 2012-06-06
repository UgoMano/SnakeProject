
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SnakeProject extends JPanel implements KeyListener
{
    int posX = 210;
    int posY = 350;
    int course = 0;
    Boolean gameOver = false;
	int snackX = 300;
	int snackY = 370;
	static int point = 0;
	private JLabel score;
    
    public SnakeProject()
    {
        addKeyListener(this);
        score = new JLabel("Score: 0");
        add(score); 
    }
    public void paintComponent( Graphics g )
    {
	    g.setColor( Color.LIGHT_GRAY );
	    g.fillRect(0, 0, 500, 500);
   
        g.setColor( Color.BLACK);
        g.fillRect( 10, 40, 395, 415 );
        g.setColor(Color.BLUE);
        g.fillRect(posX, posY, 15, 15);
        
        Graphics2D g2D = ( Graphics2D ) g;
        g.setColor(Color.GRAY);
        g2D.setStroke( new BasicStroke(10) );
        g2D.drawRect(5, 35, 395, 415);
        
        g.setColor(Color.GREEN);
        g.fillRect(snackX, snackY, 15, 15);
        
    }
    
    public void move()
    {
        switch ( course )
        {
            case 0:
                posX = posX - 10; 
                break;
            
            case 1:
                posY = posY + 10;
                break;
                
            case 2:
                posX = posX + 10;
                break;
                
                
            case 3:
                posY = posY - 10;
                break;
                
        }
        
        repaint();
        
    }
    
    public void playGame()
    {
        while ( !gameOver )
        {
            if ( (posX <= 380 && posX >= 10) && ( posY <= 430 && posY >= 40) )
            {
                move();
                try 
                {
                    Thread.sleep(100);
                } 
                catch (InterruptedException e) 
                {
                
                }
                repaint();
                
                
                if ( ( posX == snackX ) && ( posY == snackY ) )
                {
	                score.setText("");
	                point++;
	                snacks();
	                score.setText("Score: "+point);
	                
	                if ( point == 10 )
	                {
	                	repaint();
	                	score.setText("Game Complete");
	                	break;
	                }
               
                }
            }
                
            
            else
            {
            	gameOver = false;
            }
        }
    }
    
    
    
    public void snacks()
    {
	    Random random = new Random();
	    snackX = 10 + random.nextInt(28)*10;
	    snackY = 40 + random.nextInt(35)*10;
   
    }
    

    public void keyPressed(KeyEvent kp ) 
    {
        if ( kp.getKeyCode() == KeyEvent.VK_LEFT )
        {
            course = 0;
            
        }
        
        else if ( kp.getKeyCode() == KeyEvent.VK_DOWN ) 
        {
            course = 1;
            
        }
        
        else if ( kp.getKeyCode() == KeyEvent.VK_RIGHT ) 
        {
            course = 2;
            
        }
        
        else if ( kp.getKeyCode() == KeyEvent.VK_UP ) 
        {
            course = 3;
            
        }
        
    }
    
    public void keyReleased(KeyEvent kr) 
    {
    
    }
    
    public void keyTyped(KeyEvent kt) 
    {
    
    }
    
    
    
    
    
}
