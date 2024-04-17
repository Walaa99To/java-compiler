package ass;

public class elseNode extends AbstractTreeNode 
{
	@Override
	public Object execute(Context context) 
	{
		children.get(0).execute(context);
		return null;
	}
}
