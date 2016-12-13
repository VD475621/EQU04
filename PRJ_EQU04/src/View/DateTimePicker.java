package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Utils.DatePicker;

public final class DateTimePicker {
	
    /** return la date selectioner
	 * 
	 * @param model will construct the table
	 * @param Title will name the window
	 * @return the row selected or 0 if clause without selection
	 */
	public final static void pickDate(JFrame window , JTextField TBox){
		DatePicker dp = new DatePicker();
    	dp.addPopupListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TBox.setText(dp.getFormattedDate());
                dp.popupHide();
            }
        });
        dp.popupShow(window);
	}
}