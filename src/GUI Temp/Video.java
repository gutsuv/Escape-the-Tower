/**
 * Class: Video
 * @author Samuel Berende
 * @version 1.0
 * Course: ITEC 3150
 * Written: January 22, 2017
 * 
 * This class describes a subclass of Media called Video.
 * 
 * Purpose: To contain the attributes specific to a type of media called Video.
 */

public class Video extends Media
{
    private boolean standardDefinition;
    private boolean highDefinition;
    private boolean DVD;
    private boolean digital;
    private String director;
    private String genre;
    private String rating;
    
	/**
	 * @param catagory
	 * @param name
	 * @param itemNum
	 * @param standardDefinition
	 * @param highDefinition
	 * @param dVD
	 * @param digital
	 * @param director
	 * @param genre
	 * @param rating
	 */
	public Video(String catagory, String name, int itemNum, boolean standardDefinition, boolean highDefinition, boolean dVD, boolean digital, String director, String genre, String rating)
	{
		super(catagory, name, itemNum);
		this.standardDefinition = standardDefinition;
		this.highDefinition = highDefinition;
		this.DVD = dVD;
		this.digital = digital;
		this.director = director;
		this.genre = genre;
		this.rating = rating;
	}

	/**
	 * @return
	 */
	public boolean isStandardDefinition()
	{
		return standardDefinition;
	}

	/**
	 * @return
	 */
	public boolean isHighDefinition()
	{
		return highDefinition;
	}

	/**
	 * @return
	 */
	public boolean isDVD()
	{
		return DVD;
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
	public String getDirector()
	{
		return director;
	}

	/**
	 * @return
	 */
	public String getGenre()
	{
		return genre;
	}

	/**
	 * @return
	 */
	public String getRating()
	{
		return rating;
	}

	/* (non-Javadoc)
	 * @see Media#toString()
	 */
	@Override
	public String toString()
	{
		return super.toString() + "Video [standardDefinition=" + standardDefinition + ", highDefinition=" + highDefinition + ", DVD=" + DVD + ", digital=" + digital + ", director=" + director + ", genre=" + genre + ", rating=" + rating + "]";
	}
}