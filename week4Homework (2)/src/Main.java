public class Main {

	public static void main(String[] args) {
		
		Gamer gamer1 = new Gamer("11111111111","Berk", "C", 1998);

		Gamer gamer2 = new Gamer("11111111112","Sena", "Y", 1998);

		GamerManager gamerManager = new GamerManager(new VerificationManager());

		gamerManager.add(gamer1);
		gamerManager.delete(gamer1);
		gamerManager.update(gamer2);

		System.out.println("********************************************************");

		Game game1 = new Game();
		game1.setGameName("Battlefield 4");
		game1.setGamePrice(800);
		game1.setId(1);
		game1.setRentPrice(60);

		Game game2 = new Game();
		game2.setGameName("Stick Fight");
		game2.setGamePrice(700);
		game2.setId(2);
		game2.setRentPrice(50);

		BuyRentService buyRentService1 = new BuyRentManager();

		buyRentService1.Buy(gamer1, game1);
		buyRentService1.Rent(gamer2, game2);


		System.out.println("********************************************************");

		CampaignService campaignService = new CampaignManager();

		campaignService.login(game1);
		campaignService.delete(game1);
		campaignService.update(game2);
	}
}