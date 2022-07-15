public class BuyRentManager implements BuyRentService{
    @Override
    public void Buy(Gamer gamer,Game game) {
        System.out.println("Game purchased : " + game.getGameName() + "---> See ya : " + gamer.getFirstName());
    }

    @Override
    public void Rent(Gamer gamer,Game game) {
        System.out.println("Game rented : " + game.getGameName()+ "---> See ya : " + gamer.getFirstName());
    }
}