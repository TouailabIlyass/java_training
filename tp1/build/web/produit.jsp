<%-- 
    Document   : produit
    Created on : Mar 6, 2019, 4:34:47 PM
    Author     : drging
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form  method="POST" action="produit" id="formlogin">
      
            
            <h2>Nos Produits</h2>
            <input type="checkbox" name="p[0]" value="Jacket,250"/><label>Jacket</label>
            <input type="radio" name="p[1]" value="Stylo,1"/><label>Stylo</label>
            <input type="radio" name="p[2]" value="MacBookpro,5000"/><label>Mac Book</label>
            
            <input type="checkbox" name="p[3]" value="Souris,30"/><label>Souris</label>
            <input type="radio" name="p[4]" value="Asus PC,5500"/><label>Asus</label>
            <input type="radio" name="p[5]" value="DELL,3000"/><label>DELL</label>
            
             <div class="form-group">
              <label for="ncard"  >Name on card</label>
              <input type="text" class="form-control"  id="ncard" name="ncard"  placeholder="Name on card" required>
               </div>
             <div class="form-group">
              <label for="ccard"  >Credit card number</label>
              <input type="text" class="form-control"  id="ccard" name="ccard"  placeholder="Credit card number" required>
               </div>
            
            
            <div class="form-group">
              <label for="ecard"  >Expiration</label>
              <input type="text" class="form-control"  id="ecard" name="ecard"  placeholder="Expiration" required>
               </div>
                      
            <div class="form-group">
              <label for="cvv"  >CVV</label>
              <input type="text" class="form-control"  id="cvv" name="cvv"  placeholder="CVV" required>
               </div>
            
            
            
            <div class="form-group text-center">
                                    <button type="submit" name="selectpr" id="login" class="btn btn-primary">Continue to checkout</button>
                                    
                                                               
                                </div>
            
            
                            </form>
        
    </body>
</html>
