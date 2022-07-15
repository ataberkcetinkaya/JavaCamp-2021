public class CampaignManager implements CampaignService{
    @Override
    public void login(Game game) {
        System.out.println("Kampanyaya giriþiniz yapýldý : " + game.getGameName() + " : " + game.getGamePrice() / 5 + " $");

    }

    @Override
    public void delete(Game game) {
        System.out.println("Kampanyaya giriþiniz silindi ve giriþ silindiði için indirim artýk geçersiz : " + game.getGameName()+" : "+game.getGamePrice()+ " " + " $");

    }

    @Override
    public void update(Game game) {
        System.out.println("Kampanya güncellendi : " + game.getGameName() + " : "+game.getGamePrice() / 3 + " $");
    }
}