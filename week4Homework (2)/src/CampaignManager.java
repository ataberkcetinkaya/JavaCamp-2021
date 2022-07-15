public class CampaignManager implements CampaignService{
    @Override
    public void login(Game game) {
        System.out.println("Kampanyaya giri�iniz yap�ld� : " + game.getGameName() + " : " + game.getGamePrice() / 5 + " $");

    }

    @Override
    public void delete(Game game) {
        System.out.println("Kampanyaya giri�iniz silindi ve giri� silindi�i i�in indirim art�k ge�ersiz : " + game.getGameName()+" : "+game.getGamePrice()+ " " + " $");

    }

    @Override
    public void update(Game game) {
        System.out.println("Kampanya g�ncellendi : " + game.getGameName() + " : "+game.getGamePrice() / 3 + " $");
    }
}