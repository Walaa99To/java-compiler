package ass;

public class exprNode extends AbstractTreeNode
{
	String str;
	boolean isbreak=false;
	public void setStrValue(String val) {
		this.str=val;
	}
	public String getStrValue() {
		return this.str;
		}
	@Override
	public Object execute(Context context) 
	{
		if (getStrValue() == "break") {
			return "break";
		}
		else{
			return "continue";
		}
	}
}
