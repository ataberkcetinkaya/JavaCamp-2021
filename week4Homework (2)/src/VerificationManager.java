public class VerificationManager implements VerificationService {
    @Override
    public boolean Verification(Gamer gamer) {
    	
        if (gamer.getTcId().length()==11 && gamer.getFirstName().length() > 3 &&
                gamer.getLastName().length() > 3 && gamer.getBirthOfYear()<=2003) {
            System.out.println(gamer.getFirstName() +" : Verification success");
            
            return true;
            
        }else{
           System.out.println(gamer.getFirstName() +" : Verification failed.");
           
            return false;
        }
    }
}