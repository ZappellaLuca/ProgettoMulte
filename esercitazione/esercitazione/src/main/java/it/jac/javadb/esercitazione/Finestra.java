package it.jac.javadb.esercitazione;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pattern.Multa;



public class Finestra extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Finestra() {
		JPanel top=new JPanel();
		JPanel center=new JPanel();
		JPanel bottom=new JPanel(); 
		JButton genera=new JButton("genera pdf");
		center.setLayout(new GridLayout(4,3));	
		
		this.setTitle("inserisci i dati per creare il pdf della multa");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		this.setLocation(0, 0);	
		top.setSize(600,100);
		bottom.setSize(600,100);
		
		String Listavarchi[]= {};		
		JList varchi=new JList(Listavarchi);
		varchi.setSelectedIndex(0); 
		
		JTextField nome=new JTextField();
		JLabel Lnome=new JLabel("nome");			
		JTextField cognome=new JTextField();
		JLabel Lcognome=new JLabel("cognome");
		JTextField targa=new JTextField();
		JLabel Ltarga=new JLabel("targa");	
		JLabel Lvarco=new JLabel("varco");	
		
		center.add(Lnome);
		center.add(nome);	
		center.add(Lcognome);
		center.add(cognome);		
		center.add(Ltarga);
		center.add(targa);
		center.add(Lvarco);
		center.add(varchi);
		bottom.add(genera);
		
		this.getContentPane().add(BorderLayout.NORTH,top);
		this.getContentPane().add(BorderLayout.CENTER,center);
		this.getContentPane().add(BorderLayout.SOUTH,bottom);
		
		genera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)  {
				try {
					new Multa(nome.getText(),cognome.getText(),targa.getText(),1,"corso di porta romana"/*varchi.getSelectedIndex(),(String) varchi.getSelectedValue()*/);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		this.setVisible(true);
	}
}
