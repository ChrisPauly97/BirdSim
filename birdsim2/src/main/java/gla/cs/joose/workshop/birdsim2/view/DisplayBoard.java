package gla.cs.joose.workshop.birdsim2.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import gla.cs.joose.workshop.birdsim2.view.BoardListener;
import gla.cs.joose.workshop.birdsim2.Bird;
import gla.cs.joose.workshop.birdsim2.Piece;
import gla.cs.joose.workshop.birdsim2.Board;

public class DisplayBoard extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	public Board board;
	ArrayList<BoardListener> buttons;
	
	public DisplayBoard(Board board){
		this.board = board;
	}
	
	
		
	/**
     * Repaints this Board and everything on it.
     * 
     * @param g
     *        The Graphics context on which this board is painted.
     */
    public void update(Graphics g) {
        paint(g);
    }

    /**
     * Repaints this Board and everything on it.
     * 
     * @param g
     *        The Graphics context on which this board is painted.
     */
    public void paint(Graphics g) {
        // Paint the board
    	board.paint(g);
        // Paint the pieces
        synchronized (board.getAllPieces()) {
            for (Iterator<Piece> iter = board.getAllPieces().iterator(); iter.hasNext();) {
                Piece piece = iter.next();
                piece.paint(g, piece.getRectangle());
            }
        }
    }



	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

    
    
} //--------end of class

//-------------------------------------------------- inner class DisplayPanel

/*class DisplayPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
     * Repaints this Board and everything on it.
     * 
     * @param g
     *        The Graphics context on which this board is painted.
     
    public void update(Graphics g) {
        paint(g);
    }

    /**
     * Repaints this Board and everything on it.
     * 
     * @param g
     *        The Graphics context on which this board is painted.
     
    public void paint(Graphics g) {
        // Paint the board
        thisBoard.paint(g);
        // Paint the pieces
        synchronized (allPieces) {
            for (Iterator<Piece> iter = allPieces.iterator(); iter.hasNext();) {
                Piece piece = iter.next();
                piece.paint(g, piece.getRectangle());
            }
        }
    }
} // end inner class DisplayPanel
*/
