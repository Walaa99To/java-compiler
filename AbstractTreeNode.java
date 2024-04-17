package ass;

import java.util.ArrayList;

public abstract class AbstractTreeNode {
	protected String name;
	protected boolean isbreak=false;
	protected boolean iscont=false;
	public String getName() {
	return name;
	}
	protected ArrayList<AbstractTreeNode> children = new ArrayList<AbstractTreeNode>();
	public ArrayList<AbstractTreeNode> getChildren() {
	return children;
	}
	public void addChild(AbstractTreeNode child) {
	children.add(child);
	}
	public abstract Object execute(Context context);

}
