/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package atm_p.BankingPlatform;

/**
 *
 * @author user
 */
public class PasswordPolicyCheck implements PasswordPolicy{
    public boolean specialChar=false;
    public boolean number=false;
    public boolean Latter=false;


    @Override
    public  void specialChar(char ch) {
        if((ch>=32 &&ch<=47)||( ch>=58&&ch<=64) || (ch>=91 && ch<=96) || (ch<=123&&ch>=126)){
            specialChar= true;
        }
    }

    @Override
    public void number(char ch) {
       if( Character.isDigit(ch))number=true;
    }

    @Override
    public void Latter(char ch) {
       if( Character.isLetter(ch))Latter=true;
    }

    boolean check(){
         if(specialChar&&number&&Latter)return true;
         return false;
    }
    void run(char ch){
        specialChar(ch);
        number(ch);
        Latter(ch);
    }
    String policeBreak(){
        String res="";
        if(!specialChar)res="Password must have atleast a special character'#@$' !";
       else if(!number)res="Password must have atleast a number '123' !";
       else if(!Latter)res="Password must have atleast a letter 'aBc' !"; 
        return res;
    }

}
