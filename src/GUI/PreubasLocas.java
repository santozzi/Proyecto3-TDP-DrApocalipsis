package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextArea;

public class PreubasLocas extends JFrame  {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreubasLocas frame = new PreubasLocas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PreubasLocas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JSlider slider = new JSlider();
	
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(124, 252, 0));
		progressBar.setBounds(279, 0, 155, 23);
		
		progressBar.setBackground(new Color(255,0,0));
		
		
		
		
		
		slider.setBounds(72, 0, 200, 26);
		contentPane.add(slider);
		contentPane.add(progressBar);
			slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				progressBar.setValue(slider.getValue());
			}
		});
			
			
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(82, 38, 240, 224);
		contentPane.add(textArea);
	}
}
