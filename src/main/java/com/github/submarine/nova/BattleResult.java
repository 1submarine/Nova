package com.github.submarine.nova;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class BattleResult extends JFrame {
	private final JPanel contentPane;
	private final JTextPane textPane;
	public class Interceptor extends PrintStream {
		public Interceptor(OutputStream out) {
			super(out,true);
		}

		@Override
		public void print(String s) {
			super.print(s);
			textPane.setText(textPane.getText()+s);
		}

		@Override
		public void println(String s) {
			super.println(s);
			textPane.setText(textPane.getText()+"\n");
		}
	}

	public BattleResult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.textPane = new JTextPane();
		JScrollPane jsp = new JScrollPane(this.textPane);
		textPane.setEditable(false);
		textPane.setContentType("text");
		textPane.setText("");

		contentPane.add(jsp, BorderLayout.CENTER);

		//redirect stream
		PrintStream interceptor = new Interceptor(System.out);
		System.setOut(interceptor);
	}
}
