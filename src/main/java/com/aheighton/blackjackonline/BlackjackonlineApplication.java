package com.aheighton.blackjackonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;


@SpringBootApplication
@RestController
public class BlackjackonlineApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(BlackjackonlineApplication.class, args);
	}

	BlackJackGame game;
	boolean started = false;

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/title")
	public String title()
	{
		return new Gson().toJson("Blackjack!");
	}

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/start")
	public void start(@RequestParam(value = "name", defaultValue = "Player") String name)
	{
		Player player = new BlackJackPlayer(name, false, false);
		Player dealer = new BlackJackPlayer("Dealer", true, true);
		List<Player> players = new LinkedList<>();
		players.add(player);
		players.add(dealer);

		game = new BlackJackGame(players);
		game.deal();
		started = true;
	}

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/getPlayer")
	public String[] getPlayer()
	{
		if (started)
		{
			return new String[]{game.getPlayers().get(0).getName()+"'s hand", game.getPlayers().get(0).getHand().toString()};
		} else
		{
			return new String[]{"",""};
		}

	}

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/getDealer")
	public String[] getDealer()
	{
		if (started)
		{
			return new String[]{game.getPlayers().get(1).getName()+"'s hand", game.getPlayers().get(1).getHand().toString()};
		} else
		{
			return new String[]{"",""};
		}	}

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/getResult")
	public String getResult()
	{
		return "You win!";
	}

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/hit")
	public void hit()
	{
		game.play(game.getPlayers().get(0),"hit");
	}
}