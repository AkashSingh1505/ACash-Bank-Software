
package atm_p.BankingPlatform;


public class Debug {
    accountOpaningForm openedForm;
    UserProfileData userProfileData;
    Debug(){}
    Debug(UserProfileData userProfileData,accountOpaningForm openedForm){
        this.openedForm=openedForm;
        this.userProfileData=userProfileData;
        new Debug().print();
    }
    public void print(){
        String query1="Insert into customer values("+"AS321002"+userProfileData.UserName+userProfileData.Password+userProfileData.CustomerName+userProfileData.DateOfBirth+
                    userProfileData.Gender+userProfileData.MaterialStatus+userProfileData.Religion+userProfileData.UID+Long.parseLong(userProfileData.MobileNumber)+
                    userProfileData.EmailAddress+userProfileData.Nationality+userProfileData.State+userProfileData.City+Integer.parseInt(userProfileData.PinCode)+
                    userProfileData.PermanentAddress+true+")";
        System.out.println(query1);
    }
    public static void main(String[] args) {
         Debug obj=new Debug();
         obj.print();
    }
}
