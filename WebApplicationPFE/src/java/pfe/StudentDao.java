package pfe;

import java.sql.Connection;
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
    
    public static int Add(Student s)
    {
        int status=0;
        
        try
        {
           PreparedStatement ps;
            ps = con.prepareStatement
                ("insert into student('nom','prenom','adresse','user','pass','date','filiere') values(?,?,?,?,?,?,?)");
            ps.setString(1,s.getNom());
            ps.setString(2,s.getPrenom());
            ps.setString(3,s.getAdresse());
            ps.setString(4,s.getUser());
            ps.setString(5,s.getPass());
            ps.setString(6,s.getDate());
            ps.setString(7, s.getFiliere());
            status=ps.executeUpdate();
            
        }catch(SQLException e)
        {
           System.out.println(e);
        }
        return status;
    }
    
    public static int Update(Student s)
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
    
    public static int delete(Student s)
    {
        int status=0;
        try
        {
           // Connection conn=getConnection();
            PreparedStatement ps=con.prepareStatement("delete from student where id=?");
            ps.setInt(1,s.getId());
            status=ps.executeUpdate();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return status;
                
    }
    
    
    public static List<Student> getAllstudent()
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
                s.setId(rs.getInt("id"));
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
    
    public static Student getOnestudent(int id)
    {
        Student s=null;
        
        try
        {
           // Connection conn=getConnection();
            PreparedStatement ps=con.prepareStatement("select * from student where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                s=new Student();
                s.setId(rs.getInt("id"));
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
}
