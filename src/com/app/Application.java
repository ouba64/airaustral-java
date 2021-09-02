package com.app;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.controllers.GeneralController;
import com.controllers.ReservationController;
import com.controllers.AdministrateurController;
import com.controllers.VolController;
import com.views.View;



public class Application {
    private static void createAndShowGUI() {

    	View view = new View();
    }
	
	
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
}
