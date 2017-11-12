package Classes;

public class Item 
{
	protected int itemId;
	protected String itemName;
	protected String itemDescShort;
	protected String itemDescLong;
	
	public Item() 
	{
		this.itemId = 0;
		this.itemName = "";
		this.itemDescShort = "";
	}

	public Item(int itemId, String itemName, String itemDesc) 
	{
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescShort = itemDesc;
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

	public String getItemDesc()
	{
		return itemDescShort;
	}

	public void setItemDesc(String itemDesc) 
	{
		this.itemDescShort = itemDesc;
	}

	@Override
	public String toString()
	{
		return "Item [itemID=" + itemId + ", itemName=" + itemName + "itemDesc=" + " itemDesc]";
	}
}