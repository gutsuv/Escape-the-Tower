/**
 * Class: Media
 * @author Samuel Berende
 * @version 1.0
 * Course: ITEC 3150
 * Written: January 22, 2017
 * 
 * This class describes the common attributes and methods of the media being collected into a library inventory.
 * 
 * Purpose: To be a parent class to different types of media.
 */

public class Media
{
    private String catagory;
    private String name;
    private int itemNum;

    /**
     * @param catagory
     * @param name
     * @param itemNum
     */
    public Media(String catagory, String name, int itemNum)
    {
        super();
        this.catagory = catagory;
        this.name = name;
        this.itemNum = itemNum;
    }

	/**
	 * @return
	 */
	public String getCatagory()
	{
		return catagory;
	}

	/**
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return
	 */
	public int getItemNum()
	{
		return itemNum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Media [catagory=" + catagory + ", name=" + name + ", itemNum=" + itemNum + "]";
	}
}
