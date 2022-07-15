public class GamerManager implements GamerService {

    public GamerManager(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    private VerificationService verificationService;
    @Override
    public void add(Gamer gamer) {
    	
        if (verificationService.Verification(gamer) ==true){
        System.out.println(gamer.getFirstName() +" " + gamer.getLastName() + " user added.");
        }else{
            System.out.println("user not added.");
        }

    }

    @Override
    public void delete(Gamer gamer) {

        if (verificationService.Verification(gamer) ==true){
            System.out.println(gamer.getFirstName() +" " + gamer.getLastName() + " user deleted.");
        }else{
            System.out.println("failed delete.");
        }


    }

    @Override
    public void update(Gamer gamer) {
    	
        if (verificationService.Verification(gamer) ==true){
            System.out.println(gamer.getFirstName() +" " + gamer.getLastName() + " user updated.");
        }else{
            System.out.println("failed update.");
        }

    }
}