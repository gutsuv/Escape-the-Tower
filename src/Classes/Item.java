package Classes;

public class Item 
{
	protected int itemId;
	protected String itemName;
	protected String itemDescLong;
	protected String itemDescShort;

	
	public Item() 
	{
		itemId = 0;
		itemName = "";
		itemDescLong = "";
		itemDescShort = "";

	}

	public Item(int itemId, String itemName, String itemDescShort, String itemDescLong) 
	{
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescShort = itemDescShort;
		this.itemDescLong = itemDescLong;


	}

	public int getItemId()
	{
		return itemId;
	}

	public void setItemId(int itemId) 
	{
		this.itemId = itemId;
	}

	public String getItemName() 
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public String getItemDescShort()
	{
		return itemDescShort;
	}

	public void setItemDescShort(String itemDescShort) 
	{
		this.itemDescShort = itemDescShort;
	}
	public String getItemDescLong()
	{
		return itemDescLong;
	}

	public void setItemDescLong(String itemDescLong) 
	{
		this.itemDescLong = itemDescLong;
	}

	@Override
	public String toString()
	{
		return "Item [itemID=" + itemId + ", itemName=" + itemName + "itemDescShort=" + itemDescShort + "itemDescLong=" + itemDescLong + "]";
	}
}