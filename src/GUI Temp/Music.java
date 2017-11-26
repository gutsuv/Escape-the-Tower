/**
 * Class: Music
 * @author Samuel Berende
 * @version 1.0
 * Course: ITEC 3150
 * Written: January 22, 2017
 * 
 * This class describes a subclass of Media called Music.
 * 
 * Purpose: To contain the attributes specific to a type of media called Music.
 */

public class Music extends Media
{
    private boolean vinyl;
    private boolean digital;
    private boolean cassette;
    private boolean CD;
    private String artist;
    
	/**
	 * @param catagory
	 * @param name
	 * @param itemNum
	 * @param vinyl
	 * @param digital
	 * @param cassette
	 * @param cD
	 * @param artist
	 */
	public Music(String catagory, String name, int itemNum, boolean vinyl, boolean digital, boolean cassette, boolean cD, String artist)
	{
		super(catagory, name, itemNum);
		this.vinyl = vinyl;
		this.digital = digital;
		this.cassette = cassette;
		this.CD = cD;
		this.artist = artist;
	}

	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public boolean isVinyl()
	{
		return vinyl;
	}

	/**
	 * @return
	 */
	public boolean isDigital()
	{
		return digital;
	}

	/**
	 * @return
	 */
	public boolean isCassette()
	{
		return cassette;
	}

	/**
	 * @return
	 */
	public boolean isCD()
	{
		return CD;
	}

	/**
	 * @return
	 */
	public String getArtist()
	{
		return artist;
	}

	/* (non-Javadoc)
	 * @see Media#toString()
	 */
	@Override
	public String toString()
	{
		return super.toString() + "Music [vinyl=" + vinyl + ", digital=" + digital + ", cassette=" + cassette + ", CD=" + CD + ", artist=" + artist + "]";
	}
}