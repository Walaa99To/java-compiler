package ass;

public class BlockNode extends AbstractTreeNode {

		@Override
		public Object execute(Context context) 
		{
		for(AbstractTreeNode n : children)
		n.execute(context);
		return null;
		}

}
