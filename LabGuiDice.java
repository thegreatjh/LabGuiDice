package guiDice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LabGuiDice extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDice;
	private int die = 0;
	private int newDie = 0;
	private Random rand = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiDice frame = new LabGuiDice();
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
	public LabGuiDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnRollDice = makeButton();
		contentPane.add(btnRollDice, BorderLayout.SOUTH);

		lblDice = diceLabel();
		contentPane.add(lblDice, BorderLayout.CENTER);
	}

	public JLabel diceLabel() {
		die = rand.nextInt(6) + 1;
		newDie = die;
		System.out.println(die);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(224, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(
				new ImageIcon(LabGuiDice.class.getResource("/resources/die-" + die + ".png")));
		return lblNewLabel;
	}

	public JButton makeButton() {
		JButton btnRollDice = new JButton("Roll 'Em");
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDice.setIcon(null);
				while (die == newDie) {
					die = rand.nextInt(6) + 1;
				}
				newDie = die;
				System.out.println(die);
				lblDice.setIcon(new ImageIcon(
						LabGuiDice.class.getResource("/resources/die-" + die + ".png")));
			}
		});
		btnRollDice.setFont(new Font("Lucida Handwriting", Font.PLAIN, 30));
		btnRollDice.setForeground(new Color(128, 0, 0));
		btnRollDice.setBackground(new Color(0, 0, 205));
		return btnRollDice;
	}

}
