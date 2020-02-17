/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ldaptest;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 *
 * @author drging
 */
public class test2 {
    public void totalUser() throws NamingException
	{
		
		Properties initialProperties = new Properties();
		initialProperties.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		initialProperties.put(Context.PROVIDER_URL, "ldap://192.168.1.12:389");
		initialProperties.put(Context.SECURITY_PRINCIPAL, "uid=itouailab,ou=Etudiants,dc=ensaf,dc=local");
		initialProperties.put(Context.SECURITY_CREDENTIALS, "hh12606");
		DirContext  context = new InitialDirContext(initialProperties);
		
		String searchFilter="(objectClass=account)";
		//String[] requiredAttributes={"sn","cn","uid","stdcne","stdcin","stddepartment"  };
		SearchControls controls=new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		//controls.setReturningAttributes(requiredAttributes);
		NamingEnumeration users=context.search("uid=itouailab,ou=Etudiants,dc=ensaf,dc=local", searchFilter, controls);
		SearchResult searchResult=null;
		String commonName=null;
		String surName=null;
		String employeeNum=null;
		while(users.hasMore())
		{
			
			searchResult=(SearchResult) users.next();
			Attributes attr=searchResult.getAttributes();
			
			commonName=attr.get("cn").get(0).toString();
			surName=attr.get("uid").get(0).toString();
			
			//employeeNum=attr.get("employeeNumber").get(0).toString();
			System.out.println("Name = "+commonName);
			System.out.println("Surname  = "+surName);
			System.out.println("uid  = "+surName);
			System.out.println("cne  = "+attr.get("stdcne").get(0).toString());
			System.out.println("cin  = "+attr.get("stdcin").get(0).toString());
			System.out.println("dept  = "+attr.get("stddepartment").get(0).toString());
			//System.out.println("Employee number = "+employeeNum);
			System.out.println("-------------------------------------------");
			
		}
		
	}
		public static void main(String[] args) throws NamingException  
	{
		test2 sample = new test2();
		sample.totalUser();
		
	}
}
