package com.aheighton.blackjackonline;

public abstract class Player
{
	private String name;
	private Hand hand;
	private boolean isDealer;
	private boolean isCPU;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Hand getHand()
	{
		return hand;
	}

	public void setHand(Hand hand)
	{
		this.hand = hand;
	}

	public boolean isDealer()
	{
		return isDealer;
	}

	public void setDealer(boolean dealer)
	{
		isDealer = dealer;
	}

	public boolean isCPU()
	{
		return isCPU;
	}

	public void setCPU(boolean isCPU)
	{
		this.isCPU = isCPU;
	}

	public abstract void hit(Card card);

	public abstract void newAbility();

	public abstract String getAbility();

	public abstract void setAbility(String s);
}
