package elementsGraphiques;

import java.awt.Color;

import javax.swing.JButton;

public class BtnOption extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public BtnOption(String Titre)
{ 
  super();
  setBounds(175, 231, 117, 29);
  setText(Titre); 
  setOpaque(true);
  setBackground(Color.GRAY);
  setFont(Police.stdPolice);
  

	}

}
