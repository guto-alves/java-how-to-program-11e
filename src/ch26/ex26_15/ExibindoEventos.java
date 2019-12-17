/*
 * Objetivo     : 12.15 (Exibindo eventos) Frequentemente, é útil exibir os eventos que ocorrem durante a execução de um aplicativo. Isso pode ajudá-lo a entender
 * quando os eventos ocorrem e como eles são gerados. Escreva um aplicativo que permita ao usuário gerar e processar cada evento discutido
 * neste capítulo. O aplicativo deve fornecer os métodos das interfaces ActionListener, ItemListener, ListSelectionListener,
 * MouseListener, MouseMotionListener e KeyListener para exibir as mensagens quando os eventos ocorrem. Utilize o método
 * toString para converter os objetos de evento recebidos em cada rotina de tratamento de evento para Strings que possam ser exibidas.
 * O método toString cria uma String contendo todas as informações no objeto de evento.
 * 
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 2 de mar de 2019
 */

package ch26.ex26_15;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ExibindoEventos extends JFrame implements ActionListener, ItemListener, ListSelectionListener,
		MouseListener, MouseMotionListener, KeyListener {
	private final JButton button;

	private final JTextArea textArea;

	private final JList<String> list;
	private static final String[] colorNames = { "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray" };

	private final JCheckBox checkBox;

	private final JTextArea textAreaMouseEvent;

	public ExibindoEventos() {
		super("Exibindo Eventos");
		setLayout(new FlowLayout(FlowLayout.CENTER));

		// MouseEvent
		textAreaMouseEvent = new JTextArea("\nÁrea para MouseEvent", 3, 13);
		textAreaMouseEvent.setEditable(false);
		textAreaMouseEvent.setDisabledTextColor(Color.BLACK);
		add(textAreaMouseEvent);
		textAreaMouseEvent.addMouseListener(this);
		textAreaMouseEvent.addMouseMotionListener(this);

		// KeyEvent
		textArea = new JTextArea("\nÁrea para KeyEvent", 3, 20);
		textArea.setEditable(false);
		textArea.setDisabledTextColor(Color.BLACK);
		add(textArea);
		textArea.addKeyListener(this);

		// ItemListener
		checkBox = new JCheckBox("CheckBox para ItemEvent");
		add(checkBox);
		checkBox.addItemListener(this);

		// ListSelectionListener
		list = new JList<>(colorNames);
		list.setVisibleRowCount(4);
		add(new JScrollPane(list));
		list.addListSelectionListener(this);

		// ActionEvent
		button = new JButton("Button para ActionEvent");
		button.addActionListener(this);
		add(button);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(ExibindoEventos.this, "ActionEvent", "ActionEvent",
				JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		textArea.setText("\nPressed: " + KeyEvent.getKeyText(arg0.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		textArea.setText("\nReleased: " + KeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		textArea.setText("\nTyped: " + e.getKeyChar());
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		textAreaMouseEvent.setText("\nMouseEvent: Dragged");

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		textAreaMouseEvent.setText("\nMouseEvent: Moved");

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		textAreaMouseEvent.setText("\nMouseEvent: Clicked");

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		textAreaMouseEvent.setText("\nMouseEvent: Entered");

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		textAreaMouseEvent.setText("\nMouseEvent: Exited");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		textAreaMouseEvent.setText("\nMouseEvent: Pressed");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		textAreaMouseEvent.setText("\nMouseEvent: Released");

	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		JOptionPane.showMessageDialog(null, "ListSelectionEvent");

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		JOptionPane.showMessageDialog(null, "ItemEvent");

	}

	public static void main(String[] args) {
		ExibindoEventos frame = new ExibindoEventos();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 220);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
