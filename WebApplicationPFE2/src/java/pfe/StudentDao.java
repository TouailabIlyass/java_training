package pfe;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    
   static Connection con;
    
    public static Connection getConnection() 
    { 
        Connection con=null;
       
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/pfe";
	    con = DriverManager.getConnection(url, "root","");
          } catch (ClassNotFoundException | SQLException e) {
              
            e.printStackTrace();
        }
        
        return con;
    }
    public StudentDao()
    {
        con=getConnection();
        System.out.println("hhhhhhhhhh");
    }
    
    public  int Add(Student s)
    {
        int status=1;
          System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        try
        {
           PreparedStatement ps;
            ps = con.prepareStatement
 ("insert into student values(?,?,?,?,?,?,?,?)");
           
            ps.setInt(1,0);
            ps.setString(2,s.getNom());
            ps.setString(3,s.getPrenom());
           System.out.println(""+s.getPrenom());
            ps.setString(4,s.getAdresse());
            ps.setString(5,s.getUser());
            ps.setString(6,s.getPass());
            ps.setDate(7,Date.valueOf(s.getDate()));
            ps.setString(8, s.getFiliere());
            ps.executeUpdate();
            
        }catch(SQLException e)
        {
           System.out.println(e);
           status=0;
        }
        return status;
    }
    
    public  int Update(Student s)
    {
        int status=0;
        
        try
        {
           // Connection conn=getConnection();
            PreparedStatement ps=con.prepareStatement
     ("update student set nom=?,prenom=?,adresse=?,user=?,pass=?,date=?,filiere=? where id=?");
            ps.setString(1,s.getNom());
            ps.setString(2,s.getPrenom());
            ps.setString(3,s.getAdresse());
            ps.setString(4,s.getUser());
            ps.setString(5,s.getPass());
            ps.setString(6,s.getDate());
            ps.setString(7, s.getFiliere());
            ps.setInt(8,s.getId());
            status=ps.executeUpdate();
            
        }catch(SQLException e)
        {
           System.out.println(e);
        }
        return status;
    }
    
    public  int delete(Student s)
    {
        int status=0;
        try
        {
           // Connection conn=getConnection();
            PreparedStatement ps=con.prepareStatement("delete from student where user=?");
            ps.setString(1,s.getUser());
            status=ps.executeUpdate();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return status;
                
    }
    
    
    public  int deleteC(Cours s)
    {
        int status=0;
        try
        {
           // Connection conn=getConnection();
            PreparedStatement ps=con.prepareStatement("delete from cours where nom=?");
            ps.setString(1,s.getPath());
            status=ps.executeUpdate();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return status;
                
    }
    
    public  List<Student> getAllstudent()
    {
        List<Student> list=new ArrayList<Student>();
        
        try
        {
          //  Connection conn=getConnection();
            PreparedStatement ps=con.prepareStatement("select * from student");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Student s=new Student();
                s.setNom(rs.getString("nom"));
                s.setPrenom(rs.getString("prenom"));
                s.setAdresse(rs.getString("adresse"));
                s.setUser(rs.getString("user"));
                s.setPass(rs.getString("pass"));
                s.setDate(rs.getString("date"));
                s.setFiliere(rs.getString("filiere"));
                list.add(s);
            }
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        return list;
    }
    
    public static Student getOnestudent(String user)
    {
        Student s=null;
        
        try
        {
           // Connection conn=getConnection();
            PreparedStatement ps=con.prepareStatement("select * from student where user=?");
            ps.setString(1,user);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                s=new Student();
                s.setNom(rs.getString("nom"));
                s.setPrenom(rs.getString("prenom"));
                s.setAdresse(rs.getString("adresse"));
                s.setUser(rs.getString("user"));
                s.setPass(rs.getString("pass"));
                s.setDate(rs.getString("date"));
                s.setFiliere(rs.getString("filiere"));
            }
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        return s;
    }
    
    
    public  List<Cours> getAllcours()
    {
        List<Cours> list=new ArrayList<Cours>();
        String nom=null,desc=null;
        try
        {
          //  Connection conn=getConnection();
            PreparedStatement ps=con.prepareStatement("select * from cours");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Cours c=new Cours();
                c.setPath(rs.getString("nom"));
                c.setDesc(rs.getString("description"));
                list.add(c);
            }
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        return list;
    }
    
    public static int getCour(String nom)
    {
        int s=0;
        
        try
        {
           Connection conn=getConnection();
            PreparedStatement ps=con.prepareStatement("select id from cours where nom=?");
            ps.setString(1,nom);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
               
               s=rs.getInt(1);
            }
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        return s;
    }
}
