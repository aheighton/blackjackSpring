package com.aheighton.blackjackonline;

public class BlackJackPlayer extends Player
{
	public BlackJackPlayer(String name, boolean isCPU, boolean isDealer)
	{
		setName(name);
		setCPU(isCPU);
		setDealer(isDealer);
		setHand(new Hand());
	}

	public void hit(Card card)
	{
		getHand().addCard(card);
	}

	@Override
	public void newAbility()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public String getAbility()
	{
		return null;
	}

	@Override
	public void setAbility(String s)
	{
		throw new UnsupportedOperationException();
	}

//	@Override
//	public String toString()
//	{
//		return "{" +
//				"\"name\"= \"" + getName() +
//				"\", \"hand\"=\"" + getHand() +
//				"\"}";
//	}
}
