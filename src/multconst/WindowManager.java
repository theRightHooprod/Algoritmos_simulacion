package multconst;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import menu.menu;

public class WindowManager extends JFrame {
	JFrame frame = this;

	final Color c1 = new Color(50, 50, 50),
		c2 = new Color(200, 200, 200),
		c3 = new Color(60, 60, 60),
		c4 = new Color(0, 0, 0, 0),
		c5 = new Color(100, 100, 100),
		c6 = new Color(225, 225, 225);
	final Border border = BorderFactory.createEmptyBorder(6, 10, 6, 10),
		border2 = BorderFactory.createEmptyBorder(4, 10, 4, 10),
		border3 = BorderFactory.createEmptyBorder(3, 5, 3, 5);
	
	public WindowManager() {
		super("Programa GUI 5");
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.insets = new Insets(3,3,3,3);

		JTextField seed = new JTextField(6) {{ setBorder(border); }},
			iterations = new JTextField(6) {{ setBorder(border); }},
			a = new JTextField(6) {{ setBorder(border); }};
		JTextArea yi = new JTextArea(){{
				setBounds(10, 30, 200, 600);
				setEditable(false);
				setBorder(BorderFactory.createCompoundBorder(getBorder(), border3));
			}}, xi = new JTextArea(){{
				setBounds(10, 30, 200, 600);
				setEditable(false);
				setBorder(BorderFactory.createCompoundBorder(getBorder(), border3));
			}}, ri = new JTextArea(){{
				setBounds(10, 30, 200, 600);
				setEditable(false);
				setBorder(BorderFactory.createCompoundBorder(getBorder(), border3));
			}};

		getContentPane().setBackground(c1);
		
		c.gridy = 0; add(new JLabel(" Semilla "){{ setForeground(c2); }}, c);
		c.gridy = 1; add(seed, c);
		c.gridx = 1;
		c.gridy = 0; add(new JLabel(" Constante "){{ setForeground(c2); }}, c);
		c.gridy = 1; add(a, c);
		c.gridx = 2;
		c.gridy = 0; add(new JLabel(" Iteraciones "){{ setForeground(c2); }}, c);
		c.gridy = 1; add(iterations, c);
		c.gridx = 2;

		c.gridx = -1;
		c.gridy = 2;
                
		add(new JButton("Ejecutar"){{
			addActionListener((ActionEvent ev) -> {
				try {
					int input = Integer.parseInt(seed.getText()),
						iMax = Integer.parseInt(iterations.getText()),
						constant = Integer.parseInt(a.getText());
					
					int tmp = input;
					
					yi.setText("");
					xi.setText("");
					ri.setText("");

					for (int i = 0; i < iMax; i++) {
						String res = "" + (tmp * constant);
						if (res.length() % 2 != 0) res = "0" + res;

						int mid = (res.length() - 4) / 2;
						String x = res.substring(mid, mid + 4);
						float r = Float.parseFloat("0." + x);

						yi.setText(yi.getText() + "Y" + i + ") " + res + "\n");
						xi.setText(xi.getText() + "X" + (i + 1) + ") " + x + "\n");
						ri.setText(ri.getText() + "R" + (i + 1) + ") " + r + "\n");

						tmp = Integer.parseInt(x);
					}
				} catch (Exception err) {
					JOptionPane.showMessageDialog(frame, "Se ha producido un error calculando el resultado.");
				}
			});
			setBackground(c5);
			setForeground(c6);
			setBorder(border2);
		}}, c);
                
                c.gridx = 2;
                c.gridy = 2;
                add(new JButton("Menu") {{
                        addActionListener((ActionEvent ev) -> {
                        frame.setVisible(false);
                        new menu().setVisible(true);
                    });
                    setBackground(c5);
                    setForeground(c6);
                    setBorder(border2);
                }}, c);
                

		c.gridx = 0;
		c.gridy = 3; add(new JLabel(" Yi "), c);
		c.gridy = 4; add(yi, c);
		c.gridx = 1;
		c.gridy = 3; add(new JLabel(" Xi "), c);
		c.gridy = 4; add(xi, c);
		c.gridx = 2;
		c.gridy = 3; add(new JLabel(" Ri "), c);
		c.gridy = 4; add(ri, c);
	}
}
