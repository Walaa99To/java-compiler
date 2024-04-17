package ass;

public class elifNode extends AbstractTreeNode 
{
	@Override
	public Object execute(Context context) 
	{
		if ((Boolean)children.get(0).execute(context))
			children.get(1).execute(context);
		return null;
	}
}
