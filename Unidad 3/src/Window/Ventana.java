package Window;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame implements MouseListener, KeyListener{
	JPanel btn_panel = new JPanel();
	public Ventana() {

		this.setSize(1250,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,200);
		this.setResizable(false);
		this.setTitle("ActionListener");
		this.setMinimumSize(new Dimension(250,250));
		this.setMaximumSize(new Dimension(1000,750));
		this.setLocationRelativeTo(null);
		this.iniciarComponentes();
		addMouseListener(this);
		addKeyListener(this);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	//Metodo iniciar los componentes del panel
	public void iniciarComponentes() {
		//this.login();
		//this.registro();
		this.botones();
		//this.calculoInteres();
		//this.calculadora();
		this.repaint();
	}
	//Metodo del registro
	public void registro() {
			JPanel registro = new JPanel();
			registro.setSize(this.getWidth(),this.getHeight());
			registro.setBackground(Color.cyan);
			registro.setLayout(null);

			JLabel register_tag = new JLabel("Registro",0);
			register_tag.setSize(300, 80);
			register_tag.setFont(new Font ("Arial",Font.BOLD,24));
			register_tag.setForeground(Color.black);
			register_tag.setLocation(780, 20);
			register_tag.setOpaque(true);//Fondo a la etiqueta
			register_tag.setBackground(Color.orange);
			registro.add(register_tag);

			//Registro de usuario
			JLabel userName = new JLabel(" Nombre de usuario:");
			userName.setBounds(860,120,180,40);
			userName.setFont(new Font ("Agency FB", Font.BOLD, 25));
			registro.add(userName);

			JTextField userField = new JTextField();
			userField.setBounds(845, 159, 180, 40);
			userField.setFont(new Font("Arial",Font.BOLD,20));
			userField.setOpaque(true);
			userField.setBackground(Color.white);
			registro.add(userField);

			JLabel bioTag = new JLabel("Biografia",0);
			bioTag.setBounds(730, 209, 400, 40);
			bioTag.setFont(new Font("Arial",Font.BOLD,20));
			registro.add(bioTag);

			JTextArea bioText = new JTextArea();
			bioText.setBounds(740, 250, 400, 80);
			bioText.setFont(new Font("Arial",Font.BOLD,20));
			registro.add(bioText);

			JLabel pref = new JLabel("Preferencias",0);
			pref.setBounds(730, 330, 400, 40);
			pref.setFont(new Font("Arial",Font.BOLD,20));
			registro.add(pref);

			JCheckBox itemBox = new JCheckBox("Papas");
			itemBox.setBounds(750, 360, 90, 40);
			itemBox.setFont(new Font("Arial",Font.BOLD,18));
			itemBox.setOpaque(false);
			itemBox.setBackground(Color.magenta);
			registro.add(itemBox);

			JCheckBox itemBox2 = new JCheckBox("Dulces");
			itemBox2.setBounds(880, 360, 100, 40);
			itemBox2.setFont(new Font("Arial",Font.BOLD,18));
			itemBox2.setOpaque(false);
			registro.add(itemBox2);

			JCheckBox itemBox3 = new JCheckBox("Refresco");
			itemBox3.setBounds(1000, 360, 130, 40);
			itemBox3.setFont(new Font("Arial",Font.BOLD,18));
			itemBox3.setOpaque(false);
			registro.add(itemBox3);

			JLabel termsTag = new JLabel("Terminos",0);
			termsTag.setBounds(880, 410, 100, 40);
			termsTag.setFont(new Font("Arial",Font.BOLD,20));
			termsTag.setOpaque(false);
			termsTag.setBackground(Color.red);
			registro.add(termsTag);

			JRadioButton acceptRadio = new JRadioButton("Acepto los terminos");
			acceptRadio.setBounds(670, 450, 220, 40);
			acceptRadio.setFont(new Font("Arial",Font.BOLD,16));
			acceptRadio.setOpaque(false);
			acceptRadio.setBackground(Color.red);
			registro.add(acceptRadio);

			JRadioButton noAcceptRadio = new JRadioButton("No acepto los terminos");
			noAcceptRadio.setBounds(1000, 450, 220, 40);
			noAcceptRadio.setFont(new Font("Arial",Font.BOLD,16));
			noAcceptRadio.setOpaque(false);
			noAcceptRadio.setBackground(Color.red);
			registro.add(noAcceptRadio);

			ButtonGroup terms = new ButtonGroup();
			terms.add(acceptRadio);
			terms.add(noAcceptRadio);

			String colony[] = {"Centro","Camino real","Ayuntamiento"};

			JComboBox locations = new JComboBox(colony);
			locations.setBounds(750, 500, 350, 40);
			locations.setFont(new Font("Arial",Font.BOLD,19));
			registro.add(locations);

			JButton registerButton = new JButton("Crear cuenta");
			registerButton.setBounds(820, 620, 200, 40);
			registerButton.setFont(new Font("Arial",Font.BOLD,19));
			registro.add(registerButton);
			
			registerButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String usr = userField.getText();
					String bio = bioText.getText();
						if(usr.length()<=0) {
							userField.setBorder(BorderFactory.createLineBorder(Color.red,2));
						}
						else {
							userField.setBorder(BorderFactory.createLineBorder(Color.green,2));
						}
						
						if(bio.length()<=0) {
							bioText.setBorder(BorderFactory.createLineBorder(Color.red,2));

						}
						else {
							bioText.setBorder(BorderFactory.createLineBorder(Color.green,2));

						}
						
						if(!acceptRadio.isSelected()) {
							acceptRadio.setBorderPainted(true);
							acceptRadio.setBorder(BorderFactory.createLineBorder(Color.red,2));
						}
						else {
							acceptRadio.setBorder(BorderFactory.createLineBorder(Color.green,2));

						}
				}
				
			});
			
			this.add(registro);
		}
	public void login() {
		JPanel login = new JPanel();
		login.setSize(this.getWidth()/2,this.getHeight());
		login.setBackground(Color.decode("#30508f"));
		login.setLayout(null);

		//User Login
		JLabel login_tag = new JLabel("User Login",0);
		login_tag.setSize(300, 80);
		login_tag.setFont(new Font ("Segoe UI Black",Font.BOLD,32));
		login_tag.setForeground(Color.white);
		login_tag.setLocation(105, 12);
		login.add(login_tag);

		//MyAccount
		JLabel myAccount = new JLabel("My Account",0);
		myAccount.setBounds(150,120,220,40);
		myAccount.setFont(new Font ("Segoe UI Black", Font.BOLD, 35));
		myAccount.setForeground(Color.decode("#D9C943"));
		login.add(myAccount);

		//Titulo
		JLabel userName = new JLabel("Enter Your Username");
		userName.setBounds(100,170,180,40);
		userName.setFont(new Font ("Agency FB", Font.BOLD, 20));
		userName.setForeground(Color.white);
		login.add(userName);

		//Textbox del username

		JTextField typeUser = new JTextField();
		typeUser.setBounds(100,210,300,35);
		typeUser.setOpaque(true);
		typeUser.setBackground(Color.white);
		login.add(typeUser);

		//Icono persona
		/*JLabel person = new JLabel();
		person.setIcon(new ImageIcon(getClass().getResource("persona.png")));
		person.setBounds(60, 218, 20, 20);
		login.add(person);/*/

		//personFrame
		JLabel iconFrame = new JLabel();
		iconFrame.setBounds(55,212,30,30);
		iconFrame.setOpaque(true);
		iconFrame.setBackground(Color.decode("#D9C943"));
		login.add(iconFrame);

		//Contraseña
		JLabel pwd = new JLabel("Enter Your Password:");
		pwd.setBounds(100,260,180,40);
		pwd.setFont(new Font("Agency FB",Font.BOLD,20));
		pwd.setForeground(Color.white);
		login.add(pwd);

		//Campo para la contraseña
		JPasswordField typePwd = new JPasswordField();
		typePwd.setBounds(100,300,300,35);
		typePwd.setFont(new Font ("Agency FB", Font.BOLD, 25));
		login.add(typePwd);

		//Locker icon
		/*JLabel locker = new JLabel();
		locker.setIcon(new ImageIcon(getClass().getResource("candado.png")));
		locker.setBounds(60, 305, 20, 20);
		login.add(locker);/*/

		//lockerFrame
		JLabel lockerFrame = new JLabel();
		lockerFrame.setBounds(55,300,30,30);
		lockerFrame.setOpaque(true);
		lockerFrame.setBackground(Color.decode("#D9C943"));
		login.add(lockerFrame);

		//Boton de acceso
		JButton accessButton = new JButton("Login");
		accessButton.setBounds(160,370,170,50);
		accessButton.setBackground(Color.decode("#D9C943"));
		accessButton.setFont(new Font("Segoe UI Black",Font.BOLD,25));
		login.add(accessButton);
		
		accessButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Hola");
				String usuario = typeUser.getText();
				String pwd = new String(typePwd.getPassword());
				
				if(usuario.length()<=0) {
					typeUser.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else {
					typeUser.setBorder(BorderFactory.createLineBorder(Color.green,2));
				}
				
				if(pwd.length()<=0) {
					typePwd.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}
				else {
					typePwd.setBorder(BorderFactory.createLineBorder(Color.green,2));
				}
				if(usuario.equals("SuperUser")) {
					System.out.println("Bienvenido");
				}else {
					
				}
			}
		});


		//Don´t have an account?
		JLabel questionAcc = new JLabel("Don´t have an account?",0);
		questionAcc.setBounds(155,450,180,40);
		questionAcc.setFont(new Font("Agency FB",Font.BOLD,20));
		questionAcc.setForeground(Color.white);
		login.add(questionAcc);

		//Sign Up
		JButton signUp = new JButton("Sign Up");
		signUp.setBounds(165,495,160,40);
		signUp.setBackground(Color.decode("#D9C943"));
		signUp.setFont(new Font("Segoe UI Black",Font.BOLD,20));
		login.add(signUp);

		//Recuadro
		JLabel frame = new JLabel();
		frame.setSize(450,350 );
		frame.setOpaque(true);
		frame.setBackground(Color.decode("#22396c"));
		frame.setLocation(25,100);
		login.add(frame);

		this.add(login);
	}
	
	public void botones() {
		
		//Panel
		this.setSize(500,750);
		btn_panel.setLocation(0, 0);
		btn_panel.setSize(this.getWidth(),this.getHeight());
		btn_panel.setOpaque(true);
		btn_panel.setBackground(Color.decode("#30508f"));
		btn_panel.setLayout(null);
		
		//
		
		JButton rgs_btn = new JButton("Clic me");		
		rgs_btn.setFont(new Font("Agency FB",Font.BOLD,40));		
		rgs_btn.setForeground(Color.black);	
		rgs_btn.setBounds(50, 530, 400, 70);	
		rgs_btn.setBackground(Color.white);	
		rgs_btn.setFocusable(false);
		btn_panel.add(rgs_btn);
		
		rgs_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//Otro boton
				
				int x = (int)Math.floor(Math.random()*450+1);
				int y = (int)Math.floor(Math.random()*650+1);
				
				int w = (int)Math.floor(Math.random()*120+1);
				int h = (int)Math.floor(Math.random()*120+1);
				
				Random rand = new Random();
				float r = rand.nextFloat();		
				float g = rand.nextFloat();	
				float b = rand.nextFloat();	
				
				Color randColor = new Color(r,g,b);
				
				JButton other_btn = new JButton(r+""+g+""+b);	
				other_btn.setBounds(x,y,w,h);	
				other_btn.setOpaque(true);
				other_btn.setBackground(randColor);
				btn_panel.add(other_btn);
				
				getContentPane().repaint();
				getContentPane().revalidate();
				
				other_btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//Ejercicio 10
						JButton yo = ((JButton)e.getSource());
						btn_panel.remove(yo);
						
						getContentPane().repaint();
						getContentPane().revalidate();
						
						/*String command = ((JButton)e.getSource()).getActionCommand();
						/*JOptionPane.showMessageDialog(null, command);/*/
						
					}
				});
			}
			
		});
		
		this.add(btn_panel);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = (int)Math.floor(Math.random()*450+1);
		int y = (int)Math.floor(Math.random()*650+1);
		
		int w = (int)Math.floor(Math.random()*120+1);
		int h = (int)Math.floor(Math.random()*120+1);
		
		Random rand = new Random();
		float r = rand.nextFloat();		
		float g = rand.nextFloat();	
		float b = rand.nextFloat();	
		
		Color randColor = new Color(r,g,b);
		
		JButton other_btn = new JButton(r+""+g+""+b);	
		other_btn.setBounds(x,y,w,h);	
		other_btn.setOpaque(true);
		other_btn.setBackground(randColor);
		
		other_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				/*JOptionPane.showMessageDialog(null, r + "," + g + "," + b, "Codigo",JOptionPane.WARNING_MESSAGE);
				/*/
			}
	});
		btn_panel.add(other_btn);
		getContentPane().repaint();
		
}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//Ejercicio 11
		Random rand = new Random();
		float r = rand.nextFloat();		
		float g = rand.nextFloat();	
		float b = rand.nextFloat();	
		
		Color randColor = new Color(r,g,b);
		btn_panel.setBackground(randColor);	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//Ejercicio 12
		System.out.println(e.getKeyCode() + " " + e.getKeyChar());
		
		if(e.getKeyCode() == KeyEvent.VK_DELETE) {
			
			btn_panel.removeAll();
			getContentPane().repaint();	
			getContentPane().revalidate();	
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	//Graficos
	/*@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//Fondo
		g2d.setColor(Color.decode("#0665C0"));
		g2d.fillRect(0, 0, 1920, 720);
		
		 //Nube
		g2d.setColor(Color.white.darker());
	    g2d.fillRoundRect(700,308, 170, 40, 120, 120);
	    g2d.setColor(Color.white);
	    g2d.fillRoundRect(700,300, 170, 40, 120, 120);
	    
	    //Nube
	    g2d.setColor(Color.white.darker());
	    g2d.fillRoundRect(80,558, 300, 40, 120, 120);
	    g2d.setColor(Color.white);
	    g2d.fillRoundRect(80,550, 300, 40, 120, 120);
	    
	    //Nube
	    g2d.setColor(Color.white.darker());
	    g2d.fillRoundRect(300,513, 250, 40, 120, 120);
	    g2d.setColor(Color.white);
	    g2d.fillRoundRect(300,505, 250, 40, 120, 120);
	    
	    //Nube
	    g2d.setColor(Color.white.darker());
	    g2d.fillRoundRect(330,608, 200, 40, 120, 120);
	    g2d.setColor(Color.white);
	    g2d.fillRoundRect(330,600, 200, 40, 120, 120);
		
	    //Sombra del primer pilar de fondo
	    g2d.setColor(Color.decode("#C6E3E7").darker());
	    g2d.fillRoundRect(44, 300, 175, 1000,200,200);
	    
		//Primer pilar del fondo    
	    g2d.setColor(Color.decode("#C6E3E7"));
	    g2d.fillRoundRect(20, 300, 175, 1000,200,200);
	    
	    //Ovalos del primer pilar
	    g2d.setColor(Color.white);
	    g2d.fillOval(100, 330, 20, 40);
	    
	    g2d.setColor(Color.white);
	    g2d.fillOval(100, 430, 20, 40);
	    
	    g2d.setColor(Color.white);
	    g2d.fillOval(50, 460, 20, 40);
	    
	    //Sombra del segundo pilar del fondo
	    g2d.setColor(Color.decode("#C6E3E7").darker());
	    g2d.fillRoundRect(424, 300, 175, 1000,200,200);
		
		//Segundo pilar del fondo
		g2d.setColor(Color.decode("#C6E3E7"));
	    g2d.fillRoundRect(400, 300, 175, 1000,200,200);
	    
	    //Ovalos del segundo pilar
	    g2d.setColor(Color.white);
	    g2d.fillOval(430, 460, 20, 40);
	    
	    g2d.setColor(Color.white);
	    g2d.fillOval(430, 350, 20, 40);
	    
	    g2d.setColor(Color.white);
	    g2d.fillOval(500, 330, 20, 40);
	     
	    //Sombra del pilar de fondo
	    g2d.setColor(Color.decode("#C6E3E7").darker());
	    g2d.fillRoundRect(600, 150, 175, 1000,200,200);
	    
	    //Tercer pilar del fondo
	    g2d.setColor(Color.decode("#C6E3E7"));
	    g2d.fillRoundRect(576, 150, 175, 1000,200,200);
	    
	    //Ovalos del tercer pilar
	    g2d.setColor(Color.white);
	    g2d.fillOval(600, 330, 20, 40);
	    
	    g2d.setColor(Color.white);
	    g2d.fillOval(670, 220, 20, 40);
	    
	    //Sombra del primer pilar del frente
	    g2d.setColor(Color.decode("#71c2ff").darker().darker());
	    g2d.fillRoundRect(-46, 500, 200, 700,250,200);
	    
	    //Primer pilar del frente
	    g2d.setColor(Color.decode("#71c2ff"));
	    g2d.fillRoundRect(-70, 500, 200, 700,250,200);
	    
	    //Sombra del segundo pilar del frente
	    g2d.setColor(Color.decode("#71c2ff").darker().darker());
	    g2d.fillRoundRect(424, 500, 200, 700,200,200);
	    
	    //Segundo pilar del frente  
	    g2d.setColor(Color.decode("#71c2ff"));
	    g2d.fillRoundRect(400, 500, 200, 700,200,200);
	    
	    //Primer tubo
        g2d.setColor(Color.black);
        g2d.fillRoundRect(497, 500, 80, 150,10,10);
        g2d.setPaint(new GradientPaint(500, 445, Color.decode("#E4E9FE"), 680, 545, Color.decode("#4C4993")));
        g2d.fillRoundRect(500, 500, 75, 150,10,10);
        
        g2d.setColor(Color.black);
        g2d.fillRoundRect(492, 500, 90, 30,10,10);
        g2d.setPaint(new GradientPaint(500, 445, Color.decode("#E4E9FE"), 680, 545, Color.decode("#4C4993")));
        g2d.fillRoundRect(494, 500, 85, 25,10,10);
        
        g2d.setColor(Color.black);
        g2d.fillRoundRect(897, 500, 80, 150,10,10);
        g2d.setPaint(new GradientPaint(500, 445, Color.decode("#E4E9FE"), 680, 545, Color.decode("#4C4993")));
        g2d.fillRoundRect(900, 500, 75, 150,10,10);
        
        g2d.setColor(Color.black);
        g2d.fillRoundRect(892, 500, 90, 30,10,10);
        g2d.setPaint(new GradientPaint(500, 445, Color.decode("#E4E9FE"), 680, 545, Color.decode("#4C4993")));
        g2d.fillRoundRect(894, 500, 85, 25,10,10);
        
        
        
        //Segundo tubo
        g2d.setColor(Color.black);
        g2d.fillRoundRect(820, 603, 80, 145,10,10);
        g2d.setPaint(new GradientPaint(800, 445, Color.decode("#E4E9FE"), 680, 545, Color.decode("#4C4993")));
        g2d.fillRoundRect(820, 605, 75, 140,10,10);
        
        g2d.setColor(Color.black);
        g2d.fillRoundRect(820, 575, 90, 30,10,10);
        g2d.setPaint(new GradientPaint(800, 445, Color.decode("#E4E9FE"), 680, 545, Color.decode("#4C4993")));
        g2d.fillRoundRect(820, 577, 85, 25,10,10);
        
        g2d.setColor(Color.black);
        g2d.fillRoundRect(820, 693, 80, 145,10,10);
        g2d.setPaint(new GradientPaint(800, 445, Color.decode("#E4E9FE"), 680, 545, Color.decode("#4C4993")));
        g2d.fillRoundRect(820, 695, 75, 140,10,10);
        
        g2d.setColor(Color.black);
        g2d.fillRoundRect(820, 665, 90, 30,10,10);
        g2d.setPaint(new GradientPaint(800, 445, Color.decode("#E4E9FE"), 680, 545, Color.decode("#4C4993")));
        g2d.fillRoundRect(820, 667, 85, 25,10,10);
        
	    //Nube
	    g2d.setColor(Color.white.darker());
        g2d.fillRoundRect(500,458, 170, 40, 120, 120);
	    g2d.setColor(Color.white);
	    g2d.fillRoundRect(500,450, 170, 40, 120, 120);
	    
	    //Sombra del terce pilar del frente
	    g2d.setColor(Color.decode("#71c2ff").darker().darker());
	    g2d.fillRoundRect(644, 350, 200, 700,200,200);
	    
	    //Tercer pilar del frente   
	    g2d.setColor(Color.decode("#71c2ff"));
	    g2d.fillRoundRect(620, 350, 200, 700,200,200);
	    
	    //Ovalos del pilar 
	    g2d.setColor(Color.white);
	    g2d.fillOval(630, 400, 30, 50);
	    
	    g2d.setColor(Color.white);
	    g2d.fillOval(700, 550, 20, 40);
	       
		//Bloque1
	    g2d.setColor(Color.gray.brighter());
		g2d.fillRect(751, 451, 48, 48);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.black);
		g2d.drawRoundRect(750, 450, 50, 50, 10, 10);
		
		//Bloque2
		g2d.setColor(Color.gray.brighter());
		g2d.fillRect(751, 501, 48, 48);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.black);
		g2d.drawRoundRect(750, 500, 50, 50, 10, 10);
		
		//Bloque3
		g2d.setColor(Color.gray.brighter());
		g2d.fillRect(751, 551, 48, 48);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.black);
		g2d.drawRoundRect(750, 550, 50, 50, 10, 10);
		
		//Bloque4
		g2d.setColor(Color.gray.brighter());
		g2d.fillRect(751, 601, 48, 48);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.black);
		g2d.drawRoundRect(750, 600, 50, 50, 10, 10);
		
		//Bloque con ojos1
		g2d.setColor(Color.yellow);
		g2d.fillRect(801, 451, 48, 48);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.black);
		g2d.drawRoundRect(800, 450, 50, 50, 10, 10);
		
		g2d.setBackground(Color.black);
		g2d.fillRect(815, 460, 5, 12);
		
		g2d.setBackground(Color.black);
		g2d.fillRect(830, 460, 5, 12);
		
		//Bloque amarillo
		g2d.setColor(Color.yellow);
		g2d.fillRect(851, 451, 48, 48);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.black);
		g2d.drawRoundRect(850, 450, 50, 50, 10, 10);
		
	
		// Nubes
		g2d.setColor(Color.white.darker());
		g2d.fillRoundRect(-80, 385, 200, 40, 100, 100);
        g2d.setColor(Color.white);
        g2d.fillRoundRect(-80, 380, 200, 40, 100, 100);
        
        g2d.setColor(Color.white.darker());
        g2d.fillRoundRect(190, 408, 280, 50, 100, 100);
        g2d.setColor(Color.white);
        g2d.fillRoundRect(190, 400, 280, 50, 100, 100);
        
        g2d.setColor(Color.white.darker());
        g2d.fillRoundRect(750, 258, 170, 40, 120, 120);
        g2d.setColor(Color.white);
        g2d.fillRoundRect(750, 250, 170, 40, 120, 120);

		//Suelo verde
		g2d.setColor(Color.green.darker());
		g2d.fillRect(0, 650, 1520, 20);
				
		//Suelo cafe
		g2d.setColor(Color.decode("#BB9866"));
		g2d.fillRect(0, 670, 1520, 130);
		
		//Imagen mario
		try {
			BufferedImage Image = ImageIO.read(new File("src/MaritoBrosito.png"));
			
			g2d.drawImage(Image, 300, 550, null);
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Imagen planta
		try {
			BufferedImage Image = ImageIO.read(new File("src/Plantilla.png"));
			
			g2d.drawImage(Image, 490, 400, null);
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}/*/
	
	public void calculadora() {
		this.setSize(500,650);

		//Panel
		JPanel panel = new JPanel();
		panel.setSize(this.getWidth(),this.getHeight());
		panel.setBackground(Color.decode("#E16080"));
		panel.setLayout( new BorderLayout() );

		//Display
		JLabel text = new JLabel("100.00",4);
		text.setOpaque(true);
		text.setBackground(Color.white);
		text.setFont(new Font ("calibri",Font.BOLD,30));
		panel.add(text, BorderLayout.NORTH);

		JPanel center = new JPanel();
		center.setBackground(Color.decode("#E16DD8"));
		center.setLayout(new GridLayout(4,3,5,5));//(Filas,columnas,separacion,separacion)
		panel.add(center, BorderLayout.CENTER);

		String buttons [] = {"7","8","9","6","5","4","3","2","1","0",".","/"};
		for(int i = 0; i < 12; i++) {
			JButton button = new JButton(buttons[i]);;
			center.add(button);
		}

		JPanel east = new JPanel();
		east.setBackground(Color.decode("#D9976A"));
		east.setLayout(new GridLayout(3,1,2,2));
		panel.add(east, BorderLayout.EAST);

		String buttons2 [] = {"+","-","="};
		for(int i = 0; i < 3; i++) {
			JButton button = new JButton(buttons2[i]);
			east.add(button);
		}

		JPanel west = new JPanel();
		west.setBackground(Color.DARK_GRAY);
		west.setLayout( new BoxLayout(west,BoxLayout.Y_AXIS));
		panel.add(west, BorderLayout.WEST);

		String buttons3 [] = {"MC","M+","*"};
		for(int i = 0; i < 3; i++) {
			JButton button = new JButton(buttons3[i]);
			west.add(button);
		}
		this.add(panel);
	}
	
	public void calculoInteres() {
		
		//Panel del fondo del frame
		JPanel pnlPrincipal = new JPanel();
		pnlPrincipal.setSize(this.getWidth(),this.getHeight());
		pnlPrincipal.setBackground(Color.white);
		pnlPrincipal.setLayout( new BorderLayout());
		
		//Panel donde se ingresan los datos
		JLabel pnlDatos = new JLabel();
		pnlDatos.setOpaque(true);
		pnlDatos.setPreferredSize(new Dimension(200,300));
		pnlDatos.setBackground(Color.GREEN);
		pnlDatos.setFont(new Font ("calibri",Font.BOLD,30));
		pnlDatos.setBorder(BorderFactory.createLineBorder(Color.white,35));
		pnlPrincipal.add(pnlDatos, BorderLayout.CENTER);
		
		
		//Label del titulo
		JLabel lblInteres = new JLabel("Calcular interés: ");
		lblInteres.setBounds(50,25,180,40);
		lblInteres.setFont(new Font ("Arial", Font.BOLD, 15));
		pnlDatos.add(lblInteres);
		
		//Label de la capital
		JLabel lblCapital = new JLabel("Capital: ");
		lblCapital.setBounds(50,80,180,40);
		lblCapital.setFont(new Font ("Agency FB", Font.BOLD, 20));
		lblCapital.setForeground(Color.black);
		pnlDatos.add(lblCapital);
		
		//Texto para ingresar capital
		JTextField txtCapital = new JTextField();
		txtCapital.setBounds(170,90,200,25);
		txtCapital.setOpaque(true);
		txtCapital.setBackground(Color.white);
		pnlDatos.add(txtCapital);
		
		//Label para el tiempo
		JLabel lblTiempo = new JLabel("Tiempo: ");
		lblTiempo.setBounds(50,140,180,40);
		lblTiempo.setFont(new Font ("Agency FB", Font.BOLD, 20));
		lblTiempo.setForeground(Color.black);
		pnlDatos.add(lblTiempo);
		
		//TypeTime Field
		JTextField txtTiempo = new JTextField();
		txtTiempo.setBounds(170,150,200,25);
		txtTiempo.setOpaque(true);
		txtTiempo.setBackground(Color.white);
		pnlDatos.add(txtTiempo);
		
		//Label para la tasa de interes
		JLabel txtTasa = new JLabel("Tasa de interés: ");
		txtTasa.setBounds(50,200,180,40);
		txtTasa.setFont(new Font ("Agency FB", Font.BOLD, 20));
		txtTasa.setForeground(Color.black);
		pnlDatos.add(txtTasa);
		
		//Texto para interes
		JTextField txtInteres = new JTextField();
		txtInteres.setBounds(170,210,200,25);
		txtInteres.setOpaque(true);
		txtInteres.setBackground(Color.white);
		pnlDatos.add(txtInteres);
		
		//Label para el interes
		JLabel interestText = new JLabel("Interés",2);
		interestText.setFont(new Font ("calibri",Font.BOLD,30));
		interestText.setForeground(Color.red);
		pnlPrincipal.add(interestText, BorderLayout.NORTH);
		
		//boton para cancelar
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(100, 300, 150, 40);
		pnlDatos.add(btnCalcular);
		
		//Boton para cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setOpaque(true);
		btnCancelar.setBounds(280, 300, 150, 40);
		pnlDatos.add(btnCancelar);
		
		
		//Panel donde se muestra la informacion
		JLabel pnlResultados = new JLabel();
		pnlResultados.setOpaque(true);
		pnlResultados.setPreferredSize(new Dimension(200,300));
		pnlResultados.setBackground(Color.PINK);
		pnlResultados.setBorder(BorderFactory.createLineBorder(Color.white,35));
		pnlPrincipal.add(pnlResultados, BorderLayout.SOUTH);
				
		//Label del interes 
		JLabel interest = new JLabel("Interés: ");
		interest.setBounds(50,80,180,40);
		interest.setFont(new Font ("Agency FB", Font.BOLD, 20));
		interest.setForeground(Color.black);
		pnlResultados.add(interest);
		
		//Texto ingresar interes 
		JTextField txtInteres2 = new JTextField();
		txtInteres2.setBounds(170,90,200,25);
		txtInteres2.setOpaque(true);
		txtInteres2.setBackground(Color.white);
		pnlResultados.add(txtInteres2);
		
		//Label para el monto
		JLabel lblMonto = new JLabel("Monto: ");
		lblMonto.setBounds(50,140,180,40);
		lblMonto.setFont(new Font ("Agency FB", Font.BOLD, 20));
		lblMonto.setForeground(Color.black);
		pnlResultados.add(lblMonto);
		
		//Texto del monto
		JTextField txtMonto = new JTextField();
		txtMonto.setBounds(170,150,200,25);
		txtMonto.setOpaque(true);
		txtMonto.setBackground(Color.white);
		pnlResultados.add(txtMonto);
		
		this.add(pnlPrincipal);
	}

	
}
