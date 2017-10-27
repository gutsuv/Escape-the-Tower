public class Item 
{
	protected int itemId;
	protected String itemName;
	protected String itemDesc;

	public Item() 
	{
		this.itemId = 0;
		this.itemName = "";
		this.itemDesc = "";
	}

	public Item(int itemId, String itemName, String itemDesc) 
	{
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
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
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) 
	{
		this.itemDesc = itemDesc;
	}

	@Override
	public String toString()
	{
		return "Item [itemID=" + itemId + ", itemName=" + itemName + "itemDesc=" + " itemDesc]";
	}
}