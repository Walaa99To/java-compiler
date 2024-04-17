package ass;

public class IfNode extends AbstractTreeNode 
{
	boolean elesAdd=false;
	public void setbool(boolean b) {
		this.elesAdd=true;
	}
	@Override
	public Object execute(Context context) 
	{
		if ((Boolean)children.get(0).execute(context)) {
			if((String)children.get(1).execute(context)=="break") {
				return "break";
			}
			if((String)children.get(1).execute(context)=="continue") {
				return "continue";
			}
			else {
				children.get(1).execute(context);
				return null;
			}
			}
		else if(!(Boolean)children.get(0).execute(context) && elesAdd) {
			children.get(2).execute(context);
			return null;
		}
		else {
			return null;
		}
		
	}
}

