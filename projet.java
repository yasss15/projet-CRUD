import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class projet extends JFrame  {
    static JFrame fenetre = new JFrame("Nouveau projet");
    static JButton btn;
    static JButton btn2;
    static JButton btn3;
    static int ID;
    static String Nom;
    static String Prenom;
    static String Telephone;
    static String Declaration;
    static String Date;
    static String Ticket;
    static String Etat;
    static DefaultTableModel newmodel = new DefaultTableModel();
    static JTable table = new JTable(newmodel);
    static JTextField a;
    static JTextField b;
    static JTextField c;
     

    public static void delete() {
                
        btn2 = new JButton();
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==btn2){
                    {
                        String url = "jdbc:mysql://localhost:3306/formulaire";
                        String username = "root";
                        String password= "";

                        int idRow = table.getSelectedRow();
                        int idUser = (int) table.getValueAt(idRow, 0);

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver"); 
                            Connection conn= DriverManager.getConnection(url, username, password);
                            PreparedStatement st = conn.prepareStatement("DELETE FROM `client` WHERE `ID` = " + idUser);
                            st.executeUpdate();
                            }
                        
                        catch (Exception e1) {
                            System.out.println(e1);
                            }                    
                            }
                        }
                    }
                  });

        btn2.setBounds(150, 320, 120, 25);
        btn2.setVisible(true);
        btn2.setBackground(Color.lightGray);
        fenetre.add(btn2);

    }

    public static void modifier(){
        btn3 = new JButton();
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==btn3){
                    {
                        String url = "jdbc:mysql://localhost:3306/formulaire";
                        String username = "root";
                        String password= "";


                        int idRow = table.getSelectedRow();
                        int idUser = (int) table.getValueAt(idRow, 0);
                        String idNom = (String) table.getValueAt(idRow, 1);
                        String idPre = (String) table.getValueAt(idRow, 2);
                        String idTel = (String) table.getValueAt(idRow, 3);
                        String idDe = (String) table.getValueAt(idRow, 4);
                        String idDate = (String) table.getValueAt(idRow, 5);
                        String idTick = (String) table.getValueAt(idRow, 6);
                        String idEtat = (String) table.getValueAt(idRow, 7);


                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver"); 
                            Connection conn= DriverManager.getConnection(url, username, password);
                            PreparedStatement st = conn.prepareStatement("UPDATE `client` SET `Nom` = '"+ idNom+"', `Prenom` = '"+ idPre+"', `Telephone` = '"+ idTel+"', `Declaration` = '"+ idDe+"', `Date` = '"+ idDate +"', `Ticket` = '"+ idTick+"', `Etat` = '"+ idEtat+"' WHERE ID = " + idUser);
                            
                            st.executeUpdate();
                            System.out.println(idNom);
                            System.out.println(idPre);
                        }
                        catch (Exception e1){
                            System.out.println(e1);
                        }
                    }
                }
            }
        });


        btn3.setBounds(280, 320, 120, 25);
        btn3.setVisible(true);
        btn3.setBackground(Color.PINK);
        fenetre.add(btn3);
    }


    public static void main(String[] agrs) {
        table.setBounds(30, 360, 500, 100);
        newmodel.addColumn("ID");
        newmodel.addColumn("Nom");
        newmodel.addColumn("Prénom");
        newmodel.addColumn("Téléphone");
        newmodel.addColumn("Declaration");
        newmodel.addColumn("Date"); 
        newmodel.addColumn("Numéro de ticket"); 
        newmodel.addColumn("Etat du ticket"); 
        delete();
        modifier();

                {

                    String url = "jdbc:mysql://localhost:3306/formulaire";
                    String username = "root";
                    String password= "";

                    try      
                    {
        
                    Class.forName("com.mysql.cj.jdbc.Driver");         
                    Connection conn = DriverManager.getConnection(url, username, password);      
                    Statement stmt = conn.createStatement();        
                    ResultSet res = stmt.executeQuery("SELECT * FROM client");
        
                    
        
                    while(res.next()) {
        
                        ID = res.getInt(1);        
                        Nom = res.getString(2);       
                        Prenom = res.getString(3);       
                        Telephone = res.getString(4);        
                        Declaration = res.getString(5);        
                        Date = res.getString(6);      
                        Ticket = res.getString(7);       
                        Etat = res.getString(8);

                        System.out.println("kljjk"+ Ticket);
        
                        newmodel.addRow(new Object[]{ID, Nom, Prenom, Telephone, Declaration, Date, Ticket, Etat});
                   }
        
                      conn.close();      
                    }
                    catch (Exception e1) {
                        System.out.println(e1);        
                    }

                    
        
                    };
                      

                JLabel text1 = new JLabel("Nom");
                text1.setBounds(30,40,200,30);

                JTextField a = new JTextField("");
                a.setBounds(140,40,200,25);

                JLabel text2 = new JLabel("Prénom");
                text2.setBounds(30,80,200,30);

                JTextField b = new JTextField("");
                b.setBounds(140,80,200,25);

                JLabel text3 = new JLabel("Téléphone");
                text3.setBounds(30,120,200,30);

                JTextField c = new JTextField("");
                c.setBounds(140,120,200,25);

                JLabel deroulant = new JLabel("Déclaration : ");
                deroulant.setBounds(30,160,200,25);
                deroulant.setVisible(true);

                String[] choices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

                final JComboBox<String> cb = new JComboBox<String>(choices);
                cb.setVisible(true);
                cb.setBounds(140,160,200,25);

                JLabel date = new JLabel("Date du jour :");
                date.setBounds(30, 200, 200, 30);
                date.setVisible(true);

                JTextField dateField = new JTextField(10);
                dateField.setBounds(140, 200, 200, 25);
                dateField.setVisible(true);

                 LocalDate dateDuJour = LocalDate.now();
                 dateField.setText(dateDuJour.toString());

                JLabel ticket = new JLabel("Numéro de ticket :");
                ticket.setBounds(30,240,200,25);
                ticket.setVisible(true);

                JTextField ticket2 = new JTextField(10);
                ticket2.setBounds(140, 240, 200, 25);
                ticket2.setVisible(true);

                JLabel etat = new JLabel("Etat du ticket :");
                etat.setBounds(30,280,200,25);
                etat.setVisible(true);

                String[] choix = { "Nouveau","En cours", "Fermer"};

                final JComboBox<String> et = new JComboBox<String>(choix);
                et.setVisible(true);
                et.setBounds(140,280,200,25);

                btn = new JButton();
                btn.setVisible(true);
                btn.setBounds(30, 320,100,25);
                btn.setForeground(Color.BLACK);
                btn.setBackground(Color.WHITE);
                Border line = new LineBorder(Color.BLACK);
                Border margin = new EmptyBorder(5, 15, 5, 15);
                Border compound = new CompoundBorder(line, margin);
                btn.setBorder(compound);


                


                
                fenetre.add(text1);
                fenetre.add(text2);
                fenetre.add(text3);
                fenetre.add(a);
                fenetre.add(b);
                fenetre.add(c);
                fenetre.add(table);
                fenetre.add(deroulant);
                fenetre.add(cb);
                fenetre.add(date);
                fenetre.add(dateField);
                fenetre.add(ticket);
                fenetre.add(etat);
                fenetre.add(et);
                fenetre.add(ticket2);
                fenetre.add(btn);
                

                fenetre.setSize(500, 500);
                fenetre.setLayout(null);
                fenetre.setVisible(true);


                 btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btn) {
                     { 
                String url = "jdbc:mysql://localhost:3306/formulaire";
    		    String username = "root";
    		    String password= "";

                String PrenomField = a.getText();
                String NomField = b.getText();
                String TelField = c.getText();
                String DeclaField = cb.getSelectedItem().toString();
                String DayField = dateField.getText();
                String TicketField = ticket2.getText();
                String EtatField = et.getSelectedItem().toString();



                
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                // Établir la connexion à la base de données et exécuter la requête d'insertion
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/formulaire", "root", "")) {
                    String insertQuery = "INSERT INTO `client` (`ID`, `Prenom`, `Nom`, `Telephone`, `Declaration`, `Date`, `Ticket`, `Etat`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
                    try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                        pstmt.setString(1, null);
                        pstmt.setString(2, PrenomField);
                        pstmt.setString(3, NomField);
                        pstmt.setString(4, TelField);
                        pstmt.setString(5, DeclaField);
                        pstmt.setString(6, DayField);
                        pstmt.setString(7, TicketField);
                        pstmt.setString(8, EtatField);
                        // id_client	descripton	date	

                        // Exécuter la requête d'insertion
                        pstmt.executeUpdate();
                        System.out.println(DeclaField);

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Erreur lors de l'ajout des données dans la base de données.");
                }

                }		
				}
				
			}

		});
            }
           
}
