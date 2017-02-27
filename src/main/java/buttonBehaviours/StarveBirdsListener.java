package buttonBehaviours;

import java.awt.event.ActionEvent;

import gla.cs.joose.coursework.birdsim1.boards.Board;

public class StarveBirdsListener extends BoardListener {

	StarveBirdsListener(Board b) {
		super(b, "Starve Birds");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		b.starveBirds();
	}

}